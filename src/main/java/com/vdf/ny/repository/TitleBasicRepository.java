package com.vdf.ny.repository;

import com.vdf.ny.entity.TitleBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TitleBasicRepository extends JpaRepository<TitleBasicEntity, String> {
  @Query(value = "select tb.original_title from title_basics tb , title_principals tp ,name_basics nb " +
      "where nb.n_const = tp.n_const and tp.t_const = tb.t_consts and " +
      "nb.primary_name like %:actorName%", nativeQuery = true)

  List<String> findMoviesByName(@Param("actorName") String actorName);

  @Query(value = "select tb.*, tp.* from title_basics tb , title_principals tp ,name_basics nb " +
      "where nb.n_const = tp.n_const and tp.t_const = tb.t_consts and " +
      "nb.primary_name like %:actorName%", nativeQuery = true)

  List<Object[]> findMoviesAllDetail(@Param("actorName") String actorName);

}
