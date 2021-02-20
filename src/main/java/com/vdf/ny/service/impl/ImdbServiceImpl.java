package com.vdf.ny.service.impl;

import com.vdf.ny.entity.NameBasicEntity;
import com.vdf.ny.model.request.MovieDetailRequest;
import com.vdf.ny.model.request.SameMovieRequest;
import com.vdf.ny.model.response.MovieDetailResponse;
import com.vdf.ny.model.response.SameMovieResponse;
import com.vdf.ny.repository.NameBasicRepository;
import com.vdf.ny.repository.TitleBasicRepository;
import com.vdf.ny.service.ImdbService;
import com.vdf.ny.type.BusinessValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ImdbServiceImpl implements ImdbService {

  private final static String wrongName = "NO_ACTOR_IN_DB";

  private final TitleBasicRepository titleBasicRepository;

  private final NameBasicRepository nameBasicRepository;

  @Autowired
  public ImdbServiceImpl(TitleBasicRepository titleBasicRepository, NameBasicRepository nameBasicRepository) {
    this.titleBasicRepository = titleBasicRepository;
    this.nameBasicRepository = nameBasicRepository;
  }


  @Override
  public SameMovieResponse sameMovieCheck(SameMovieRequest sameMovieRequest) {
    log.info("[CHECK_SAME_MOVIE] start");
    List<String> basicEntityList = new ArrayList<>();
    String actorFirstName = sameMovieRequest.getFirstActorName();
    String actorSecondName = sameMovieRequest.getSecondActorName();
    if (!checkActorIsValid(actorFirstName, actorSecondName)) {
      log.error("[CHECK_SAME_MOVIE] " + wrongName);
      throw new BusinessValidationException(wrongName);

    }

    List<String> moviesForActorFirst = titleBasicRepository.findMoviesByName(sameMovieRequest.getFirstActorName());
    List<String> moviesForActorSecond = titleBasicRepository.findMoviesByName(sameMovieRequest.getSecondActorName());

    for (String strMv : moviesForActorFirst) {
      basicEntityList = moviesForActorSecond
          .stream()
          .filter(movieName -> movieName.equals(strMv))
          .collect(Collectors.toList());
    }
    if (!basicEntityList.isEmpty()) {
      return SameMovieResponse.builder()
          .areSameMovies(true)
          .message(actorFirstName + " and " + actorSecondName + " starred in the same movie")
          .build();
    }
    return SameMovieResponse.builder().areSameMovies(false)
        .message(actorFirstName + " and " + actorSecondName + " didn't star in the same movie")
        .build();
  }

  @Override
  public List<MovieDetailResponse> inquireMovieDetail(MovieDetailRequest movieDetailRequest) {
    log.info("[MOVIE_DETAILS] start");

    if (!checkActorIsValid(movieDetailRequest.getActorName())) {
      log.error("[CHECK_SAME_MOVIE] " + wrongName);
      throw new BusinessValidationException(wrongName);
    }

    List<Object[]> objectsMovieDetail = titleBasicRepository.findMoviesAllDetail(movieDetailRequest.getActorName());

    List<MovieDetailResponse> movieDetailResponse = mapObjectToMovieDetail(objectsMovieDetail);

    return movieDetailResponse;
  }

   public boolean checkActorIsValid(String actorName, String secondActorName) {
    log.info("[CHECK_SAME_MOVIE] checking DB for Actor Names");
    NameBasicEntity nameBasicEntity = nameBasicRepository.findByPrimaryName(actorName);
    NameBasicEntity nameBasicEntitySecond = nameBasicRepository.findByPrimaryName(secondActorName);
    return Objects.nonNull(nameBasicEntity) && Objects.nonNull(nameBasicEntitySecond);
  }

  public List<MovieDetailResponse> mapObjectToMovieDetail(List<Object[]> objectList) {
    List<MovieDetailResponse> movieDetailResponseList = new ArrayList<>();
    for (Object[] mvObj : objectList) {
      MovieDetailResponse movieDetailResponse = new MovieDetailResponse();
      movieDetailResponse.setIsAdult(mvObj[2].toString());
      movieDetailResponse.setOriginalTitle(mvObj[3].toString());
      movieDetailResponse.setTitle(mvObj[4].toString());
      movieDetailResponse.setRunTimeMinutes(mvObj[5].toString());
      movieDetailResponse.setStartDate(mvObj[6].toString());
      movieDetailResponse.setTitleType(mvObj[7].toString());
      movieDetailResponse.setGender(mvObj[9].toString());
      movieDetailResponse.setCharacter(mvObj[10].toString());

      movieDetailResponseList.add(movieDetailResponse);
    }
    return movieDetailResponseList;

  }

  private boolean checkActorIsValid(String actorName) {
    log.info("[CHECK_SAME_MOVIE] checking DB for Actor Name");
    NameBasicEntity nameBasicEntity = nameBasicRepository.findByPrimaryName(actorName);
    return Objects.nonNull(nameBasicEntity);
  }

}
