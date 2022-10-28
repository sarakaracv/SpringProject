package com.cydeo.repository;

import com.cydeo.entity.Course;
import com.sun.jdi.connect.ListeningConnector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category select (* from courses) where category=..

    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name

    List<Course> findByCategoryOrderByName(String category);

    //check if a course with the supplied name exists. Return true if exists, false otherwise

    boolean existsByName(String name);

    //Return the count of courses for given category

    int countByCategory(String category);

    //find all the courses that start with the given course name string

    List<Course> findByNameStartingWith(String name);

    //find all courses by category and return a stream

    Stream<Course> streamAllByCategory(String category);

    //static Optional<Course> findByCategory(String category)

    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);

}
