package com.example.demo.Model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // this annotation tells spring that format of date object to be stored
    @CreatedDate // this annotation tells spring that only handle it for object creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  // this annotation tells spring that format of date object to be stored
    @LastModifiedDate // this annotation tells spring that only handle it for object update
    protected Date updatedAt;
}
