package com.deploytest.awsDeploy.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class PatchUserDto {

    private Long userId;

    private String name;
}
