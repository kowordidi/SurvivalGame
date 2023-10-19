import greenfoot.*;
import java.lang.Math.*;
import java.util.ArrayList;
public class MyWorld extends World
{
    public int worldX;
    public int worldY;
    public ArrayList<Actor> actorsOnMap = new ArrayList<Actor>();
    public Boolean isInside = true;
    Boolean isNorthGateOpen = false;
     
  
    //---------------------------------------------------
    private final int showMessageTimeMax = 200;
    private int       showMessageTimeCurrent = 0;
    void incMessageTimeCurrent(){showMessageTimeCurrent++;}
    void initMessageTimeCurrent(){ showMessageTimeCurrent = 0;};
    boolean messageTimeElapsed() {return showMessageTimeCurrent >= showMessageTimeMax;} 
    //----------------------------------------------------        
    String MyMessage = "";
    
  
    Player hitbox = new Player();
    sichtbarerSpieler spieler = new sichtbarerSpieler();
    
    //---------------------------------------------------
    Objekt baum1 = new Objekt("tree 1.png");
    Objekt baum2 = new Objekt("tree 1.png");
    Objekt baum3 = new Objekt("tree 1.png");
    Objekt baum4 = new Objekt("tree 1.png");
    Objekt baum5 = new Objekt("tree 1.png");
    
    Objekt baum6 = new Objekt("tree 2.png");
    Objekt baum7 = new Objekt("tree 2.png");
    Objekt baum8 = new Objekt("tree 2.png");
    Objekt baum9 = new Objekt("tree 2.png");
    Objekt baum10 = new Objekt("tree 2.png");
    
    Objekt baum11 = new Objekt("tree 3.png");
    Objekt baum12 = new Objekt("tree 3.png");
    Objekt baum13 = new Objekt("tree 3.png");
    Objekt baum14 = new Objekt("tree 3.png");
    Objekt baum15 = new Objekt("tree 3.png");
    
    Objekt baum16 = new Objekt("tree 4.png");
    Objekt baum17 = new Objekt("tree 4.png");
    Objekt baum18 = new Objekt("tree 4.png");
    Objekt baum19 = new Objekt("tree 4.png");
    Objekt baum20 = new Objekt("tree 4.png");
    
    Objekt baum21 = new Objekt("tree small.png");
    Objekt baum22 = new Objekt("tree small.png");
    Objekt baum23 = new Objekt("tree small.png");
    
    Objekt baumreihe1 = new Objekt("tree row 1.png");
    Objekt baumreihe2 = new Objekt("tree row 2.png");
    Objekt baumreihe3 = new Objekt("tree row 3.png");
    Objekt baumreihe4 = new Objekt("tree row 4.png");
    
    Objekt stein1 = new Objekt("rock 1.png");
    Objekt stein2 = new Objekt("rock 2.png");
    Objekt stein3 = new Objekt("rock 3.png");
    Objekt stein4 = new Objekt("rock 4.png");
    Objekt stein5 = new Objekt("rock 5.png");
    Objekt stein6 = new Objekt("rock 6.png");
    Objekt stein7 = new Objekt("rock 7.png");
    
    Objekt stumpf1 = new Objekt("tree stump 1.png");
    Objekt stumpf2 = new Objekt("tree stump 2.png");
    Simpel lagerfeuer1 = new Simpel("fire");
    Simpel lagerfeuer2 = new Simpel("fire");
    
    Objekt schrank1 = new Objekt("cupboard.png");
    Objekt schrank2 = new Objekt("small cupboard apples.png");
    Objekt schrank3 = new Objekt("cupboard fruit.png");
    Simpel kamin = new Simpel("stove");
    Objekt hocker1 = new Objekt("stool.png");
    Objekt vase1 = new Objekt("vase 1.png");
    Objekt vase2 = new Objekt("vase 2.png");
    Objekt vase3 = new Objekt("vase 3.png");
    Objekt feuerholz = new Objekt("firewood.png");
    Objekt bett = new Objekt("bed.png");
    Objekt couch = new Objekt("couch.png");
    
    Objekt long_horizontal_wall1 = new Objekt("long horizontal wall.png");
    Objekt long_horizontal_wall2 = new Objekt("long horizontal wall.png");
    Objekt long_vertical_wall1 = new Objekt("long vertical wall.png");
    Objekt long_vertical_wall2 = new Objekt("long vertical wall.png");
    
