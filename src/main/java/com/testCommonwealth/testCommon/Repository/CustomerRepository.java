package com.testCommonwealth.testCommon.Repository;

import com.testCommonwealth.testCommon.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("Select c from Customer c where c.name like %:name% order by c.name asc")
    List<Customer> findByNameIgnoreContaining(String name);



}
