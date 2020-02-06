package cl.uchile.ing.adi.adisnackbar;

import androidx.appcompat.app.AppCompatActivity;
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
        ADISnackbar.snackbar("this is a success messsage", ADISnackbar.Type.SUCCESS, v, getApplicationContext());
    }
    public void onDefaultMsg(View v){
        ADISnackbar.snackbar("this is a normal messsage", ADISnackbar.Type.NORMAL, v, getApplicationContext());
    }
    public void onWarningMsg(View v){
        ADISnackbar.snackbar("this is a warning message", ADISnackbar.Type.WARNING, v, getApplicationContext());
    }
    public void onErrorMsg(View v){
        ADISnackbar.snackbar("this is a failure messsage", ADISnackbar.Type.ERROR, v, getApplicationContext());
    }
    public void onCallMany(View v){
        char[] symbols = new char[4];
        symbols[0] = '+';
        symbols[1] = '-';
        symbols[2] = '*';
        symbols[3] = ' ';
        for(int i=0;i<5;i++){
            ADISnackbar.snackbar(String.format("%c Prueba %d", symbols[i%symbols.length], i), v, getApplicationContext());
        }
    }
}
