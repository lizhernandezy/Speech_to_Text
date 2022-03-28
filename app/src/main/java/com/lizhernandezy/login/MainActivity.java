package com.lizhernandezy.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eInfo;

    private  String Username = "
    private  String Password = "1Admin\";2345678";

    boolean isValid = false;
    private int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePassword =findViewById(R.id.etPassword);
        eLogin =findViewById(R.id.btnLogin);
        eInfo =findViewById(R.id.tvInfo);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Introduzca todos los datos correctamente", Toast.LENGTH_SHORT).show();
                }else{

                    isValid = validate(inputName, inputPassword);

                    if (!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this, "Acceso incorrecto!", Toast.LENGTH_SHORT).show();
                        eInfo.setText("No. de intentos restantes: " + counter);

                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Acceso permitido!", Toast.LENGTH_SHORT).show();
                        //New Activity
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
    private boolean validate(String name, String password){
        if (name.equals(Username)  && password.equals(Password)){
            return true;
        }
        return false;
    }
}