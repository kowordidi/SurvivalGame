import greenfoot.*;
public class Händler extends Interagierbares
{
    String item;
    int value;
    String image;
    private int animationPhase = 1;
    private int animationTimer = 20;
    public Händler(String img, String item, int value){
        //ticksForInRow = 50; if i want to customize for different classes
        this.item = item;
        this.value = value;
        this.image = img;
    }
    
    public void act() 
    {
        super.act();
        animation();
        setImage(image + " " + animationPhase + ".png");
        if(isNear() && Greenfoot.isKeyDown("e"))
            buyItem();
    }
    void buyItem(){
        if(((MyWorld)getWorld()).getPlayer().getItem(item) > 0){
            ((MyWorld)getWorld()).getPlayer().setItem(item, (value * -1));
            ((MyWorld)getWorld()).getPlayer().setItem("gold", value);
            Greenfoot.playSound("gold_get.wav");
            showMessage("sold for " + value + " gold!");
        }
        else
            Greenfoot.playSound("no.wav");
        while(Greenfoot.isKeyDown("e")){
                //wait for key release
        }
    }
    private void animation(){
            if(animationTimer < 60)
                animationTimer++;
            else
                animationTimer = 20;
            animationPhase = animationTimer/20;
    }
}
