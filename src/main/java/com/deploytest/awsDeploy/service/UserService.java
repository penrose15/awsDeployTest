package com.deploytest.awsDeploy.service;

import com.deploytest.awsDeploy.entity.User;
import com.deploytest.awsDeploy.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //user생성
    public User save(User user) {
        return userRepository.save(user);
    }
    //user 수정
    public User update(User user) {
        Optional<User> findUser = userRepository.findById(user.getUserId());
        User user1 = findUser.orElseThrow();
        Optional.ofNullable(user.getName()).ifPresent(u -> user1.setName(u));
        //이름만 수정가능
        return userRepository.save(user1);
    }
    //user식별자로 조회
    public User find(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow();
    }
    //page 조회, userId로 내림차순
    public Page<User> finds(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "userId");
        Page<User> findPage = userRepository.findAll(pageable);
        return findPage;
    }
    //user 삭제
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
