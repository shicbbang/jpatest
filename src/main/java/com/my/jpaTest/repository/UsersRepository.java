package com.my.jpaTest.repository;

import com.my.jpaTest.dto.Gender;
import com.my.jpaTest.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    //쿼리메서드 생성
    //이름으로 검색하기
    //Select * users where name = '장원영' <-- 기존 사용법
    //findByName(String name(또는 searchName));
    List<Users> findByName(String searchName);

    //2. 상위 3개 같은 색상 정보 찾기
    //select * from users where color='pink' limit 3;
    List<Users> findTop3ByLikeColor(String color);

    //    //3. 성별이 여자이고, 좋아하는 색상이 red인 자료
//    //select * from users where gender= 'Female' and like_color ='Red';
    List<Users> findByGenderAndLikeColor(Gender gender, String color);

    //
// 4. 범위 검색(날짜, 시간)
// 어제 이후 생성된 모든 자료 검색하기(어제, 오늘...)
// select * from users where created_at >= '어제';
    List<Users> findByCreatedAtAfter(LocalDateTime searchDate);

    //5. 최근 1개월 자료 검색하기
    List<Users> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    //7. ID 가 91번 이상인 자료를 찾아봅니다.
// >= : GreaterThanEqual, <= : LessThanEqual
//> : After, < : Before
    //null 값 비교 : Null or IsNotNull
    List<Users> findByIdGreaterThanEqual(Long id);

    //8. 문자열 관련
    //StartingWith : 주언진 문자열로 시작하는 데이터
    //EndingWith : 주어진 문자열로 끝나는 데이터
    //Contains : 포함된 자료
    //Like : 사용 시 넘겨주는 인자 값 양쪽에 % 를 붙여주어야 한다.
    //8-1. 이름이 D로 시작하는 데이터 전체 출력
    List<Users> findByNameStartingWith(String x);
    //8-2. 이름이 S로 끝나는 데이터 전체 출력
    List<Users> findByNameEndingWith(String x);
    //8-4. email에 org 를 포함하는 데이터(Contains/like)
    List<Users> findByEmailContains(String x);
    List<Users> findByEmailLike(String x);

    //9. 정렬
    // id 가 1번부터 10까지 이름의 내림차순으로 정렬을 하고 싶다.
    //select * from users where id between 1 to 10 order by name desc;
    List<Users> findByIdBetweenOrderByNameDesc(Long start, Long end);


    //quiz.
    //Orange 색상 중 Gender에 오름차순, CreatesAt에 내림차순 후 상위 10개를 검색
    //select * from users where like_color='Orange' order by gender asc, created_at desc;
    List<Users> findTop10ByLikeColorOrderByGenderAscCreatedAtDesc(String color);


    //10. Sort 사용하기
    //
    List<Users> findByLikeColor(String color, Sort sort);
}

/// /6.좋아하는 색상이 red,pink 인 모든 자료 출력
//    //select * from users where like_color in ('Red', 'Pink')
//    //In 구문에는 리스트를 인자로 준다.
// List<Users> findByLikeColorIn(List<String> colors);
//}



