import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/* KAAN CAMCI 150119063
   SENA VATANSEVER 150119755
 */
public class LevelStarter {

    private boolean finished = false; //controls if the level is finised or not
    private ArrayList<String> boxesInfos = new ArrayList<String>(); //datas of boxes
    private ArrayList<ImageView> boxes = new ArrayList<ImageView>(); //boxes



    /*
    oyun başladığı zaman girilen txt dosyası okutulup boxesinfos arraylistine ekleniyor

    boxesInfos'taki bilgilere göre boxes arrayList'ine imageView öğeleri sırayla ekleniyor

    boxes arrayListindeki sırasına göre imageView objeleri pane'e ekleniyor




    bir kutucuğa tıklandığı zaman controlStaticStatus methodu çalışıyor ve tıklanın öğenin boxes arrayListindeki sırasına bakılıyor

    kaçıncıysa o sıradaki *****boxesInfos'a bakılıyor***** ve eğer pipe ve empty değilse hareket edemiyor



    hareket ettirilen kutucuk bırakıldığı zaman relocate methodu çalıştırılıyor
    tek tek bütün kutucuklar boxes arraylistinden kontrol ediliyor ve eğer bırakılan kutucuğun merkezinin konumu kontrol edilen kutunun içindeyse,
    başlangıç konumunun x'leri arasındaki fark 197 ya da y'leri arasındaki fark 197'yse,
    kontrol edilen kutucuğun boxesInfos'taki sırasındaki 2. kelimeye bakılır, eğer "free" ise:

    kontrol edilen kutucuğun x ve y değerleri freeX ve freeY'ye eşitlenir
    kontrol edilen konumu hareket ettirilen kutucuğun başlangıç konumuna eşitlenir ve freeLoc değişkenine Free kutucuğun konumu boxes'taki sırasına eşitlenir



    freeLoc 20 değilse (başta 20 olarak atanıyor) hareket ettirilen kutunun konumu freeX ve freeY'ye eşitleniyor
    boxesInfos ve boxes ArrayList'lerindeki yerleri değiştiriliyor


     */

    public LevelStarter(){

    }

    public LevelStarter(File file, Pane pane) throws FileNotFoundException { //starts new level with the given txt file parameter

        try { //adding datas into boxInfos arrayList
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.length() > 3) {
                    boxesInfos.add(data);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }


        for (int i = 0; i < 16; i++) {
            String a;
            if (i < 9) {
                a = boxesInfos.get(i).substring(2);
            } else {
                a = boxesInfos.get(i).substring(3);
            }


            switch (a) {
                case "Empty,none":
                    boxes.add(new ImageView(new Image(new FileInputStream("empty.png"))));
                    break;

                case "Empty,Free":

                case "Empty,free":
                    boxes.add(new ImageView(new Image(new FileInputStream("free.jpeg"))));
                    break;

                case "Starter,Vertical":
                    boxes.add(new ImageView(new Image(new FileInputStream("starter_vertical.png"))));
                    break;

                case "Starter,Horizontal":
                    boxes.add(new ImageView(new Image(new FileInputStream("starter_horizontal.png"))));
                    break;

                case "End,Horizontal":
                    boxes.add(new ImageView(new Image(new FileInputStream("end_horizontal.png"))));
                    break;

                case "End,Vertical":
                    boxes.add(new ImageView(new Image(new FileInputStream("end_vertical.png"))));
                    break;

                case "PipeStatic,Horizontal":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipeStatic_horizontal.png"))));
                    break;

                case "PipeStatic,Vertical":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipeStatic_vertical.png"))));
                    break;

                case "Pipe,00":
                    boxes.add(new ImageView(new Image(new FileInputStream("curved_00.png"))));
                    break;

                case "Pipe,01":
                    boxes.add(new ImageView(new Image(new FileInputStream("curved_01.png"))));
                    break;

                case "Pipe,10":
                    boxes.add(new ImageView(new Image(new FileInputStream("curved_10.png"))));
                    break;

                case "Pipe,11":
                    boxes.add(new ImageView(new Image(new FileInputStream("curved_11.png"))));
                    break;

                case "Pipe,Vertical":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipe_vertical.png"))));
                    break;

                    case "Pipe,Horizontal":
                        boxes.add(new ImageView(new Image(new FileInputStream("pipe_horizontal.png"))));
                        break;
                case "PipeStatic,00":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipeStatic_00.png"))));
                    break;
                case "PipeStatic,01":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipeStatic_01.png"))));
                    break;
                case "PipeStatic,10":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipeStatic_10.png"))));
                    break;
                case "PipeStatic,11":
                    boxes.add(new ImageView(new Image(new FileInputStream("pipeStatic_11.png"))));
                    break;
            }

        }




        boxes.get(0).setX(60);
        boxes.get(0).setY(80);

        boxes.get(1).setX(257);
        boxes.get(1).setY(80);

        boxes.get(2).setX(454);
        boxes.get(2).setY(80);

        boxes.get(3).setX(651);
        boxes.get(3).setY(80);

        boxes.get(4).setX(60);
        boxes.get(4).setY(277);

        boxes.get(5).setX(257);
        boxes.get(5).setY(277);

        boxes.get(6).setX(454);
        boxes.get(6).setY(277);

        boxes.get(7).setX(651);
        boxes.get(7).setY(277);

        boxes.get(8).setX(60);
        boxes.get(8).setY(474);

        boxes.get(9).setX(257);
        boxes.get(9).setY(474);

        boxes.get(10).setX(454);
        boxes.get(10).setY(474);

        boxes.get(11).setX(651);
        boxes.get(11).setY(474);

        boxes.get(12).setX(60);
        boxes.get(12).setY(671);

        boxes.get(13).setX(257);
        boxes.get(13).setY(671);

        boxes.get(14).setX(454);
        boxes.get(14).setY(671);

        boxes.get(15).setX(651);
        boxes.get(15).setY(671);



        pane.getChildren().add(boxes.get(0));
        pane.getChildren().add(boxes.get(1));
        pane.getChildren().add(boxes.get(2));
        pane.getChildren().add(boxes.get(3));
        pane.getChildren().add(boxes.get(4));
        pane.getChildren().add(boxes.get(5));
        pane.getChildren().add(boxes.get(6));
        pane.getChildren().add(boxes.get(7));
        pane.getChildren().add(boxes.get(8));
        pane.getChildren().add(boxes.get(9));
        pane.getChildren().add(boxes.get(10));
        pane.getChildren().add(boxes.get(11));
        pane.getChildren().add(boxes.get(12));
        pane.getChildren().add(boxes.get(13));
        pane.getChildren().add(boxes.get(14));
        pane.getChildren().add(boxes.get(15));

    }


