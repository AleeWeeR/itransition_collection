package com.itransition.appusercollection.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "comment_item")
public class Comment {
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(columnDefinition = "text")
    String text;


    @OneToOne
    @JoinColumn(name = "commented_item")
    Item item;


    @OneToOne
    @JoinColumn(name = "commented_user")
    User commentedUser;


}
