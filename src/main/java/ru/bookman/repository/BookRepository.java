package ru.bookman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bookman.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:year IS NULL OR b.year = :year) AND " +
            "(:brand IS NULL OR LOWER(b.brand) LIKE LOWER(CONCAT('%', :brand, '%')))")
    Page<Book> findByTitleContainingAndYearAndBrand(
            @Param("title") String title,
            @Param("year") Integer year,
            @Param("brand") String brand,
            Pageable pageable);
}