package com.vdf.ny.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "title_principals")
public class TitlePrincipalEntity {

  @Id
  @Column(name = "ordering", columnDefinition = "serial")
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Integer ordering;

  @Column(name = "t_const")
  private String tConst;


  @OneToOne(fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @JoinColumn(name = "n_const")
  private NameBasicEntity nConst;

  @Column(name = "category")
  private String category;

  @Column(name = "job")
  private String job;

  @Column(name = "character")
  private String character;

  public String gettConst() {
    return tConst;
  }

  public void settConst(String tConst) {
    this.tConst = tConst;
  }

  public Integer getOrdering() {
    return ordering;
  }

  public void setOrdering(Integer ordering) {
    this.ordering = ordering;
  }

  public NameBasicEntity getnConst() {
    return nConst;
  }

  public void setnConst(NameBasicEntity nConst) {
    this.nConst = nConst;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }
}
