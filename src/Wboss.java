public class Wboss extends FlyObject{

    int blood;

    public Wboss(){

        img = Data.getBoss();

        x=220;
        y=0;

        w=img.getWidth();
        h=img.getHeight();

        blood = 10;

    }


    public boolean isShot(Bullet b) {
        Boolean is = x <= b.x+b.w &&x>b.x-w&&y<=b.y+b.h&&y>b.y-h;
        return is;
    }
}
