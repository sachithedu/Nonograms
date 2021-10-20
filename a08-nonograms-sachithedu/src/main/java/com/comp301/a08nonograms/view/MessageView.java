package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.controller.ControllerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MessageView implements FXComponent {

  private ControllerImpl controller;

  public MessageView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #336699;");
    hbox.setAlignment(Pos.CENTER);

    Label statusTextBox = new Label();
    statusTextBox.setTextFill(Color.web("#000000"));
    String message =
        "Puzzle " + (controller.getPuzzleIndex() + 1) + " of " + controller.getPuzzleCount() + ":";

    if (controller.isSolved()) {
      message = message + " Solved! Great Job!";
      statusTextBox.setText(message);
    } else {
      message = message + " Not Solved!";
      statusTextBox.setText(message);
    }

    statusTextBox.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 20));
    statusTextBox.setStyle("-fx-font-size: 20px;");
    // statusTextBox.setTextAlignment(TextAlignment.CENTER);
    hbox.getChildren().addAll(statusTextBox);
    return hbox;
  }
}
