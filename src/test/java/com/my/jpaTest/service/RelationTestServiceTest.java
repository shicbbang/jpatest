package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import com.my.jpaTest.entity.Team;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class RelationTestServiceTest {
    @Autowired
    RelationTestService relationTestService;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("MemberAndTeam Insert Test")
    void insertTest() {
        relationTestService.insertMemberAndTeam();
    }
//    @Test
//    @DisplayName("단방향 연관관계 설정 후 팀 이름 찾기")
//    void findTeamName() {
//        relationTestService.insertMemberAndTeam();
//        //jang의 정보를 가져온다.
//        Member jang = em.find(Member.class, "jang");
//        System.out.println("팀 이름 :" + jang.getTeam().getTeamName());


    @Test
    @DisplayName("양방향 연관관계를 설정 후 저장하기")
    void saveBothData() {
        relationTestService.insertBothRelation();
    }

    @Test
    @DisplayName("씨름팀 멤버 출력")
    void 씨름팀멤버출력() {
        Team team = em.find(Team.class, "ssirum");
        List<Member> members = team.getMemberList();
        for (Member m : members) {
            System.out.println(m.getName());
        }
    }
//
//        //연관관계가 없으면 한 없이 찾아들어가서 원하는 자료를 찾아야함
//        //1. member 에서 jang을 찾아온다.
//        Member jang = em.find(Member.class, jang);
//        //2. member의 teamId로 team에서 검색한다.
//        Team team = em.find(Team.class, jang.getTeamId());
//        System.out.println("Team Name :" + team.getTeamName());
//    }

}