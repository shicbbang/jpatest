package com.my.jpaTest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Builder
public class IdolMember {
    @Id
    private String Id;
    private String Name;
    @ManyToOne
    @JoinColumn(name = "groupId")
    private GirlGroup girlGroup;
}
