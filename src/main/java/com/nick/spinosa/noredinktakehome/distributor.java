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
    Map<Long, Long> strandUsage = generateStrandUsageMap();
    Map<Long, Long> standardUsage = generateStandardUsageMap();

    for (int i = 0; i <= numberOfQuestions; i++) {
      // find strand with lowest number of questions asked
      Long strandId =  getLeastAskedStrand(strandUsage);

      // find the standard in that strand with the lowest questions asked
      Long standardId = getLeastAskedStandardInStrand(strandId, standardUsage);

      // find the question with that standard with the lowest usage
      Question question = getLowestUsedQuestionByStrand(standardId);

      // increment usage on question, and increment above standard/strand maps
      question.incrementUsage();
      strandUsage.put(strandId, strandUsage.get(strandId) + 1);
      standardUsage.put(standardId, standardUsage.get(standardId) + 1);

      // add question to questions list
      questions.add(question);
    }

    return questions;
  }

  private Question getLowestUsedQuestionByStrand(Long strandId) {
    return null;
  }

  private Long getLeastAskedStrand(Map<Long, Long> strandUsageMap) {
    return null;
  }

  private Long getLeastAskedStandardInStrand(Long strandId, Map<Long, Long> standardUsage) {
    return null;
  }

  // generates a map from strand id to the number of questions initialized at 0
  private Map<Long, Long> generateStrandUsageMap() {
    Map<Long, Long> map = new HashMap<>();

    for(Strand strand: store.getStrands()) {
      map.put(strand.getId(), 0L);
    }

    return map;
  }

  // generates a map from strand id to the number of questions initialized at 0;
  private Map<Long, Long> generateStandardUsageMap() {
    Map<Long, Long> map = new HashMap<>();

    for(Long standardId: store.getStandards()) {
      map.put(standardId, 0L);
    }

    return map;
  }

}
