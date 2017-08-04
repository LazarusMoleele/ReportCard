package com.example.andriod.reportcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.andriod.reportcard.R.id.btnAddMarks;
import static com.example.andriod.reportcard.R.id.btnAddStudent;

/**
 * Created by Lazarus Moleele on 2017/08/02.
 */

public class Admin2 extends AppCompatActivity {

    private Button viewall;
    private Button btnAdd;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        //btnAddMarks = (Button) findViewById(btnAddMarks);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        viewall=(Button)findViewById(R.id.btnViewAll);

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Admin2.this,ViewAll.class);
                startActivity(intent);
            }
        });


//        btnAddMarks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(Admin2.this, AddMarks.class);
//                startActivity(intent);
//            }
//        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin2.this,AddStudent.class);
                startActivity(intent);
            }
        });
    }
}
