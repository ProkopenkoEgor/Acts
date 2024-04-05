package com.example.ActsBack.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RoleDto {

    @JsonProperty("ROLENAME")
    private final String roleName;

    public RoleDto(String roleName) {
        this.roleName = roleName;
    }
}
