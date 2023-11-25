package com.teclab.sharedpreferenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtUser, txtPass, campoUser, campoPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = (TextView) findViewById(R.id.txtUser);
        txtPass = (TextView) findViewById(R.id.txtPass);
        campoUser = (TextView) findViewById(R.id.CampoUser);
        campoPass = (TextView) findViewById(R.id.CampoPass);

    }

    public void onClick(View view) {
        switch ( view.getId()) {
            case R.id.guardar:
                guardarPreferencias();
                hideSoftKeyboard(this);
                break;
            case R.id.cargar:
                cargarPreferencias();
                break;
        }
    }

    //Metodo para ocultar teclado en pantalla
    private void hideSoftKeyboard(MainActivity mainActivity) {
        InputMethodManager inputMethodManager = (InputMethodManager) mainActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(mainActivity.getCurrentFocus().getWindowToken(), 0);
    }



    public void guardarPreferencias() {
        String usuario = txtUser.getText().toString();
        String password = txtPass.getText().toString();

        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", usuario);
        editor.putString("pass", password);
        editor.putBoolean("boolean", true);
         editor.putFloat("float", 4044);

        editor.commit();


    }



    public  void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        String usuario = preferences.getString("usuario", "No existe la informacion");
        String password = preferences.getString("pass", "No existe la informacion");

        campoUser.setText(usuario);
        campoPass.setText(password);


    }
}