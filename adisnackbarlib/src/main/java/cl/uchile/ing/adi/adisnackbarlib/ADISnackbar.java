package cl.uchile.ing.adi.adisnackbarlib;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;

/**
 * ADISnackbar eases the creation of customized Android Snackbars.
 */
public class ADISnackbar {
    /**
     * Shows a Snackbar
     *
     * @param context The Application's context
     * @param message The message id to show
     * @param type Type of message to show
     * @param view The view to start the CoordinatorLayout or FrameLayout where to show the snackbar
     */
    public static void snackbar(int message, Type type, View view, Context context){
        if(context == null) return;
        snackbar(context.getString(message), type, view, context);
    }


    /**
     *
     *  Shows a Snackbar
     *
     * @param message The message id to show
     * @param type Type of message to show
     * @param fragment The fragment where the snackbar will be shown
     */
    public static void snackbar(int message, Type type, Fragment fragment){
        snackbar(message, type, fragment.getView(), fragment.getContext());
    }

    /**
     *
     *  Shows a Snackbar
     *
     * @param message The message to show
     * @param type Type of message to show
     * @param fragment The fragment where the snackbar will be shown
     */
    public static void snackbar(String message, Type type, Fragment fragment){
        snackbar(message, type, fragment.getView(), fragment.getContext());
    }

    /**
     * Shows a Snackbar from a formatted message.
     *
     * The message can be formatted by adding a special character at the beginning of the text:
     * <ul>
     * <li>'+' success message</li>
     * <li> '-' error message</li>
     * <li> '!' warning message</li>
     * </ul>
     *
     * When the special char is present, it's removed from the shown message and the snackbar is formatted accordingly
     * When no special char is present, the message is shown and the type is @{@link Type#DEFAULT}
     *
     * @param formattedString The formatted string
     * @param view The view to start the CoordinatorLayout or FrameLayout where to show the snackbar
     * @param context The application's context
     */
    public static void snackbar(String formattedString, View view, Context context){
        if(TextUtils.isEmpty(formattedString)) return;
        Type type;
        char typeChar = formattedString.charAt(0);
        switch (typeChar){
            case '+':
                type = Type.SUCCESS;
                formattedString = formattedString.substring(1);
                break;
            case '-':
                type = Type.ERROR;
                formattedString = formattedString.substring(1);
                break;
            case '!':
                type = Type.WARNING;
                formattedString = formattedString.substring(1);
                break;
            default:
                type = Type.DEFAULT;
                break;
        }
        snackbar(formattedString,type,view,context);
    }

    /**
     * Shows a Snackbar
     *
     * @param message Message to be shown
     * @param type Type of message to show
     * @param view The view to start the CoordinatorLayout or FrameLayout where to show the snackbar
     * @param context The application's context
     */
    public static void snackbar(String message, Type type, View view, Context context){
        int duration = message.length() > 100 ? Snackbar.LENGTH_LONG : Snackbar.LENGTH_SHORT;
        final Snackbar snackbar = Snackbar.make(view, message, duration);

        View snackview = snackbar.getView();
        int color;
        switch(type){
            case SUCCESS:
                color = R.color.success;
                break;
            case WARNING:
                color = R.color.warning;
                break;
            case ERROR:
                color = R.color.error;
                break;
            case DEFAULT:
            default:
                color = R.color.normal;
                break;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) snackview.setBackgroundColor(context.getResources().getColor(color, null));
        else //noinspection deprecation
            snackview.setBackgroundColor(context.getResources().getColor(color));
        if (Looper.myLooper() != Looper.getMainLooper())
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override public void run() {
                    snackbar.show();
                }
            });
        else snackbar.show();
    }



    public enum Type {
        DEFAULT, SUCCESS, WARNING, ERROR;
    }
}
