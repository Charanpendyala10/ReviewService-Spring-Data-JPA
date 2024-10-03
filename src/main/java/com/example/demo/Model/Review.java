package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "bookingreview")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // this annotation tells spring that format of date object to be stored
    @CreatedDate // this annotation tells spring that only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  // this annotation tells spring that format of date object to be stored
    @LastModifiedDate // this annotation tells spring that only handle it for object update
    private Date updatedAt;

    @Override
    public String toString() {
        return "Review : " + this.content+" "+this.rating+" "+this.createdAt+" "+this.updatedAt;
    }
}
