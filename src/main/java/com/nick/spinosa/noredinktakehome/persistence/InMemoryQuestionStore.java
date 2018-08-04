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
                          "Proper Nouns",
                          2L,
                          3L,
                          0.8,
                          0,
                          1L,
                          "Nouns")
          )),
          Map.entry(3L, List.of(
                  new Question(
                          "Proper Nouns",
                          3L,
                          4L,
                          0.2,
                          0,
                          1L,
                          "Nouns"),
                  new Question(
                          "Proper Nouns",
                          3L,
                          5L,
                          0.5,
                          0,
                          1L,
                          "Nouns"),
                  new Question(
                          "Proper Nouns",
                          3L,
                          6L,
                          0.4,
                          0,
                          1L,
                          "Nouns")
          )),
          Map.entry(4L, List.of(
                  new Question(
                          "Action Verbs",
                          4L,
                          7L,
                          0.2,
                          0,
                          2L,
                          "Nouns"),
                  new Question(
                          "Action Verbs",
                          4L,
                          8L,
                          0.5,
                          0,
                          2L,
                          "Nouns")
          )),
          Map.entry(5L, List.of(
                  new Question(
                          "Action Verbs",
                          4L,
                          9L,
                          0.2,
                          0,
                          2L,
                          "Nouns"),
                  new Question(
                          "Action Verbs",
                          4L,
                          10L,
                          0.5,
                          0,
                          2L,
                          "Nouns"),
                  new Question(
                          "Action Verbs",
                          4L,
                          11L,
                          0.5,
                          0,
                          2L,
                          "Nouns")
          )),
          Map.entry(6L, List.of(
                  new Question(
                          "Action Verbs",
                          4L,
                          12L,
                          0.2,
                          0,
                          2L,
                          "Nouns")
          ))
  );
  // maps a strand id to the set of standards associated to it
  private Map<Long, Set<Long>> strandToStandardsMap = Map.ofEntries(
          Map.entry(1L, Set.of(1L, 2L, 3L)),
          Map.entry(2L, Set.of(4L, 5L, 6L))
  );
  // list of all strands
  private List<Strand> strands = List.of(
          new Strand("Nounds", 1L),
          new Strand("Verbs", 2L));


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
