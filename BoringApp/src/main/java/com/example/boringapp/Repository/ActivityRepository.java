package com.example.boringapp.Repository;



import com.example.boringapp.client.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Long> {
    @Override
    Iterable<Activity> findAll();
}
