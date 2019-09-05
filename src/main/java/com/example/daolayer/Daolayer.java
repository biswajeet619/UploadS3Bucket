package com.example.daolayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbentity.ImgLog;



public interface Daolayer extends JpaRepository<ImgLog, Integer> {

}
