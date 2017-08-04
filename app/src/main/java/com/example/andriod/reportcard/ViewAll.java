package com.example.andriod.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAll extends AppCompatActivity {
    ListView lvmain;
    ArrayAdapter<Student> adapter;
    ArrayList<Student> students=new ArrayList<>();
    StudentDatabase studentDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        studentDatabase=new StudentDatabase(this);

        students=studentDatabase.getAllStudents();


        lvmain=(ListView)findViewById(R.id.lvmain);


        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,students);

        lvmain.setAdapter(adapter);

    }
}
