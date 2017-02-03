import java.awt.*;
import java.util.Random;

class Target {
    private int x,y,lx,ly;
    Random rn=new Random();
    int r=0;
    private static int points=0;
    public void update(Alpha a,Player p){
        if(r==0){
            x=180;
            y=0;
            lx=40;
            ly=5;
        }
        if(r==1){
            x=180;
            y=400-5;
            lx=40;
            ly=5;
        }
        if(r==2){
            x=0;
            y=180;
            lx=5;
            ly=40;
        }
        if(r==3){
            x=400-5;
            y=180;
            lx=5;
            ly=40;
        }
        Collision(p);
    }
    
    public void paint(Graphics g,Alpha a){
        g.setColor(Color.GREEN);
        g.fillRect(x,y,lx,ly);
    }

    private void Collision(Player p) {
        int px,py;
        px=p.getX();
        py=p.getY();
        if(px+20>=x&&px<=x+40&&py+20>=y&&py<=y+5){
            r=rn.nextInt(4);
            points++;
        }
        if(px+20>=x&&px<=x+5&&py+20>=y&&py<=y+40){
            r=rn.nextInt(4);
            points++;
        }
    }
    public static int getPoints(){
        return points;
    }
}