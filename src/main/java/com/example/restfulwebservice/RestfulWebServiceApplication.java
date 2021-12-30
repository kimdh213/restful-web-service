package com.example.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServiceApplication.class, args);
    }

    @Bean   // 스프링부트 어플레이케이션이란 어노테이션을 가지고 있는 class 에
            // bean 을 등록하면 스프링부트가 초기화 될 때 이 Bean 어노테이션을 사용하는
            // 메소드가 같이 초기화 되어 메모리에 올라가서 다른쪽의 class 에서 사용할 수 있다.
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
}
