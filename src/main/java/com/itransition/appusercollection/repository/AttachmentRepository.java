package com.itransition.appusercollection.repository;

import com.itransition.appusercollection.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
