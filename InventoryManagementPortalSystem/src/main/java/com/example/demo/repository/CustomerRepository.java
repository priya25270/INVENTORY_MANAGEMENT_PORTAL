package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.CustomerModel;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer>{
	@Query(value="select * from customer_model",nativeQuery = true )
	public List<CustomerModel>getAllrows();

	@Modifying
	@Transactional
	@Query("Delete from CustomerModel h where h.custId=:id")
	public int deleteId(@Param("id") int id);
	
	
	
}