package com.example.ec.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class TourRating {

    @Id
    private String id;
    private String tourId;
    @NotNull
    private Integer customerId;
    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 50)
    private String comment;

    public TourRating(String tourId, Integer customerId, Integer score, String comment) {
        this.tourId = tourId;
        this.customerId = customerId;
        this.score = score;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getTourId() {
        return tourId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public void setScore(Integer score) {
    }

    public void setComment(String comment) {
    }
}
