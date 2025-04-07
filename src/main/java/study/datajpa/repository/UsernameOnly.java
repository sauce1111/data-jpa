package study.datajpa.repository;

import org.springframework.beans.factory.annotation.Value;

// interface close 기반 프로젝션
public interface UsernameOnly {

//    open projection
//    @Value("#{target.username + ' ' + target.age"}")
    String getUsername();
}
