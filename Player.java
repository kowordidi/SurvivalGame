import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    int apples;
    int gold;
    int speed = 2;
    public Player(){
        getImage().setTransparency(0);
    }
    public void act() 
    {
        movePlayer();
        checkEdge();
        ((MyWorld)getWorld()).setBackground();
        getWorld().showText("Äpfel: " + apples, 750, 20);
        getWorld().showText("Gold: " + gold, 750, 50);
        
        ((MyWorld)getWorld()).konsole();
    }
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - speed);
            if(isTouching(Objekt.class)|| isTouching(Interagierbares.class))
                setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
            if(isTouching(Objekt.class)|| isTouching(Interagierbares.class))
                setLocation(getX(), getY() - speed);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
            if(isTouching(Objekt.class)|| isTouching(Interagierbares.class))
                setLocation(getX() - speed, getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
            if(isTouching(Objekt.class)|| isTouching(Interagierbares.class))
                setLocation(getX() + speed, getY());
        }
        
    }
    void checkEdge(){
        // check if at edge, if yes change worldX and worldY accordingly
        if(getY() > 790){
            setLocation(getX(), 11);
            ((MyWorld)getWorld()).changeWorldPos(0, -1);
        }
        if(getY() < 10){
            setLocation(getX(), 789);
            ((MyWorld)getWorld()).changeWorldPos(0, 1);
        }
         if(getX() > 790){
            setLocation(11, getY());
            ((MyWorld)getWorld()).changeWorldPos(1, 0);
        }
        if(getX() < 10){
            setLocation(789, getY());
            ((MyWorld)getWorld()).changeWorldPos(-1, 0);
        }
    }
    int getItem(String name){
        if(name.equals("apples"))
            return apples;
        else if(name.equals("gold"))
            return gold;
        else
            return apples;
    }
    void setItem(String name, int change){
        if(name.equals("apples"))
            apples = apples + change;
        else if(name.equals("gold"))
            gold = gold + change;
    }
    
    
    
    
    
    
}
