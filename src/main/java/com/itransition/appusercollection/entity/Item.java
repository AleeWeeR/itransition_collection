package com.itransition.appusercollection.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
    Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    Collection collection;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "likedItem")
    Set<Like> likes;




}
