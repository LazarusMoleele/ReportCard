package com.example.andriod.reportcard;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private Button admin, student;
    private EditText edtUserName, edtPassword;
    private String userName,password;
    private Dialog dialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin = (Button)findViewById(R.id.btnAdmin);
        student = (Button) findViewById(R.id.btnStudent);



        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v = MainActivity.this.getLayoutInflater().inflate(R.layout.logindialog,null,false);
                dialog = new Dialog(MainActivity.this);
                builder = new  AlertDialog.Builder(MainActivity.this);
                builder.setTitle("LogIn");
                edtUserName = (EditText) v.findViewById(R.id.edtUserName);
                edtPassword = (EditText) v.findViewById(R.id.edtPassword);
                builder.setView(v);
                builder.setNegativeButton("Cancel",null);
                builder.setPositiveButton("LogIn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        userName = edtUserName.getText().toString();
                        password = edtPassword.getText().toString();

                        if (userName.equals("Laz")&& password.equals("1234")){

                            Intent intent = new Intent(MainActivity.this,Admin2.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this,"Username or Password Incorrect!",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog = builder.create();
                dialog.show();

            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v = MainActivity.this.getLayoutInflater().inflate(R.layout.logindialog,null,false);
                dialog = new Dialog(MainActivity.this);
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("LogIn");
                edtUserName = (EditText) v.findViewById(R.id.edtUserName);
                edtPassword = (EditText) v.findViewById(R.id.edtPassword);
                builder.setView(v);
                builder.setNegativeButton("Cancel",null);
                builder.setPositiveButton("LogIn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        userName = edtUserName.getText().toString();
                        password = edtPassword.getText().toString();

                        if (userName.equals("Laz")&&password.equals("1234")){

                            Intent intent = new Intent(MainActivity.this,Student2.class);
                            startActivity(intent);
                        }else
                            Toast.makeText(MainActivity.this,"Username or Password Incorrect!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog = builder.create();
                dialog.show();

            }
        });
    }
}
