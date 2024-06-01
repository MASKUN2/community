package com.maskun.community.member;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Builder.Default
    @Column(name = "api_id", nullable = false, unique = true, updatable = false)
    private final String apiId = UUID.randomUUID().toString();

    @Column(name = "member_email", nullable = false, unique = true, updatable = false, length = 64)
    private String email;

    @Column(name = "member_password", nullable = false)
    private String password;

}
