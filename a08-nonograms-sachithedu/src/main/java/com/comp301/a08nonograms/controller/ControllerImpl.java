package com.comp301.a08nonograms.controller;

import com.comp301.a08nonograms.model.Clues;
import com.comp301.a08nonograms.model.ModelImpl;

public class ControllerImpl implements Controller {

  private final ModelImpl model;

  public ControllerImpl(ModelImpl model) {
    if (model == null) {
      throw new RuntimeException("Null model value");
    }
    this.model = model;
  }

  @Override
  public Clues getClues() {
    return model.getClues();
  }

  public boolean getSolvedStatus() {
    return model.getSolvedStatus();
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    try {
      model.setPuzzleIndex(model.getPuzzleIndex() + 1);
    } catch (IndexOutOfBoundsException e) {
      // do nothing...
    }
  }

  @Override
  public void prevPuzzle() {
    try {
      model.setPuzzleIndex(model.getPuzzleIndex() - 1);
    } catch (IndexOutOfBoundsException e) {
      // do nothing...
    }
  }

  @Override
  public void randPuzzle() {
    int index = (int) (Math.random() * model.getPuzzleCount());
    model.setPuzzleIndex(index);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
