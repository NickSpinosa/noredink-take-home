package com.nick.spinosa.noredinktakehome;

import com.nick.spinosa.noredinktakehome.beans.Question;
import com.nick.spinosa.noredinktakehome.beans.Strand;
import com.nick.spinosa.noredinktakehome.persistence.InMemoryQuestionStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class distributor {

  private InMemoryQuestionStore store;


  public List<Question> distributeQuestions(int numberOfQuestions) {

    List<Question> questions = new ArrayList<>();
    Map<Long, Long> strandToNumberOfQuestions = generateStrandMap();
    Map<Long, Long> standardToNumberOfQuestions = generateStandardMap();

    for (int i = 0; i <= numberOfQuestions; i++) {
      // find strand with lowest number of questions asked
      // find the standard in that strand with the lowest questions asked
      // find the question with that standard with the lowest usage
      // increment usage on question, and increment above standard/strand maps
      // add question to questions list

    }

    return questions;
  }



  // generates a map from strand id to the number of questions initialized at 0
  private Map<Long, Long> generateStrandMap() {
    Map<Long, Long> map = new HashMap<>();

    for(Strand strand: store.getStrands()) {
      map.put(strand.getId(), 0L);
    }

    return map;
  }

  // generates a map from strand id to the number of questions initialized at 0;
  private Map<Long, Long> generateStandardMap() {
    Map<Long, Long> map = new HashMap<>();

    for(Long standardId: store.getStandards()) {
      map.put(standardId, 0L);
    }

    return map;
  }

}
