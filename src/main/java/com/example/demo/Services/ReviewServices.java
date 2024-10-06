package com.example.demo.Services;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Review;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

import java.util.Date;
import java.util.Optional;

@Service
public class ReviewServices implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;


    public ReviewServices(ReviewRepository reviewRepository, BookingRepository bookingRepository){
        this.reviewRepository=reviewRepository;
        this.bookingRepository=bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");

        /*Review r  = Review.builder() // code to create plain java object
                .content("Excellent ride Quality")
                .rating(5.0)
                .build();

        Booking b = Booking.builder()
                .endTime(new Date())
                .review(r)
                .build();


        System.out.println(r);

        reviewRepository.save(r); // this code executes SQL query
        bookingRepository.save(b);

        List<Review> review=reviewRepository.findAll();

        for(Review reviews:review){
            System.out.println(reviews.getContent()+" "+reviews.getRating());
        }*/

        Optional<Booking> b = bookingRepository.findById(1L);
        if(b.isPresent()){
            bookingRepository.delete(b.get());
        }



        //reviewRepository.deleteById(3L);
    }
}
