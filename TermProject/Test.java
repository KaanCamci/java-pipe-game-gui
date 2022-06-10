import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


// KAAN CAMCI
public class Test extends Application {




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        primaryStage.setTitle("Oyun");
        Pane pane = new Pane();

        //level label location
        Rectangle levelRectangle = new Rectangle(); //instantiating Rectangle
        levelRectangle.setX(20); //setting the X coordinate of upper left //corner of rectangle
        levelRectangle.setY(20); //setting the Y coordinate of upper left //corner of rectangle
        levelRectangle.setWidth(100); //setting the width of rectangle
        levelRectangle.setHeight(40); // setting the height of rectangle


        //black background
        Rectangle game = new Rectangle(); //instantiating Rectangle
        game.setX(50); //setting the X coordinate of upper left //corner of rectangle
        game.setY(70); //setting the Y coordinate of upper left //corner of rectangle
        game.setWidth(800); //setting the width of rectangle
        game.setHeight(800); // setting the height of rectangle

        Text levelLabel = new Text();
        levelLabel.setText("Level 1");
        levelLabel.setFont(new Font(20));
        levelLabel.setX(30);
        levelLabel.setY(45);
        levelLabel.setFill(Color.WHITE);


        pane.getChildren().add(levelRectangle);
        pane.getChildren().add(game);
        pane.getChildren().add(levelLabel);

        ArrayList<File> files = new ArrayList<File>();

        String fileName;

        File file;
        int fileLevel = 0;

        do {
            fileLevel++;

            fileName = "CSE1242_spring2022_project_level" + fileLevel + ".txt";

            file = new File(fileName);

            if (file.exists()) {
                files.add(file);
            }
        } while (file.exists());




        //starting new level from datas from text file

        LevelStarter level1 = new LevelStarter(files.get(0), pane);

        play(0, level1, pane, files, levelLabel);

        primaryStage.setScene(new Scene(pane, 900, 900));
        primaryStage.show();
    }












    public void play(int levelCount, LevelStarter level, Pane pane, ArrayList<File> files, Text levelLabel) throws FileNotFoundException {

        //when pressed 0
        pane.setOnMousePressed(event -> {


            int a = 0;
            if (event.getX() > 60 && event.getX() < 247 && event.getY() > 80 && event.getY() < 267) {
                a = 0;
            } else if (event.getX() > 257 && event.getX() < 444 && event.getY() > 80 && event.getY() < 267) {
                a = 1;
            } else if (event.getX() > 454 && event.getX() < 641 && event.getY() > 80 && event.getY() < 267) {
                a = 2;
            } else if (event.getX() > 651 && event.getX() < 838 && event.getY() > 80 && event.getY() < 267) {
                a = 3;
            } else if (event.getX() > 60 && event.getX() < 247 && event.getY() > 277 && event.getY() < 464) {
                a = 4;
            } else if (event.getX() > 257 && event.getX() < 444 && event.getY() > 277 && event.getY() < 464) {
                a = 5;
            } else if (event.getX() > 454 && event.getX() < 641 && event.getY() > 277 && event.getY() < 464) {
                a = 6;
            } else if (event.getX() > 651 && event.getX() < 838 && event.getY() > 277 && event.getY() < 464) {
                a = 7;
            } else if (event.getX() > 60 && event.getX() < 247 && event.getY() > 474 && event.getY() < 661) {
                a = 8;
            } else if (event.getX() > 257 && event.getX() < 444 && event.getY() > 474 && event.getY() < 661) {
                a = 9;
            } else if (event.getX() > 454 && event.getX() < 641 && event.getY() > 474 && event.getY() < 661) {
                a = 10;
            } else if (event.getX() > 651 && event.getX() < 838 && event.getY() > 474 && event.getY() < 661) {
                a = 11;
            } else if (event.getX() > 60 && event.getX() < 247 && event.getY() > 671 && event.getY() < 858) {
                a = 12;
            } else if (event.getX() > 257 && event.getX() < 444 && event.getY() > 671 && event.getY() < 858) {
                a = 13;
            } else if (event.getX() > 454 && event.getX() < 641 && event.getY() > 671 && event.getY() < 858) {
                a = 14;
            } else if (event.getX() > 651 && event.getX() < 838 && event.getY() > 671 && event.getY() < 858) {
                a = 15;
            }


            //controlling if the pressed box is static or not
            if (!level.controlStaticStatus(a)) {
                double xDifference = event.getX() - level.getBoxes().get(a).getX();
                double yDifference = event.getY() - level.getBoxes().get(a).getY();

                double startingX = level.getBoxes().get(a).getX();
                double startingY = level.getBoxes().get(a).getY();

                //removing and adding box because otherwise it may be below other boxes
                pane.getChildren().remove(level.getBoxes().get(a));
                pane.getChildren().add(level.getBoxes().get(a));


                //when dragged
                int finalA = a;
                level.getBoxes().get(a).setOnMouseDragged(event1 -> {

                    //changing location of box due to location of mouse
                    level.dragging(xDifference, yDifference, level.getBoxes().get(finalA), event1.getX(), event1.getY());

                    //when released
                    level.getBoxes().get(finalA).setOnMouseReleased(event2 -> {

                        double releaseCenterX = level.getBoxes().get(finalA).getX() + 93.5;
                        double releaseCenterY = level.getBoxes().get(finalA).getY() + 93.5;
                        level.relocate(level.getBoxes().get(finalA), finalA, startingX, startingY, releaseCenterX, releaseCenterY, pane);


                    });

                });
            }
        });

        pane.setOnMouseReleased(event -> {

            if(level.isFinished()==true) {//if level finished

                int newLevelCount = levelCount + 1;

                    for (int i = 0; i < 16; i++) {
                        pane.getChildren().remove(level.getBoxes().get(i));
                    }

                if (newLevelCount!=files.size()) {//if there is next level

                    String newLevelLabel = levelLabel.getText().substring(0,6);

                    newLevelLabel = newLevelLabel + (newLevelCount + 1 );

                    levelLabel.setText(newLevelLabel);

                    LevelStarter level1 = null;
                    try {
                        level1 = new LevelStarter(files.get(newLevelCount), pane);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    try {
                        play(newLevelCount, level1, pane, files, levelLabel);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }


                else{//if game finished

                    for(int i = 0; i<pane.getChildren().size();i++){
                        pane.getChildren().remove(0);


                    }
                }

            }

        });



    }

}