import java.awt.*;
import java.awt.event.*;
import java.net.URL;

class Player implements KeyListener{
    private int x=200,y=200,dirx=0,diry=0;
	private URL url;
	private Image img;
    public void update(Alpha a){
        x+=dirx;
        y+=diry;
        if(x<=0)
            x=0;
        if(x>=400-20)
            x=400-20;
        if(y<=0)
            y=0;
        if(y>=400-20)
            y=400-20;
        a.addKeyListener(this);
    }
	public Player(Alpha a){
		url=a.getDocumentBase();
		img=a.getImage(url,"player.JPG");
	}
    public void paint(Graphics g,Alpha a){
        g.drawImage(img,x,y,a);
    }
    @Override
    public void keyPressed(KeyEvent k){
        switch(k.getKeyCode()){
            case KeyEvent.VK_W: diry=-5;
            break;
            case KeyEvent.VK_S: diry=5;
            break;
            case KeyEvent.VK_D: dirx=5;
            break;
            case KeyEvent.VK_A: dirx=-5;
            break;
        }
    }
    @Override
    public void keyReleased(KeyEvent k){
        switch(k.getKeyCode()){
            case KeyEvent.VK_W: diry=0;
            break;
            case KeyEvent.VK_S: diry=0;
            break;
            case KeyEvent.VK_D: dirx=0;
            break;
            case KeyEvent.VK_A: dirx=0;
            break;
        }
    }
    @Override
    public void keyTyped(KeyEvent l){}
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    void restart() {
        x=200;
        y=200;
        dirx=0;
        diry=0;
    }
}

