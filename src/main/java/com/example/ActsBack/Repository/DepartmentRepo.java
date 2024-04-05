package com.example.ActsBack.Repository;

import com.example.ActsBack.Model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentModel,Long> {
}
