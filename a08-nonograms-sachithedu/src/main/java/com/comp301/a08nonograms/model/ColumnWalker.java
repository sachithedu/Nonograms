package com.comp301.a08nonograms.model;

public class ColumnWalker {

  private int column;
  private int cursor;
  private Board board;
  private Clues clues;

  public ColumnWalker(int column, Board board, Clues clues) {
    this.column = column;
    this.cursor = 0;
    this.board = board;
    this.clues = clues;
  }

  public int getNextShadedCount() {
    int count = 0;
    // Skip initial blank spaces
    while (cursor < clues.getHeight() && !board.isShaded(cursor, column)) {
      cursor++;
    }
    // Count consecutive shaded spaces
    while (cursor < clues.getHeight() && board.isShaded(cursor, column)) {
      cursor++;
      count++;
    }

    return count;
  }
}
