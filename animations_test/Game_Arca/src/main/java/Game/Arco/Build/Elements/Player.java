package Game.Arco.Build.Elements;


import Game.Arco.Build.Element;
import Game.Arco.Build.GameLoop;
import Game.Arco.Build.Overlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Element {
    double s_x = 0;
    double s_y = 0;
    double a = 450;
    double max_speed = 750;
    double drag = 0.956;
    double grav = -987;

    boolean on_ground = false;
    boolean wDown = false;
    boolean sDown = false;
    boolean aDown = false;
    boolean dDown = false;
    boolean spaceDown = false;
    boolean shiftDown = false;
    boolean controlDown = false;
    boolean qDown = false;

    PlayerBite TestTile = new PlayerBite();
    Overlay testOverlay = new Overlay();



    ImageIcon frame_1 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/7.png");
    ImageIcon frame_2 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/6.png");
    ImageIcon frame_3 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/5.png");
    ImageIcon frame_4 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/4.png");
    ImageIcon frame_5 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/3.png");
    ImageIcon frame_6 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/2.png");
    ImageIcon frame_7 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/Bite/1.png");

    int bite_frame = 0;
    
    double cool_down = 0.0;
    double counter_aux = 0.0;
    double lifetime = 0.0;

    GameLoop gameLoop;

    int current_frame;
    double frame_timer;

    int centerX;
    int centerY;

    ArrayList<Overlay> frameList = new ArrayList<>();
    ArrayList<Element> elementArrayList = new ArrayList<>();
    ArrayList<ImageIcon> imageIconArrayList = new ArrayList<>();
    ArrayList<ImageIcon> biteSpriteList = new ArrayList<>();
    public void setImageIconArrayList(ArrayList<ImageIcon> imageIconArrayList) {
        this.imageIconArrayList = imageIconArrayList;






    }

    public Player() {

//        this.biteSpriteList.add(frame_1);
//        this.biteSpriteList.add(frame_2);
        this.biteSpriteList.add(frame_3);
        this.biteSpriteList.add(frame_4);
        this.biteSpriteList.add(frame_5);
        this.biteSpriteList.add(frame_6);
        this.biteSpriteList.add(frame_7);


    }

    public void createControls(JFrame frame) {

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        wDown = true;
                        break;
                    case KeyEvent.VK_S:
                        sDown = true;
                        break;
                    case KeyEvent.VK_A:
                        aDown = true;
                        break;
                    case KeyEvent.VK_D:
                        dDown = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        spaceDown = true;
                        break;
                    case KeyEvent.VK_SHIFT:
                        shiftDown = true;
                        break;
                    case KeyEvent.VK_CONTROL:
                        controlDown = true;
                        break;
                    case KeyEvent.VK_Q:
                        if(!qDown){
                            bite();
                        }
                        qDown = true;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        wDown = false;
                        break;
                    case KeyEvent.VK_S:
                        sDown = false;
                        break;
                    case KeyEvent.VK_A:
                        aDown = false;
                        break;
                    case KeyEvent.VK_D:
                        dDown = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        spaceDown = false;
                        break;
                    case KeyEvent.VK_SHIFT:
                        shiftDown = false;
                        break;
                    case KeyEvent.VK_CONTROL:
                        controlDown = false;
                        break;
                    case KeyEvent.VK_Q:
//                        qDown = false;
                        break;
                }
            }
        });
    }


    public void update() {

        double totalArea = 0;
        double sumX = 0;
        double sumY = 0;
        for (Overlay overlay : getOverlays()) {
            Rectangle rect = overlay.getRect();
            double area = rect.getWidth() * rect.getHeight();
            totalArea += area;
            sumX += (rect.getCenterX() * area);
            sumY += (rect.getCenterY() * area);
        }
        this.centerX = (int) (sumX / totalArea);
        this.centerY = (int) (sumY / totalArea);
    }

    public void tick(int delta_x, int delta_y, double dt) {

        if (delta_x != 0) {
            frame_timer += dt;
            if (frame_timer >= 0.12) {
                frame_timer = 0;
                if (current_frame > 3) {
                    current_frame = 1;
                }
                if(controlDown){
                    getOverlays().getFirst().setImage(imageIconArrayList.get(current_frame++).getImage());
                } else {
                    getOverlays().getFirst().setImage(new ImageIcon(frameList.get(current_frame++).getImage()).getImage());
                }
            }
        }

        if(qDown){
            lifetime += dt;
            if (lifetime >= 0.24) {
                lifetime = 0;
                if (bite_frame < biteSpriteList.size()) {
                    this.TestTile.getOverlays().getFirst().setImage(biteSpriteList.get(bite_frame).getImage());
                    System.out.println("Frame da mordida: " + bite_frame);
                    bite_frame++;
                } else {
                    gameLoop.rmvElement(TestTile);
                    qDown = false;
                    bite_frame = 0;
                    lifetime = 0;
                }
            }
        }

        if (delta_x == 0 && delta_y == 0 && dt == 0) {
            current_frame = 2;
            if(controlDown){
                getOverlays().getFirst().setImage(imageIconArrayList.get(current_frame).getImage());
            } else {
                getOverlays().getFirst().setImage(new ImageIcon(frameList.get(current_frame).getImage()).getImage());
            }
        }

        for (Overlay sprite : getOverlays()) {
            sprite.setX(sprite.getX() - delta_x);
            sprite.setY(sprite.getY() - delta_y);

            if (sprite.getY() >= 1000) {
                sprite.setY(0);
                sprite.setX(0);
                this.getViewPort().setPosition_y(0);
                this.getViewPort().setPosition_x(0);
            }

            if (delta_x < 0) {
                sprite.image_width = Math.abs(sprite.image_width);
            } else if (delta_x > 0) {
                sprite.image_width = -(Math.abs(sprite.image_width));
            }
        }
        this.update();
        if (delta_y != 0) {
            this.getViewPort().setPosition_y(this.getViewPort().getPosition_y() - ((this.centerY) - (this.getViewPort().getViewport_height() / 2)));
        }
        if (delta_x != 0) {
            this.getViewPort().setPosition_x(this.getViewPort().getPosition_x() - ((this.centerX) - (this.getViewPort().getViewport_width() / 2)));
        }
    }

