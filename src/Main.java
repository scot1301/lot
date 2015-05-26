import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Main {

    public static JFrame frame = new JFrame("Land of Tanks Menu");
    public static JButton btn[] = new JButton[2];
    public static JLabel lblmoney;
    public static String selTank="None";
    //russin tank images
    public static ImageIcon bt2, a20, su76, su85, kv1;
    //british tank images
    public static ImageIcon cruis1, cruis3, matilda, grant, church1;
    //american tank images
    public static ImageIcon m2light, m3stu, chaffee, hellcat, m4sherm;
    //german tank images
    public static ImageIcon ltraktor, pz1c, luchs, stug4, pz4h;
    public static ImageIcon tiger, ltlarge, tiglarge;
    
    
    //work on this
    public static ImageIcon tankslot[] = new ImageIcon[6];
    public static String tankSlot[] = new String[6];
    
    
    public static boolean TSlotFull[] = new boolean[6];
    public static Integer screen=0;
    public static boolean mouseDown;
    public static int mX, mY;
    public static JPanel panel = new JPanel(){
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.clearRect(0, 0, 750, 520);
            g.setColor(Color.black);
            g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
            g.setColor(Color.white);
            g.drawString("Current Tank: "+selTank, 25, 30);
            drawTankBoxes(g);
            repaint();
        }
    };
    public static int money=5000;
    public static int mainJW, mainJH;
    public static int btnW=150, btnH=30;
    
    public static void main(String[] args) {
        frame.setSize(800,600);
        mainJW=frame.getWidth();
        mainJH=frame.getHeight();
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mX=e.getX();
                mY=e.getY();
                //System.out.println("X: "+mX + " Y: "+ mY);
            }
        });
        panel.addMouseListener(new MouseListener() {

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
        init();
        TechTree.init();
        frame.setVisible(true);
        
    }
    public static void show(){
        panel.setVisible(true);
        for(int i=0;i<btn.length;i++)
        {
            btn[i].setVisible(true);
        }
    }
    public static void init(){
        lblmoney = new JLabel();
        lblmoney.setBounds(25, 5, btnW, btnH);
        lblmoney.setText("Money: "+ money);
        frame.add(lblmoney);
        
        tankslot[0] = new ImageIcon(Main.class.getResource("/LTraktor.png"));
        tankslot[1] = new ImageIcon(Main.class.getResource("/tiger.png"));
        tankslot[2] = new ImageIcon(Main.class.getResource("/empty.png"));
        tankslot[3] = new ImageIcon(Main.class.getResource("/empty.png"));
        tankslot[4] = new ImageIcon(Main.class.getResource("/empty.png"));
        tankslot[5] = new ImageIcon(Main.class.getResource("/empty.png"));
        
        ltraktor = new ImageIcon(Main.class.getResource("/LTraktor.png"));
        pz1c = new ImageIcon(Main.class.getResource("/pz 1 c.png"));
        luchs = new ImageIcon(Main.class.getResource("/luchs.png"));
        stug4 = new ImageIcon(Main.class.getResource("/stug-iv.png"));
        pz4h = new ImageIcon(Main.class.getResource("/pzivausfh.png"));
        
        bt2 = new ImageIcon(Main.class.getResource("/bt2.png"));
        a20 = new ImageIcon(Main.class.getResource("/a20.png"));
        su76 = new ImageIcon(Main.class.getResource("/su 76.png"));
        su85 = new ImageIcon(Main.class.getResource("/su85-10.png"));
        kv1 = new ImageIcon(Main.class.getResource("/kv-1.png"));
        
        cruis1 = new ImageIcon(Main.class.getResource("/cruiser mk1.png"));
        cruis3 = new ImageIcon(Main.class.getResource("/cruiser mk3.png"));
        matilda = new ImageIcon(Main.class.getResource("/matilda.png"));
        grant = new ImageIcon(Main.class.getResource("/grant.png"));
        church1 = new ImageIcon(Main.class.getResource("/churchill1.png"));
        
        m2light = new ImageIcon(Main.class.getResource("/m2 light.png"));
        m3stu = new ImageIcon(Main.class.getResource("/m3 stuart.png"));
        chaffee = new ImageIcon(Main.class.getResource("/chaffee.png"));
        hellcat = new ImageIcon(Main.class.getResource("/hellcat.png"));
        m4sherm = new ImageIcon(Main.class.getResource("/m4 sherman.png"));
        
        tiger = new ImageIcon(Main.class.getResource("/tiger.png"));
        tiglarge = new ImageIcon(Main.class.getResource("/tigerlarge.png"));
        ltlarge = new ImageIcon(Main.class.getResource("/LTraktorlarge.png"));
        
        panel.setBounds(25,40,750,520);
        panel.setVisible(true);
        frame.add(panel);
        
        btn[0] = new JButton();
        btn[0].setText("Play");
        btn[0].setBounds(300,5,btnW,btnH);
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoTGame.show();
                screen =1;
                for(int i=0;i<btn.length;i++)
                {
                    btn[i].setVisible(false);
                    lblmoney.setVisible(false);
                    panel.setVisible(false);
                    
                }
            }
        });
        btn[0].setVisible(true);
        frame.add(btn[0]);
        
        btn[1] = new JButton();
        btn[1].setText("TechTree");
        btn[1].setBounds(475+btnW,5,btnW,btnH);
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TechTree.show();
                screen =2;
                
                for(int i=0;i<btn.length;i++)
                {
                    btn[i].setVisible(false);
                    panel.setVisible(false);
                }
                
            }
        });
        btn[1].setVisible(true);
        frame.add(btn[1]);
    }
    private static void drawTankBoxes(Graphics g){
        //checks to see what tank is selected
        if(mX>18&& mX<tankslot[0].getIconWidth()+18&&mY>420 && mY<tankslot[0].getIconHeight()+420){
            tankSlot[0] = "LTraktor";
            TSlotFull[0]=true;
            if(mouseDown==true){
                selTank=tankSlot[0];
            }
        }
        else if(mX>140&& mX<tankslot[1].getIconWidth()+140&&mY>430 && mY<tankslot[1].getIconHeight()+430){
            TSlotFull[1]=true;
            tankSlot[1]="Tiger";
            if(mouseDown==true){
                selTank=tankSlot[1];
            }
        }
//        else if(mX>265&& mX<tankslot[2].getIconWidth()+265&&mY>430 && mY<tankslot[12].getIconHeight()+430){
//            TSlotFull[2]=true;
//            tankSlot[2]=tankSlot[2];
//            if(mouseDown==true){
//                selTank=tankSlot[1];
//            }
//        }
//        else if(mX>140&& mX<tankslot[3].getIconWidth()+140&&mY>430 && mY<tankslot[3].getIconHeight()+430){
//            TSlotFull[3]=true;
//            tankSlot[3]="Tiger";
//            if(mouseDown==true){
//                selTank=tankSlot[1];
//            }
//        }
//        else if(mX>140&& mX<tankslot[4].getIconWidth()+140&&mY>430 && mY<tankslot[4].getIconHeight()+430){
//            TSlotFull[4]=true;
//            tankSlot[4]="Tiger";
//            if(mouseDown==true){
//                selTank=tankSlot[1];
//            }
//        }
        
        //draws white boxes for tanks in garage
        for (int i = 0; i < 6; i++) {
                g.setColor(Color.white);
                g.fillRect(17+(123*i),400,100,100);
        }
        //draws tanks into the garage
        
        //sets tank display to current tank
        if(selTank.equals("LTraktor")){
            g.drawImage(ltlarge.getImage(), 18, 100, null);
            g.setColor(Color.yellow);
            g.fillRect(17,400,100,100);
        }
        else if(selTank.equals("Tiger")){
            g.drawImage(tiglarge.getImage(), 18, 100, null);
            g.setColor(Color.yellow);
            g.fillRect(140,400,100,100);
        }
        g.drawImage(tankslot[0].getImage(), 18, 420, null);
        g.drawImage(tankslot[1].getImage(), 140, 430, null);
        g.drawImage(tankslot[2].getImage(), 263, 430, null);
        g.drawImage(tankslot[3].getImage(), 386, 400, null);
        g.drawImage(tankslot[4].getImage(), 509, 400, null);
        g.drawImage(tankslot[5].getImage(), 632, 400, null);
        
        
        //if()
    }
}