    public void dragging(double xDifference, double yDifference, ImageView box, double mouseX, double mouseY) {

        box.setX(mouseX - xDifference);

        box.setY(mouseY - yDifference);

    }


    //controlling if the box is relocatable or not
    public boolean controlStaticStatus(int boxLocation) {

        String str = this.boxesInfos.get(boxLocation);
        String[] arrOfStr = str.split(",", 3);

        if (arrOfStr[1].equals("Pipe") || arrOfStr[2].equals("none")) {
            return false;
        } else {
            return true;
        }
    }




    public void relocate(ImageView box, int locationInArrayList, double startingX, double startingY, double releaseCenterX, double releaseCenterY, Pane pane) {

        ArrayList<Pipe> pipesList = new ArrayList<Pipe>();
        int freeLoc = 20;
        double freeX = 0;
        double freeY = 0;

        for (int i = 0; i < 16; i++) {

            double twoBoxesStartingXDifference = Math.abs(startingX - this.boxes.get(i).getX());
            double twoBoxesStartingYDifference = Math.abs(startingY - this.boxes.get(i).getY());


            if ((releaseCenterX >= this.boxes.get(i).getX() && releaseCenterX <= this.boxes.get(i).getX() + 187)
                    && (releaseCenterY >= this.boxes.get(i).getY() && releaseCenterY <= this.boxes.get(i).getY() + 187)) {
                if ((twoBoxesStartingXDifference == 197 && twoBoxesStartingYDifference == 0)
                        || (twoBoxesStartingYDifference == 197 && twoBoxesStartingXDifference == 0)) {

                    String str = this.boxesInfos.get(i);
                    String[] arrOfStr = str.split(",", 3);

                    if (arrOfStr[2].equals("Free")) {

                        freeX = this.boxes.get(i).getX();
                        freeY = this.boxes.get(i).getY();


                        this.boxes.get(i).setX(startingX);
                        this.boxes.get(i).setY(startingY);

                        freeLoc = i;
                        break;

                    }


                }


            }


        }


        if (freeLoc != 20) {
            box.setX(freeX);
            box.setY(freeY);


            //freeLoc means free box's location in boxes arraylist and boxesInfos arraylist
            //locationInArraylist means the box's (that will change locations with free box) location in boxes arraylist and boxesInfos arraylist

            String freeBoxInfo = this.boxesInfos.get(freeLoc);
            String boxInfo = this.boxesInfos.get(locationInArrayList);

            String[] arrOfFree = freeBoxInfo.split(",", 3);
            String[] arrOfBox = boxInfo.split(",", 3);

            String newBoxInfo;
            String newFreeBoxInfo;
            if (arrOfFree[0].length() == 1 && arrOfBox[0].length() == 1) {

                newBoxInfo = freeBoxInfo.substring(0, 2) + boxInfo.substring(2);
                newFreeBoxInfo = boxInfo.substring(0, 2) + freeBoxInfo.substring(2);

            } else if (arrOfFree[0].length() == 2 && arrOfBox[0].length() == 2) {
                newBoxInfo = freeBoxInfo.substring(0, 3) + boxInfo.substring(3);
                newFreeBoxInfo = boxInfo.substring(0, 3) + freeBoxInfo.substring(3);
            } else if (arrOfFree[0].length() == 1 && arrOfBox[0].length() == 2) {
                newBoxInfo = freeBoxInfo.substring(0, 2) + boxInfo.substring(3);
                newFreeBoxInfo = boxInfo.substring(0, 3) + freeBoxInfo.substring(2);

            } else {
                newBoxInfo = freeBoxInfo.substring(0, 3) + boxInfo.substring(2);
                newFreeBoxInfo = boxInfo.substring(0, 2) + freeBoxInfo.substring(3);
            }


            //changed locations in boxesInfos
            this.boxesInfos.set(locationInArrayList, newFreeBoxInfo);
            this.boxesInfos.set(freeLoc, newBoxInfo);


            //changed locations in boxes arrayList
            ImageView tempView = this.boxes.get(freeLoc);
            this.boxes.set(freeLoc, this.boxes.get(locationInArrayList));
            this.boxes.set(locationInArrayList, tempView);


            for (int i = 0; i<16; i++){

                if(i<9){
                    String features = boxesInfos.get(i).substring(2);
                    pipesList.add(new Pipe(features,i));
                }
                else{
                    String features = boxesInfos.get(i).substring(3);
                    pipesList.add(new Pipe(features,i));
                }

            }



        } else {
            box.setX(startingX);
            box.setY(startingY);
        }



        //setAccessible(-40,pipesList,0);


        this.controlFinishedOrNot(pipesList);

    }

