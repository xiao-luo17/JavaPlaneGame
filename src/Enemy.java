import java.util.Random;

public class Enemy extends FlyObject{

    //设置敌机飞行速度
    int speed;
    //
    int blood;
    Random random = new Random();

    public Enemy(){

        img = Data.getEnemy();
        w=img.getWidth();
        h=img.getHeight();
        x=random.nextInt(Data.getBackground().getWidth()-w);
        speed=5;
        blood=2;
    }

    public void move(){
        y+=speed;
    }

    public boolean isShot(Bullet b){
        Boolean is = x <= b.x+b.w &&x>b.x-w&&y<=b.y+b.h&&y>b.y-h;
        return is;
    }

    public boolean isShot(MyPlane m){
        Boolean is = x <= m.x+m.w &&x>m.x-w&&y<=m.y+m.h&&y>m.y-h;
        return is;
    }

}
