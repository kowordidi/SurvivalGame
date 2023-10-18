import greenfoot.*;
import java.util.*;


public class Interagierbares extends Actor
{
    //------------------------------------
    private int actsSincePrevEvent = 0;   // derived class "events" are like appleTree picking apple
    private int EventsInRow = 0;          // 2 events are considered "in a row" if the second one happens within "actsForInRow" of the first
    protected int actsForInRow = 200;
    //-----------------------------------
    
    public Interagierbares(String image){
        //
    }
    public Interagierbares()
    {
        //
    }
    public void act() 
    {
        actsSincePrevEvent++;
    }
    Boolean isNear(){
        // Pythagoras, gibt Abstand zwischen Spieler und Interagierbarem wider
        if(Math.sqrt(Math.pow( getX() - ((MyWorld) getWorld()).getPlayer().getX(), 2) + Math.pow( getY() - ((MyWorld) getWorld()).getPlayer().getY() , 2)) < 110)
            return true;
        else
            return false;
    }
    public void showMessage(String message){
        if( (actsSincePrevEvent == 0) || (actsSincePrevEvent > actsForInRow))
                EventsInRow = 1;
         else                    
                EventsInRow++;            
        actsSincePrevEvent = 0;
        
        String Message = (EventsInRow >1)? (message + "(x" + EventsInRow + ")"  ) : message; 
        ((MyWorld)getWorld()).addMessage(Message);
    }
}







