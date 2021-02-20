package com.vdf.ny.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class GenreEntity {
  @Id
  @Column(name = "genre_Id", columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private Long genreId;

  @Column(name = "t_consts")
  private String tConst;

  public Long getGenreId() {
    return genreId;
  }

  public void setGenreId(Long genreId) {
    this.genreId = genreId;
  }

  public String gettConst() {
    return tConst;
  }

  public void settConst(String tConst) {
    this.tConst = tConst;
  }
}
