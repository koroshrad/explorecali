package com.example.ec.repo;

import com.example.ec.domain.TourRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, String> {


//    List<TourRating> findByTourRatingPkTourId(Integer tourId); /*aligned with Relational-DB*/
    List<TourRating> findByTourId(String tourId);

//    Optional<TourRating> findByTourRatingPkTourIdAndTourRatingPkCustomerId(Integer tourId, Integer customerId);
    Optional<TourRating> findByTourIdAndCustomerId(String tourId, Integer customerId);


//    Page<TourRating> findByTourRatingPkTourId(Integer tourId, Pageable pageable);
    Page<TourRating> findByTourId(String tourId, Pageable pageable);

}