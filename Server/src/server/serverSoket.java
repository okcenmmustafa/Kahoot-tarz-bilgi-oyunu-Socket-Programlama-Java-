package server;

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

public class serverSoket extends javax.swing.JFrame 
{
    
   ArrayList<String> k;
   ArrayList clientOutputStreams;
   ArrayList<String> users;
   ArrayList<String> sorular = new ArrayList();
        ArrayList<String> yc1 = new ArrayList();
        ArrayList<String> yc2 = new ArrayList();
        ArrayList<String> yc3 = new ArrayList();
        ArrayList<String> dc = new ArrayList();
          Random rand = new Random();
          static int cntr =4;
           baglan conn= new baglan();
    Connection baglan;

   public class ClientHandler implements Runnable	
   {
       
       private BufferedReader in;
       private Socket client;
       private PrintWriter out;

       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
           try {
               this.client = clientSocket;
               in = new BufferedReader(new InputStreamReader(client.getInputStream()));
               out=new PrintWriter(client.getOutputStream(),true);
                
               
           } catch (IOException ex) {
               Logger.getLogger(serverSoket.class.getName()).log(Level.SEVERE, null, ex);
           }
                      

       }

       @Override
       public void run() 
       {
         
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            String[] data;

            try 
            {
                while ((message = in.readLine()) != null) 
                {
                    ta_chat.append("Alındı: " + message + "\n");
                    data = message.split(":");
                    
                    
                    for (String token:data) 
                    {
                        ta_chat.append(token + "\n");
                    }

                    if (data[2].equals(connect)) 
                    {
                        
                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        userAdd(data[0]);
                       
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        tellEveryone((data[0] + ":Ağdan ayrıldı" + ":" + chat));
                        userRemove(data[0]);
                        
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        tellEveryone(message);
                    } 
                   
                    else 
                    {
                        ta_chat.append("Bağlantı Yapılamıyor \n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                ta_chat.append("Bir bağlantı koptu \n");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
             } 
	} 

      
    }

    public serverSoket() throws ClassNotFoundException 
    {   System.out.println(k); 
        
        this.baglan = conn.baglan();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        b_start = new javax.swing.JButton();
        b_end = new javax.swing.JButton();
        b_users = new javax.swing.JButton();
        b_clear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Server's frame");
        setName("server"); // NOI18N
        setResizable(false);

        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        b_start.setText("Baslat");
        b_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startActionPerformed(evt);
            }
        });

