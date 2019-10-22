import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame{
     public JFrame frame;
     public JPanel panel1;
     public JPanel panel2;
     public JPanel panel3;
     public JPanel panel4;
     public JLabel label1,label2,label3,label4,label5;
     public JTextField hour,min,second;
     private int hourtime,mintime,secondtime;
     public JButton button,button2;
     public JTextArea textArea;
     public Time time;
     private long midtime;
     public void init(){
         frame = new JFrame();
         frame.setTitle("倒计时");
         frame.setSize(500,300);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         time = new Time();
         //
         panel1 = new JPanel();
         label1 = new JLabel();
         label1.setText("倒计时时间");
         panel1.add(label1);
         //
         panel2 = new JPanel();
         label2 = new JLabel();
         label2.setText("小时");
         label3 = new JLabel();
         label3.setText("分钟");
         label4 = new JLabel();
         label4.setText("秒");
         hour = new JTextField(5);
         min = new JTextField(5);
         second = new JTextField(5);
         panel2.add(hour);
         panel2.add(label2);
         panel2.add(min);
         panel2.add(label3);
         panel2.add(second);
         panel2.add(label4);
         //
         panel3 = new JPanel();
         panel4 = new JPanel();
         button = new JButton();
         button.setText("开始倒计时");

         panel3.add(button);

         //
         label5 = new JLabel();
         label5.setForeground(Color.RED);
         panel4.add(label5);
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 hourtime = Integer.parseInt(hour.getText());
                 mintime = Integer.parseInt(min.getText());
                 secondtime = Integer.parseInt(second.getText());
                 //midtime = time.countdown(hourtime,mintime,secondtime);
                 midtime = time.countdown2(hourtime,mintime,secondtime);
                 //添加新线程，以解决frame界面不刷新问题
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         while (midtime > 0){
                             midtime--;
                             long hh = midtime / 60 / 60 % 60 ;
                             long mm = midtime / 60 % 60 ;
                             long ss = midtime % 60 ;
                             label5.setText(hh+"小时"+mm+"分钟"+ss+"秒");
                             try {
                                 Thread.sleep(1000);
                             } catch (InterruptedException ex) {
                                 ex.printStackTrace();
                             }
                         }
                     }
                 }).start();
             }
         });


         Box box = Box.createVerticalBox();
         box.add(panel1);
         box.add(panel2);
         box.add(panel3);
         box.add(panel4);
         frame.add(box);
         frame.setVisible(true);
     }
}
