# How to Contribute
This page contains information related to the development of this theme. If you want to contribute by submitting code or notify the developers about issues you experienced, this page is for you!

> Hint for pros: A lot of the emojis are linked to useful sites, so you can use them as a button!

## Creating Issues
This section covers the process on how to create an issue.
First of all, there are templates that you should use whenever possible. They provide a nice guideline on what information is needed to see the issue adressed.
If your request doesn't quite fit into these categories, feel free to open a blank one (small text below the templates).

### [🐛](https://github.com/l0drex/Intellij-KDE-Breeze-Theme/issues/new?assignees=&labels=bug&template=bug_report.md&title=) Bug report
Use this template for any problem you experienced.
Common problems would be:

- _Too low contrast, so that text can't be read easily or icons are invisible_
- _Colors that don't fit into the Breeze theme_
- _Colors used in the wrong place_

### [💡](https://github.com/l0drex/Intellij-KDE-Breeze-Theme/issues/new?assignees=&labels=enhancement&template=feature_request.md&title=) Feature request
Use this template to request a feature that you want to see implemented into this theme.
A feature request could be:

- _Automatic dark mode_
- _Use the Breeze icons_

### [📖](https://github.com/l0drex/Intellij-KDE-Breeze-Theme/issues/new?assignees=&labels=documentation&template=documentation.md&title=) Documentation
This template should be used for requests related to the documentation (Contributing, Readme, License, Wiki, ...).
This could be:

- _A typo you found_
- _Updating old information, e.g. a process that changed due to an update_

## Proposing Changes

### ❗ Before you start ❗
Before you start to start editing this theme, checkout
[closed issues marked as _wontfix_](https://github.com/l0drex/Intellij-KDE-Breeze-Theme/issues?q=is%3Aissue+is%3Aclosed+label%3Awontfix),
since these are issues that can't be resolved.
If you don't see the issue that you want to adress there, create a new issue and mention that you want to fix this by yourself.
This ensures others aren't working on the same thing at the same time, resulting in duplicated pull requests.

If you have any questions regarding the code, checkout the wiki [ 📖](https://github.com/l0drex/Intellij-KDE-Breeze-Theme/wiki).

### 💻 How to work on this theme
This section covers the process on how to propose changes to this theme.
**You need to use an IDE made by intellij to test the theme. To find more info, see the section *testing*.**

1. [Fork](https://docs.github.com/en/github/getting-started-with-github/fork-a-repo) this repository.
2. [Create a new _draft pull request_](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/about-pull-requests#draft-pull-requests) where you describe exactly what changes you have made and link the issue you resolved so that it gets closed when the pull request has been merged.
3. Open the project in your IDE.
4. Start making changes. The most important files are located in `src/main/resources`.
   1. `*.theme.json` files are used for the UI theme. Just edit the file directly.
      Use the defined colors at the top of the file wherever possible. Add new definitions if you happen to use one color very often.
   3. `*.xml` files are the editor color schemes. These files can be edited from within a GUI:
      1. Copy the file to a new location.
      2. Rename it so that it ends with `*.icls`.
      3. In the intellij IDE, go to <kbd>File</kbd> → <kbd>Editor</kbd> → <kbd>Color Scheme</kbd>
      4. Select <kbd>⚙️</kbd> → <kbd>Import Scheme </kbd> → <kbd>Intellij IDEA color scheme </kbd>
      5. Select your renamed file.
      6. Enjoy the GUI! 🎉
4. Check out how the theme looks (see _Testing_ for editor color schemes).
5. Push your changes to your repository.
6. Mark the pull request as _ready for review_.

### ✔️ Testing
This section covers the process of testing out UI schemes. To preview an editor scheme, hitting apply in the color scheme section of the settings menu is enough.

To see an UI theme in action, run the plugin (top right corner). Go to <kbd>Tools</kbd> → <kbd>Internal Actions</kbd> → <kbd>UI</kbd>

There are many test dialogs to try out, here are some important ones:

- Standard Panels
- Validation Dialog Test
- Test notification
- Test progress indicators

### ❔ More information
If you want to know more, here are some useful links you can use:

- [JetBrains documentation on how to create custom UI themes](https://plugins.jetbrains.com/docs/intellij/themes.html)
- [Official listing of all UI components](https://plugins.jetbrains.com/docs/intellij/user-interface-components.html), useful to find the names of a specific thing
- [Official documentation of Breeze](https://develop.kde.org/hig/)
- Not a link, but a [gallery of all UI components used in plasma](https://apps.kde.org/kirigami2.gallery/) (ok, it still is a link)
- A [mockup created in inkscape](https://community.kde.org/KDE_Visual_Design_Group/HIG/MockupToolkit) for the Breeze theme
