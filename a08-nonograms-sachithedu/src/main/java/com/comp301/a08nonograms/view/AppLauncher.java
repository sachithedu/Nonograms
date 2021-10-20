package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.controller.ControllerImpl;
import com.comp301.a08nonograms.model.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {
    // TODO: Launch your GUI here
    ModelImpl model = new ModelImpl(PuzzleLibrary.create());
    ControllerImpl controller = new ControllerImpl(model);
    ControlView controlView = new ControlView(controller);
    MessageView messageView = new MessageView(controller);
    PuzzleView puzzleView = new PuzzleView(controller);

    HBox row3 = new HBox();
    FakeView fakeView = new FakeView(controller);
    ColumnCluesView columnCluesView = new ColumnCluesView(controller);
    row3.setAlignment(Pos.CENTER);
    row3.getChildren().addAll(fakeView.render(), columnCluesView.render());

    HBox row4 = new HBox();
    RowCluesView rowCluesView = new RowCluesView(controller);
    row4.setAlignment(Pos.CENTER);
    row4.getChildren().addAll(rowCluesView.render(), puzzleView.render());

    model.addObserver(
        (Model m) -> {
          VBox v = new VBox();

          HBox r3 = new HBox();
          ColumnCluesView ccw = new ColumnCluesView(controller);
          FakeView fw = new FakeView(controller);
          r3.setAlignment(Pos.CENTER);
          r3.getChildren().addAll(fw.render(), ccw.render());

          HBox r4 = new HBox();
          RowCluesView rcw = new RowCluesView(controller);
          r4.setAlignment(Pos.CENTER);
          r4.getChildren().addAll(rcw.render(), puzzleView.render());

          HBox title = new HBox();
          title.setStyle("-fx-background-color: #336699;");
          title.setAlignment(Pos.CENTER);
          Label titleWord = new Label();
          titleWord.setText("Nonograms Game");
          titleWord.setTextFill(Color.web("#FFFFFF"));
          titleWord.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 30));
          titleWord.setStyle("-fx-font-size: 30px;");
          title.getChildren().add(titleWord);

          HBox key = new HBox();
          key.setAlignment(Pos.BOTTOM_CENTER);
          Text keyText = new Text();
          keyText.setText(
              "A \"S\" indicates a shaded region. A \"*\" indicates an eliminated region.");
          key.getChildren().add(keyText);

          MessageView mv = new MessageView(controller);
          v.getChildren().addAll(title, controlView.render(), mv.render(), r3, r4, key);

          Scene s = new Scene(v, 600, 550);
          stage.setScene(s);
        });

    HBox title = new HBox();
    title.setStyle("-fx-background-color: #336699;");
    title.setAlignment(Pos.CENTER);
    Label titleWord = new Label();
    titleWord.setText("Nonograms Game");
    titleWord.setTextFill(Color.web("#FFFFFF"));
    titleWord.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 30));
    titleWord.setStyle("-fx-font-size: 30px;");
    title.getChildren().add(titleWord);

    HBox key = new HBox();
    key.setAlignment(Pos.BOTTOM_CENTER);
    Text keyText = new Text();
    keyText.setText("A \"S\" indicates a shaded region. A \"*\" indicates an eliminated region.");
    key.getChildren().add(keyText);

    VBox vbox = new VBox();
    vbox.getChildren().addAll(title, controlView.render(), messageView.render(), row3, row4, key);

    Scene scene = new Scene(vbox, 600, 550);
    stage.setScene(scene);
    stage.show();
  }
}
