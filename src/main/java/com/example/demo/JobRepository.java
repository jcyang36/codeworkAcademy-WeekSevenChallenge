package com.example.demo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by student on 6/23/17.
 */
public interface JobRepository extends CrudRepository<Job, Integer>{

    public List<Job> findAllBySkills(String skills);
    @Query("SELECT j FROM Job j WHERE j.skills LIKE CONCAT('%',:skills,'%')")
    List<String> findJobsWithPartOfSkills(@Param("skills") String skills);

}
