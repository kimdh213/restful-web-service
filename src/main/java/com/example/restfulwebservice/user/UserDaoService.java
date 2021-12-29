package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    // 비즈니스 로직
    private static List<User> users = new ArrayList<>();

    private static int userCount=3;

    // static 으로 만들어져 있는 변수이기 때문에 static{} 에 초기값 설정
    static {
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "Elena", new Date()));
    }

    // 전체 사용자 목록 반환
    public List<User> findAll() {
        return users;
    }

    // 사용자 추가
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    // 사용자 개별 데이터 반환
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
