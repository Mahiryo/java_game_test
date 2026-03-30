package Game.Arco.Build.Elements;

import Game.Arco.Build.Element;
import Game.Arco.Build.Overlay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerBite extends Element {

    double totalArea = 0;

    int centerX;
    int centerY;
    double sumX = 0;
    double sumY = 0;
    int current_frame;
    double frame_timer;
    JPanel jPanel;
    ArrayList<Overlay> frameList = new ArrayList<>();

    public PlayerBite(){}

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
//
//    public void tick(int delta_x, int delta_y, double dt) {
//
//        if (delta_x != 0) {
//            frame_timer += dt;
//            if (frame_timer >= 0.12) {
//                frame_timer = 0;
//                if (current_frame > 3) {
//                    current_frame = 1;
//                }
//                    getOverlays().getFirst().setImage(new ImageIcon(frameList.get(current_frame++).getImage()).getImage());
//            }
//        }
//        if (delta_x == 0 && delta_y == 0 && dt == 0) {
//            current_frame = 2;
//            getOverlays().getFirst().setImage(new ImageIcon(frameList.get(current_frame).getImage()).getImage());
//        }
//
//        for (Overlay sprite : getOverlays()) {
//            sprite.setX(sprite.getX() - delta_x);
//            sprite.setY(sprite.getY() - delta_y);
//
//            if (sprite.getY() >= 1000) {
//                sprite.setY(0);
//                sprite.setX(0);
//                this.getViewPort().setPosition_y(0);
//                this.getViewPort().setPosition_x(0);
//            }
//            System.out.println(sprite.getY());
//
//            if (delta_x < 0) {
//                sprite.image_width = Math.abs(sprite.image_width);
//            } else if (delta_x > 0) {
//                sprite.image_width = -(Math.abs(sprite.image_width));
//            }
//        }
//        this.update();
//    }
//
//



    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JPanel getjPanel() {
        return jPanel;
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

}