    public void controlFinishedOrNot(ArrayList<Pipe> pipesList){

        int ballLocation = 0;

        for (int i = 0; i < 16; i++) {

            if (i < 9) {
                if (boxesInfos.get(i).substring(2).equals("Starter,Vertical")) {
                ballLocation = i ;
                break;
                }
                else if(boxesInfos.get(i).substring(2).equals("Starter,Horizontal")){
                    ballLocation = i ;
                    break;
                }

            }
            else {

                if (boxesInfos.get(i).substring(3).equals("Starter,Vertical")) {
                    ballLocation = i ;
                    break;
                }
                else if(boxesInfos.get(i).substring(3).equals("Starter,Horizontal")){
                    ballLocation = i;
                    break;
                }
            }
            }
        controlAndFinish(ballLocation,pipesList,0);

    }


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public ArrayList<String> getBoxesInfos() {
        return boxesInfos;
    }

    public void setBoxesInfos(ArrayList<String> boxesInfos) {
        this.boxesInfos = boxesInfos;
    }

    public ArrayList<ImageView> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<ImageView> boxes) {
        this.boxes = boxes;
    }


    public void controlAndFinish(int ballLocation , ArrayList<Pipe>pipeList, int revornot){
        if(ballLocation==-40){
            for (int i = 0; i < 16; i++) {

                if (i < 9) {
                    if (boxesInfos.get(i).substring(2).equals("Starter,Vertical")) {
                        ballLocation = i ;
                        break;
                    }
                    else if(boxesInfos.get(i).substring(2).equals("Starter,Horizontal")){
                        ballLocation = i ;
                        break;
                    }

                }
                else {

                    if (boxesInfos.get(i).substring(3).equals("Starter,Vertical")) {
                        ballLocation = i ;
                        break;
                    }
                    else if(boxesInfos.get(i).substring(3).equals("Starter,Horizontal")){
                        ballLocation = i;
                        break;
                    }
                }
            }
        }

        Pipe current = pipeList.get(ballLocation);
        if(revornot==1){

            int temp = current.getGiris();
            current.setGiris(current.getCikis());
            current.setCikis(temp);
        }
        Pipe next = pipeList.get(current.getCikis());
        int a=2;//terslik (0sa düz 1se ters)

        int k = 0;//geçebilmesi
        if(current.getCikis()== next.getLoc()&&current.getLoc()== next.getGiris()){
            ballLocation = current.getCikis();
            a=0;
            k=1;
        }
        if(current.getCikis()== next.getLoc()&&current.getLoc()== next.getCikis()){
            ballLocation = current.getCikis();
            k=1;
            a=1;
        }


        if(k==1) {
            int endballLocation = 0;

            for (int i = 0; i < 16; i++) {

                if (i < 9) {
                    if (boxesInfos.get(i).substring(2).equals("End,Vertical")) {
                        endballLocation = i;
                        break;
                    } else if (boxesInfos.get(i).substring(2).equals("End,Horizontal")) {
                        endballLocation = i;
                        break;
                    }

                } else {

                    if (boxesInfos.get(i).substring(3).equals("End,Vertical")) {
                        endballLocation = i;
                        break;
                    } else if (boxesInfos.get(i).substring(3).equals("End,Horizontal")) {
                        endballLocation = i;
                        break;
                    }
                }
            }

            if (endballLocation == ballLocation) {
                this.setFinished(true);
            }else{
                controlAndFinish(ballLocation, pipeList,a);
            }



        }


    }


}

