package com.vdf.ny.service.impl;

import com.vdf.ny.entity.NameBasicEntity;
import com.vdf.ny.model.request.MovieDetailRequest;
import com.vdf.ny.model.request.SameMovieRequest;
import com.vdf.ny.model.response.MovieDetailResponse;
import com.vdf.ny.model.response.SameMovieResponse;
import com.vdf.ny.repository.NameBasicRepository;
import com.vdf.ny.repository.TitleBasicRepository;
import com.vdf.ny.type.BusinessValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ImdbServiceImplTest {
  @Spy
  @InjectMocks
  private ImdbServiceImpl imdbService;
  @Mock
  private TitleBasicRepository titleBasicRepository;
  @Mock
  private NameBasicRepository nameBasicRepository;

  private SameMovieRequest sameMovieRequest;

  private MovieDetailRequest movieDetailRequest;

  @BeforeEach
  public void setUp() {
    sameMovieRequest = new SameMovieRequest();
    sameMovieRequest.setFirstActorName("Anthony Hopkins");
    sameMovieRequest.setSecondActorName("Jodie Foster");

    movieDetailRequest = new MovieDetailRequest();
    movieDetailRequest.setActorName("Hugh Jackman");
  }


  @Test
  void sameMovieCheck_thenOK() {
    List<String> movieList = Arrays.asList("The Silence of the Lambs");
    NameBasicEntity nameBasicEntity = new NameBasicEntity();

    Mockito.when(titleBasicRepository.findMoviesByName(anyString())).thenReturn(movieList);
    Mockito.when(nameBasicRepository.findByPrimaryName(anyString())).thenReturn(nameBasicEntity);

    final SameMovieResponse result = imdbService.sameMovieCheck(sameMovieRequest);

    assertNotNull(result);
    assertThat(result.isAreSameMovies()).isEqualTo(true);

  }

  @Test
  void notSameMovieCheck_thenOK() {
    List<String> movieList = Arrays.asList("The Silence of the Lambs");

    Mockito.when(titleBasicRepository.findMoviesByName(anyString())).thenReturn(movieList);

    Mockito.when(titleBasicRepository.findMoviesByName(anyString())).thenReturn(null);
    assertThrows(BusinessValidationException.class, () -> imdbService.sameMovieCheck(sameMovieRequest));

  }

  @Test
  void inquireMovieDetail_thenOK() {

    NameBasicEntity nameBasicEntity = new NameBasicEntity();
      String [] arr = {"1","odin","wolverine","120","Movie","The Silence of the Lambs",
          "1991","Drama","1962","Kuzuların Sessizliği","Crime","Doctor"};
    List<Object[]> list= new ArrayList<>();
    list.add(arr);

    Mockito.when(titleBasicRepository.findMoviesAllDetail(anyString())).thenReturn(list);
    Mockito.when(nameBasicRepository.findByPrimaryName(anyString())).thenReturn(nameBasicEntity);
    final List<MovieDetailResponse> result = imdbService.inquireMovieDetail(movieDetailRequest);
    assertNotNull(result);
    assertThat(result.size() > 0);

  }


}