    Objekt short_horizontal_wall1 = new Objekt("short horizontal wall.png");
    Objekt short_horizontal_wall2 = new Objekt("short horizontal wall.png");
    Objekt short_vertical_wall1 = new Objekt("short vertical wall.png");
    Objekt short_vertical_wall2 = new Objekt("short vertical wall.png");
    //---------------------------------------------------
    Interagierbares haus1 = new Tür( "house 5 green.png", 100, 100, 400, 520);
    Interagierbares tür1 = new Tür( "door.png", 0, 0, 230, 590);
    
    Interagierbares haus2 = new Tür( "house 7 green.png", 101, 100, 400, 500);
    Interagierbares tür2 = new Tür( "door.png", 0, 0, 640, 460);
    
    Interagierbares apfelbaum1 = new Apfelbaum();
    Interagierbares apfelbaum2 = new Apfelbaum();
    Interagierbares apfelbaum3 = new Apfelbaum();
    Interagierbares apfelbaum4 = new Apfelbaum();
    Interagierbares apfelbaum5 = new Apfelbaum();
    
    Interagierbares händler1 = new Händler("npc", "apples", 1);
    Interagierbares nordwache = new Wächter("north");
    Interagierbares vertical_gate = new Tor();
    //---------------------------------------------------
    public MyWorld()
    {    
        super(800, 800, 1);
        prepare();
        setPaintOrder(sichtbarerSpieler.class);
    }
    
