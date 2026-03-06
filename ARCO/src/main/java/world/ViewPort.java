package world;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ViewPort extends JPanel {
    public final int max_width = 10_000;
    public final int max_height = 10_000;

    public Rectangle rect;

    public int viewport_width;
    public int viewport_height;

    public int position_x;
    public int position_y;

    public int rect_width;
    public int rect_height;

    public ViewPort(int frameWidth, int frameHeight){
        this.viewport_width = frameWidth;
        this.viewport_height = frameHeight;
        this.rect_width = 100;
        this.rect_height = 100;
        this.rect = new Rectangle(
        ((position_x - 100/2) + (viewport_width/2) - position_x),
        ((position_y - 100/2) + (viewport_height/2) - position_y) ,
        rect_width,
        rect_height);

    }
    public void render(Graphics g){
        this.rect = new Rectangle(
        ((position_x - 100/2) + (viewport_width/2) - position_x),
        ((position_y - 100/2) + (viewport_height/2) - position_y) ,
        rect_width,
        rect_height);

        g.setColor(Color.PINK);

        g.drawRect(
        ((position_x - 100/2) + (viewport_width/2) - position_x),
        ((position_y - 100/2) + (viewport_height/2) - position_y),
        rect_width,
        rect_height);

    }
}
