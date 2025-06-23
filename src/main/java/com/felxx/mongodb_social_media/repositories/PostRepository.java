package com.felxx.mongodb_social_media.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.felxx.mongodb_social_media.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'date': { $gte: ?1, $lte: ?2 } } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
