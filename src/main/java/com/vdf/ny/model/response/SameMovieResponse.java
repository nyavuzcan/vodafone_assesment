package com.vdf.ny.model.response;

import lombok.*;

@Data
@Builder
public class SameMovieResponse {
  private boolean areSameMovies;
  private String message;
}
