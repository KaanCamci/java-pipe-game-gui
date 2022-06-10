import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
/* KAAN CAMCI 150119063
   SENA VATANSEVER 150119755
 */
public class Pipe {

    private int giris;
    private int cikis;
    private int loc;
    private String features;


    public Pipe(String features, int loc) {
        this.features=features;
        this.loc = loc;
        switch (features) {
            case "Empty,none":
                this.giris=50;
                this.cikis=50;
                break;

            case "Empty,Free":

            case "Empty,free":
                this.giris=50;
                this.cikis=50;
                break;

            case "Starter,Vertical":
                this.giris=50;
                this.cikis=loc+4;
                break;

            case "Starter,Horizontal":
                this.giris=50;
                this.cikis=loc-1;
                break;

            case "End,Horizontal":
                this.giris=loc-1;
                this.cikis=50;
                break;

            case "End,Vertical":
                this.giris=50;
                this.cikis=loc+4;
                break;

            case "Pipe,Horizontal":
            case "PipeStatic,Horizontal":
                this.giris=loc-1;
                this.cikis=loc+1;
                break;

            case "Pipe,Vertical":
            case "PipeStatic,Vertical":
                this.giris=loc-4;
                this.cikis=loc+4;
                break;

            case "PipeStatic,00":
            case "Pipe,00":
                this.giris=loc-1;
                this.cikis=loc-4;
                break;

            case "PipeStatic,01":
            case "Pipe,01":
                this.giris=loc-4;
                this.cikis=loc+1;
                break;

            case "PipeStatic,10":
            case "Pipe,10":
                this.giris=loc-1;
                this.cikis=loc+4;
                break;

            case "PipeStatic,11":
            case "Pipe,11":
                this.giris=loc+1;
                this.cikis=loc+4;
                break;

        }
    }

    public int getGiris() {
        return giris;
    }

    public void setGiris(int giris) {
        this.giris = giris;
    }

    public int getCikis() {
        return cikis;
    }

    public void setCikis(int cikis) {
        this.cikis = cikis;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}
