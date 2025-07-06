package edu.ma.ebrowser;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FrameLayout webViewContainer;
    WebView webView;
    EditText urlEditText;
    ImageButton tabButton, menuButton;
    TextView tabCountText;
    LinearLayout topBar;

    ArrayList<String> bookmarks = new ArrayList<>();
    ArrayList<String> history = new ArrayList<>();
    List<WebView> webViews = new ArrayList<>();

    int currentTabIndex = 0;
    String defaultPage = "https://www.google.com";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webViewContainer = findViewById(R.id.webViewContainer);
        urlEditText = findViewById(R.id.urlEditText);
        tabButton = findViewById(R.id.tabButton);
        menuButton = findViewById(R.id.menuButton);
        tabCountText = findViewById(R.id.tabCount);
        topBar = findViewById(R.id.topBar);

        createNewTab(defaultPage);

        urlEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_GO) {
                loadUrl();
                return true;
            }
            return false;
        });

        urlEditText.setOnFocusChangeListener((v, hasFocus) -> {
            topBar.setVisibility(hasFocus ? View.GONE : View.VISIBLE);
        });

        tabButton.setOnClickListener(v -> {
            createNewTab(defaultPage);
            Toast.makeText(this, "New Tab Opened", Toast.LENGTH_SHORT).show();
        });

        tabButton.setOnLongClickListener(v -> {
            showTabSwitcher();
            return true;
        });

        menuButton.setOnClickListener(this::showMenu);
        updateTabCount();

        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            if (webView != null) {
                webView.loadUrl(defaultPage);
                urlEditText.setText(defaultPage);
            }
        });

    }

    private void loadUrl() {
        String url = urlEditText.getText().toString().trim();
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        if (webView != null) {
            webView.loadUrl(url);
            history.add(url);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void createNewTab(String url) {
        WebView newWebView = new WebView(this);
        newWebView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        WebSettings settings = newWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        newWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                urlEditText.setText(url);
                if (history.isEmpty() || !history.get(history.size() - 1).equals(url)) {
                    history.add(url);
                }
            }
        });

        newWebView.loadUrl(url);
        webViews.add(newWebView);
        switchToTab(webViews.size() - 1);
    }

    private void switchToTab(int index) {
        if (index < 0 || index >= webViews.size()) return;

        if (webView != null) {
            webViewContainer.removeView(webView);
        }

        currentTabIndex = index;
        webView = webViews.get(index);
        webViewContainer.addView(webView);

        String url = webView.getUrl();
        if (url != null) urlEditText.setText(url);

        updateTabCount();
    }

    private void updateTabCount() {
        tabCountText.setText(String.valueOf(webViews.size()));
    }

    private void showTabSwitcher() {
        if (webViews.isEmpty()) {
            Toast.makeText(this, "No tabs open", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] tabUrls = new String[webViews.size()];
        for (int i = 0; i < webViews.size(); i++) {
            String url = webViews.get(i).getUrl();
            tabUrls[i] = (url != null) ? url : "New Tab";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Open Tabs");
        builder.setItems(tabUrls, (dialog, which) -> {
            switchToTab(which);
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }


    private void showMenu(View v) {
        PopupMenu menu = new PopupMenu(this, v);
        menu.getMenuInflater().inflate(R.menu.browser_menu, menu.getMenu());

        menu.setOnMenuItemClickListener(this::handleMenuClick);
        menu.show();
    }

    private boolean handleMenuClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_back) {
            if (webView.canGoBack()) webView.goBack();
            return true;

        } else if (id == R.id.action_forward) {
            if (webView.canGoForward()) webView.goForward();
            return true;

        } else if (id == R.id.action_reload) {
            webView.reload();
            return true;

        } else if (id == R.id.action_bookmark) {
            String url = webView.getUrl();
            if (url != null && !bookmarks.contains(url)) {
                bookmarks.add(url);
                Toast.makeText(this, "Bookmarked!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Already Bookmarked", Toast.LENGTH_SHORT).show();
            }
            return true;

        } else if (id == R.id.action_show_bookmarks) {
            showListDialog("Bookmarks", bookmarks);
            return true;

        } else if (id == R.id.action_show_history) {
            showHistoryBottomSheet();
            return true;

        } else if (id == R.id.action_delete_history) {
            new AlertDialog.Builder(this)
                    .setTitle("Clear History")
                    .setMessage("Are you sure you want to delete all browsing history?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        history.clear();
                        Toast.makeText(this, "History cleared!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
            return true;

        } else if (id == R.id.action_zoom_in) {
            webView.zoomIn();
            return true;

        } else if (id == R.id.action_zoom_out) {
            webView.zoomOut();
            return true;

        } else if (id == R.id.action_recent_tabs) {
            Toast.makeText(this, "Tabs opened: " + webViews.size(), Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.action_incognito) {
            Toast.makeText(this, "Incognito mode placeholder", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

    private void showListDialog(String title, ArrayList<String> list) {
        if (list.isEmpty()) {
            Toast.makeText(this, title + " is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setItems(list.toArray(new String[0]), (dialog, which) -> {
            String selected = list.get(which);
            urlEditText.setText(selected);
            webView.loadUrl(selected);
        });
        builder.setNegativeButton("Close", null);
        builder.show();
    }

    private void showHistoryBottomSheet() {
        if (history.isEmpty()) {
            Toast.makeText(this, "History is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        BottomSheetDialog bottomSheet = new BottomSheetDialog(this);
        ListView listView = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, history);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = history.get(position);
            webView.loadUrl(selected);
            urlEditText.setText(selected);
            bottomSheet.dismiss();
        });

        bottomSheet.setContentView(listView);
        bottomSheet.show();
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
}
