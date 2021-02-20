package com.vdf.ny.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "name_basics")
public class NameBasicEntity {

  @Id
  @Column(name = "n_const")
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String nConst;

  private String primaryName;

  private String birthYear;

  private String deathYear;

  @ElementCollection
  @CollectionTable(name = "professions", joinColumns = @JoinColumn(name = "n_const"))
  private List<String> primaryProfession;

  @OneToMany(fetch = FetchType.EAGER,
      cascade = CascadeType.ALL)
  @JoinColumn(name = "n_const")
  private List<KnownForTitlesEntity> knowForTitles;

  public List<KnownForTitlesEntity> getKnowForTitles() {
    return knowForTitles;
  }

  public void setKnowForTitles(List<KnownForTitlesEntity> knowForTitles) {
    this.knowForTitles = knowForTitles;
  }

  public String getnConst() {
    return nConst;
  }

  public void setnConst(String nConst) {
    this.nConst = nConst;
  }

  public String getPrimaryName() {
    return primaryName;
  }

  public void setPrimaryName(String primaryName) {
    this.primaryName = primaryName;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getDeathYear() {
    return deathYear;
  }

  public void setDeathYear(String deathYear) {
    this.deathYear = deathYear;
  }

  public List<String> getPrimaryProfession() {
    return primaryProfession;
  }

  public void setPrimaryProfession(List<String> primaryProfession) {
    this.primaryProfession = primaryProfession;
  }
}
