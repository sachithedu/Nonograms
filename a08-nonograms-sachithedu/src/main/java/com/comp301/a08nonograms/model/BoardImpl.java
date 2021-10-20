package com.comp301.a08nonograms.model;

import java.util.Arrays;

public class BoardImpl implements Board {

  private final int[][] board;

  public BoardImpl(int row, int col) {
    this.board = new int[row][col];
  }

  @Override
  public boolean isShaded(int row, int col) {
    return board[row][col] == 1;
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return board[row][col] == 2;
  }

  @Override
  public boolean isSpace(int row, int col) {
    return board[row][col] == 0;
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (isShaded(row, col)) {
      board[row][col] = 0;
    } else {
      board[row][col] = 1;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (isEliminated(row, col)) {
      board[row][col] = 0;
    } else {
      board[row][col] = 2;
    }
  }

  @Override
  public void clear() {
    for (int[] b : board) {
      Arrays.fill(b, 0);
    }
  }
}
