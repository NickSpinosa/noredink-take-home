package com.nick.spinosa.noredinktakehome.persistence;

import com.nick.spinosa.noredinktakehome.beans.Question;
import com.nick.spinosa.noredinktakehome.beans.Strand;

import java.util.*;

public class InMemoryQuestionStore implements QuestionStore {
  // maps a standard id to the list of quesions associated to it
  private Map<Long, List<Question>> standardToQuestionMap = Map.ofEntries(
          Map.entry(1L, List.of(
                  new Question(
                          "Common Nouns",
                          1L,
                          1L,
                          0.7,
                          0,
                          1L,
                          "Nouns"),
                  new Question(
                          "Common Nouns",
                          1L,
                          2L,
                          0.6,
                          0,
                          1L,
                          "Nouns")
          )),
          Map.entry(2L, List.of(
                  new Question(
                          "Common Nouns",
                          2L,
                          3L,
                          0.7,
                          0,
                          1L,
                          "Abstract Nouns")
          ))
  );
  // maps a strand id to the set of standards associated to it
  private Map<Long, Set<Long>> strandToStandardsMap = new HashMap<>();
  // list of all strands
  private List<Strand> strands = new ArrayList<>();


  public List<Strand> getStrands() {
    return strands;
  }

  public List<Long> getStandards() {
    return null;
  }

  public List<Question> getQuestionsByStandardId(Long id) {
    return standardToQuestionMap.get(id);
  }

  public boolean isStandardInStrand(Long standardId, Long strandId) {
    return strandToStandardsMap.get(strandId).contains(standardId);
  }
}
