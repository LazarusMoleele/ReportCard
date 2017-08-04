package com.example.andriod.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.R.attr.version;

/**
 * Created by Lazarus Moleele on 2017/08/03.
 */

public class StudentDatabase extends SQLiteOpenHelper {

    private final static String DATABASE_NAME="student.db";
    private final static String TABLE_NAME ="student";

    public final static String COLUMN_ID="id";
    public final static String COLUMN_NAME="name";
    public final static String COLUMN_STUDENT_NUMBER="student number";

    public final static String COLUMN_SUB1="sub1";
    public final static String COLUMN_SUB2="sub2";
    public final static String COLUMN_SUB3="sub3";
    public final static String COLUMN_SUB4="sub4";
    public final static String COLUMN_SUB5="sub5";
    public final static String COLUMN_SUB6="sub6";

    public final static String COLUMN_MARK1="mark1";
    public final static String COLUMN_MARK2="mark2";
    public final static String COLUMN_MARK3="mark3";
    public final static String COLUMN_MARK4="mark4";
    public final static String COLUMN_MARK5="mark5";
    public final static String COLUMN_MARK6="mark6";

    public final static String DATABASE_CREATE = "create table " +TABLE_NAME + "("
                                                +COLUMN_ID + " integer primary key autoincrement, "
                                                +COLUMN_STUDENT_NUMBER + " text not null, "
                                                +COLUMN_SUB1 + " text not null, "
                                                +COLUMN_SUB2 + " text not null, "
                                                +COLUMN_SUB3 + " text not null, "
                                                +COLUMN_SUB4 + " text not null, "
                                                +COLUMN_SUB5 + " text not null, "
                                                +COLUMN_SUB6 + " text not null, "

                                                +COLUMN_MARK1 + " text not null, "
                                                +COLUMN_MARK2 + " text not null, "
                                                +COLUMN_MARK3 + " text not null, "
                                                +COLUMN_MARK4 + " text not null, "
                                                +COLUMN_MARK5 + " text not null, "
                                                +COLUMN_MARK6 + " text not null );";

    public StudentDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);

    }

    public void  addStudent(Student student){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv= new ContentValues();

        cv.put(COLUMN_NAME,student.getStudentName());
        cv.put(COLUMN_STUDENT_NUMBER,student.getStudentNumber());
        cv.put(COLUMN_SUB1,student.getSub1());
        cv.put(COLUMN_SUB2,student.getSub2());
        cv.put(COLUMN_SUB3,student.getSub3());
        cv.put(COLUMN_SUB4,student.getSub4());
        cv.put(COLUMN_SUB5,student.getSub5());
        cv.put(COLUMN_SUB6,student.getSub6());
        cv.put(COLUMN_MARK1, student.getMark1());
        cv.put(COLUMN_MARK2, student.getMark2());
        cv.put(COLUMN_MARK3, student.getMark3());
        cv.put(COLUMN_MARK4, student.getMark4());
        cv.put(COLUMN_MARK5, student.getMark5());
        cv.put(COLUMN_MARK6, student.getMark6());

        db.insert(TABLE_NAME, null, cv);
    }

//    public void addMark(Student student){
//
//        SQLiteDatabase db=this.getWritableDatabase();
//
//        ContentValues cv= new ContentValues();
//
//        cv.put(COLUMN_MARK1, student.getMark1());
//        cv.put(COLUMN_MARK2, student.getMark2());
//        cv.put(COLUMN_MARK3, student.getMark3());
//        cv.put(COLUMN_MARK4, student.getMark4());
//        cv.put(COLUMN_MARK5, student.getMark5());
//        cv.put(COLUMN_MARK6, student.getMark6());
//
//        db.insert(TABLE_NAME, null, cv);
//
//    }

    public ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList<>();

        String sql = "select * from " +TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst())
        {
            do {

                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setStudentName(cursor.getString(1));
                student.setStudentNumber(cursor.getString(2));
                student.setSub1(cursor.getString(3));
                student.setSub2(cursor.getString(4));
                student.setSub3(cursor.getString(5));
                student.setSub4(cursor.getString(6));
                student.setSub5(cursor.getString(7));
                student.setSub6(cursor.getString(8));
                student.setMark1(cursor.getString(9));
                student.setMark2(cursor.getString(10));
                student.setMark3(cursor.getString(11));
                student.setMark4(cursor.getString(12));
                student.setMark5(cursor.getString(13));
                student.setMark6(cursor.getString(14));

                students.add(student);



            }while (cursor.moveToNext());

        }
        return students;
    }

}
