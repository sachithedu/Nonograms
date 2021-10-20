package com.comp301.a08nonograms.model;

public class RowWalker {

  private int row;
  private int cursor;
  private Board board;
  private Clues clues;

  public RowWalker(int row, Board board, Clues clues) {
    this.row = row;
    this.cursor = 0;
    this.board = board;
    this.clues = clues;
  }

  public int getNextShadedCount() {
    int count = 0;
    // Skip initial blank spaces
    while (cursor < clues.getWidth() && !board.isShaded(row, cursor)) {
      cursor++;
    }
    // Count consecutive shaded spaces
    while (cursor < clues.getWidth() && board.isShaded(row, cursor)) {
      cursor++;
      count++;
    }

    return count;
  }
}
