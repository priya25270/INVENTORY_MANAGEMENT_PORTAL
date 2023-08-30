package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StockMovement;

public interface smrepository extends JpaRepository<StockMovement, Integer> {

}
