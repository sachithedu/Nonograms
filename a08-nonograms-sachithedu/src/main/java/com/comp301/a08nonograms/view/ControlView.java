package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent {

  private Controller controller;

  public ControlView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #336699;");
    hbox.setAlignment(Pos.CENTER);

    Button previousButton = new Button("Previous Puzzle");
    previousButton.setPrefSize(150, 20);
    previousButton.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
        });

    Button randomButton = new Button("Random Puzzle");
    randomButton.setPrefSize(150, 20);
    randomButton.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });

    Button nextButton = new Button("Next Puzzle");
    nextButton.setPrefSize(150, 20);
    nextButton.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
        });

    Button clearButton = new Button("Reset");
    clearButton.setPrefSize(150, 20);
    clearButton.setOnAction(
        (ActionEvent event) -> {
          controller.clearBoard();
        });

    hbox.getChildren().addAll(previousButton, randomButton, nextButton, clearButton);
    return hbox;
  }
}
