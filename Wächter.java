import greenfoot.*;


public class Wächter extends Interagierbares
{
    String name;
    Boolean hasTalked;
    private int animationPhase = 1;
    private int animationTimer = 20;
    public Wächter(String name){
        this.name = name;
        hasTalked = false;
    }
    
    public void act()
    {
        super.act();
        animation();
        setImage("guard " + animationPhase + ".png");
        if(isNear() && Greenfoot.isKeyDown("e")){
            Greenfoot.playSound("mutter.wav");
            if(!hasTalked)
                talk();
            else if( ((MyWorld)getWorld()).getPlayer().getItem("gold") >= 20 && !((MyWorld)getWorld()).getIsNorthGateOpen())
            {
                ((MyWorld)getWorld()).getPlayer().setItem("gold", -20);
                ((MyWorld)getWorld()).openNorthGate();
                ((MyWorld)getWorld()).setBackground();
            }
            while(Greenfoot.isKeyDown("e")){
                //wait for key release
            }
        }
    }
    public void talk(){
        if(name == "north"){
            showMessage("I'll let you pass for 20 gold!");
            hasTalked = true;
        }
    }
    private void animation(){
            if(animationTimer < 60)
                animationTimer++;
            else
                animationTimer = 10;
            animationPhase = animationTimer/10;
    }
}
