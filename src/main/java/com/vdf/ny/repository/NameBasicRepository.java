package com.vdf.ny.repository;

import com.vdf.ny.entity.NameBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NameBasicRepository extends JpaRepository<NameBasicEntity, String> {
  NameBasicEntity findByPrimaryName(String name);
}

