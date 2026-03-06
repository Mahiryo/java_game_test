package Player;

import world.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls {
    public GamePanel panel;

    public boolean wDown = false;
    public boolean sDown = false;
    public boolean aDown = false;
    public boolean dDown = false;
    public boolean spaceDown = false;
    public boolean shiftDown = false;

    public Controls(GamePanel gamePanel) {
        this.panel = gamePanel;
    }

    public void createControls() {


        panel.parentFrame.addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
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
                }
            }

            @Override public void keyReleased(KeyEvent e) {
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
                }
            }
        });
    }
}