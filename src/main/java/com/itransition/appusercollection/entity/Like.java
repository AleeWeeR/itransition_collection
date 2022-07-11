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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "like_item")
public class Like {
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @OneToOne
    @JoinColumn(name = "liked_user")
    User likedUser;

    @ManyToOne
    @JoinColumn(name = "liked_item")
    Item likedItem;
}
