import java.applet.*;
import java.awt.*;

//<applet code="Alpha.class" width="400" height="400"></applet>
public class Alpha extends Applet implements Runnable {
    Thread t=new Thread(this);
    boolean b=true;
    Player p;
    Enemy e1,e2,e3,e4,e5,e6,e7,e8;
    Target tg;
    int life,points;
    Image dbImage;
    Graphics dbGraphics;
    public void init(){
        setSize(400,400);
        p=new Player(this);
        e1=new Enemy(190,35,5,"horizontal",this);
        e2=new Enemy(190,345,-5,"horizontal",this);
        e3=new Enemy(35,190,5,"vertical",this);
        e4=new Enemy(345,190,-5,"vertical",this);
        e5=new Enemy(190,100,-10,"horizontal",this);
        e6=new Enemy(190,280,10,"horizontal",this);
        e7=new Enemy(100,190,-10,"vertical",this);
        e8=new Enemy(280,190,10,"vertical",this);
        tg=new Target();
    }
    public void start(){
        t.start();
    }
    public void destroy(){
        b=false;
    }
    public void run(){
        while(b){
            p.update(this);
            e1.update(this,p);
            e2.update(this,p);
            e3.update(this,p);
            e4.update(this,p);
            e5.update(this,p);
            e6.update(this,p);
            e7.update(this,p);
            e8.update(this,p);
            tg.update(this,p);
            life=Enemy.getLife();
            points=Target.getPoints();
            repaint();
            try{
                t.sleep(20);
            }
            catch(Exception e){
                //Do nothing...
            }
        }
    }
    public void update(Graphics g){
        dbImage=createImage(400,400);
        dbGraphics=dbImage.getGraphics();
        paint(dbGraphics);
        g.drawImage(dbImage,0,0,this);
        if(life==0){
            String pts="Points : "+String.valueOf(points);
            g.setColor(Color.WHITE);
            g.fillRect(125,125,150,150);
            g.setColor(Color.BLACK);
            g.drawString("GAME OVER !!!",150,185);
            g.drawString(pts,150,200);
            b=false;
        }
    }
    public void paint(Graphics g){
        String lf="Life : "+String.valueOf(life);
        String pts="Points : "+String.valueOf(points);
        g.drawRect(0,0,400,400);
        g.drawString(lf,20,20);
        g.drawString(pts,340,20);
        p.paint(g,this);
        e1.paint(g,this);
        e2.paint(g,this);
        e3.paint(g,this);
        e4.paint(g,this);
        e5.paint(g,this);
        e6.paint(g,this);
        e7.paint(g,this);
        e8.paint(g,this);
        tg.paint(g,this);
    }
}
