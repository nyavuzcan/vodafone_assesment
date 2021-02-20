package com.vdf.ny.service;

import com.vdf.ny.model.request.MovieDetailRequest;
import com.vdf.ny.model.response.MovieDetailResponse;
import com.vdf.ny.model.request.SameMovieRequest;
import com.vdf.ny.model.response.SameMovieResponse;

import java.util.List;

public interface ImdbService {
  SameMovieResponse sameMovieCheck(SameMovieRequest sameMovieRequest);

  List<MovieDetailResponse> inquireMovieDetail(MovieDetailRequest movieDetailRequest);
}
