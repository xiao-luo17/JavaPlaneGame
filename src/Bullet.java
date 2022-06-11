public class Bullet extends FlyObject{


    int dir;

    public Bullet(int x1,int y1,int dir){

        img = Data.getBullet();

        w = img.getWidth();
        h = img.getHeight();

        x = x1;
        y = y1;

        this.dir = dir;

    }


    public void move(){

        if(dir==0){
            y-=10;
        }

        if(dir==1){
            x-=1;
            y-=10;
        }

        if(dir==2){
            x+=1;
            y-=10;
        }

    }


}
