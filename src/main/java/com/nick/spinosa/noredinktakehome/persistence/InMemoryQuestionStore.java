package com.nick.spinosa.noredinktakehome.persistence;

import com.nick.spinosa.noredinktakehome.beans.Question;
import com.nick.spinosa.noredinktakehome.beans.Strand;

import java.util.*;

public class InMemoryQuestionStore implements QuestionStore {
  // maps a standard id to the list of quesions associated to it
  private Map<Long, List<Question>> standardToQuestionMap = new HashMap<>();
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
