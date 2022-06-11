import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//数据集类
public class Data extends FlyObject{


    public static BufferedImage getImgURL(String url){

        try {
            return ImageIO.read(Data.class.getResource(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static BufferedImage bee = getImgURL("/static/img/bee0.png");
    private static BufferedImage myPlane = getImgURL("/static/img/hero1.png");
    private static BufferedImage enemy = getImgURL("/static/img/airplane0.png");
    private static BufferedImage boss = getImgURL("/static/img/bigplane0.png");
    private static BufferedImage background = getImgURL("static/img/background.png");
    private static BufferedImage start = getImgURL("/static/img/start.png");
    private static BufferedImage over = getImgURL("/static/img/gameover.png");
    private static BufferedImage pause = getImgURL("/static/img/pause.png");
    private static BufferedImage bullet = getImgURL("/static/img/bullet.png");

    public static BufferedImage getBee() {

        return bee;
    }

    public static BufferedImage getMyPlane() {
        return myPlane;
    }

    public static BufferedImage getEnemy() {
        return enemy;
    }

    public static BufferedImage getBoss() {
        return boss;
    }

    public static BufferedImage getBackground() {
        return background;
    }

    public static BufferedImage getStart() {
        return start;
    }

    public static BufferedImage getOver() {
        return over;
    }

    public static BufferedImage getPause() {
        return pause;
    }

    public static BufferedImage getBullet() {
        return bullet;
    }
}
