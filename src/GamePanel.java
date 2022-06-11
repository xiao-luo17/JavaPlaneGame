import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


//游戏面板
public class GamePanel extends JPanel {

    GameLogic gameLogic = new GameLogic();

        //绘制背景
        //绘制敌机
        //绘制生命值
        //绘制击败敌机数
        //绘制Boss
        //绘制死亡画面
        //绘制胜利画面
        //绘制菜单页
        //绘制选项页
        //绘制
        //

    public GamePanel(GameFrame frame){
        //构造对象时执行主逻辑
        gameLogic.run();
        //加入鼠标监听
        //加入键盘监听
        frame.addKeyListener(new Listener().getKeyAdapter(gameLogic));
        addMouseListener(new Listener().getMouseAdapter(gameLogic));
        addMouseMotionListener(new Listener().getMouseAdapter(gameLogic));
    }

    //画图方法
    @Override
    public void paint(Graphics g) {
        //调用父类中的一些渲染方法
        super.paint(g);
        //画背景
        g.drawImage(Data.getBackground(),0,0,null);
        //画敌机
        for (int i = 0; i < gameLogic.enemies.size(); i++) {
            Enemy enemy = gameLogic.enemies.get(i);
            g.drawImage(enemy.img,enemy.x,enemy.y,null);
        }
        //画子弹
        for (int i = 0; i < gameLogic.bullets.size(); i++) {
            Bullet bullet = gameLogic.bullets.get(i);
            g.drawImage(bullet.img,bullet.x,bullet.y,bullet.w,bullet.h,null);

        }
        //画分数
        g.setColor(Color.white);
        //设置字体型号，设置加粗，设置字体大小
        g.setFont(new Font("\u6977\u4F53",Font.BOLD,30));
        //显示分数
        g.drawString("分数:"+gameLogic.score,10,30);
        //画游戏机
        g.drawImage(gameLogic.myPlane.img,gameLogic.myPlane.x,gameLogic.myPlane.y,null);
        //画游戏机血量
        for (int i = 0; i < gameLogic.myPlane.blood; i++) {
            g.drawImage(gameLogic.myPlane.img,380+i*35,5,30,30,null);
        }
        if(gameLogic.boss!=null){
            g.drawImage(gameLogic.boss.img,gameLogic.boss.x,gameLogic.boss.y,null);
        }

        if(gameLogic.boss!=null && gameLogic.score>=100){

            for (int i = 0; i < gameLogic.fires.size(); i++) {
                Fire fire = gameLogic.fires.get(i);
                g.drawImage(fire.img,fire.x,fire.y,fire.w,fire.h,null);

            }
        }
        //画游戏结束
        if(gameLogic.gameover){

            g.drawImage(Data.getOver(),0,0,Data.getBackground().getWidth(),Data.getBackground().getHeight(),null);
            //设置字体颜色为红色
            //g.setColor(Color.red);
            //设置字体型号，设置加粗，设置字体大小
            //g.setFont(new Font("楷体",Font.BOLD,35));
            //显示字体
            //g.drawString("GAMEOVER",170,300);
            //设置字体颜色为绿色
            //g.setColor(Color.green);
            //设置字体型号，设置加粗，设置字体大小
            //g.setFont(new Font("楷体",Font.BOLD,29));
            //显示字体
            g.drawString("点击屏幕任意位置重新开始",50,450);
        }
        //重新绘制界面
        repaint();
    }

}
