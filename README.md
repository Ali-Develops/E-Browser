# eBrowser

eBrowser is a simple, lightweight Android web browser designed for basic Browse functionalities. It supports multiple tabs, bookmarking, Browse history, and essential navigation controls, offering a clean and user-friendly experience.

## Features

* **Multi-tab Browse:** Open and switch between multiple web pages effortlessly.
* **Bookmarks:** Save your favorite websites for quick access.
* **Browse History:** Keep track of visited websites and revisit them easily.
* **Intuitive Navigation:** Go back, forward, reload pages, and return to the home page with ease.
* **Search/URL Bar:** Directly type URLs or search the web.
* **Zoom Functionality:** Zoom in and out of web pages.
* **Basic UI:** A straightforward interface focused on core Browse.

## Screenshots

*(Due to the nature of this response, I cannot provide actual screenshots. Please replace this section with actual screenshots of your application.)*

| Home Screen | Tab Switcher | Bookmarks/History |
|-------------|--------------|-------------------|
| [Screenshot 1 URL] | [Screenshot 2 URL] | [Screenshot 3 URL] |
| *Description of Home Screen* | *Description of Tab Switcher* | *Description of Bookmarks/History* |

## Installation

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Android Studio (Latest Version Recommended)
* Android SDK (API Level 21 or higher)

### Steps

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/eBrowser.git](https://github.com/YOUR_USERNAME/eBrowser.git)
    ```
    (Replace `YOUR_USERNAME` with your actual GitHub username or the repository owner's username.)

2.  **Open in Android Studio:**
    * Launch Android Studio.
    * Select "Open an existing Android Studio project" and navigate to the cloned `eBrowser` directory.

3.  **Sync Gradle:**
    * Android Studio should automatically sync the Gradle project. If not, click on `File > Sync Project with Gradle Files`.

4.  **Run the application:**
    * Connect an Android device to your computer or use an Android emulator.
    * Click on the `Run` button (green play icon) in Android Studio.

## Usage

1.  **Opening the Browser:** Launch the eBrowser app from your Android device's app drawer.
2.  **Navigating:**
    * Type a URL or search query into the address bar at the top and press Enter.
    * Use the back and forward arrows (if available in your `browser_menu.xml` - not provided in the snippet) to navigate through your Browse history for the current tab.
    * Tap the home icon to go to the default home page (`https://www.google.com`).
3.  **Tabs:**
    * Tap the "New Tab" button (usually represented by an icon with a plus sign or multiple squares) to open a new tab.
    * Long-press the "New Tab" button to view and switch between open tabs.
4.  **Menu Options:**
    * Tap the "Menu" button (three vertical dots or lines) to access additional options:
        * **Back/Forward/Reload:** Standard browser navigation.
        * **Bookmark:** Add the current page to your bookmarks.
        * **Show Bookmarks:** View your saved bookmarks and open them.
        * **Show History:** View your Browse history and open past visited sites.
        * **Delete History:** Clear all your Browse history.
        * **Zoom In/Out:** Adjust the page's zoom level.
        * **Recent Tabs:** (Currently shows a Toast with tab count - could be expanded).
        * **Incognito:** (Placeholder for future incognito mode).

## Project Structure

* `app/src/main/java/edu/ma/ebrowser/MainActivity.java`: The core activity containing all the browser logic.
* `app/src/main/res/layout/activity_main.xml`: The main layout file defining the UI elements of the browser.
* `app/src/main/res/menu/browser_menu.xml`: Defines the options available in the browser's overflow menu.
* `app/src/main/res/drawable/`: Contains drawable resources like `ic_home`, `ic_tab`, `ic_menu`, `rounded_edittext`, `bordered_textview`.

## Contributing

Contributions are welcome! If you have suggestions for improvements, new features, or bug fixes, please follow these steps:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/AmazingFeature`).
3.  Make your changes.
4.  Commit your changes (`git commit -m 'Add some AmazingFeature'`).
5.  Push to the branch (`git push origin feature/AmazingFeature`).
6.  Open a Pull Request.

Please ensure your code adheres to standard Android development practices and includes appropriate comments.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
*(You'll need to create a LICENSE file in your repository if you haven't already. A common choice is the MIT License for open-source projects.)*

## Acknowledgements

* Android Developers Documentation
* [Any other libraries or resources you used that require attribution]

---
© 2023 Your Name or Organization. All rights reserved.
