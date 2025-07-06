
eBrowser: Your Simple Android Web Companion

Welcome to eBrowser, a clean and straightforward web browser designed for Android. Built as a semester project, eBrowser focuses on delivering essential Browse features in a user-friendly package, making your everyday web navigation smooth and efficient.

✨ Features at a Glance

    Effortless Multi-tab Browse: Juggle multiple websites with ease. Open new tabs and switch between them seamlessly to keep your Browse organized.

    Quick Bookmark Access: Found a page you love? Bookmark it instantly and revisit your favorite sites with a single tap from your saved list.

    Comprehensive Browse History: Never lose track of where you've been. Your complete Browse history is just a tap away, allowing you to quickly revisit previously viewed pages.

    Intuitive Navigation Controls: Navigate the web like a pro with dedicated buttons for going back, forward, reloading pages, and jumping straight back to your homepage.

    Smart Search & URL Bar: Whether you know the exact address or just want to search for something, our combined bar makes it quick to get where you need to go.

    Flexible Zoom: Zoom in to catch every detail or zoom out for a broader view – eBrowser adapts to your reading preferences.

📸 Glimpse of eBrowser

(Since I can't generate images, please replace these placeholders with actual screenshots of your amazing eBrowser app!)

Home Screen
	

Tab Switcher
	

Bookmarks & History


 Your gateway to the web, featuring the URL bar and quick access buttons.
	


 Effortlessly switch between your open tabs, keeping your Browse tidy.
	


 Access your favorite sites and revisit past pages with convenience.

🚀 Getting Started

Ready to experience eBrowser? Here's how to get it up and running on your Android device or emulator.

Prerequisites

    Android Studio: The latest version is recommended for the best experience.

    Android SDK: Ensure you have API Level 21 or higher installed.

Installation Steps

    Clone the Repository:
    Start by cloning the project to your local machine using Git:
    Bash

    git clone https://github.com/YOUR_GITHUB_USERNAME/eBrowser.git

    (Remember to replace YOUR_GITHUB_USERNAME with your actual GitHub username and the correct repository name!)

    Open in Android Studio:
    Launch Android Studio and select "Open an existing Android Studio project." Navigate to the eBrowser directory you just cloned and open it.

    Sync Gradle Project:
    Android Studio will typically sync the project automatically. If it doesn't, simply go to File > Sync Project with Gradle Files to ensure all dependencies are resolved.

    Run the Application:
    Connect your Android device (ensure USB debugging is enabled) or start an Android emulator. Click the green 'Run' button (play icon) in Android Studio, and watch eBrowser come to life!

📖 How to Use

eBrowser is designed to be intuitive. Here's a quick guide to its main functions:

    Web Navigation: Type any URL or search query into the address bar at the top. Press Enter, and you're off!

    Going Back/Forward/Reloading: Use the navigation icons in the menu to move through your Browse history or refresh the current page.

    New Tabs: Tap the tab icon to instantly open a fresh new tab.

    Switching Tabs: Want to see all your open tabs? Long-press the tab icon to bring up the tab switcher and select your desired page.

    Main Menu Options: Tap the three-dot menu icon to reveal more options, including:

        Bookmark: Save your current page.

        Show Bookmarks: View and open your saved sites.

        Show History: Browse your past visits.

        Clear History: Wipe your Browse history clean.

        Zoom In/Out: Adjust content size.

        (You can expand on other menu options if you add more to browser_menu.xml!)

🏗️ Project Structure

For those curious about the internals, here's a brief overview of eBrowser's core components:

    app/src/main/java/edu/ma/ebrowser/MainActivity.java: The heart of the application, containing all the logic for browser operations, tab management, and user interactions.

    app/src/main/res/layout/activity_main.xml: Defines the visual layout and user interface elements you see when you open eBrowser.

    app/src/main/res/menu/browser_menu.xml: Houses the definitions for the overflow menu options, like bookmarking, history, and navigation controls.

    app/src/main/res/drawable/: Contains all the lovely icons and custom background shapes that give eBrowser its look and feel.

🙏 Acknowledgments

This project benefited immensely from:

    The comprehensive Android Developers Documentation, a truly invaluable resource.

    (Add any specific tutorials, Stack Overflow threads, or individuals who provided significant help or inspiration here!)
