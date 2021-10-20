package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private int index; /* for active puzzle */
  private List<ModelObserver> observers = new ArrayList<ModelObserver>();
  private List<Puzzle> puzzles = new ArrayList<Puzzle>();

  public ModelImpl(List<Clues> cluesList) {
    this.index = 0;
    for (Clues clues : cluesList) {
      Board board = new BoardImpl(clues.getHeight(), clues.getWidth());
      this.puzzles.add(new Puzzle(board, clues));
    }
  }

  @Override
  public int getPuzzleCount() {
    return puzzles.size();
  }

  @Override
  public int getPuzzleIndex() {
    return index;
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (index < 0 || index >= getPuzzleCount()) {
      throw new IndexOutOfBoundsException();
    }
    this.index = index;
    NotifyObservers();
  }

  public Clues getClues() {
    return puzzles.get(this.index).getClues();
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  public void NotifyObservers() {
    for (ModelObserver observer : observers) {
      observer.update(this);
    }
  }

  public boolean getSolvedStatus() {
    Puzzle puzzle = puzzles.get(this.index);
    return puzzle.getSolvedStatus();
  }

  @Override
  public boolean isSolved() {
    Puzzle puzzle = puzzles.get(this.index);
    boolean solved = puzzle.isSolved();
    return solved;
  }

  @Override
  public boolean isShaded(int row, int col) {
    Board board = puzzles.get(this.index).getBoard();
    return board.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    Board board = puzzles.get(this.index).getBoard();
    return board.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    Board board = puzzles.get(this.index).getBoard();
    return board.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    Board board = puzzles.get(this.index).getBoard();
    board.toggleCellShaded(row, col);
    NotifyObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    Board board = puzzles.get(this.index).getBoard();
    board.toggleCellEliminated(row, col);
    NotifyObservers();
  }

  @Override
  public void clear() {
    Board board = puzzles.get(this.index).getBoard();
    board.clear();
    NotifyObservers();
  }

  @Override
  public int getWidth() {
    Clues clues = puzzles.get(this.index).getClues();
    return clues.getWidth();
  }

  @Override
  public int getHeight() {
    Clues clues = puzzles.get(this.index).getClues();
    return clues.getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    Clues clues = puzzles.get(this.index).getClues();
    return clues.getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    Clues clues = puzzles.get(this.index).getClues();
    return clues.getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    Clues clues = puzzles.get(this.index).getClues();
    return clues.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    Clues clues = puzzles.get(this.index).getClues();
    return clues.getColCluesLength();
  }
}
