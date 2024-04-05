package com.example.ActsBack.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DepartmentDto {

    @JsonProperty("DEPARTMENTNAME")
    private final String departmentName;

    public DepartmentDto(String departmentName) {
        this.departmentName = departmentName;
    }
}
