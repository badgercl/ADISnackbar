package cl.uchile.ing.adi.adisnackbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cl.uchile.ing.adi.adisnackbarlib.ADISnackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSuccessMsg(View v){
        ADISnackbar.snackbar("+this is a success messsage", v, getApplicationContext());
    }
    public void onDefaultMsg(View v){
        ADISnackbar.snackbar("this is a normal messsage", v, getApplicationContext());
    }
    public void onWarningMsg(View v){
        ADISnackbar.snackbar("!this is a warning message", v, getApplicationContext());
    }
    public void onErrorMsg(View v){
        ADISnackbar.snackbar("-this is a failure messsage", v, getApplicationContext());
    }
}
