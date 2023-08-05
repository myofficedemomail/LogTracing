package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.AppEntity;

public interface AppRepo extends JpaRepository<AppEntity, Integer> {

}
