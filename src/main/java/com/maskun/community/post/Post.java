package com.maskun.community.post;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Builder.Default
    @Column(name = "api_id", nullable = false, unique = true, updatable = false)
    private final String apiId = UUID.randomUUID().toString();

    @Column(name = "post_title", nullable = false)
    private String title;

    @Lob
    @Column(name = "post_content")
    private String content;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private Set<Comment> comments = new LinkedHashSet<>();

}
