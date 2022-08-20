package com.deploytest.awsDeploy.controller;

import com.deploytest.awsDeploy.dto.PatchUserDto;
import com.deploytest.awsDeploy.dto.PostUserDto;
import com.deploytest.awsDeploy.entity.User;
import com.deploytest.awsDeploy.mapper.UserMapper;
import com.deploytest.awsDeploy.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class UserApiController {

    private final UserService userService;
    private final UserMapper mapper;

    public UserApiController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    //user 생성
    @PostMapping
    public ResponseEntity post(@RequestBody PostUserDto postUserDto) {
        User user = userService.save(mapper.postUserDtoToUser(postUserDto));
        return new ResponseEntity<>(mapper.userToResponseUserDto(user),HttpStatus.CREATED);
    }
    //user 수정
    @PatchMapping("/{user-id}")
    public ResponseEntity patch(@PathVariable("user-id") Long userId,
                                @RequestBody PatchUserDto patchUserDto) {
        patchUserDto.setUserId(userId);
        User user = userService.update(mapper.patchUserDtoToUser(patchUserDto));
        return new ResponseEntity<>(mapper.userToResponseUserDto(user), HttpStatus.OK);
    }
    //userId로 user조회
    @GetMapping("/{user-id}")
    public ResponseEntity get(@PathVariable("user-id") Long userId) {
        User user = userService.find(userId);
        return new ResponseEntity<>(mapper.userToResponseUserDto(user), HttpStatus.OK);
    }
    //page단위로 전체 조회
    @GetMapping
    public ResponseEntity getAll(@RequestParam(value = "page")int page,
                                 @RequestParam(value = "size")int size) {
        Page<User> userPage = userService.finds(page,size);
        List<User> userList = userPage.getContent();

        return new ResponseEntity<>(mapper.userToResponseUserDtos(userList),HttpStatus.OK);
    }
    //user 삭제
    @DeleteMapping("/{user-id}")
    public ResponseEntity delete(@PathVariable("user-id") Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
