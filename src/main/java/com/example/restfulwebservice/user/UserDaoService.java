package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    // 비즈니스 로직
    private static List<User> users = new ArrayList<>();

    private static int userCount=3;

    // static 으로 만들어져 있는 변수이기 때문에 static{} 에 초기값 설정
    static {
        users.add(new User(1, "Kenneth", new Date(), "pass1", "701010-1111111"));
        users.add(new User(2, "Alice", new Date(), "pass2", "801010-2222222"));
        users.add(new User(3, "Elena", new Date(), "pass3", "901010-1333333"));
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

    // 사용자 삭제
    public User deleteById(int id) {
        // Iterator = 열거형(배열, 리스트 등) 타입의 데이터
        Iterator<User> iterator = users.iterator();

        // 순차적으로 하나씩 데이터를 가져와 확인
        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        // 위 결과가 실행되지 않았을 경우 Null 처리
        return null;
    }

    // 사용자 업데이트
    public User updateById(User user, int id) {
        User findUser = findOne(id);
        if (findUser == null) {
            return null;
        }

        findUser.setName(user.getName());
        return findUser;
    }
}