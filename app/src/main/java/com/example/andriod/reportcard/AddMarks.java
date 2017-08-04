package com.example.andriod.reportcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;

/**
 * Created by Lazarus Moleele on 2017/07/28.
 */

public class AddMarks extends AppCompatActivity {
    private Button add;
    private EditText edtMark1,edtMark2, edtMark3, edtMark4, edtMark5, edtMark6;
    private String mark1,mark2,mark3,mark4,mark5,mark6;
    private String fullname,studentNumber, Sub1, Sub2, Sub3,Sub4,Sub5,Sub6;
    StudentDatabase database;
    Student student;
    Intent intent;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmarks);
        edtMark1=(EditText)findViewById(R.id.edtMark1);
        edtMark2=(EditText)findViewById(R.id.edtMark2);
        edtMark3=(EditText)findViewById(R.id.edtMark3);
        edtMark4=(EditText)findViewById(R.id.edtMark4);
        edtMark5=(EditText)findViewById(R.id.edtMark5);
        edtMark6=(EditText)findViewById(R.id.edtMark6);
        add=(Button)findViewById(R.id.btnAddMark);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mark1=edtMark1.getText().toString();
                mark2=edtMark2.getText().toString();
                mark3=edtMark3.getText().toString();
                mark4=edtMark4.getText().toString();
                mark5=edtMark5.getText().toString();
                mark6=edtMark6.getText().toString();

                 intent= AddMarks.this.getIntent();

                fullname=intent.getStringExtra(AddStudent.FULLNAME);
                studentNumber=intent.getStringExtra(AddStudent.STUDENT_NO);
                Sub1=intent.getStringExtra(AddStudent.SUB1);
                Sub2=intent.getStringExtra(AddStudent.SUB2);
                Sub3=intent.getStringExtra(AddStudent.SUB3);
                Sub4=intent.getStringExtra(AddStudent.SUB4);
                Sub5=intent.getStringExtra(AddStudent.SUB5);
                Sub6=intent.getStringExtra(AddStudent.SUB6);
                student= new Student(fullname,studentNumber,Sub1,Sub2,Sub3,Sub4,Sub5,Sub6,mark1,mark2,mark3,mark4,mark5,mark6);

                database=new StudentDatabase(AddMarks.this);


                database.addStudent(student);
                Toast.makeText(AddMarks.this,"Adding Complete",Toast.LENGTH_LONG).show();
                intent=new Intent(AddMarks.this,Admin2.class);
                startActivity(intent);

            }
        });
    }
}
