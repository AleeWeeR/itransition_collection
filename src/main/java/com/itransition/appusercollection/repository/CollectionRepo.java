package com.itransition.appusercollection.repository;

import com.itransition.appusercollection.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepo extends JpaRepository<Collection, Long> {
}
