package com.nick.spinosa.noredinktakehome.persistence;

import com.nick.spinosa.noredinktakehome.beans.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryQuestionStore {

  // maps a standard id to the list of quesions associated to it
  private Map<Long, List<Question>> standardToQuestionMap = new HashMap<>();

  // maps a strand id to the list of standards associated to it
  private Map<Long, List<Long>> strandToStandardsMap = new HashMap<>();
}
