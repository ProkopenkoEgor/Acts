package com.example.ActsBack.Repository;

import com.example.ActsBack.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository <RoleModel,Long> {
}
