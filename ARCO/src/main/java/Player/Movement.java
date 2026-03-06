package Player;


import world.GamePanel;
import world.ViewPort;

public class Movement {
    public double s_x = 0;
    public double s_y = 0;
    public double a;          
    public double max_speed;  
    public double drag;       
    public double grav;

    boolean on_ground = false;
    double cool_down;

    GamePanel gamePanel;
    Controls controls;
    Resolve resolve;
    ViewPort viewPort;
    public Movement(Controls controller,
                    double acceleration,
                    double max_speed,
                    double drag,
                    double gravity) {

        this.controls = controller;
        this.gamePanel = this.controls.panel;
        this.viewPort = this.controls.panel.viewPort;
        this.resolve = new Resolve(this.controls.panel);

        this.a = acceleration;
        this.max_speed = max_speed;
        this.drag = drag;
        this.grav = gravity;
    }

    public void tick(double dt) {

        if (dt > 0.05) dt = 0.05;
        if (dt <= 0) return;

        double target_X = 0.0;
//        double target_Y = 0.0;
        cool_down += dt;
        if (controls.aDown && !controls.dDown) target_X = max_speed;
        if (controls.dDown && !controls.aDown) target_X = -max_speed;

//        if (controls.wDown && !controls.sDown) target_Y = max_speed;
//        if (controls.sDown && !controls.wDown) target_Y = -max_speed;

        double maxChange = a * dt;

        double diff_X = target_X - s_x;
//        double diff_Y = target_Y - s_y;

        if (diff_X >  maxChange) diff_X =  maxChange;
        if (diff_X < -maxChange) diff_X = -maxChange;

//        if (diff_Y >  maxChange) diff_Y =  maxChange;
//        if (diff_Y < -maxChange) diff_Y = -maxChange;

        int prevX = this.viewPort.position_x;
        int prevY = this.viewPort.position_y;

        s_x += diff_X;
        int d_x = ((int)(Math.round(s_x * dt)));
        boolean can_move_x = this.resolve.solveX(d_x);
        if(can_move_x) {
            this.viewPort.position_x += (int) (Math.round(s_x * dt));
        }
        else {
            this.viewPort.position_x = prevX;
            s_x = 0;
        }

//        s_y += diff_Y;
        s_y += grav * dt;
        int d_y = ((int)(Math.round(s_y * dt)));
        boolean can_move_y = this.resolve.solveY(d_y);
        if(can_move_y) {
            this.viewPort.position_y += (int) (Math.round(s_y * dt));
        }
        else {
            this.viewPort.position_y = prevY;
            if(s_y < 0){
                on_ground = true;
            }
            s_y = 0;
        }

        if(s_y == 0 && on_ground ){
            jump();
        }
        if(controls.shiftDown && cool_down >= 1){
            dash();
            controls.shiftDown = false;
        }


        s_x *= drag;
        s_y *= drag;
    }
    void jump(){
        if(controls.spaceDown){
            s_y = 450;
            on_ground = false;
        }
    }
    void dash(){
        if (controls.dDown && !controls.aDown) {
            s_x = -650;
            cool_down = 0;
            return;
        }
        if (controls.aDown && !controls.dDown) {
            s_x = 650;
            cool_down = 0;
            return;
        }
    }




}