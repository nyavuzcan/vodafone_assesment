package com.vdf.ny.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "known_for_titles")
public class KnownForTitlesEntity {
  @Id
  @Column(name = "id", columnDefinition = "serial")
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "t_const")
  private String tConst;

  @Column(name = "n_const")
  private String nConst;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String gettConst() {
    return tConst;
  }

  public void settConst(String tConst) {
    this.tConst = tConst;
  }

  public String getnConst() {
    return nConst;
  }

  public void setnConst(String nConst) {
    this.nConst = nConst;
  }
}
