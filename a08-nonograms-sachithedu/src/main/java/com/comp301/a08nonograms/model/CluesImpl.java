package com.comp301.a08nonograms.model;

public class CluesImpl implements Clues {

  private int height;
  private int width;
  private int[][] rowClues;
  private int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new RuntimeException("Values cannot be null");
    }
    this.rowClues = rowClues;
    this.colClues = colClues;
  }

  @Override
  public int getWidth() {
    return colClues.length;
  }

  @Override
  public int getHeight() {
    return rowClues.length;
  }

  @Override
  public int[] getRowClues(int index) {
    if (index < 0) {
      throw new RuntimeException("Invalid value");
    }
    int[] clueList = rowClues[index];
    return clueList;
  }

  @Override
  public int[] getColClues(int index) {
    if (index < 0) {
      throw new RuntimeException("Invalid value");
    }
    int[] clueList = colClues[index];
    return clueList;
  }

  @Override
  public int getRowCluesLength() {
    // Get length of initial
    int length = rowClues[0].length;
    for (int i = 1; i < rowClues.length; i++) {
      if (rowClues[i].length > length) {
        length = rowClues[i].length;
      }
    }
    return length;
  }

  @Override
  public int getColCluesLength() {
    // Get length of initial
    int length = colClues[0].length;
    for (int i = 1; i < colClues.length; i++) {
      if (colClues[i].length > length) {
        length = colClues[i].length;
      }
    }
    return length;
  }
}
