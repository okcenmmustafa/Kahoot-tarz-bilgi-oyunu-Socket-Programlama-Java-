package Oyun;



import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import baglanti.baglan;
import java.awt.Color;
import java.sql.Array;

public class ClientSoket extends javax.swing.JFrame 
{
    
    String username, address = "localhost";
    ArrayList<String> k = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    ArrayList ServerOutputStreams;
    Socket sock;
    BufferedReader input;
    PrintWriter writer;
    baglan conn= new baglan();
    Connection baglan;
    PrintWriter server;
     Statement myState = null;
         ResultSet soru = null;
    String dogruCevap;
    
        
        
    //--------------------------//
          
           

       
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    //--------------------------//
    
    public void userAdd(String data) 
    {
         k.add(data);
    }
    
    //--------------------------//
    
    public void userRemove(String data) 
    {
         ekran.setText(data + " şu anda çevrimdışı.\n");
         k.remove(data);
    }
    
    //--------------------------//
    
    public void writeUsers() 
    {
         String[] tempList = new String[(k.size())];
         k.toArray(tempList);
         for (String token:tempList) 
         {
             //k.setText(token + "\n");
         }
    }
    
    //--------------------------//
    
    public void sendDisconnect() 
    {
        String kapa = (username + ": :Bağlatısı Kesildi");
        try
        {
            writer.println(kapa); 
            writer.flush(); 
        } catch (Exception e) 
        {
            ekran.setText("Could not send Disconnect message.\n");
        }
    }

    //--------------------------//
    
    public void Disconnect() 
    {
        try 
        {
            ekran.setText("Disconnected.\n");
            sock.close();
            
        } catch(Exception ex) {
            ekran.setText("Failed to disconnect. \n");
        }
        isConnected = false;
        tf_username.setEditable(true);

    }
    
    public ClientSoket() throws ClassNotFoundException 
    {
        this.baglan = conn.baglan();
       
        initComponents();
            ekran.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jButton3.setVisible(false);
            jButton4.setVisible(false);
            jButton5.setVisible(false);
    }
    
    //--------------------------//
    
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
             
            
               
            
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat",basla="basla";
           
