package world;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public ArrayList<GameObject> components = new ArrayList<GameObject>();
    public ArrayList<GameOverlay> decorations = new ArrayList<GameOverlay>();
    public JFrame parentFrame;
    public ViewPort viewPort;
//    Image front_crib = new ImageIcon("/home/marci/Imagens/sketch_crib/cribFront.png").getImage();
//    Image middle_crib = new ImageIcon("/home/marci/Imagens/sketch_crib/cribMiddle.png").getImage();
//    Image back_crib = new ImageIcon("/home/marci/Imagens/sketch_crib/cribBack.png").getImage();

    Color referenceColor = new Color(0,0,0, 120);
    public GamePanel(JFrame jFrame){
        this.parentFrame = jFrame;
        this.viewPort = new ViewPort(parentFrame.getWidth(),parentFrame.getHeight());

        Start();
 }
    public void Start(){
//        decorations.add(new GameOverlay("back_crib",100,100,200,200,viewPort, back_crib, true));
//        decorations.add(new GameOverlay("middle_crib",100,100,200,200,viewPort, middle_crib, true));
//        decorations.add(new GameOverlay("front_crib",100,100,200,200,viewPort, front_crib, true));

        components.add(new GameObject("Test", 400,0,200,200,referenceColor, viewPort,false));
        components.add(new GameObject("Test", -400,0,200,200,referenceColor, viewPort,false));

        components.add(new GameObject("FLOOR", 0,400,10_000,10,Color.BLUE, viewPort,true));

        decorations.add(new GameOverlay("Orientation_X", 0,0,20_000,1,viewPort,null,false));
        decorations.add(new GameOverlay("Orientation_Y", 0,0,1,20_000,viewPort,null,false));
    }

    public ArrayList<GameObject> getList(){
        return components;
    }

    public ArrayList<GameOverlay> getDecorations(){
        return decorations;
    }
}
