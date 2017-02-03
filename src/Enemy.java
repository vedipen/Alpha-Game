import java.awt.*;
import java.net.URL;

class Enemy {
    private int x,y,speed;
    private String type;
    private static int life=10;
	private URL url;
	private Image img;
    public void update(Alpha a,Player p){
        if(type.equalsIgnoreCase("horizontal")){
            x+=speed;
            if(x<=0||x>=400-20){
                speed=(-1)*speed;
            }
        }
        if(type.equalsIgnoreCase("vertical")){
            y+=speed;
            if(y<=0||y>=400-20){
                speed=(-1)*speed;
            }
        }
        Collision(p);
    }
    public Enemy(int i,int j,int s,String t,Alpha a){
        x=i;
        y=j;
        speed=s;
        type=t;
		url=a.getDocumentBase();
		img=a.getImage(url,"enemy.JPG");
    }
    public void paint(Graphics g,Alpha a){
        g.drawImage(img,x,y,a);
    }
    private void Collision(Player p) {
        int px,py;
        px=p.getX();
        py=p.getY();
        if(px+20>=x&&px<=x+20&&py+20>=y&&py<=y+20){
            life-=1;
            p.restart();
        }
    }
    public static int getLife(){
        return life;
    }
}