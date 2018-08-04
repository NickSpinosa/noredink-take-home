package com.nick.spinosa.noredinktakehome.beans;

public class Question {
  private Strand strand;
  private String name;
  private Long standardId;
  private Long id;
  private double difficulty;

  public Strand getStrand() {
    return strand;
  }

  public Question setStrand(Strand strand) {
    this.strand = strand;
    return this;
  }

  public String getName() {
    return name;
  }

  public Question setName(String name) {
    this.name = name;
    return this;
  }

  public Long getStandardId() {
    return standardId;
  }

  public Question setStandardId(Long standardId) {
    this.standardId = standardId;
    return this;
  }

  public Long getId() {
    return id;
  }

  public Question setId(Long id) {
    this.id = id;
    return this;
  }

  public double getDifficulty() {
    return difficulty;
  }

  public Question setDifficulty(double difficulty) {
    this.difficulty = difficulty;
    return this;
  }
}
