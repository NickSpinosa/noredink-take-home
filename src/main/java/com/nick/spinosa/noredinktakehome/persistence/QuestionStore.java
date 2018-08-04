package com.nick.spinosa.noredinktakehome.persistence;

import com.nick.spinosa.noredinktakehome.beans.Question;
import com.nick.spinosa.noredinktakehome.beans.Strand;

import java.util.List;

public interface QuestionStore {

  List<Strand> getStrands();

  List<Long> getStandards();;

  List<Question> getQuestionsByStandardId(Long id);

  boolean isStandardInStrand(Long standardId, Long strandId);
}
