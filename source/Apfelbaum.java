import greenfoot.*;

public class Apfelbaum extends Interagierbares
{
    private int delayCount = 0;
    private int applesOnTree = 5;
    private int growTimer = 10000;
    
 
    public void act() 
    
    {
        super.act();
        setImage("apple_tree" + applesOnTree + ".png");
        
        if(isNear() && Greenfoot.isKeyDown("e")){
            if(delayCount < 1 && applesOnTree > 0){
                showMessage("Collected an apple!");
                
                Greenfoot.playSound("pop.wav");
                ((MyWorld)getWorld()).getPlayer().apples++;
                applesOnTree--;
                delayCount = 50;
                while(Greenfoot.isKeyDown("e")){
                    //wait for key release
                }
            }
            else
                delayCount--;
        }
        if(growTimer < 1 && applesOnTree < 5){
            growTimer = Greenfoot.getRandomNumber(3000) + 2000;
            applesOnTree++;
        }
        else
            growTimer--;
    }    
}