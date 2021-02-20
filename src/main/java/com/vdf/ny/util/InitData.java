package com.vdf.ny.util;

import com.vdf.ny.entity.KnownForTitlesEntity;
import com.vdf.ny.entity.NameBasicEntity;
import com.vdf.ny.entity.TitleBasicEntity;
import com.vdf.ny.entity.TitlePrincipalEntity;
import com.vdf.ny.repository.TitleBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static com.vdf.ny.type.GeneralEnumerationDefinition.TitleTypes;

@Component
public class InitData {
  @Autowired
  TitleBasicRepository titleBasicRepository;


  @PostConstruct
  public void init() {
    TitleBasicEntity silenceOfTheLambs = new TitleBasicEntity();
    silenceOfTheLambs.setTitleType(TitleTypes.MOVIE.name());
    silenceOfTheLambs.setPrimaryTitle("Kuzuların Sessizliği");
    silenceOfTheLambs.setOriginalTitle("The Silence of the Lambs");
    silenceOfTheLambs.setAdult(true);
    silenceOfTheLambs.setStartYear("1991");
    silenceOfTheLambs.setEndYear(null);
    silenceOfTheLambs.setRuntimeMinutes(118l);
    silenceOfTheLambs.setGenres(Arrays.asList("Crime", "Drama", "Thriller"));

    TitlePrincipalEntity theLambsPrincipalAnthony = new TitlePrincipalEntity();
    theLambsPrincipalAnthony.setCategory("Drama");
    theLambsPrincipalAnthony.setJob(null);
    theLambsPrincipalAnthony.setCharacter("Odin");

    NameBasicEntity anthonyHopkins = new NameBasicEntity();
    anthonyHopkins.setPrimaryName("Anthony Hopkins");
    anthonyHopkins.setBirthYear("1937");
    anthonyHopkins.setDeathYear(null);
    anthonyHopkins.setPrimaryProfession(Arrays.asList("Actor", "Soundtrack", "Composer"));
    theLambsPrincipalAnthony.setnConst(anthonyHopkins);

    KnownForTitlesEntity anthonySilenceOfTheLamb = new KnownForTitlesEntity();


    anthonyHopkins.setKnowForTitles(Arrays.asList(anthonySilenceOfTheLamb));

    TitlePrincipalEntity theLambsJodyFoster = new TitlePrincipalEntity();
    theLambsJodyFoster.setCategory("Actress");
    theLambsJodyFoster.setJob("Director");

    NameBasicEntity jodyFoster = new NameBasicEntity();
    jodyFoster.setPrimaryName("Jodie Foster");
    jodyFoster.setBirthYear("1962");
    jodyFoster.setDeathYear(null);
    jodyFoster.setPrimaryProfession(Arrays.asList("Actress", "Director", "Producer"));

    theLambsJodyFoster.setnConst(jodyFoster);

    silenceOfTheLambs.setTitlePrincipals(Arrays.asList(theLambsPrincipalAnthony, theLambsJodyFoster));


    titleBasicRepository.save(silenceOfTheLambs);

    TitleBasicEntity prestige = new TitleBasicEntity();
    prestige.setTitleType(TitleTypes.MOVIE.name());
    prestige.setPrimaryTitle("Wolverine");
    prestige.setOriginalTitle("The Wolverine");
    prestige.setAdult(false);
    prestige.setStartYear("2006");
    prestige.setEndYear(null);
    prestige.setRuntimeMinutes(130l);
    prestige.setGenres(Arrays.asList("Sci-Fi", "Drama", "Mystery"));

    TitlePrincipalEntity prestigeHughJackman = new TitlePrincipalEntity();
    prestigeHughJackman.setCategory("Fantasy");
    prestigeHughJackman.setJob(null);
    prestigeHughJackman.setCharacter("Wolverine");

    NameBasicEntity hughJackman = new NameBasicEntity();
    hughJackman.setPrimaryName("Hugh Jackman");
    hughJackman.setBirthYear("1968");
    hughJackman.setDeathYear(null);
    hughJackman.setPrimaryProfession(Arrays.asList("Actor", "Soundtrack", "Producer"));
    prestigeHughJackman.setnConst(hughJackman);

    prestige.setTitlePrincipals(Arrays.asList(prestigeHughJackman));
    titleBasicRepository.save(prestige);



  }
}
