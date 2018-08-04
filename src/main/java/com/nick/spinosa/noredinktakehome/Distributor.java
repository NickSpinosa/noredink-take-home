package com.nick.spinosa.noredinktakehome;

import com.nick.spinosa.noredinktakehome.beans.Question;
import com.nick.spinosa.noredinktakehome.beans.Strand;
import com.nick.spinosa.noredinktakehome.persistence.InMemoryQuestionStore;
import com.nick.spinosa.noredinktakehome.persistence.QuestionStore;

import java.util.*;
import java.util.stream.Collectors;

public class Distributor {

  private QuestionStore store;


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
      Question question = getLowestUsedQuestionByStandard(standardId);

      // increment usage on question, and increment above standard/strand maps
      question.incrementUsage();
      strandUsage.put(strandId, strandUsage.get(strandId) + 1);
      standardUsage.put(standardId, standardUsage.get(standardId) + 1);

      // add question to questions list
      questions.add(question);
    }

    return questions;
  }

  private Question getLowestUsedQuestionByStandard(Long standardId) {
    List<Question> sortedQuestions = store.getQuestionsByStandardId(standardId);

    sortedQuestions.sort((Question a, Question b) -> {
      if(a.getUsage() == b.getUsage()) {
        return 0;
      }
      return a.getUsage() - b.getUsage();
    });

    return sortedQuestions.get(0);
  }

  private Long getLeastAskedStrand(Map<Long, Long> strandUsageMap) {
    Map.Entry<Long, Long> leastUsedStrand = null;

    for(Map.Entry<Long, Long> entry: strandUsageMap.entrySet()) {
      if (leastUsedStrand == null || entry.getValue() < leastUsedStrand.getValue()) {
        leastUsedStrand = entry;
      }
    }

    return leastUsedStrand.getKey();
  }

  private Long getLeastAskedStandardInStrand(Long strandId, Map<Long, Long> standardUsage) {
    Map.Entry<Long, Long> leastUsedStandard = null;
    Set<Map.Entry<Long, Long>> entries = standardUsage
            .entrySet()
            .stream()
            .filter(e -> store.isStandardInStrand(e.getValue(), strandId))
            .collect(Collectors.toSet());

    for (Map.Entry<Long, Long> entry: entries) {
      if(leastUsedStandard == null || entry.getValue() < leastUsedStandard.getValue()) {
        leastUsedStandard = entry;
      }
    }

    return leastUsedStandard.getValue();
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