double dt;
    public void movement(double dt) {

        if (dt > 0.05) dt = 0.05;
        if (dt <= 0) return;
        this.dt = dt;
        double target_X = 0.0;
        if (aDown && !dDown) {
            target_X = max_speed;
        }
        if (dDown && !aDown) {
            target_X = -max_speed;
        }

        if (!dDown && !aDown) {

            tick(0, 0, 0);

        }
        double maxChange = a * dt;
        double diff_X = target_X - s_x;

        if (diff_X > maxChange) diff_X = maxChange;
        if (diff_X < -maxChange) diff_X = -maxChange;

        int prevX = getCenterX();
        int prevY = getCenterY();

        s_x += diff_X;
        int d_x = ((int) (Math.round(s_x * dt)));
        boolean can_move_x = solveX(d_x);
        if (can_move_x) {
            tick((int) (Math.round(s_x * dt)), 0, dt);
        } else {
            setCenterX(prevX);
            s_x = 0;
        }

        boolean can_move_y = false;

        if (on_ground) {
            s_y = 0;
        } else {
            s_y += (grav * dt);
        }

        double d_y = (s_y * dt);

        if (d_y != 0) {
            can_move_y = solveY((int) (Math.round(d_y)));
        }

        if (can_move_y) {
            tick(0, (int) (Math.round(d_y)), dt);
            on_ground = false;
        } else {
            setCenterY(prevY);
            on_ground = s_y < 0;
            s_y = 0;
        }
        if (s_y == 0 && on_ground) {
            jump();
        }
        if (shiftDown && cool_down >= 1) {
            dash();
            shiftDown = false;
        }


        counter_aux -= dt;
        cool_down += dt;
        s_y *= drag;
        s_x *= drag;

    }

    void jump() {
        if (spaceDown) {
            s_y = 550;
            on_ground = false;
        }
    }

    void dash() {
        if (dDown && !aDown) {
            s_x = -650;
            cool_down = 0;
            counter_aux = 0.5;
            return;
        }
        if (aDown && !dDown) {
            s_x = 650;
            cool_down = 0;
            counter_aux = 0.5;
        }
    }



    void bite (){
        bite_frame = 0;
        lifetime = 0;
        testOverlay = new Overlay();
        TestTile = new PlayerBite();

        testOverlay.setH(128);
        testOverlay.setW(128);
        testOverlay.image_width = 128;
        if ((s_x * dt) > 0) {
            testOverlay.image_width = +Math.abs(testOverlay.image_width);
            testOverlay.setX(-getViewPort().getPosition_x() - 76);
        } else if ((s_x * dt) < 0) {
            testOverlay.image_width = -(Math.abs(testOverlay.image_width));
            testOverlay.setX(-getViewPort().getPosition_x() + 76);
        }
        testOverlay.setName("aaaa");
        testOverlay.setViewPort(getViewPort());
        testOverlay.setImage(frame_1.getImage());

        testOverlay.setY(-getViewPort().getPosition_y());

        testOverlay.loadRect();

        TestTile.addOverlay(testOverlay);
        TestTile.setjPanel(this.getjPanel());

        gameLoop.addElement(TestTile);
    }


    public boolean solveX(int dx) {
        Rectangle local_test_rectangle_x = new Rectangle(this.getOverlays().getFirst().getRect());
        local_test_rectangle_x.x -= (dx);
        for (Element element : elementArrayList) {
            if (!(element instanceof Player)) {
                if (!(element instanceof PlayerBite)) {
                    for (Overlay overlay : element.getOverlays()) {
                        if (local_test_rectangle_x.intersects(overlay.getRect())) {
                        return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean solveY(int dy) {
        Rectangle local_test_rectangle_y = new Rectangle(this.getOverlays().getFirst().getRect());
        local_test_rectangle_y.y -= (dy);
        for (Element element : elementArrayList) {
            if (!(element instanceof Player)) {
                if (!(element instanceof PlayerBite)) {
                    for (Overlay overlay : element.getOverlays()) {
                        if (local_test_rectangle_y.intersects((overlay.getRect()))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setFrameList(ArrayList<Overlay> frameList) {
        this.frameList = frameList;
    }

    public void setElementArrayList(ArrayList<Element> elementArrayList) {
        this.elementArrayList = elementArrayList;
    }
    public void setjPanel(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public GameLoop getjPanel() {
        return gameLoop;
    }

}
