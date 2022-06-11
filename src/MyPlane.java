public class MyPlane extends FlyObject{

    int blood;

    public MyPlane(){

        img = Data.getMyPlane();

        x=500;
        y=200;

        w=img.getWidth();
        h=img.getHeight();

        blood = 10;

    }

    public void move(int x1,int y1){
        x = x1;
        y = y1;
    }


}
