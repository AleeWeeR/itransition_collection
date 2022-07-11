package com.itransition.appusercollection.repository;

import com.itransition.appusercollection.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {

    Optional<AttachmentContent> findByAttachmentId(Long attachment_id);

}
