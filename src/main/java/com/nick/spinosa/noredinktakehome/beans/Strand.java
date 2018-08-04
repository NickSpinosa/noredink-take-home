package com.nick.spinosa.noredinktakehome.beans;

public class Strand {
  private String name;
  private Long id;

  public String getName() {
    return name;
  }

  public Strand setName(String name) {
    this.name = name;
    return this;
  }

  public Long getId() {
    return id;
  }

  public Strand setId(Long id) {
    this.id = id;
    return this;
  }
}
