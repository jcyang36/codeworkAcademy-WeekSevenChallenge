package com.example.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/23/17.
 */
public interface RecordRepository extends CrudRepository<Record, Integer>{

    public List<Record> findById(int id);

    public List<Record> findAllByFirst(String First);
    public List<Record> findAllByLast(String Last);

    public List<Record> findAllBySchool(String School);

    public List<Record> findAllByCompany(String Company);
    public List<Record> findAllBySkill(String Skill);
}