    private void prepare()
    {
        placeActors();
        worldX = 101;
        worldY = 100;
        setBackground();
        addObject(hitbox,311, 390);
        addObject(spieler,311, 376);
        getPlayer().apples = 0;
        getPlayer().gold = 0;
    } 
    public void konsole()
    {
        incMessageTimeCurrent();
        if(messageTimeElapsed())
            MyMessage = "";
        showText(MyMessage  , 400, 750);
    }
    public void addMessage(String newMessage)
    {
        MyMessage =  newMessage; 
        initMessageTimeCurrent();
              
    }
    public void setBackground(){
        setBackground( "(" + worldX + "." + worldY + ").png" );
        removeActors();
        placeActors();
    }
    public void changeWorldPos(int X, int Y){
        this.worldX = worldX + X;
        this.worldY = worldY + Y;
    }
    public void setWorldPos(int X, int Y){
        this.worldX = X;
        this.worldY = Y;
    }
    int getWorldX(){
        return worldX;
    }
    int getWorldY(){
        return worldY;
    }
    void placeActors(){
        if(worldX == 0 && worldY == 0){
            addActor(baum6, 280, 200);
            addActor(baum7, 670, 560);
            addActor(haus1, 230, 500);
            addActor(haus2, 640, 350);
            addActor(stein1, 500, 300);
            addActor(lagerfeuer1, 200, 700);
            addActor(stumpf1, 150, 700);
            addActor(stumpf2, 250, 700);
        }
        
        if(worldX == 1 && worldY == 0){
            addActor(baum1, 600, 700);
            addActor(baum6, 530, 320);
            addActor(baum7, 600, 280);
            addActor(baum11, 660, 120);
            
            addActor(baum21, 700, 500);
            addActor(baum22, 200, 240);
            
            addActor(apfelbaum1, 400, 400);
            addActor(apfelbaum2, 475, 200);
            
            addActor(long_vertical_wall1, 800, 400); //wall right
        }
        
        if(worldX == 1 && worldY == 1){
            addActor(baum16, 480, 380);
            addActor(baum17, 230, 120);
            addActor(baum18, 610, 295);
            addActor(baumreihe4, 470, 145);
            
            addActor(baum11, 647, 410);
            addActor(baum12, 700, 480);
            addActor(baumreihe3, 190, 236);
            
            addActor(baum6, 148, 610);
            addActor(baum7, 346, 480);
            addActor(baum8, 570, 622);
            
            addActor(stein2, 500, 500);
            addActor(stein4, 456, 612);
            
            addActor(stumpf2, 174, 430);
            
            addActor(long_vertical_wall1, 800, 400); //wall right
            addActor(long_horizontal_wall1, 400, 0); //wall up
        }
        
        if(worldX == 0 && worldY == 1){
            addActor(nordwache, 350, 70);
            
            addActor(baum16, 655, 180);
            addActor(baum17, 200, 130);
            addActor(baum18, 640, 465);
            
            addActor(baum11, 547, 300);
            addActor(baum12, 700, 480);
            
            addActor(short_horizontal_wall1, 150, 0);//wall up
            addActor(short_horizontal_wall2, 650, 0);//wall up
            if(!isNorthGateOpen)
                addActor(vertical_gate, 400, 0);//gate up            
        }
        
        if(worldX == -1 && worldY == 1){
            addActor(stumpf1, 290, 440);
            addActor(lagerfeuer2, 340, 440);
            addActor(stumpf2, 390, 440);
            
            addActor(baumreihe4, 160, 200);
            addActor(baumreihe3, 300, 300);
            addActor(baum16, 600, 210);
            
            addActor(stein3, 240,650);
            
            addActor(long_vertical_wall1, 0, 400);
            addActor(long_horizontal_wall1, 400, 0);//north gate
        }
        
        if(worldX == -1 && worldY == 0){
            addActor(baum1, 330, 550);
            addActor(baumreihe2, 170, 270);
            
            addActor(long_vertical_wall1, 0, 400);//wall left
        }
        
        if(worldX == -1 && worldY == -1){
            addActor(baum1, 270, 400);
            addActor(baum21, 470, 480);
            addActor(baum22, 350, 600);
            addActor(baum23, 670, 550);
            addActor(apfelbaum3, 100, 650);
            
            addActor(long_vertical_wall1, 0, 400);//wall left
            addActor(long_horizontal_wall1, 400, 800);//wall down
         
        }
        
        if(worldX == 0 && worldY == -1){
            addActor(baum6, 600, 400);
            addActor(baum7, 520, 200);
            addActor(baum2, 350, 430);
            addActor(baum21, 350, 650);
            addActor(baumreihe1, 190, 510);
            addActor(stumpf1, 132, 220);
            addActor(stumpf1, 132, 220);
            addActor(stein4, 621, 458);
            addActor(stein2, 610, 548);
            
            addActor(long_horizontal_wall1, 400, 800);//wall down
        }
        
        if(worldX == 1 && worldY == -1){
            addActor(baum1, 300, 460);
            addActor(baum21, 540, 160);
            
            addActor(stein2, 200, 613);
            addActor(stein3, 395, 587);
            addActor(stein4, 400, 400);
            addActor(stein5, 580, 500);
            addActor(stein6, 520, 610);
            addActor(stein7, 700, 700);
            addActor(stein1, 370, 632);
            
            addActor(long_vertical_wall1, 800, 400);//wall right
            addActor(long_horizontal_wall1, 400, 800);//wall down
        }
        
        if(worldX == 0 && worldY == 2){
            addActor(long_vertical_wall1, 800, 400);//wall right
            addActor(long_vertical_wall2, 0, 400);//wall left
            addActor(long_horizontal_wall1, 400, 0);//wall up
            
            addActor(short_horizontal_wall1, 150, 800);//wall down
            addActor(short_horizontal_wall2, 650, 800);//wall down
        }
    
        if(worldX == 100 && worldY == 100){ //haus1
            addActor(long_vertical_wall1, 200, 400);//wall left
            addActor(long_vertical_wall2, 600, 400);//wall right
            addActor(long_horizontal_wall1, 400, 270);//wall up
            addActor(long_horizontal_wall2, 400, 570);//wall down
            
            addActor(tür1, 400, 570);
            addActor(couch, 550, 340);
            addActor(händler1, 270, 330);
            addActor(schrank2, 233, 310);
            addActor(schrank3, 320, 310);
            addActor(vase1, 500, 510);
            addActor(vase2, 530, 520);
            addActor(vase3, 560, 490);
        }
        
        if(worldX == 101 && worldY == 100){ //haus2
            addActor(long_vertical_wall1, 250, 400);//wall left
            addActor(long_vertical_wall2, 550, 400);//wall right
            addActor(long_horizontal_wall1, 400, 250);//wall up
            addActor(long_horizontal_wall2, 400, 550);//wall down
            
            addActor(bett, 285, 380);
            addActor(tür2, 400, 550);
            addActor(schrank1, 330, 270);
            addActor(hocker1, 500, 380);
            addActor(kamin, 480, 250);
            addActor(feuerholz, 410, 275);
        }
    }
    
    void addActor(Actor name, int X, int Y){
        addObject(name,  X, Y);
        actorsOnMap.add(name);
    }
    
    void removeActors(){
        for(int i = 0; i < actorsOnMap.size(); i++)
            removeObject(actorsOnMap.get(i));
        actorsOnMap.clear();
    }
    
    Player getPlayer(){
        return hitbox;
    }
    
    Interagierbares getTor(){
        return vertical_gate;
    }
    
    void setIsInside(Boolean b){
        isInside = b;
    }
    
    Boolean getIsNorthGateOpen(){
        return isNorthGateOpen;
    }
    
    void openNorthGate(){
        isNorthGateOpen = true;
    }
}