        b_end.setText("Durdur");
        b_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_endActionPerformed(evt);
            }
        });

        b_users.setText("Çevrimiçi Kullanıcılar");
        b_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_usersActionPerformed(evt);
            }
        });

        b_clear.setText("Temizle");
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });

        jButton1.setText("Soru Gönder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_start, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_users, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(209, 209, 209))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_start)
                    .addComponent(b_users)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_clear)
                    .addComponent(b_end))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_endActionPerformed
        try 
        {
            Thread.sleep(5000);                 //5000 milliseconds is five second.
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
        tellEveryone("Server:Server durucak ve bütün kullanicilar atılacak.\n:Chat");
        ta_chat.append("Server durduruluyor... \n");
        
        ta_chat.setText("");
    }//GEN-LAST:event_b_endActionPerformed

    private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
        Thread starter = new Thread(new ServerStart());
        starter.start();
        
        ta_chat.append("Server Kullanicilarin baglanmasini bekliyor...\n");
    }//GEN-LAST:event_b_startActionPerformed

    private void b_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_usersActionPerformed
        ta_chat.setText("");
        ta_chat.append("\n Online Kullanicilar : \n");
        int sayi=KullaniciSay();
        ta_chat.append(""+sayi);
        for (String current_user : k)
        {
            
            ta_chat.append(current_user);
            ta_chat.append("\n");
        }    
        
    }//GEN-LAST:event_b_usersActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        ta_chat.setText("");
    }//GEN-LAST:event_b_clearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        sorual();
        int kullanicisayisi=KullaniciSay();
        if(kullanicisayisi==1){
            basla("kazandi",0,0);
        }
        
        

    }//GEN-LAST:event_jButton1ActionPerformed
   
    public int KullaniciSay(){
        int kullanici=0;
        
        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                it.next();
		
                kullanici++;
            } 
            catch (Exception ex) 
            {
		ta_chat.append("Error telling everyone. \n");
            }
        }
        return kullanici;
    }
    
    
    public int[] FarkliRandom(){
       Random rnd = new Random(); //Rastgele sayı üretmek için kullanılacak sınıf
    int[] dizim = new int[4]; //Dizimiz
    int yeni_sayi; //Her seferinde üretilecek sayımız.
    boolean durum = true;

    for (int i = 0; i < dizim.length; i++)
    {
    while (durum)
    {
    yeni_sayi=rnd.nextInt(4)+1;

    if (i == 0)
    {
    dizim[0] = yeni_sayi;
    break; //While döngüsünden çıkılır.
    }

    //Dizim içersinde oluşturulan yeni sayıdan varmı diye kontrol ediliyor.
    //Varsa durum true oluyor ve for döngüsünden çıkıyor. Çünkü yeni bir sayı atamamız gerekiyor.
    for (int k = 0; k < i; k++)
    {
    if (dizim[k] == yeni_sayi) //Yeni oluşan sayımız dizide daha önceden varsa
    {
    durum = true;
    break; //for döngüsünden çık
    }
    else
    durum = false;
    
    
}

if (durum == false)
dizim[i] = yeni_sayi;
}
durum = true;


}
return dizim;

   }
    public void sorual(){
       if(sorular.size()==0){
            SorulariArrayeAl();
       }
        int random = rand.nextInt(10);
        int[] dizim=FarkliRandom();
        System.out.println(dizim);
        System.out.println(sorular);
        basla(sorular.get(random),0,0);
        basla(dc.get(random),dizim[0],1);
        basla(yc1.get(random),dizim[1],0);
        basla(yc2.get(random),dizim[2],0);
        basla(yc3.get(random),dizim[3],0);
   }
    public static void main(String args[]) 
    {
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                
                try {
                    
                    new serverSoket().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(serverSoket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
            
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  
            k= new ArrayList();
            System.out.println();
            try 
            {
                ServerSocket serverSock = new ServerSocket(2222);

                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);

				Thread listener = new Thread(new ClientHandler(clientSock, writer));
                                
                                
				listener.start();
                                ta_chat.removeAll();
				ta_chat.append("Bİr bağlantı bulundu \n");
                }
            }
            catch (Exception ex)
            {
                ta_chat.append("Hatalı bağlantı \n");
            }
        }
    }
    
    public void userAdd (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        k.add(name);
        String[] tempList = new String[(k.size())];
        k.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    public void basla (String data,int i,int d) 
    {
        String message, add = ": :basla", done = "Server: :Done", name = data;
        users.add(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add+":"+i+":"+d);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void userRemove (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        k.remove(name);
        String[] tempList = new String[(k.size())];
        k.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
     public void SorulariArrayeAl(){
        Statement myState ;
         ResultSet soru ;
         try {
             myState = (Statement) baglan.createStatement();
             soru =(ResultSet) myState.executeQuery("select * from soru  ");
            while(soru.next()){
            sorular.add(soru.getString("sor"));
            yc1.add(soru.getString("yc1"));
            yc2.add(soru.getString("yc2"));
            yc3.add(soru.getString("yc3"));
            dc.add(soru.getString("dc"));
            }
         } catch (SQLException ex) {
            
         } 
    }
      
    public void tellEveryone(String message) 
    {
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		ta_chat.append("Sending: " + message + "\n");
                writer.flush();
                ta_chat.setCaretPosition(ta_chat.getDocument().getLength());

            } 
            catch (Exception ex) 
            {
		ta_chat.append("Error telling everyone. \n");
            }
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_end;
    private javax.swing.JButton b_start;
    private javax.swing.JButton b_users;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_chat;
    // End of variables declaration//GEN-END:variables
}
