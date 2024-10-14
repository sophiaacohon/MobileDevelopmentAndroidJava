package com.ph.edu.usc.roomdbjava;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao


public interface PersonDAO {

    @Insert
    public void addPerson(Person person);

    @Update
    public void updatePerson(Person person);

    @Delete
    public void deletePerson(Person person);

    @Query("SELECT * FROM PERSON")
    public List<Person> getAllPersons();

    @Query("SELECT * FROM PERSON WHERE person_id == :person_id")
    public Person getPerson(int person_id);


}
