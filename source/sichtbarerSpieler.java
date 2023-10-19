import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class sichtbarerSpieler extends Actor
{
    private int animationTimer;
    private int animationPhase = 1;
    private Boolean isMoving;
    private String direction = "down";
    private String hood = " hood ";
    public void act() 
    {
        setImage();
        animation();
        setLocation(((MyWorld)getWorld()).getPlayer().getX(),((MyWorld)getWorld()).getPlayer().getY() - 14);
    }
    public void setImage()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            direction = "right";
            isMoving = true;
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            direction = "left";
            isMoving = true;
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            direction = "up";
            isMoving = true;
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            direction = "down";
            isMoving = true;
        }
        else
            isMoving = false;
        if( ((MyWorld)getWorld()).isInside )
            hood = " ";
        else
            hood = " hood ";
            
        
        setImage("player " + direction + hood + animationPhase + ".png");
    }
    private void animation(){
        if(isMoving){
            animationTimer++;
            if(animationTimer < 30){
                if(animationTimer < 10)
                    animationPhase = 3;
                else if(animationTimer < 20)
                    animationPhase = 2;
                else
                    animationPhase = 1;
            }
            else
                animationTimer = 0;
        }
        else
            animationPhase = 1;
    }
}
