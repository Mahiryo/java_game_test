package world;

import Player.Controls;
import Player.Movement;
import Player.Resolve;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameLoop extends JPanel implements ActionListener {

    public long lastTime = System.nanoTime();
    GamePanel gamePanel;
    ArrayList<GameObject> colliders;
    ArrayList<GameOverlay> overlays;
    Controls controls;
    Movement movement;
    ViewPort viewPort;

    public GameLoop(GamePanel panel){
        new Timer(16, this).start();
        this.gamePanel = panel;
        this.controls = new Controls(this.gamePanel);
        this.movement = new Movement(this.controls,500, 1_250,0.987, -987);
        this.controls.createControls();
        this.viewPort = gamePanel.viewPort;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long now = System.nanoTime();
        double dt = (now - lastTime) / 1_000_000_000.0; // 1 000 000 000 or jus ONE BILLION
        lastTime = now;
        if (dt > 0.05){
            dt = 0.05;
        }
        movement.tick(dt);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GameObject gameObject : gamePanel.components) {
            gameObject.render(g);
        }

        for (GameOverlay gameOverlay : gamePanel.decorations) {
            gameOverlay.render(g);
        }
        this.viewPort.render(g);
    }

}
