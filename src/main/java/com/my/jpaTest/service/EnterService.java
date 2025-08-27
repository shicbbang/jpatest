package com.my.jpaTest.service;

import com.my.jpaTest.entity.Entertainment;
import com.my.jpaTest.entity.GirlGroup;
import com.my.jpaTest.entity.IdolMember;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EnterService {
        @Autowired
        EntityManager em;

    public void initData() {
        //Enter 생성
        Entertainment starship = Entertainment.builder()
                .enterId("starship")
                .enterName("스타쉽")
                .build();

        Entertainment YG = Entertainment.builder()
                .enterId("YG")
                .enterName("와이지")
                .build();

        //Group 생성, 엔터등록
        GirlGroup ive = GirlGroup.builder()
                .groupId("ive")
                .groupName("아이브")
                .entertainment(starship)
                .build();

        GirlGroup blackPink = GirlGroup.builder()
                .groupId("blackPink")
                .groupName("블랙핑크")
                .entertainment(YG)
                .build();

        //Idol 생성, 그룹등록
        IdolMember ahn = IdolMember.builder()
                .Id("유진")
                .Name("유진")
                .girlGroup(ive)
                .build();

        IdolMember jang = IdolMember.builder()
                .Id("장원영")
                .Name("원영")
                .girlGroup(ive)
                .build();

        IdolMember jany = IdolMember.builder()
                .Id("재니")
                .Name("짼")
                .girlGroup(blackPink)
                .build();

        IdolMember jisu = IdolMember.builder()
                .Id("지수")
                .Name("찌수")
                .girlGroup(blackPink)
                .build();



        //Enter 에 Group List 등록
        starship.getGroups().add(ive);
        YG.getGroups().add(blackPink);

        //Group에 Idol List 등록
        ive.getMembers().add(ahn);
        ive.getMembers().add(jang);
        blackPink.getMembers().add(jany);
        blackPink.getMembers().add(jisu);

        //starship 저장
        em.persist(starship);

        //YG 저장
        em.persist(YG);

    }
}
