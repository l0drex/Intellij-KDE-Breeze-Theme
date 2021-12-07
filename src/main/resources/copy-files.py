#!/bin/env python

from os.path import isfile, isdir
from shutil import copyfile
import sys
import json

# NOTE change this to the path where you cloned breeze-icons to
# The repo-url is https://invent.kde.org/frameworks/breeze-icons
breeze_icons_path = "/home/l0drex/Projekte/KDE/breeze-icons"
while not isfile(breeze_icons_path + "/README.md"):
    print("Looks like the path to the breeze-icons repo is wrong.")
    breeze_icons_path = input("Your actual path: ")

images = {}
light_theme_file = "./Breeze_Light.theme.json"
dark_theme_file = light_theme_file.replace("Light", "Dark")


def image_paths():
    for image in images.values():
        yield image
        yield image.replace("/icons/", "/icons-dark/")


def copy_files():
    """Copies the needed icons from the breeze-icons repo to this project"""

    print("Copying file from the breeze-icons to this project")

    for image in image_paths():
        if not isfile("." + image):
            try:
                copyfile(breeze_icons_path + image, "." + image)
            except FileNotFoundError as e:
                print("Invalid path found:", image)
                raise e


def dark_icons():
    """Copies the custom icons from the light theme to the dark theme in the dark variant"""

    print("Adding icons to dark theme")

    with open(dark_theme_file) as config_file:
        config_data = json.load(config_file)

    # remove every custom icon
    colors = config_data["icons"]["ColorPalette"]
    config_data["icons"].clear()
    config_data["icons"]["ColorPalette"] = colors

    # append modified icons from light theme
    for key, value in images.items():
        config_data["icons"][key] = value.replace("/icons/", "/icons-dark/", 1)

    # save the file
    with open(dark_theme_file, "w") as file:
        json.dump(config_data, file, indent=2)


def main():
    # find all used images
    with open("./Breeze_Light.theme.json") as config_file:
        config_data = json.load(config_file)

    config_images = config_data["icons"]
    config_images.pop("ColorPalette")
    images.update(config_images)

    print(f"Using {len(images)} images")

    dark_icons()
    copy_files()


if __name__ == "__main__":
    main()
