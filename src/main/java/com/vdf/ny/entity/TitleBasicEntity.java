package com.vdf.ny.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "title_basics")
public class TitleBasicEntity {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "t_consts")
  private String tConst;

  private String titleType;

  private String primaryTitle;

  private String originalTitle;

  private Boolean isAdult;

  private String startYear;

  private String endYear;

  private Long runtimeMinutes;

  @ElementCollection
  @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "t_consts"))
  private List<String> genres;

  @OneToMany(fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  @JoinColumn(name = "t_const")
  private List<TitlePrincipalEntity> titlePrincipals;

  public String gettConst() {
    return tConst;
  }

  public void settConst(String tConst) {
    this.tConst = tConst;
  }

  public String getTitleType() {
    return titleType;
  }

  public void setTitleType(String titleType) {
    this.titleType = titleType;
  }

  public String getPrimaryTitle() {
    return primaryTitle;
  }

  public void setPrimaryTitle(String primaryTitle) {
    this.primaryTitle = primaryTitle;
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public Boolean getAdult() {
    return isAdult;
  }

  public void setAdult(Boolean adult) {
    isAdult = adult;
  }

  public String getStartYear() {
    return startYear;
  }

  public void setStartYear(String startYear) {
    this.startYear = startYear;
  }

  public String getEndYear() {
    return endYear;
  }

  public void setEndYear(String endYear) {
    this.endYear = endYear;
  }

  public Long getRuntimeMinutes() {
    return runtimeMinutes;
  }

  public void setRuntimeMinutes(Long runtimeMinutes) {
    this.runtimeMinutes = runtimeMinutes;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public List<TitlePrincipalEntity> getTitlePrincipals() {
    return titlePrincipals;
  }

  public void setTitlePrincipals(List<TitlePrincipalEntity> titlePrincipals) {
    this.titlePrincipals = titlePrincipals;
  }
}
