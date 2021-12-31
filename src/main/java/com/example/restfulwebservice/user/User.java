package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 생성
// @JsonIgnoreProperties(value={"password"})
// @JsonIgnoreProperties 는 아예 안보여주도록 설정
// @JsonIgnoreProperties(value={"",""}) 를 이용해서 특정 변수정보가 외부에 노출되지 않도록 설정
@JsonFilter("UserInfo")
// @JsonFilter 는 특정 변수를 원하는 문자로 바꿔줌(value 는 임의로 설정)
//
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    @Past
    private Date joinDate;

    // 각 변수마다 @JsonIgnore 를 이용해 외부에 노출되지 않게 설정
    //@JsonIgnore
    private String password;
    //@JsonIgnore
    private String ssn;
}
