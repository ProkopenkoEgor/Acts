package com.example.ActsBack.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    @Column
    private String departmentName;

    @OneToMany(mappedBy = "departmentModel")
    private List<UserModel> userModelList;
}