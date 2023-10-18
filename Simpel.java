import greenfoot.*;
public class Simpel extends Interagierbares
{
    String animation;
    String image;
    Boolean isActive;
    private int animationPhase = 1;
    private int animationTimer = 10;
    
    public Simpel(String img){
        this.image = img;
        isActive = false;
    }
    public void act()
    {
        animation();
        interact();
        setImage(image + " " + animationPhase + ".png");
    }
    
    private void interact(){
        if(isNear() && Greenfoot.isKeyDown("e")){
            if(isActive)
                isActive = false;
            else
                isActive = true;
        }
        while(Greenfoot.isKeyDown("e")){
                    //wait for key release
        }
    }
    private void animation(){
        if(isActive){
            
            if(animationTimer < 50)
                animationTimer++;
            else
                animationTimer = 20;
            animationPhase = animationTimer/10 -1;
        }
        else
            animationPhase = 0;
    }
}