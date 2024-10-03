package com.example.demo.Services;

import com.example.demo.Model.Review;
import com.example.demo.Repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Date;

@Service
public class ReviewServices implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewServices(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");
        Review r  = Review.builder() // code to create plain java object
                .content("Excellent ride Quality")
                .rating(5.0)
                .build();
        System.out.println(r);
        reviewRepository.save(r); // this code executes SQL query

        List<Review> review=reviewRepository.findAll();

        for(Review reviews:review){
            System.out.println(reviews.getContent()+" "+reviews.getRating());
        }
        //reviewRepository.deleteById(3L);
    }
}
