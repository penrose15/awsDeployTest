package com.deploytest.awsDeploy.mapper;

import com.deploytest.awsDeploy.dto.PatchUserDto;
import com.deploytest.awsDeploy.dto.PostUserDto;
import com.deploytest.awsDeploy.dto.ResponseUserDto;
import com.deploytest.awsDeploy.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User postUserDtoToUser(PostUserDto postUserDto);

    User patchUserDtoToUser(PatchUserDto patchUserDto);

    ResponseUserDto userToResponseUserDto(User user);

    List<ResponseUserDto> userToResponseUserDtos(List<User> users);
}
