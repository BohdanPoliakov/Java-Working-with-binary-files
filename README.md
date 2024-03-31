[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/9BNu5dce)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=14295504)
# Assignments

Develop a program to process a binary file. It is compulsory to use
Main.java, which is available on github.com. Main.java contains five
methods: main, create, view, calculate and about. The main, create and view methods are already
already implemented and perform the following operations:
- The create method creates a binary file containing integers of type int. Initially, the create method
method inputs the name of the file (with path) from the keyboard, and then the number of integers and the integer
The method then uses the integer sequence. The create method writes the numbers entered from the keyboard into the file.
- The view method outputs the contents of the file to the screen. Initially, the view method enters from the keyboard the corresponding
file name (with path) and then outputs the contents of the file.
- The main method outputs the following menu to the screen in an infinite loop:
1) Create
2) Calculate
3) View
4) About
5) Exit
The main method then inputs an integer from the keyboard. If the user entered 1, then the method
main calls the create method and creates the file. If the user entered 2, the method
main calls the calculate method. If the user entered 3, the contents of the specified file are output to the screen by
the view method. If the user entered 4, the about method is called. But if the user
entered 5, then the program exits.

Task:

Modify the calculate and about methods to do the following:
- The calculate method must enter a filename (with path) and a number from the keyboard. From the file
delete all numbers equal to the entered number
