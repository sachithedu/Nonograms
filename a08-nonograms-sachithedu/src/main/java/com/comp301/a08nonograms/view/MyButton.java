package com.comp301.a08nonograms.view;

import javafx.scene.control.Button;

public class MyButton extends Button {

  private int row;
  private int col;

  public MyButton(int row, int col) {
    super();
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }
}
