import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tür extends Interagierbares
{
    int WorldX;
    int WorldY;
    int PlayerX;
    int PlayerY;
    
    public void act() 
    {
        if(isNear() && Greenfoot.isKeyDown("e")){
            Greenfoot.playSound("door.wav");
            ((MyWorld)getWorld()).setWorldPos(WorldX, WorldY);
            ((MyWorld)getWorld()).getPlayer().setLocation(PlayerX,PlayerY);
            if(((MyWorld)getWorld()).isInside)
                 ((MyWorld)getWorld()).setIsInside(false);
            else
                ((MyWorld)getWorld()).setIsInside(true);
            while(Greenfoot.isKeyDown("e")){
                //wait for key release
            }
        }
    }
    
    public Tür(String image, int X, int Y, int x, int y){
        WorldX = X;
        WorldY = Y;
        PlayerX = x;
        PlayerY = y;
        setImage(image);
    }
}
