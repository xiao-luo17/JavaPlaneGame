public class Fire extends FlyObject{
    //子弹当前移动方向，0为左上角飞，1垂直飞，2右上角飞
    int dir;

    //构造方法，初始化子弹
    public Fire(int hx, int hy, int dir){
        //获取子弹的图片
        img = Data.getBullet();
        w = img.getWidth();
        h = img.getHeight();
        //根据构造函数传进来的参数设置子弹的位置以及子弹的方向
        x = hx;
        y = hy;
        this.dir=dir;
    }

    //子弹的移动方法
    public void move() {

        if(dir==0){
            x -= 1;
            y += 10;
        }
        else if(dir == 1){
            x += 1;
            y += 10;
        }
        else if(dir == 2){
            x -= 2;
            y += 10;
        }
        else if(dir == 3){
            x += 2;
            y += 10;
        }
        else if(dir == 4) {
            x -= 3;
            y += 10;
        }
        else if(dir == 5){
            x += 3;
            y += 10;
        }
        else if(dir == 6) {
            y += 10;
        }
    }

    public boolean isShot(MyPlane m){
        Boolean is = x <= m.x+m.w &&x>m.x-w&&y<=m.y+m.h&&y>m.y-h;
        return is;
    }
}

