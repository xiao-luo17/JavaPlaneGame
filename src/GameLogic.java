import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    //构造本机
    MyPlane myPlane = new MyPlane();
    //Boss
    Wboss boss;
    //敌机集合
    List<Enemy> enemies = new ArrayList<>();
    //弹药集合
    List<Bullet> bullets = new ArrayList<>();
    //Boss弹药集合
    List<Fire> fires = new ArrayList<>();
    //定义分数
    int score;
    //设置游戏开关
    Boolean gameover=false;
    //设置火力
    int power = 1;

    //创建本机子弹
    int index_MB;
    protected void inputMyBullet(){
        index_MB++;
        if(index_MB>=10){
            if(power==1){
                Bullet bullet0 = new Bullet(myPlane.x+45,myPlane.y,0);
                bullets.add(bullet0);
            }else if(power==2){
                Bullet bullet0 = new Bullet(myPlane.x+15,myPlane.y,0);
                bullets.add(bullet0);
                Bullet bullet1 = new Bullet(myPlane.x+75,myPlane.y,0);
                bullets.add(bullet1);
            }else if(power==3){
                Bullet bullet0 = new Bullet(myPlane.x+15,myPlane.y,0);
                bullets.add(bullet0);
                Bullet bullet1 = new Bullet(myPlane.x+45,myPlane.y,0);
                bullets.add(bullet1);
                Bullet bullet2 = new Bullet(myPlane.x+75,myPlane.y,0);
                bullets.add(bullet2);
            }
            index_MB=0;
        }
    }
    //本机子弹移动
    protected void MyBulletMove(){
        for (int i = 0; i < bullets.size(); i++) {
            //获取每一颗子弹位置
            Bullet bullet = bullets.get(i);
            //依次移动每一颗子弹
            bullet.move();
        }
    }
    //创建敌机
    int index_E;
    protected void inputEnemy(){
        index_E++;
        //创建敌机
        if(index_E>=20){
            //创建敌机
            Enemy enemy = new Enemy();
            //加入集合
            enemies.add(enemy);
            //重置计数器
            index_E = 0;
        }
    }
    //敌机移动
    protected void enemyMove(){
        //遍历敌机集合，依次移动
        for (int i = 0; i < enemies.size(); i++) {
            //获取集合中敌机
            Enemy enemy = enemies.get(i);
            //调用敌机类中的移动方法
            enemy.move();
        }
    }
    //创建Boss子弹
    int index_BB;
    protected void inputBossBullet(){
        index_BB++;
        if (boss!=null){
            if(index_BB>=40){
                for (int i = 0; i < 7; i++) {
                    Fire fire = new Fire(boss.x+30,boss.y+70,i);
                    fires.add(fire);
                }
                index_BB = 0;
            }
        }

    }
    //Boss子弹飞行
    protected void BossBulletMove(){
        for (int i = 0; i < fires.size(); i++) {
            Fire fire = fires.get(i);
            fire.move();
        }
    }
    //命中碰撞逻辑
    protected void aim(){
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            for (int j = 0; j < enemies.size(); j++) {
                Enemy enemy = enemies.get(j);
                if(enemy.isShot(bullet)){
                    enemy.blood--;
                    bullets.remove(bullet);
                    if(enemy.blood==0){
                        score += 10;
                        enemies.remove(enemy);
                    }
                }
            }
        }
        if(boss!=null){
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if(boss.isShot(bullet)){
                    boss.blood--;
                    bullets.remove(bullet);
                    if(boss.blood==0){
                        boss = null;
                        score+=1000;
                        break;
                    }
                }
            }
        }

    }
    //受击碰撞逻辑
    protected void hurt(){
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if(enemy.isShot(myPlane)){
                enemies.remove(enemy);
                myPlane.blood--;
                score+=10;
                if(myPlane.blood==0){
                    gameover=true;
                }
            }
        }
        for (int i = 0; i < fires.size(); i++) {
            Fire fire = fires.get(i);
            if(fire.isShot(myPlane)){
                myPlane.blood--;
                fires.remove(fire);
                if(myPlane.blood==0){
                    gameover=true;
                }
            }
        }
    }

    //本机大招逻辑
    int index_Big;
    public void superBang(){
        power = 3;
        isBang = true;
        index_Big++;
        if(index_Big>=200){
            power = 1;
            index_Big = 0;
            isBang = false;
        }

    }
    //
    //
    //
    //

    Boolean isBang = false;
    public void run(){
        //创建线程
        new Thread(){
            public void run(){
                //无线循环创建
                while (true){
                    //判断如果游戏没有失败，则执行以下操作
                    if(!gameover){

                        //敌机进场
                        inputEnemy();
                        //敌机移动
                        enemyMove();

                        //本机子弹进场
                        inputMyBullet();
                        //本机子弹移动
                        MyBulletMove();
                        //执行大招
                        if(isBang){
                            superBang();
                        }

                        if(score == 100){
                            //Boss进场
                            // 构造Boss
                            boss = new Wboss();
                        }
                        if(score >= 100){
                            //Boss子弹进场
                            inputBossBullet();
                            //Boss子弹移动
                            BossBulletMove();
                        }

                        //判断子弹是否击中敌机
                        aim();
                        //检测敌机是否撞到游戏机
                        hurt();
                    }
                    //每执行一次，线程休眠一会儿
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();//让线程开始运行
    }
}