            try 
            {
                while ((stream = input.readLine()) != null) 
                {
                     buttonYenile();
                     data = stream.split(":");
                     System.out.println(data[2]);
                     if (data[2].equals(chat)) 
                     {
                        ekran.setText(data[0] + ": " + data[1] + "\n");
                        
                     } 
                     else if (data[2].equals(connect))
                     {
                         
                        ekran.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        k.clear();
                     }
                     else if (data[2].equals(basla)) 
                     {
                         
                        //users.setText("");
                                    switch (data[3]) {
                     case "0" :
                         
                         
                        ekran.setText(data[0]);
                        System.out.println("0 Girdi");
                         break;

                     case "1" :
                         
                         if(Integer.parseInt(data[4])==1){
                             dogruCevap=data[0];
                         }
                         System.out.println(data[0] +data[1]+data[2]+data[3]+data[4]+"DogruCevap:"+dogruCevap);
                         jButton1.setText(data[0]);
                          System.out.println("1 Girdi");
                         break;
                     case "2" :
                         if(Integer.parseInt(data[4])==1){
                             dogruCevap=data[0];
                         }
                        jButton2.setText(data[0]);
                         System.out.println("2 Girdi");
                         break;
                    case "3" :
                        if(Integer.parseInt(data[4])==1){
                             dogruCevap=data[0];
                         }
                       jButton3.setText(data[0]);
                        System.out.println("3 Girdi");
                         break;
                    case "4" :
                        if(Integer.parseInt(data[4])==1){
                             dogruCevap=data[0];
                         }
                         jButton4.setText(data[0]);
                          System.out.println("4 Girdi");
                         break;
                          
                         
                        
                          
                         
                       
                  
                     
                     }
                         if(data[4]=="kazandi"){
                         Kazandiniz kz = new Kazandiniz();
                          kz.setVisible(true);
                          
                                    
                     }
                      
                      
                }
                }
           }catch(Exception ex) { }
        }

        private void setVİsiable(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
   

    //--------------------------//
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_username = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        b_connect = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ekran = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Client's frame");
        setName("client"); // NOI18N
        setResizable(false);

        lb_username.setText("Kullanici Adi");

        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        b_connect.setText("Bağlan");
        b_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        jButton1.setText("Cevap1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cevap2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cevap3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cevap4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Hazir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ekran.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ekran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ekran.setText("Soru");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(364, 364, 364))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_connect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(ekran, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_connect)
                    .addComponent(lb_username))
                .addGap(18, 18, 18)
                .addComponent(ekran, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jButton5)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
    
    }//GEN-LAST:event_tf_usernameActionPerformed
  public Connection baglan() throws ClassNotFoundException{
     Connection con=null;
     
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              
      
      String dburl="jdbc:sqlserver://localhost:1433;databaseName=Sorular;user=admin;password=123456";
      try{
    
        con=DriverManager.getConnection(dburl);
        System.out.println("baglanti basarili");
      }
      catch(SQLException e)
      {
          System.out.println(e);
      }
      return con;
     
         
      
      
  }
  public void buttonYenile(){
        jButton5.setEnabled(false);
        jButton1.setBackground(Color.white);
        jButton2.setBackground(Color.white);
        jButton3.setBackground(Color.white);
        jButton4.setBackground(Color.white);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
  }
  public void tellEveryone(String message) 
    {
	Iterator it = ServerOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		ekran.setText("Gönderiliyor: " + message + "\n");
                writer.flush();
                

            } 
            catch (Exception ex) 
            {
		ekran.setText("Error telling everyone. \n");
            }
        } 
    }
    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed
        if (isConnected == false) 
        {
            username = tf_username.getText();
            tf_username.setEditable(false);
            
            try 
            {
               baglan();
               
               
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                input = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream(),true);
                writer.println(username + ":başarıyla bağlanıldı.:Connect");
                
                isConnected = true; 
                
            }
          
            catch (Exception ex) 
            {
                ekran.setText("Cannot Connect! Try Again. \n");
                tf_username.setEditable(true);
            }
            
            ListenThread();
            
            
               
               
                
            
            
            
            
            
        } else if (isConnected == true) 
        {
            ekran.setText("Zaten Giriş yapılmış durumda \n");
        }
            ekran.setVisible(true);
            jButton1.setVisible(true);
            jButton2.setVisible(true);
            jButton3.setVisible(true);
            jButton4.setVisible(true);
            jButton5.setVisible(true);
            b_connect.setVisible(false);
            tf_username.setVisible(false);
            lb_username.setVisible(false);
    }//GEN-LAST:event_b_connectActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            
        jButton5.setText("Oyun Basladi");
      
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          jButton5.setText("Oyun Basladi");   
       System.out.println(jButton1.getText());
       System.out.println(dogruCevap);
        
        if(jButton1.getText()==dogruCevap){
           
        jButton1.setBackground(Color.green);
       }
       
       else {
        jButton1.setBackground(Color.red);
        sendDisconnect();
        new Kaybettiniz().setVisible(true);
        this.setVisible(false);
        
        
       }
        
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         jButton5.setText("Oyun Basladi");
        if(jButton2.getText()==dogruCevap)
       {
            jButton2.setBackground(Color.green);
       }
       else{
            jButton2.setBackground(Color.red);
            sendDisconnect();
            new Kaybettiniz().setVisible(true);
        this.setVisible(false);
        }
       
        
         jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         jButton5.setText("Oyun Basladi");
        if(jButton3.getText()==dogruCevap)
        {
            jButton3.setBackground(Color.green);
        }
        else{
            jButton3.setBackground(Color.red);
            sendDisconnect();
            new Kaybettiniz().setVisible(true);
        this.setVisible(false);
        }
        
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         jButton5.setText("Oyun Basladi");
        
        if(jButton4.getText()==dogruCevap)
        {
            jButton4.setBackground(Color.green);
        }
        else{
            jButton4.setBackground(Color.red);
            sendDisconnect();
            new Kaybettiniz().setVisible(true);
        this.setVisible(false);
        }
        
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed
   
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            
            @Override
            public void run() 
            {
                
                try {
                    
                    new ClientSoket().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientSoket.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_connect;
    private javax.swing.JLabel ekran;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel lb_username;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
