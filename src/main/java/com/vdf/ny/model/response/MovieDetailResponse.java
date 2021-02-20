package com.vdf.ny.model.response;

import lombok.Data;

@Data
public class MovieDetailResponse {
  private String isAdult;
  private String title;
  private String originalTitle;
  private String startDate;
  private String gender;
  private String character;
  private String titleType;
  private String runTimeMinutes;


}
