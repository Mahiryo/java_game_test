package Game.Arco;

import Game.Arco.Build.Elements.Player;
import Game.Arco.Build.Elements.Tile;
import Game.Arco.Build.GameLoop;
import Game.Arco.Build.Overlay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {

    GameLoop gameLoop;
    JFrame frame;
    Tile tile_1;
    Tile tile_2;
    Tile tile_3;
    Tile tile_4;
    Tile tile_5;
    Tile tile_6;
    Tile tile_7;
    Tile tile_8;
    Tile tile_9;
    Tile tile_10;
    Tile tile_11;

    Overlay tileOverlay;
    Overlay tileOverlay_2;
    Overlay tileOverlay_3;
    Overlay tileOverlay_4;
    Overlay tileOverlay_5;
    Overlay tileOverlay_6;
    Overlay tileOverlay_7;
    Overlay tileOverlay_8;
    Overlay tileOverlay_9;
    Overlay tileOverlay_10;
    Overlay tileOverlay_11;

    ViewPort viewPort;
    Player player;

    Overlay Frame_01 = new Overlay();
    Overlay Frame_02 = new Overlay();
    Overlay Frame_03 = new Overlay();
    Overlay Frame_04 = new Overlay();


    public GameFrame() {
        this.frame = new JFrame("Arc");
        this.frame.setPreferredSize(new Dimension(1280, 720));
        this.frame.pack();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.gameLoop = new GameLoop();
        this.viewPort = new ViewPort(frame.getWidth(), frame.getHeight());
        this.gameLoop.setViewPort(viewPort);
        this.player = new Player();
        this.player.setViewPort(viewPort);

        this.Frame_01.setH(48);
        this.Frame_01.setW(22);
        this.Frame_01.image_width = 22;
        this.Frame_01.setName("frame_01");
        this.Frame_01.setViewPort(viewPort);
        this.Frame_01.setImage(new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/protag_0001.png").getImage());

        this.Frame_02.setH(48);
        this.Frame_02.setW(22);
        this.Frame_02.image_width = 22;
        this.Frame_02.setName("frame_02");
        this.Frame_02.setViewPort(viewPort);
        this.Frame_02.setImage(new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/protag_0002.png").getImage());

        this.Frame_03.setH(48);
        this.Frame_03.setW(22);
        this.Frame_03.image_width = 22;
        this.Frame_03.setName("frame_03");
        this.Frame_03.setViewPort(viewPort);
        this.Frame_03.setImage(new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/protag_0003.png").getImage());

        this.Frame_04.setH(48);
        this.Frame_04.setW(22);
        this.Frame_04.image_width = 22;
        this.Frame_04.setName("frame_04");
        this.Frame_04.setViewPort(viewPort);
        this.Frame_04.setImage(new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/protag_0004.png").getImage());



        this.player.addOverlay(Frame_01);

        this.player.setViewPort(viewPort);

        ArrayList<Overlay> sprites = new ArrayList<>();

        sprites.add(Frame_01);
        sprites.add(Frame_02);
        sprites.add(Frame_03);
        sprites.add(Frame_04);

        player.setFrameList(sprites);

        player.createControls(frame);

        player.setjPanel(gameLoop);

        tile_1 = new Tile();
        tile_1.setjPanel(gameLoop);

        tileOverlay = new Overlay();
        tileOverlay.setH(32);
        tileOverlay.setW(64);
        tileOverlay.image_width = 64;
        tileOverlay.setName("ccccc");
        tileOverlay.setViewPort(viewPort);
        tileOverlay.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/middle_center_til.png").getImage());
        tile_1.addOverlay(tileOverlay);
        tile_1.getOverlays().getFirst().setY(100);
        tile_1.getOverlays().getFirst().setX(0);


        tile_2 = new Tile();
        tile_2.setjPanel(gameLoop);

        tileOverlay_2 = new Overlay();
        tileOverlay_2.setH(32);
        tileOverlay_2.setW(64);
        tileOverlay_2.image_width = 64;
        tileOverlay_2.setName("bbbb");
        tileOverlay_2.setViewPort(viewPort);
        tileOverlay_2.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/middle_center_til.png").getImage());
        tile_2.addOverlay(tileOverlay_2);
        tile_2.getOverlays().getFirst().setY(100);
        tile_2.getOverlays().getFirst().setX(64);


        tile_3 = new Tile();
        tile_3.setjPanel(gameLoop);

        tileOverlay_3 = new Overlay();
        tileOverlay_3.setH(32);
        tileOverlay_3.setW(64);
        tileOverlay_3.image_width = 64;
        tileOverlay_3.setName("aaaa");
        tileOverlay_3.setViewPort(viewPort);
        tileOverlay_3.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/middle_center_til.png").getImage());
        tile_3.addOverlay(tileOverlay_3);
        tile_3.getOverlays().getFirst().setY(100);
        tile_3.getOverlays().getFirst().setX(-64);

        tile_4 = new Tile();
        tile_4.setjPanel(gameLoop);

        tileOverlay_4 = new Overlay();
        tileOverlay_4.setH(32);
        tileOverlay_4.setW(64);
        tileOverlay_4.image_width = 64;
        tileOverlay_4.setName("aaaa");
        tileOverlay_4.setViewPort(viewPort);
        tileOverlay_4.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/left_end_tile.png").getImage());
        tile_4.addOverlay(tileOverlay_4);
        tile_4.getOverlays().getFirst().setY(100);
        tile_4.getOverlays().getFirst().setX(128);

        tile_5 = new Tile();
        tile_5.setjPanel(gameLoop);

        tileOverlay_5 = new Overlay();
        tileOverlay_5.setH(32);
        tileOverlay_5.setW(64);
        tileOverlay_5.image_width = 64;
        tileOverlay_5.setName("aaaa");
        tileOverlay_5.setViewPort(viewPort);
        tileOverlay_5.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/right_end_tile.png").getImage());
        tile_5.addOverlay(tileOverlay_5);
        tile_5.getOverlays().getFirst().setY(100);
        tile_5.getOverlays().getFirst().setX(-128);


        tile_6 = new Tile();
        tile_6.setjPanel(gameLoop);

        tileOverlay_6 = new Overlay();
        tileOverlay_6.setH(32);
        tileOverlay_6.setW(32);
        tileOverlay_6.image_width = 32;
        tileOverlay_6.setName("aaaa");
        tileOverlay_6.setViewPort(viewPort);
        tileOverlay_6.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/middle_center_til.png").getImage());
        tile_6.addOverlay(tileOverlay_6);
        tile_6.getOverlays().getFirst().setY(48);
        tile_6.getOverlays().getFirst().setX(-256);


        tile_7 = new Tile();
        tile_7.setjPanel(gameLoop);

        tileOverlay_7 = new Overlay();
        tileOverlay_7.setH(32);
        tileOverlay_7.setW(32);
        tileOverlay_7.image_width = 32;
        tileOverlay_7.setName("aaaa");
        tileOverlay_7.setViewPort(viewPort);
        tileOverlay_7.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/left_end_tile.png").getImage());
        tile_7.addOverlay(tileOverlay_7);
        tile_7.getOverlays().getFirst().setY(48);
        tile_7.getOverlays().getFirst().setX(-256 + 32);

        tile_8 = new Tile();
        tile_8.setjPanel(gameLoop);

        tileOverlay_8 = new Overlay();
        tileOverlay_8.setH(32);
        tileOverlay_8.setW(32);
        tileOverlay_8.image_width = 32;
        tileOverlay_8.setName("aaaa");
        tileOverlay_8.setViewPort(viewPort);
        tileOverlay_8.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/right_end_tile.png").getImage());
        tile_8.addOverlay(tileOverlay_8);
        tile_8.getOverlays().getFirst().setY(48);
        tile_8.getOverlays().getFirst().setX(-256 - 32);

        tile_9 = new Tile();
        tile_9.setjPanel(gameLoop);

        tileOverlay_9 = new Overlay();
        tileOverlay_9.setH(32);
        tileOverlay_9.setW(32);
        tileOverlay_9.image_width = 32;
        tileOverlay_9.setName("aaaa");
        tileOverlay_9.setViewPort(viewPort);
        tileOverlay_9.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/middle_center_til.png").getImage());
        tile_9.addOverlay(tileOverlay_9);
        tile_9.getOverlays().getFirst().setY(48);
        tile_9.getOverlays().getFirst().setX(256);


        tile_10 = new Tile();
        tile_10.setjPanel(gameLoop);

        tileOverlay_10 = new Overlay();
        tileOverlay_10.setH(32);
        tileOverlay_10.setW(32);
        tileOverlay_10.image_width = 32;
        tileOverlay_10.setName("aaaa");
        tileOverlay_10.setViewPort(viewPort);
        tileOverlay_10.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/left_end_tile.png").getImage());
        tile_10.addOverlay(tileOverlay_10);
        tile_10.getOverlays().getFirst().setY(48);
        tile_10.getOverlays().getFirst().setX(256 + 32);

        tile_11 = new Tile();
        tile_11.setjPanel(gameLoop);

        tileOverlay_11 = new Overlay();
        tileOverlay_11.setH(32);
        tileOverlay_11.setW(32);
        tileOverlay_11.image_width = 32;
        tileOverlay_11.setName("aaaa");
        tileOverlay_11.setViewPort(viewPort);
        tileOverlay_11.setImage(new ImageIcon("src/main/resources/Imagens/Sprite_Tile/right_end_tile.png").getImage());
        tile_11.addOverlay(tileOverlay_11);
        tile_11.getOverlays().getFirst().setY(48);
        tile_11.getOverlays().getFirst().setX(256 - 32);


        gameLoop.addElement(tile_1);
        gameLoop.addElement(tile_2);
        gameLoop.addElement(tile_3);
        gameLoop.addElement(tile_4);
        gameLoop.addElement(tile_5);
        gameLoop.addElement(tile_6);
        gameLoop.addElement(tile_7);
        gameLoop.addElement(tile_8);
        gameLoop.addElement(tile_9);
        gameLoop.addElement(tile_10);
        gameLoop.addElement(tile_11);
        gameLoop.addElement(player);

        ImageIcon smol_frame_01 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/smol/protag_0001.png");
        ImageIcon smol_frame_02 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/smol/protag_0002.png");
        ImageIcon smol_frame_03 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/smol/protag_0003.png");
        ImageIcon smol_frame_04 = new ImageIcon("/home/marci/IdeaProjects/Game_Arca/src/main/resources/Imagens/prot/update/smol/protag_0004.png");

        ArrayList<ImageIcon> imageIcons = new ArrayList<>();
        imageIcons.add(smol_frame_01);
        imageIcons.add(smol_frame_02);
        imageIcons.add(smol_frame_03);
        imageIcons.add(smol_frame_04);

        player.setImageIconArrayList(imageIcons);

        player.setElementArrayList(gameLoop.getElementArrayList());

        frame.getContentPane().setBackground(Color.BLACK);
        gameLoop.setBackground(Color.BLACK);

        frame.add(gameLoop);

        gameLoop.start_this();

        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setVisible(true);


    }


}
