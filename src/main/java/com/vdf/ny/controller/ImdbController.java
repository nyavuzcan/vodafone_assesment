package com.vdf.ny.controller;

import com.vdf.ny.model.request.MovieDetailRequest;
import com.vdf.ny.model.request.SameMovieRequest;
import com.vdf.ny.model.response.MovieDetailResponse;
import com.vdf.ny.model.response.SameMovieResponse;
import com.vdf.ny.repository.TitleBasicRepository;
import com.vdf.ny.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/imdb")
public class ImdbController {

  private final ImdbService imdbService;


  @Autowired
  public ImdbController(ImdbService imdbService) {
    this.imdbService = imdbService;
  }

  @PostMapping(value = "/sameMovieCheck", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SameMovieResponse> sameMovieCheck(@RequestBody SameMovieRequest sameMovieRequest) {
    return ResponseEntity.ok(imdbService.sameMovieCheck(sameMovieRequest));
  }

  @PostMapping(value = "/getMovieDetail", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<MovieDetailResponse>> getMovieDetail(@RequestBody MovieDetailRequest movieDetailRequest) {
    return ResponseEntity.ok(imdbService.inquireMovieDetail(movieDetailRequest));
  }

}
