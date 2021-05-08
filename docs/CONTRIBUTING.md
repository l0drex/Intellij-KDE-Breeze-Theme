# How to Contribute
This page contains notes related to the development of this theme. If you want to contribute, this page is for you!

## Creating Issues
This section covers the process on how to create an issue.
First of all, there are templates that you should use whenever possible. They provide a nice guideline on what information is needed to see the issue adressed.
If your request doesn't quite fit into these categories, feel free to open a blank one (small text below the templates).

### 🐛 Bug report
Use this template for any problem you experienced.
Common problems would be:

- Too low contrast, so that text can't be read easily or icons are invisible
- Colors that don't fit the Breeze theme
- Colors used in the wrong place

### 💡 Feature request
Use this template to request a feature that you want to see implemented into this theme.
A feature request could be:

- Change the theme automatically based on the theme the system uses
- Use the Breeze icons

## Proposing Changes

### ❗ Before you start ❗
Before you start to start editing this theme, make sure to go through all
[closed issues marked as _wontfix_](https://github.com/l0drex/Intellij-KDE-Breeze-Theme/issues?q=is%3Aissue+is%3Aclosed+label%3Awontfix),
since these are issues that can't be resolved.

### 💻 How to work on this theme
This section covers the process on how to propose changes to this theme.
**You need to use an IDE made by intellij to test the theme. To find more info, see the section *testing*.**

1. Fork this repository
2. Open the project in your IDE
3. Start making changes. The most import files are located in `src/main/resources`.
   1. `*.theme.json` are used for the UI theme. Just edit the file directly.
   2. `*.xml` files are the editor schemes. These files can be edited from within a GUI:
      1. Copy the file to a new location.
      2. Rename it so that it ends with `*.icls`.
      3. In the intellij IDE, go to <kbd>File</kbd> → <kbd>Editor</kbd> → <kbd>Color Scheme</kbd>
      4. Select <kbd>⚙️</kbd> → <kbd>Import Scheme </kbd> → <kbd>Intellij IDEA color scheme </kbd>
      5. Select your renamed file.
      6. Enjoy the GUI! 🎉
4. Check out how the theme (see Testing).

### ✔️ Testing
This section covers the process of testing out UI schemes. To an editor scheme, hitting apply in the color scheme section of the settings menu is enough.
To see the theme in action, run the plugin (top right corner). Go to <kbd>Tools</kbd> → <kbd>Internal Actions</kbd> → <kbd>UI</kbd>

There are many test dialogs to try out, here are some important ones:

- Standard Panels
- Validation Dialog Test
- Test notification
- Test progress indicators
