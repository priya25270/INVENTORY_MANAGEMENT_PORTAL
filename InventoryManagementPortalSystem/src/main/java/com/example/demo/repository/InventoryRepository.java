package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InventoryStorageArea;

public interface InventoryRepository extends JpaRepository<InventoryStorageArea, Integer>{

}
