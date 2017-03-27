# ADISnackbar
Snackbars to allow showing modern-looking messages than Toast. Unfortunately if you want to add some styling you need to use several lines of aditional code. We provide a simple library to show coloured snackbars with a simple methods calls.

# Usage

There are several methods you can use, there are all documented in the ADISnackbar.java class.

There two main ways to show a Snackbar:

Using a formatted text using the chars '+', '-', '*' to modify the colours.

```
ADISnackbar.snackbar("+hello world", fragment);
```

Or you can explicitly define the type of message as argument:

```
ADISnackbar.snackbar("this is a failure messsage", ADISnackbar.Type.ERROR, v, getApplicationContext());
```

You can check the demo app included in this repo for running examples.
