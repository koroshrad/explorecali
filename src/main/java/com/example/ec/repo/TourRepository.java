package com.example.ec.repo;

import com.example.ec.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

// define a repo interface for each domain entity
@Repository
public interface TourRepository extends PagingAndSortingRepository<Tour, String> {

        Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

        @Query(value = "{'tourPackageCode' : ?0 }",
                fields = "{ 'id':1, 'title':1, 'tourPackageCode':1, 'tourPackageName':1}")
        Page<Tour> findSummaryByTourPackageCode(@Param("code")String code, Pageable pageable);


        @Override
        @RestResource(exported = false)
        <S extends Tour> S save(S entity);

        @Override
        @RestResource(exported = false)
        <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

        @Override
        @RestResource(exported = false)
        void deleteById(String integer);

        @Override
        @RestResource(exported = false)
        void delete(Tour entity);

        @Override
        @RestResource(exported = false)
        void deleteAllById(Iterable<? extends String> integers);

        @Override
        @RestResource(exported = false)
        void deleteAll(Iterable<? extends Tour> entities);

        @Override
        @RestResource(exported = false)
        void deleteAll();
}
