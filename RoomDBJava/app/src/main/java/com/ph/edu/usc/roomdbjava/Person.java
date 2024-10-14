package com.ph.edu.usc.roomdbjava;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Person")
public class Person {

    @ColumnInfo(name="person_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="age")
    String age;

    @Ignore
    public Person(){

    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}





