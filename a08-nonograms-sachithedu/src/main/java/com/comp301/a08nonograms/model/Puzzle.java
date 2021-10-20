package com.comp301.a08nonograms.model;

public class Puzzle {

  private Board board;
  private Clues clues;
  private boolean solvedStatus;

  public Puzzle(Board board, Clues clues) {
    this.board = board;
    this.clues = clues;
    this.solvedStatus = false;
  }

  public Board getBoard() {
    return board;
  }

  public Clues getClues() {
    return clues;
  }

  public boolean getSolvedStatus() {
    return solvedStatus;
  }

  public boolean isSolved() {
    for (int i = 0; i < clues.getHeight(); i++) {
      if (!isRowSolved(i)) {
        solvedStatus = false;
        return false;
      }
    }

    for (int i = 0; i < clues.getWidth(); i++) {
      if (!isColSolved(i)) {
        solvedStatus = false;
        return false;
      }
    }
    solvedStatus = true;
    System.out.println("solved");
    return true;
  }

  private boolean isRowSolved(int index) {
    RowWalker rowWalker = new RowWalker(index, board, clues);
    int[] rowClues = clues.getRowClues(index);
    for (int i = 0; i < rowClues.length; i++) {
      int shadedCount = rowClues[i];
      if (shadedCount == 0) {
        continue;
      }
      if (rowWalker.getNextShadedCount() != shadedCount) {
        return false;
      }
    }
    if (rowWalker.getNextShadedCount() != 0) {
      return false;
    }
    return true;
  }

  private boolean isColSolved(int index) {
    ColumnWalker columnWalker = new ColumnWalker(index, board, clues);
    int[] colClues = clues.getColClues(index);
    for (int i = 0; i < colClues.length; i++) {
      int shadedCount = colClues[i];
      if (shadedCount == 0) {
        continue;
      }
      if (columnWalker.getNextShadedCount() != shadedCount) {
        return false;
      }
    }
    if (columnWalker.getNextShadedCount() != 0) {
      return false;
    }
    return true;
  }
}
