import java.awt.event.*;

//适配器与监听器集
public class Listener {

    //鼠标适配器
    public MouseAdapter getMouseAdapter(GameLogic gameLogic) {
        MouseAdapter adapter = new MouseAdapter() {
            //点击鼠标时会执行的代码
            @Override
            public void mouseClicked(MouseEvent e) {
                //游戏结束时候，点击屏幕时重新开始游戏
                if (gameLogic.gameover) {
                    //boss机重置
                    gameLogic.boss = null;
                    //重新初始化主机
                    gameLogic.myPlane = new MyPlane();
                    //重置游戏开关
                    gameLogic.gameover = false;
                    //分数清0
                    gameLogic.score = 0;
                    //清空敌机集合
                    gameLogic.enemies.clear();
                    //随机背景图
                    //重新绘制
                }
            }

            //确定需要监听的事件，此处监听鼠标移动事件
            @Override
            public void mouseMoved(MouseEvent e) {
                //让游戏机的横纵坐标等于鼠标的移动坐标
                //获取鼠标的横纵坐标
                int x = e.getX();
                int y = e.getY();
                //传递坐标
                if (!gameLogic.gameover) {
                    //使鼠标坐标位于图片中央
                    gameLogic.myPlane.move(x - 114 / 2, y - 93 / 2);
                }
                //重新绘制界面
            }
        };
        //将适配器加入到监听器中
        return adapter;
    }

    public KeyAdapter getKeyAdapter(GameLogic gameLogic){
        KeyAdapter adapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //当键盘被按下触发
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                //上键
                if(keyCode == KeyEvent.VK_UP){
                    gameLogic.myPlane.y-=10;
                }
                //下键
                else if(keyCode == KeyEvent.VK_DOWN){
                    gameLogic.myPlane.y+=10;
                }
                //左键
                else if(keyCode == KeyEvent.VK_LEFT){
                    gameLogic.myPlane.x-=10;
                }
                //右键
                else if(keyCode == KeyEvent.VK_RIGHT){
                    gameLogic.myPlane.x+=10;
                }
                //Key == S
                else if(keyCode == KeyEvent.VK_S){
                    gameLogic.superBang();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return adapter;
    }

}
//键盘监听
//
//
//
//
//


