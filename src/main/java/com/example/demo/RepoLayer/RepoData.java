package com.example.demo.RepoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Order;

@Repository
public interface RepoData extends JpaRepository<Order, Long> {}