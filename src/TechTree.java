import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;


public class TechTree extends Main{
    private static JButton mainMenu;
    private static String rusTanks[] = {"BT-2","A-20","SU-76","SU-85","KV-1"};
    private static String britTanks[] = {"Cruiser MK1","Cruiser MK3","Matilda","Grant","Churhchill 1"};
    private static String germTanks[] = {"LTraktor","PZ-1c","Luchs","Stug IV","PZ IV Ausf H."};
    private static String usaTanks[] = {"M2 Light","M3 Stuart","Chaffee","Hellcat","M4 Sherman"};
    private static int mX, mY;
    private static JPanel techpanel = new JPanel(){
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.clearRect(0, 0, 750, 520);
            g.setColor(Color.black);
            g.fillRect(0, 0, techpanel.getWidth(), techpanel.getHeight());
            g.setColor(Color.white);
            g.drawString("USSR Tanks:", 17, 50);
            g.drawString("British Tanks:", 17, 170);
            g.drawString("German Tanks:", 17, 290);
            g.drawString("American Tanks:", 17, 410);
            for(int x=0; x<5;x++){
                g.drawString("Tier "+(x+1),(x*130)+140, 30);
                
            }
            
            drawBoxes(g);
            drawtechtreeTanks(g);
            repaint();
        }
    };
    
    public static void init(){
        techpanel.setBounds(25,40,750,520);
        techpanel.setVisible(false);
        frame.add(techpanel);
        mainMenu = new JButton();
        mainMenu.setBounds(25,5,btnW,btnH);
        mainMenu.setText("Back");
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.show();
                hide();
            }
        });
        techpanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mX=e.getX();
                mY=e.getY();
                System.out.println("X: "+mX + " Y: "+ mY);
            }
        });
            techpanel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                mouseDown=true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                mouseDown=false;
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        mainMenu.setVisible(false);
        frame.add(mainMenu);
    }
    public static void show(){
        lblmoney.setVisible(true);
        lblmoney.setBounds(200, 5, 150, 30);
        techpanel.setVisible(true);
        mainMenu.setVisible(true);
        
    }
    public static void hide(){
        mainMenu.setVisible(false);
        techpanel.setVisible(false);
        lblmoney.setBounds(25, 5, btnW, btnH);
        
    }
    private static void drawBoxes(Graphics g){
       
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                g.setColor(Color.white);
                g.fillRect(110+(130*i), 40+(120*j), 100, 100);
                g.setColor(Color.black);
                g.drawString(rusTanks[i], (i*133)+140, 135);
                g.drawString(britTanks[i], (i*133)+130, 250);
                g.drawString(germTanks[i], (i*132)+125, 373);
                g.drawString(usaTanks[i], (i*133)+125, 490);
            }
        }
    }
    public static void drawtechtreeTanks(Graphics g){
        g.drawImage(ltraktor.getImage(), 110, 300, null);
        g.drawImage(pz1c.getImage(), 240, 315, null);
        g.drawImage(luchs.getImage(), 370, 300, null);
        g.drawImage(stug4.getImage(), 500, 317, null);
        g.drawImage(pz4h.getImage(), 630, 300, null);
        
        g.drawImage(bt2.getImage(), 110, 70, null);
        g.drawImage(a20.getImage(), 240, 70, null);
        g.drawImage(su76.getImage(), 370, 70, null);
        g.drawImage(su85.getImage(), 500, 77, null);
        g.drawImage(kv1.getImage(), 630, 70, null);
        
        g.drawImage(m2light.getImage(), 110, 420, null);
        g.drawImage(m3stu.getImage(), 240, 420, null);
        g.drawImage(chaffee.getImage(), 370, 420, null);
        g.drawImage(hellcat.getImage(), 500, 420, null);
        g.drawImage(m4sherm.getImage(), 630, 420, null);
        
        g.drawImage(cruis1.getImage(), 110, 185, null);
        g.drawImage(cruis3.getImage(), 240, 185, null);
        g.drawImage(matilda.getImage(), 370, 185, null);
        g.drawImage(grant.getImage(), 500, 185, null);
        g.drawImage(church1.getImage(), 630, 185, null);
        
            if(mX>110 && mX<ltraktor.getIconWidth()+110 && mY>300 && mY<ltraktor.getIconHeight()+300){
                if(mouseDown==true){
                    for (int i = 0; i <tankSlot.length; i++) {
                        if(tankSlot[i]=="LTraktor"){
                            g.setColor(Color.red);
                            g.drawString("You already have this Tank!", 10, 15);
                        }
                        else{
                            
                        }
                    }
                }
            }
            else if(mX>240&& mX<pz1c.getIconWidth()+240 && mY>315 && mY<pz1c.getIconHeight()+315){
                if(mouseDown==true){
                    for (int i = 0; i <tankSlot.length; i++) {
                        if(tankSlot[i]=="PZ 1c"){
                            g.setColor(Color.red);
                            g.drawString("You already have this Tank!", 10, 10); 
                        }
                        else {
                            g.setColor(Color.red);
                            g.drawString("Tank Bought!", 10, 15); 
                            money-=500;
                            for (int j = 0; j < 6; j++) {
                                if(TSlotFull[j]==true){
                                    
                                }
                                else{
                                    tankSlot[j]="PZ 1c";
                                    tankslot[j]= new ImageIcon(Main.class.getResource("/pz 1 c.png"));
                                }
                            }
                        }
                    }
                }
            }
            else if(mX>370&& mX<luchs.getIconWidth()+370 && mY>300 && mY<luchs.getIconHeight()+300){
                if(mouseDown==true){
                    for (int i = 0; i <tankSlot.length; i++) {
                        if(tankSlot[i]=="Luchs"){
                            g.setColor(Color.red);
                            g.drawString("You already have this Tank!", 10, 10); 
                        }
                        else {
                            g.setColor(Color.red);
                            g.drawString("You don't have this tank!", 10, 15); 
                        }
                    }
                }
            }
            else if(mX>500&& mX<stug4.getIconWidth()+500 && mY>317 && mY<stug4.getIconHeight()+317){
                if(mouseDown==true){
                    for (int i = 0; i <tankSlot.length; i++) {
                        if(tankSlot[i]=="Stug IV"){
                            g.setColor(Color.red);
                            g.drawString("You already have this Tank!", 10, 10); 
                        }
                        else {
                            g.setColor(Color.red);
                            g.drawString("You don't have this tank!", 10, 15); 
                        }
                    }
                }
            }
            else if(mX>630&& mX<pz4h.getIconWidth()+630 && mY>300 && mY<pz4h.getIconHeight()+300){
                if(mouseDown==true){
                    for (int i = 0; i <tankSlot.length; i++) {
                        if(tankSlot[i]=="PZ IV Ausf H."){
                            g.setColor(Color.red);
                            g.drawString("You already have this Tank!", 10, 10); 
                        }
                        else {
                            g.setColor(Color.red);
                            g.drawString("You don't have this tank!", 10, 15); 
                        }
                    }
                }
            }
        }
}

