package com.example.andriod.reportcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.icu.lang.UCharacter.DecompositionType.SUB;

/**
 * Created by Lazarus Moleele on 2017/08/02.
 */

public class AddStudent extends AppCompatActivity {

    StudentDatabase database;

    private Button btnAddStudent;
    private EditText edtName, edtSurname,edtStudentNumber, edtSub1,edtSub2,edtSub3,edtSub4,edtSub5,edtSub6;
    private String fullname,name, surname,studentNumber, Sub1, Sub2, Sub3,Sub4,Sub5,Sub6;
    public final static String FULLNAME="fullname";
    public final static String STUDENT_NO="fullname";
    public final static String SUB1="fullname";
    public final static String SUB2="fullname";
    public final static String SUB3="fullname";
    public final static String SUB4="fullname";
    public final static String SUB5="fullname";
    public final static String SUB6="fullname";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        btnAddStudent = (Button) findViewById(R.id.btnAddStudent);
        edtName = (EditText) findViewById(R.id.edtStudentName);
        edtSurname = (EditText) findViewById(R.id.edtStudentSurname);
        edtStudentNumber = (EditText) findViewById(R.id.edtStudentName);
        edtSub1 =(EditText) findViewById(R.id.edtSub1);
        edtSub2 =(EditText) findViewById(R.id.edtSub2);
        edtSub3 =(EditText) findViewById(R.id.edtSub3);
        edtSub4 =(EditText) findViewById(R.id.edtSub4);
        edtSub5 =(EditText) findViewById(R.id.edtSub5);
        edtSub6 =(EditText) findViewById(R.id.edtSub6);
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=edtName.getText().toString();
                surname=edtSurname.getText().toString();

                fullname=surname +" "+name;
                studentNumber=edtStudentNumber.getText().toString();
                Sub1=edtSub1.getText().toString();
                Sub2=edtSub2.getText().toString();
                Sub3=edtSub3.getText().toString();
                Sub4=edtSub4.getText().toString();
                Sub5=edtSub5.getText().toString();
                Sub6=edtSub6.getText().toString();


                Intent intent=new Intent(AddStudent.this,AddMarks.class);
                intent.putExtra(FULLNAME,fullname);
                intent.putExtra(STUDENT_NO,studentNumber);
                intent.putExtra(SUB1,Sub1);
                intent.putExtra(SUB2,Sub2);
                intent.putExtra(SUB3,Sub3);
                intent.putExtra(SUB4,Sub4);
                intent.putExtra(SUB5,Sub5);
                intent.putExtra(SUB6,Sub6);
                startActivity(intent);


//                Student student= new Student(fullname,studentNumber,Sub1,Sub2,Sub3,Sub4,Sub5,Sub6);
//                database = new StudentDatabase(AddStudent.this);
//                database.addStudent(student);


            }
        });



    }
}
