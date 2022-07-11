package com.itransition.appusercollection.entity;

import com.itransition.appusercollection.entity.enums.Topic;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "collection")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    String name;

    Topic topic;

    @Column(columnDefinition = "text")
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "collection")
    Set<Item> items;

}
