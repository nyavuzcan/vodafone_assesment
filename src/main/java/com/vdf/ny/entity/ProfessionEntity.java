package com.vdf.ny.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professions")
public class ProfessionEntity {
  @Id
  @Column(name = "profession_id", columnDefinition = "serial")
  @Generated(GenerationTime.INSERT)
  private Long professionId;

  @Column(name ="n_const")
  private String nconst;

  public Long getProfessionId() {
    return professionId;
  }

  public void setProfessionId(Long professionId) {
    this.professionId = professionId;
  }

  public String getNconst() {
    return nconst;
  }

  public void setNconst(String nconst) {
    this.nconst = nconst;
  }
}
