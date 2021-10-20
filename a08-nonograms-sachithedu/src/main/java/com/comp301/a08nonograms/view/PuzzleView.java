package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.model.Clues;
import com.comp301.a08nonograms.model.Model;
import com.comp301.a08nonograms.model.ModelObserver;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PuzzleView implements FXComponent, ModelObserver {

  private Controller controller;

  public PuzzleView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox vbox = new VBox();
    vbox.setAlignment(Pos.CENTER);

    for (int row = 0; row < controller.getClues().getHeight(); row++) {
      HBox hbox = new HBox();
      hbox.setAlignment(Pos.CENTER);
      for (int col = 0; col < controller.getClues().getWidth(); col++) {
        MyButton button = new MyButton(row, col);
        button.setPrefSize(30, 30);
        // button.setStyle("fx-background-color: #C0C0C0");
        if (controller.isShaded(row, col)) {
          button.setText("S");
          // button.setStyle("fx-background-color: #000000");
        } else if (controller.isEliminated(row, col)) {
          button.setText("*");
        }
        hbox.getChildren().add(button);
        button.setOnMouseClicked(
            event -> {
              if (event.getButton() == MouseButton.PRIMARY) {
                if (button.getText().compareTo("") == 0) {
                  controller.toggleShaded(button.getRow(), button.getCol());
                } else if (button.getText().compareTo("S") == 0) {
                  controller.toggleShaded(button.getRow(), button.getCol());
                }
              } else if (event.getButton() == MouseButton.SECONDARY) {
                if (button.getText().compareTo("") == 0) {
                  controller.toggleEliminated(button.getRow(), button.getCol());
                } else if (button.getText().compareTo("*") == 0) {
                  controller.toggleEliminated(button.getRow(), button.getCol());
                }
              }
            });
      }
      vbox.getChildren().add(hbox);
    }
    return vbox;
  }

  @Override
  public void update(Model model) {
    // do nothing..
  }
}
