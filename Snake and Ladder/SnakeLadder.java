
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class FSnakeLadder extends JFrame {
    PSnakeLadder PS;

    FSnakeLadder() {
        super.setTitle("Snake & Ladder");
        PS = new PSnakeLadder();
        add(PS);

    }

}

class PSnakeLadder extends JPanel implements ActionListener {
    ImageIcon img1, img2, img3, img4;
    ImageIcon img5, img6, img7, img8, img9;
    Image swt, board, s1, start;
    Image player1, player2, player3, player4, roll;
    Image player11, player22, player33, player44;
    JButton b1, b2, b3, b4, b5;
    static JTextField tx1, tx2, tx3, tx4, tx5, tx6;
    static int xx = -1060, yy = -10635, x3 = -1060, y3 = -10635, x4 = -1060, y4 = -10635;
    JButton[] boardButtons;
    static int x2 = -10120, y2 = -10635;
    static int chance = 1;
    static JLabel l3 = new JLabel();
    String country[] = {"2 Players", "3 Players", "4 Players"};
    JComboBox<String> cb = new JComboBox<>(country);
    int px11 = -1000, py11 = -1000, px22 = -1000, py22 = -1000, px33 = -1000, py33 = -1000, px44 = -1000, py44 = -1000;
    static int startVisible = 0;//start button
    int bx = -10000, by = -10000;//board coordinates
    // JButton b5;
    int rollingX = -1000, rollingY = -1000;

    PSnakeLadder() {
        setBackground(Color.pink);
        img1 = new ImageIcon("swt.jpg");
        img2 = new ImageIcon("Boardimg11.jpg");
        img3 = new ImageIcon("s11.jpg");
        img6 = new ImageIcon("reset.jpg");
        img7 = new ImageIcon("rolling.gif");
        img5 = new ImageIcon("player4.png");
        img4 = new ImageIcon("player33.png");
        img9 = new ImageIcon("player2.png");
        img8 = new ImageIcon("player1.png");


        roll = img7.getImage();
//        start = img4.getImage();
        swt = img1.getImage();
        board = img2.getImage();
        s1 = img3.getImage();

        player11 = img8.getImage();
        player22 = img9.getImage();

        player1 = img8.getImage();
        player2 = img9.getImage();

        player33 = img4.getImage();
        player44 = img5.getImage();

        player3 = img4.getImage();
        player4 = img5.getImage();


        setLayout(null);
//        b1=new JButton(img5);
//        b1.setBounds(50,170,100,30);
//        add(b1);
//        b1.setBackground(Color.pink);

        b2 = new JButton(img6);
        b2.setBounds(65, 50, 100, 49);
        add(b2);
        b2.addActionListener(this);
        b2.setBackground(Color.pink);
        b2.setVisible(false);

        Font f = new Font("Arial", Font.BOLD, 20);


        cb.setBounds(50, 120, 150, 35);
        add(cb);
//        cb.setHorizontalAlignment(SwingConstants.CENTER);
        cb.setBackground(Color.black);
        cb.setForeground(Color.green);
        cb.setFont(f);
        cb.addActionListener(this);
        cb.setVisible(false);

        // player 1
        tx2 = new JTextField("Player 1");
        tx2.setBounds(50, 200, 150, 35);
        tx2.setHorizontalAlignment(SwingConstants.CENTER);
        add(tx2);
        tx2.setBackground(Color.black);
        tx2.setForeground(Color.green);
        tx2.setFont(f);
        tx2.setVisible(false);

        //player 2
        tx3 = new JTextField("Player 2");
        tx3.setBounds(50, 260, 150, 35);
        tx3.setHorizontalAlignment(SwingConstants.CENTER);
        add(tx3);
        tx3.setBackground(Color.black);
        tx3.setForeground(Color.green);
        tx3.setFont(f);
        tx3.setVisible(false);

        //player 3
        tx5 = new JTextField("Player 3");
        tx5.setBounds(50, 320, 150, 35);
        tx5.setHorizontalAlignment(SwingConstants.CENTER);
        add(tx5);
        tx5.setBackground(Color.black);
        tx5.setForeground(Color.green);
        tx5.setFont(f);
        tx5.setVisible(false);

        //player 4
        tx6 = new JTextField("Player 4");
        tx6.setBounds(50, 380, 150, 35);
        tx6.setHorizontalAlignment(SwingConstants.CENTER);
        add(tx6);
        tx6.setBackground(Color.black);
        tx6.setForeground(Color.green);
        tx6.setFont(f);
        tx6.setVisible(false);


        //dice output display
        tx4 = new JTextField();
        tx4.setBounds(130, 460, 70, 70);
        tx4.setForeground(Color.yellow);
        tx4.setEnabled(false);
        add(tx4);
        tx4.setBackground(Color.darkGray);
        tx4.setFont(new Font("Arial", Font.BOLD, 70));
        tx4.setHorizontalAlignment(SwingConstants.CENTER);
        tx4.setVisible(false);

        b3 = new JButton("Roll");
        b3.setBounds(65, 550, 100, 30);
        add(b3);
        b3.setFont(f);
        b3.setForeground(Color.red);
        b3.setBackground(Color.black);
        b3.addActionListener(this);
        b3.setVisible(false);

        b4 = new JButton("START");
        b4.setBounds(280, 280, 400, 100);
        b4.setOpaque(true);
        b4.setBackground(Color.black);
        b4.setFont(new Font("Arial", Font.BOLD, 95));
        b4.setHorizontalAlignment(SwingConstants.CENTER);
        b4.setForeground(Color.green);
        b4.setVisible(true);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("EXIT");//exit to the start button
        b5.setBounds(0, 0, 80, 35);
        b5.setOpaque(true);
        b5.setBackground(Color.red);
        b5.setHorizontalAlignment(SwingConstants.CENTER);
        b5.setForeground(Color.black);
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b5.addActionListener(this);
        add(b5);
        b5.setVisible(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.pink);
        g.fillRect(0, 0, 100, 735);
//        g.drawImage(swt,0,0,this);
        g.drawImage(board, bx, by, this);
        g.drawImage(roll, rollingX, rollingY, this);
        g.drawImage(player11, px11, py11, this);
        g.drawImage(player22, px22, py22, this);
        g.drawImage(player33, px33, py33, this);
        g.drawImage(player44, px44, py44, this);
        g.drawImage(player4, x4, y4, this);
        g.drawImage(player3, x3, y3, this);
        g.drawImage(player2, x2, y2, this);
        g.drawImage(player1, xx, yy, this);

    }


    public void actionPerformed(ActionEvent e) {
        String s2 = tx3.getText();
        String s1 = tx2.getText();
        String s4 = tx5.getText();
        String s5 = tx6.getText();
        String s3 = (String) cb.getSelectedItem();
        //start button
        if (e.getSource() == b4) {
            bx = 220;
            by = 0;
            rollingX = 20;
            rollingY = 450;
            b2.setVisible(true);
            b3.setVisible(true);
            tx4.setVisible(true);
            b5.setVisible(true);//start
            b4.setVisible(false);
            cb.setVisible(true);
            xx = 170;
            yy = 635;
            x2 = 165;
            y2 = 635;
            x3 = 175;
            y3 = 635;
            x4 = 160;
            y4 = 635;

            startVisible = 1;
            repaint();
        }
        //exit button
        if (e.getSource() == b5) {
            bx = -10220;
            by = -10000;
            rollingX = -10020;
            rollingY = -10450;
            b2.setVisible(false);
            b3.setVisible(false);
            tx4.setVisible(false);
            b5.setVisible(false);//exit
            b4.setVisible(true);//start
            cb.setVisible(false);
            l3.setVisible(false);
            px11 = -1000;
            py11 = -1000;
            px22 = -1000;
            py22 = -1000;
            px33 = -1000;
            py33 = -1000;
            px44 = -1000;
            py44 = -1000;

            tx3.setVisible(false);
            tx2.setVisible(false);
            tx5.setVisible(false);
            tx6.setVisible(false);
            xx = -10000;
            yy = -10000;
            y2 = -10000;
            x2 = -10000;
            x3 = -10170;
            y3 = -10635;
            x4 = -10165;
            y4 = -10635;

            startVisible = 0;
            repaint();

        }

        if (e.getSource() == b2) {
            //reset button
            xx = 170;
            yy = 635;
            x2 = 165;
            y2 = 635;
            x3 = 175;
            y3 = 635;
            x4 = 160;
            y4 = 635;
// //            l3.setBounds(0,0,0,0);
            l3.setVisible(false);
//             tx2.setVisible(false);
//             tx3.setVisible(false);

            //            remove(l3);
            chance = 1;
            repaint();

        }
        if (startVisible == 1) {
            if (s3 == "2 Players") {
                tx2.setVisible(true);
                tx3.setVisible(true);
                tx5.setVisible(false);
                tx6.setVisible(false);

                px11 = 10;
                py11 = 180;
                px22 = 10;
                py22 = 240;
                px33 = -10000;
                px44 = -10000;
                py33 = -30000;
                py44 = 3-6000;
            } else if (s3 == "3 Players") {
                tx2.setVisible(true);
                tx3.setVisible(true);
                tx5.setVisible(true);
                tx6.setVisible(false);

                px11 = 10;
                py11 = 180;
                px22 = 10;
                py22 = 240;
                px33 = 10;
                py33 = 300;
                px44 = -10000;
                py44 = -36000;
            } else if (s3 == "4 Players") {
                tx2.setVisible(true);
                tx3.setVisible(true);
                tx5.setVisible(true);
                tx6.setVisible(true);
                px11 = 10;
                py11 = 180;
                px22 = 10;
                py22 = 240;
                px33 = 10;
                px44 = 10;
                py33 = 300;
                py44 = 360;

            }
            if (e.getSource() == b3) {
                int random = (int) Math.round(Math.random() * 5 + 1);
                if (chance == 1) {
                    // tx3.setBackground(Color.white);
                    // tx3.setForeground(Color.black);
                    // tx3.setVisible(true);

                    tx2.setBackground(Color.black);
                    tx2.setForeground(Color.green);
                    tx2.setVisible(true);
                    tx3.setBackground(Color.white);
                    tx3.setForeground(Color.black);
                    tx3.setVisible(true);
                    


                    switch (random) {
                        case 1:
                            tx4.setText("1");
                            if ((xx < 870) && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 70;
                            } else if (xx == 870 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
//                        xx -= 70;
                                //870 Ladder()
                                yy -= 70;
                            } else if (xx > 240 && (yy == 565 || yy == 425 || yy == 285 || yy == 145 || yy == 5)) {
                                xx -= 70;
                            } else if (xx == 240 && (yy == 565 || yy == 425 || yy == 285 || yy == 145)) {
                                yy -= 70;
                            }

                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            }
                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            } else if (xx == 870 && yy == 565) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 565) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 450 && yy == 565) {
                                xx += 210;
                                yy -= 420;
                            } else if (xx == 380 && yy == 565) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 590 & yy == 495) {
                                xx += 280;
                                yy += 140;
                            } else if (xx == 310 && yy == 495) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 380 && yy == 425) {
                                xx -= 70;
                                yy -= 140;
                            } else if (xx == 310 && yy == 425) {
                                xx += 210;
                                yy += 210;
                            } else if (xx == 800 && yy == 355) {
                                xx -= 140;
                                yy -= 140;
                            } else if (xx == 870 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 660 && yy == 285) {
                                xx -= 140;
                                yy += 140;
                            } else if (xx == 520 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 450 && yy == 285) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 240 && yy == 285) {
                                xx += 140;
                                yy += 210;
                            } else if (xx == 240 && yy == 215) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 145) {
                                xx += 140;
                                yy += 350;
                            } else if (xx == 730 && yy == 145) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 870 && yy == 75) {
                                xx -= 140;
                                yy += 280;
                            } else if (xx == 730 && yy == 75) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 520 && yy == 75) {
                                xx -= 210;
                                yy += 210;
                            } else if (xx == 380 && yy == 75) {
                                xx += 140;
                                yy += 280;
                            } else if (xx == 240 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 800 && yy == 5) {
                                xx -= 280;
                                yy += 490;
                            } else if (xx == 450 && yy == 5) {
                                xx += 210;
                                yy += 70;
                            } else if (xx == 310 && yy == 5) {
                                xx += 70;
                                yy += 210;
                            }


                            break;
                        case 2:
                            tx4.setText("2");
                            if ((xx < 800) && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 140;
                            } else if (xx > 310 && (yy == 565 || yy == 425 || yy == 285 || yy == 145 || yy == 5)) {
                                xx -= 140;
                            } else if (xx == 800 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 870 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx -= 70;
                                yy -= 70;
                            } else if (xx == 240 && (yy == 565 || yy == 425 || yy == 285 || yy == 145)) {
                                yy -= 70;
                                xx += 70;
                            } else if (xx == 310 && (yy == 565 || yy == 425 || yy == 285 || yy == 145)) {
                                xx -= 70;
                                yy -= 70;
                            }

                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            }
                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            } else if (xx == 870 && yy == 565) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 565) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 450 && yy == 565) {
                                xx += 210;
                                yy -= 420;
                            } else if (xx == 380 && yy == 565) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 590 & yy == 495) {
                                xx += 280;
                                yy += 140;
                            } else if (xx == 310 && yy == 495) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 380 && yy == 425) {
                                xx -= 70;
                                yy -= 140;
                            } else if (xx == 310 && yy == 425) {
                                xx += 210;
                                yy += 210;
                            } else if (xx == 800 && yy == 355) {
                                xx -= 140;
                                yy -= 140;
                            } else if (xx == 870 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 660 && yy == 285) {
                                xx -= 140;
                                yy += 140;
                            } else if (xx == 520 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 450 && yy == 285) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 240 && yy == 285) {
                                xx += 140;
                                yy += 210;
                            } else if (xx == 240 && yy == 215) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 145) {
                                xx += 140;
                                yy += 350;
                            } else if (xx == 730 && yy == 145) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 870 && yy == 75) {
                                xx -= 140;
                                yy += 280;
                            } else if (xx == 730 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 520 && yy == 75) {
                                xx -= 210;
                                yy += 210;
                            } else if (xx == 380 && yy == 75) {
                                xx += 140;
                                yy += 280;
                            } else if (xx == 240 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 800 && yy == 5) {
                                xx -= 280;
                                yy += 490;
                            } else if (xx == 450 && yy == 5) {
                                xx += 210;
                                yy += 70;
                            } else if (xx == 310 && yy == 5) {
                                xx += 70;
                                yy += 210;
                            }
                            break;
                        case 3:
                            tx4.setText("3");
                            if (xx < 730 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 210;
                            } else if ((xx == 800) && (yy == 635 || yy == 495 || yy == 215 || yy == 75)) {
//                        xx += 70;
                                yy -= 70;
                            } else if (xx == 870 && (yy == 635 || yy == 495 || yy == 355 || yy == 215)) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 730 && (yy == 495 || yy == 355 || yy == 215)) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx > 380 && (yy == 565 || yy == 565 || yy == 425 || yy == 285 || yy == 145 || yy == 5)) {
                                xx -= 210;
                            } else if ((xx == 380) && (yy == 285 || yy == 145)) {
                                xx -= 140;
                                yy -= 70;
                            } else if ((xx == 310) && (yy == 565 || yy == 285 || yy == 145)) {
                                yy -= 70;
                            } else if ((xx == 240) && (yy == 565 || yy == 425 || yy == 145)) {
                                xx += 140;
                                yy -= 70;
                            }


                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            } else if (xx == 870 && yy == 565) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 565) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 450 && yy == 565) {
                                xx += 210;
                                yy -= 420;
                            } else if (xx == 380 && yy == 565) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 590 & yy == 495) {
                                xx += 280;
                                yy += 140;
                            } else if (xx == 310 && yy == 495) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 380 && yy == 425) {
                                xx -= 70;
                                yy -= 140;
                            } else if (xx == 310 && yy == 425) {
                                xx += 210;
                                yy += 210;
                            } else if (xx == 800 && yy == 355) {
                                xx -= 140;
                                yy -= 140;
                            } else if (xx == 870 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 660 && yy == 285) {
                                xx -= 140;
                                yy += 140;
                            } else if (xx == 520 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 450 && yy == 285) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 240 && yy == 285) {
                                xx += 140;
                                yy += 210;
                            } else if (xx == 240 && yy == 215) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 145) {
                                xx += 140;
                                yy += 350;
                            } else if (xx == 730 && yy == 145) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 870 && yy == 75) {
                                xx -= 140;
                                yy += 280;
                            } else if (xx == 730 && yy == 75) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 520 && yy == 75) {
                                xx -= 210;
                                yy += 210;
                            } else if (xx == 380 && yy == 75) {
                                xx += 140;
                                yy += 280;
                            } else if (xx == 240 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 800 && yy == 5) {
                                xx -= 280;
                                yy += 490;
                            } else if (xx == 450 && yy == 5) {
                                xx += 210;
                                yy += 70;
                            } else if (xx == 310 && yy == 5) {
                                xx += 70;
                                yy += 210;
                            }


                            break;
                        case 4:
                            tx4.setText("4");
                            if (xx < 660 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 280;
                            } else if (xx == 660 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 210;
                                yy -= 70;
                            } else if (xx == 800 && (yy == 635 || yy == 495 || yy == 215 || yy == 75)) {
                                xx -= 70;
                                yy -= 70;
                            } else if (xx == 870 && (yy == 635 || yy == 495 || yy == 355 || yy == 215)) {
                                xx -= 210;
                                yy -= 70;
                            } else if (xx == 730 && (yy == 495 || yy == 355 || yy == 215)) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx > 450 && (yy == 565 || yy == 425 || yy == 285 || yy == 145 || yy == 5)) {
                                xx -= 280;
                            } else if (xx == 450 && (yy == 425 || yy == 145)) {
                                xx -= 210;
                                yy -= 70;
                            } else if (xx == 380 && (yy == 285 || yy == 145)) {
                                xx -= 70;
                                yy -= 70;
                            } else if (xx == 310 && (yy == 565 || yy == 285 || yy == 145)) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 240 && (yy == 565 || yy == 425 || yy == 145)) {
                                xx += 210;
                                yy -= 70;
                            }


                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            } else if (xx == 870 && yy == 565) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 565) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 450 && yy == 565) {
                                xx += 210;
                                yy -= 420;
                            } else if (xx == 380 && yy == 565) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 590 & yy == 495) {
                                xx += 280;
                                yy += 140;
                            } else if (xx == 310 && yy == 495) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 380 && yy == 425) {
                                xx -= 70;
                                yy -= 140;
                            } else if (xx == 310 && yy == 425) {
                                xx += 210;
                                yy += 210;
                            } else if (xx == 800 && yy == 355) {
                                xx -= 140;
                                yy -= 140;
                            } else if (xx == 870 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 660 && yy == 285) {
                                xx -= 140;
                                yy += 140;
                            } else if (xx == 520 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 450 && yy == 285) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 240 && yy == 285) {
                                xx += 140;
                                yy += 210;
                            } else if (xx == 240 && yy == 215) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 145) {
                                xx += 140;
                                yy += 350;
                            } else if (xx == 730 && yy == 145) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 870 && yy == 75) {
                                xx -= 140;
                                yy += 280;
                            } else if (xx == 730 && yy == 75) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 520 && yy == 75) {
                                xx -= 210;
                                yy += 210;
                            } else if (xx == 380 && yy == 75) {
                                xx += 140;
                                yy += 280;
                            } else if (xx == 240 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 800 && yy == 5) {
                                xx -= 280;
                                yy += 490;
                            } else if (xx == 450 && yy == 5) {
                                xx += 210;
                                yy += 70;
                            } else if (xx == 310 && yy == 5) {
                                xx += 70;
                                yy += 210;
                            }


                            break;
                        case 5:
                            tx4.setText("5");
                            if (xx < 590 && ((yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75))) {
                                xx += 350;
                            } else if (xx == 590 && (yy == 355 || yy == 215 || yy == 75)) {
                                xx += 280;
                                yy -= 70;
                            } else if (xx == 660 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 730 && (yy == 495 || yy == 355 || yy == 215)) {
                                yy -= 70;
                            } else if (xx == 800 && (yy == 635 || yy == 495 || yy == 215 || yy == 75)) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 870 && (yy == 635 || yy == 495 || yy == 355 || yy == 215)) {
                                xx -= 280;
                                yy -= 70;
                            } else if (xx > 520 && (yy == 565 || yy == 425 || yy == 285 || yy == 145 || yy == 5)) {
                                xx -= 350;
                            } else if (xx == 520 && (yy == 565 || yy == 425 || yy == 145)) {
                                xx -= 280;
                                yy -= 70;
                            } else if (xx == 450 && (yy == 425 || yy == 145)) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 380 && (yy == 285 || yy == 145)) {
                                yy -= 70;
                            } else if (xx == 310 && (yy == 565 || yy == 285 || yy == 145)) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 240 && (yy == 565 || yy == 425 || yy == 145)) {
                                xx += 280;
                                yy -= 70;
                            }

                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            } else if (xx == 870 && yy == 565) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 565) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 450 && yy == 565) {
                                xx += 210;
                                yy -= 420;
                            } else if (xx == 380 && yy == 565) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 590 & yy == 495) {
                                xx += 280;
                                yy += 140;
                            } else if (xx == 310 && yy == 495) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 380 && yy == 425) {
                                xx -= 70;
                                yy -= 140;
                            } else if (xx == 310 && yy == 425) {
                                xx += 210;
                                yy += 210;
                            } else if (xx == 800 && yy == 355) {
                                xx -= 140;
                                yy -= 140;
                            } else if (xx == 870 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 660 && yy == 285) {
                                xx -= 140;
                                yy += 140;
                            } else if (xx == 520 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 450 && yy == 285) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 240 && yy == 285) {
                                xx += 140;
                                yy += 210;
                            } else if (xx == 240 && yy == 215) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 145) {
                                xx += 140;
                                yy += 350;
                            } else if (xx == 730 && yy == 145) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 870 && yy == 75) {
                                xx -= 140;
                                yy += 280;
                            } else if (xx == 730 && yy == 75) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 520 && yy == 75) {
                                xx -= 210;
                                yy += 210;
                            } else if (xx == 380 && yy == 75) {
                                xx += 140;
                                yy += 280;
                            } else if (xx == 240 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 800 && yy == 5) {
                                xx -= 280;
                                yy += 490;
                            } else if (xx == 450 && yy == 5) {
                                xx += 210;
                                yy += 70;
                            } else if (xx == 310 && yy == 5) {
                                xx += 70;
                                yy += 210;
                            }


                            break;
                        case 6:
                            tx4.setText("6");
                            if (xx < 520 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 420;
                            } else if (xx == 520 && (yy == 635 || yy == 495 || yy == 355 || yy == 215)) {
                                xx += 350;
                                yy -= 70;
                            } else if (xx == 590 && (yy == 355 || yy == 215 || yy == 75)) {
                                xx += 210;
                                yy -= 70;
                            } else if (xx == 660 && (yy == 635 || yy == 495 || yy == 355 || yy == 215 || yy == 75)) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && (yy == 495 || yy == 355 || yy == 215)) {
                                xx -= 70;
                                yy -= 70;
                            } else if (xx == 800 && (yy == 635 || yy == 495 || yy == 215 || yy == 75)) {
                                xx -= 210;
                                yy -= 70;
                            } else if (xx == 870 && (yy == 635 || yy == 495 || yy == 355 || yy == 215)) {
                                xx -= 350;
                                yy -= 70;
                            } else if (xx > 590 && (yy == 565 || yy == 425 || yy == 285 || yy == 145 || yy == 5)) {
                                xx -= 420;
                            } else if (xx == 240 && (yy == 565 || yy == 425 || yy == 145)) {
                                xx += 350;
                                yy -= 70;
                            } else if (xx == 310 && (yy == 565 || yy == 285 || yy == 145)) {
                                xx += 210;
                                yy -= 70;
                            } else if (xx == 380 && (yy == 285 || yy == 145)) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 450 && (yy == 425 || yy == 145)) {
                                xx -= 70;
                                yy -= 70;
                            } else if (xx == 520 && (yy == 565 || yy == 425 || yy == 145)) {
                                xx -= 210;
                                yy -= 70;
                            } else if (xx == 590 && (yy == 425 || yy == 285)) {
                                xx -= 350;
                                yy -= 70;
                            }


                            if (xx == 380 && yy == 635) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 635) {
                                xx += 70;
                                yy -= 70;
                            } else if (xx == 730 && yy == 635) {
                                xx -= 280;
                            } else if (xx == 870 && yy == 565) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 565) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 450 && yy == 565) {
                                xx += 210;
                                yy -= 420;
                            } else if (xx == 380 && yy == 565) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 590 & yy == 495) {
                                xx += 280;
                                yy += 140;
                            } else if (xx == 310 && yy == 495) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 380 && yy == 425) {
                                xx -= 70;
                                yy -= 140;
                            } else if (xx == 310 && yy == 425) {
                                xx += 210;
                                yy += 210;
                            } else if (xx == 800 && yy == 355) {
                                xx -= 140;
                                yy -= 140;
                            } else if (xx == 870 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 660 && yy == 285) {
                                xx -= 140;
                                yy += 140;
                            } else if (xx == 520 && yy == 285) {
                                xx -= 280;
                                yy += 350;
                            } else if (xx == 450 && yy == 285) {
                                xx += 70;
                                yy -= 140;
                            } else if (xx == 240 && yy == 285) {
                                xx += 140;
                                yy += 210;
                            } else if (xx == 240 && yy == 215) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 590 && yy == 145) {
                                xx += 140;
                                yy += 350;
                            } else if (xx == 730 && yy == 145) {
                                xx -= 140;
                                yy += 70;
                            } else if (xx == 870 && yy == 75) {
                                xx -= 140;
                                yy += 280;
                            } else if (xx == 730 && yy == 75) {
                                xx -= 140;
                                yy -= 70;
                            } else if (xx == 520 && yy == 75) {
                                xx -= 210;
                                yy += 210;
                            } else if (xx == 380 && yy == 75) {
                                xx += 140;
                                yy += 280;
                            } else if (xx == 240 && yy == 75) {
                                xx += 140;
                                yy -= 70;
                            } else if (xx == 800 && yy == 5) {
                                xx -= 280;
                                yy += 490;
                            } else if (xx == 450 && yy == 5) {
                                xx += 210;
                                yy += 70;
                            } else if (xx == 310 && yy == 5) {
                                xx += 70;
                                yy += 210;
                            }


                            break;
                    }
                    if (xx == 240 && yy == 5) {
                        l3.setText(s1 + " WON");
                        l3.setBackground(Color.black);
                        l3.setForeground(Color.red);
                        l3.setOpaque(true);
                        l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        l3.setHorizontalAlignment(SwingConstants.CENTER);
                        l3.setBounds(220, 300, 700, 100);
//                    b3.setEnabled(false);
                        l3.setFont(new Font("Arial", Font.BOLD, 70));
                        l3.setVisible(true);
                        add(l3);
                    }
                    repaint();
                    chance = 2;


                } else if (chance == 2) {
                    // tx2.setBackground(Color.white);
                    // tx2.setForeground(Color.black);
                    // tx2.setVisible(true);

                    // tx3.setForeground(Color.green);
                    // tx3.setBackground(Color.black);
                    // tx3.setVisible(true);
                    tx3.setBackground(Color.black);
                    tx3.setForeground(Color.green);
                    tx3.setVisible(true);
                    if(s3=="2 Players"){
                        tx2.setBackground(Color.white);
                    tx2.setForeground(Color.black);
                    tx2.setVisible(true);
                    }
                    if(s3=="3 Players" || s3 =="4 Players"){
                        tx5.setBackground(Color.white);
                    tx5.setForeground(Color.black);
                    tx5.setVisible(true);
                    }
                    switch (random) {
                        case 1:
                            tx4.setText("1");
                            if ((x2 < 865) && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 70;
                            } else if (x2 == 865 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
//                        x2 -= 70;
                                //865 Ladder()
                                y2 -= 70;
                            } else if (x2 > 235 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145 || y2 == 5)) {
                                x2 -= 70;
                            } else if (x2 == 235 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145)) {
                                y2 -= 70;
                            }

                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            }
                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            } else if (x2 == 865 && y2 == 565) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 565) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 445 && y2 == 565) {
                                x2 += 210;
                                y2 -= 420;
                            } else if (x2 == 375 && y2 == 565) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 585 & y2 == 495) {
                                x2 += 280;
                                y2 += 140;
                            } else if (x2 == 305 && y2 == 495) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 375 && y2 == 425) {
                                x2 -= 70;
                                y2 -= 140;
                            } else if (x2 == 305 && y2 == 425) {
                                x2 += 210;
                                y2 += 210;
                            } else if (x2 == 795 && y2 == 355) {
                                x2 -= 140;
                                y2 -= 140;
                            } else if (x2 == 865 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 655 && y2 == 285) {
                                x2 -= 140;
                                y2 += 140;
                            } else if (x2 == 515 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 445 && y2 == 285) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 235 && y2 == 285) {
                                x2 += 140;
                                y2 += 210;
                            } else if (x2 == 235 && y2 == 215) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 145) {
                                x2 += 140;
                                y2 += 350;
                            } else if (x2 == 725 && y2 == 145) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 865 && y2 == 75) {
                                x2 -= 140;
                                y2 += 280;
                            } else if (x2 == 725 && y2 == 75) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 515 && y2 == 75) {
                                x2 -= 210;
                                y2 += 210;
                            } else if (x2 == 375 && y2 == 75) {
                                x2 += 140;
                                y2 += 280;
                            } else if (x2 == 235 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 795 && y2 == 5) {
                                x2 -= 280;
                                y2 += 490;
                            } else if (x2 == 445 && y2 == 5) {
                                x2 += 210;
                                y2 += 70;
                            } else if (x2 == 305 && y2 == 5) {
                                x2 += 70;
                                y2 += 210;
                            }


                            break;
                        case 2:
                            tx4.setText("2");
                            if ((x2 < 795) && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 140;
                            } else if (x2 > 305 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145 || y2 == 5)) {
                                x2 -= 140;
                            } else if (x2 == 795 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 865 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 -= 70;
                                y2 -= 70;
                            } else if (x2 == 235 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145)) {
                                y2 -= 70;
                                x2 += 70;
                            } else if (x2 == 305 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145)) {
                                x2 -= 70;
                                y2 -= 70;
                            }

                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            }
                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            } else if (x2 == 865 && y2 == 565) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 565) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 445 && y2 == 565) {
                                x2 += 210;
                                y2 -= 420;
                            } else if (x2 == 375 && y2 == 565) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 585 & y2 == 495) {
                                x2 += 280;
                                y2 += 140;
                            } else if (x2 == 305 && y2 == 495) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 375 && y2 == 425) {
                                x2 -= 70;
                                y2 -= 140;
                            } else if (x2 == 305 && y2 == 425) {
                                x2 += 210;
                                y2 += 210;
                            } else if (x2 == 795 && y2 == 355) {
                                x2 -= 140;
                                y2 -= 140;
                            } else if (x2 == 865 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 655 && y2 == 285) {
                                x2 -= 140;
                                y2 += 140;
                            } else if (x2 == 515 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 445 && y2 == 285) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 235 && y2 == 285) {
                                x2 += 140;
                                y2 += 210;
                            } else if (x2 == 235 && y2 == 215) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 145) {
                                x2 += 140;
                                y2 += 350;
                            } else if (x2 == 725 && y2 == 145) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 865 && y2 == 75) {
                                x2 -= 140;
                                y2 += 280;
                            } else if (x2 == 725 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 515 && y2 == 75) {
                                x2 -= 210;
                                y2 += 210;
                            } else if (x2 == 375 && y2 == 75) {
                                x2 += 140;
                                y2 += 280;
                            } else if (x2 == 235 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 795 && y2 == 5) {
                                x2 -= 280;
                                y2 += 490;
                            } else if (x2 == 445 && y2 == 5) {
                                x2 += 210;
                                y2 += 70;
                            } else if (x2 == 305 && y2 == 5) {
                                x2 += 70;
                                y2 += 210;
                            }
                            break;
                        case 3:
                            tx4.setText("3");
                            if (x2 < 725 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 210;
                            } else if ((x2 == 795) && (y2 == 635 || y2 == 495 || y2 == 215 || y2 == 75)) {
//                        x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 865 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 725 && (y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 > 375 && (y2 == 565 || y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145 || y2 == 5)) {
                                x2 -= 210;
                            } else if ((x2 == 375) && (y2 == 285 || y2 == 145)) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if ((x2 == 305) && (y2 == 565 || y2 == 285 || y2 == 145)) {
                                y2 -= 70;
                            } else if ((x2 == 235) && (y2 == 565 || y2 == 425 || y2 == 145)) {
                                x2 += 140;
                                y2 -= 70;
                            }


                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            } else if (x2 == 865 && y2 == 565) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 565) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 445 && y2 == 565) {
                                x2 += 210;
                                y2 -= 420;
                            } else if (x2 == 375 && y2 == 565) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 585 & y2 == 495) {
                                x2 += 280;
                                y2 += 140;
                            } else if (x2 == 305 && y2 == 495) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 375 && y2 == 425) {
                                x2 -= 70;
                                y2 -= 140;
                            } else if (x2 == 305 && y2 == 425) {
                                x2 += 210;
                                y2 += 210;
                            } else if (x2 == 795 && y2 == 355) {
                                x2 -= 140;
                                y2 -= 140;
                            } else if (x2 == 865 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 655 && y2 == 285) {
                                x2 -= 140;
                                y2 += 140;
                            } else if (x2 == 515 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 445 && y2 == 285) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 235 && y2 == 285) {
                                x2 += 140;
                                y2 += 210;
                            } else if (x2 == 235 && y2 == 215) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 145) {
                                x2 += 140;
                                y2 += 350;
                            } else if (x2 == 725 && y2 == 145) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 865 && y2 == 75) {
                                x2 -= 140;
                                y2 += 280;
                            } else if (x2 == 725 && y2 == 75) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 515 && y2 == 75) {
                                x2 -= 210;
                                y2 += 210;
                            } else if (x2 == 375 && y2 == 75) {
                                x2 += 140;
                                y2 += 280;
                            } else if (x2 == 235 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 795 && y2 == 5) {
                                x2 -= 280;
                                y2 += 490;
                            } else if (x2 == 445 && y2 == 5) {
                                x2 += 210;
                                y2 += 70;
                            } else if (x2 == 305 && y2 == 5) {
                                x2 += 70;
                                y2 += 210;
                            }


                            break;
                        case 4:
                            tx4.setText("4");
                            if (x2 < 655 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 280;
                            } else if (x2 == 655 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 210;
                                y2 -= 70;
                            } else if (x2 == 795 && (y2 == 635 || y2 == 495 || y2 == 215 || y2 == 75)) {
                                x2 -= 70;
                                y2 -= 70;
                            } else if (x2 == 865 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 -= 210;
                                y2 -= 70;
                            } else if (x2 == 725 && (y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 > 445 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145 || y2 == 5)) {
                                x2 -= 280;
                            } else if (x2 == 445 && (y2 == 425 || y2 == 145)) {
                                x2 -= 210;
                                y2 -= 70;
                            } else if (x2 == 375 && (y2 == 285 || y2 == 145)) {
                                x2 -= 70;
                                y2 -= 70;
                            } else if (x2 == 305 && (y2 == 565 || y2 == 285 || y2 == 145)) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 235 && (y2 == 565 || y2 == 425 || y2 == 145)) {
                                x2 += 210;
                                y2 -= 70;
                            }


                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            } else if (x2 == 865 && y2 == 565) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 565) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 445 && y2 == 565) {
                                x2 += 210;
                                y2 -= 420;
                            } else if (x2 == 375 && y2 == 565) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 585 & y2 == 495) {
                                x2 += 280;
                                y2 += 140;
                            } else if (x2 == 305 && y2 == 495) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 375 && y2 == 425) {
                                x2 -= 70;
                                y2 -= 140;
                            } else if (x2 == 305 && y2 == 425) {
                                x2 += 210;
                                y2 += 210;
                            } else if (x2 == 795 && y2 == 355) {
                                x2 -= 140;
                                y2 -= 140;
                            } else if (x2 == 865 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 655 && y2 == 285) {
                                x2 -= 140;
                                y2 += 140;
                            } else if (x2 == 515 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 445 && y2 == 285) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 235 && y2 == 285) {
                                x2 += 140;
                                y2 += 210;
                            } else if (x2 == 235 && y2 == 215) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 145) {
                                x2 += 140;
                                y2 += 350;
                            } else if (x2 == 725 && y2 == 145) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 865 && y2 == 75) {
                                x2 -= 140;
                                y2 += 280;
                            } else if (x2 == 725 && y2 == 75) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 515 && y2 == 75) {
                                x2 -= 210;
                                y2 += 210;
                            } else if (x2 == 375 && y2 == 75) {
                                x2 += 140;
                                y2 += 280;
                            } else if (x2 == 235 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 795 && y2 == 5) {
                                x2 -= 280;
                                y2 += 490;
                            } else if (x2 == 445 && y2 == 5) {
                                x2 += 210;
                                y2 += 70;
                            } else if (x2 == 305 && y2 == 5) {
                                x2 += 70;
                                y2 += 210;
                            }


                            break;
                        case 5:
                            tx4.setText("5");
                            if (x2 < 585 && ((y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75))) {
                                x2 += 350;
                            } else if (x2 == 585 && (y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 280;
                                y2 -= 70;
                            } else if (x2 == 655 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 725 && (y2 == 495 || y2 == 355 || y2 == 215)) {
                                y2 -= 70;
                            } else if (x2 == 795 && (y2 == 635 || y2 == 495 || y2 == 215 || y2 == 75)) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 865 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 -= 280;
                                y2 -= 70;
                            } else if (x2 > 515 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145 || y2 == 5)) {
                                x2 -= 350;
                            } else if (x2 == 515 && (y2 == 565 || y2 == 425 || y2 == 145)) {
                                x2 -= 280;
                                y2 -= 70;
                            } else if (x2 == 445 && (y2 == 425 || y2 == 145)) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 375 && (y2 == 285 || y2 == 145)) {
                                y2 -= 70;
                            } else if (x2 == 305 && (y2 == 565 || y2 == 285 || y2 == 145)) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 235 && (y2 == 565 || y2 == 425 || y2 == 145)) {
                                x2 += 280;
                                y2 -= 70;
                            }

                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            } else if (x2 == 865 && y2 == 565) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 565) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 445 && y2 == 565) {
                                x2 += 210;
                                y2 -= 420;
                            } else if (x2 == 375 && y2 == 565) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 585 & y2 == 495) {
                                x2 += 280;
                                y2 += 140;
                            } else if (x2 == 305 && y2 == 495) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 375 && y2 == 425) {
                                x2 -= 70;
                                y2 -= 140;
                            } else if (x2 == 305 && y2 == 425) {
                                x2 += 210;
                                y2 += 210;
                            } else if (x2 == 795 && y2 == 355) {
                                x2 -= 140;
                                y2 -= 140;
                            } else if (x2 == 865 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 655 && y2 == 285) {
                                x2 -= 140;
                                y2 += 140;
                            } else if (x2 == 515 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 445 && y2 == 285) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 235 && y2 == 285) {
                                x2 += 140;
                                y2 += 210;
                            } else if (x2 == 235 && y2 == 215) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 145) {
                                x2 += 140;
                                y2 += 350;
                            } else if (x2 == 725 && y2 == 145) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 865 && y2 == 75) {
                                x2 -= 140;
                                y2 += 280;
                            } else if (x2 == 725 && y2 == 75) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 515 && y2 == 75) {
                                x2 -= 210;
                                y2 += 210;
                            } else if (x2 == 375 && y2 == 75) {
                                x2 += 140;
                                y2 += 280;
                            } else if (x2 == 235 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 795 && y2 == 5) {
                                x2 -= 280;
                                y2 += 490;
                            } else if (x2 == 445 && y2 == 5) {
                                x2 += 210;
                                y2 += 70;
                            } else if (x2 == 305 && y2 == 5) {
                                x2 += 70;
                                y2 += 210;
                            }


                            break;
                        case 6:
                            tx4.setText("6");
                            if (x2 < 515 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 420;
                            } else if (x2 == 515 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 += 350;
                                y2 -= 70;
                            } else if (x2 == 585 && (y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 210;
                                y2 -= 70;
                            } else if (x2 == 655 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215 || y2 == 75)) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && (y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 -= 70;
                                y2 -= 70;
                            } else if (x2 == 795 && (y2 == 635 || y2 == 495 || y2 == 215 || y2 == 75)) {
                                x2 -= 210;
                                y2 -= 70;
                            } else if (x2 == 865 && (y2 == 635 || y2 == 495 || y2 == 355 || y2 == 215)) {
                                x2 -= 350;
                                y2 -= 70;
                            } else if (x2 > 585 && (y2 == 565 || y2 == 425 || y2 == 285 || y2 == 145 || y2 == 5)) {
                                x2 -= 420;
                            } else if (x2 == 235 && (y2 == 565 || y2 == 425 || y2 == 145)) {
                                x2 += 350;
                                y2 -= 70;
                            } else if (x2 == 305 && (y2 == 565 || y2 == 285 || y2 == 145)) {
                                x2 += 210;
                                y2 -= 70;
                            } else if (x2 == 375 && (y2 == 285 || y2 == 145)) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 445 && (y2 == 425 || y2 == 145)) {
                                x2 -= 70;
                                y2 -= 70;
                            } else if (x2 == 515 && (y2 == 565 || y2 == 425 || y2 == 145)) {
                                x2 -= 210;
                                y2 -= 70;
                            } else if (x2 == 585 && (y2 == 425 || y2 == 285)) {
                                x2 -= 350;
                                y2 -= 70;
                            }


                            if (x2 == 375 && y2 == 635) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 635) {
                                x2 += 70;
                                y2 -= 70;
                            } else if (x2 == 725 && y2 == 635) {
                                x2 -= 280;
                            } else if (x2 == 865 && y2 == 565) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 565) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 445 && y2 == 565) {
                                x2 += 210;
                                y2 -= 420;
                            } else if (x2 == 375 && y2 == 565) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 585 & y2 == 495) {
                                x2 += 280;
                                y2 += 140;
                            } else if (x2 == 305 && y2 == 495) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 375 && y2 == 425) {
                                x2 -= 70;
                                y2 -= 140;
                            } else if (x2 == 305 && y2 == 425) {
                                x2 += 210;
                                y2 += 210;
                            } else if (x2 == 795 && y2 == 355) {
                                x2 -= 140;
                                y2 -= 140;
                            } else if (x2 == 865 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 655 && y2 == 285) {
                                x2 -= 140;
                                y2 += 140;
                            } else if (x2 == 515 && y2 == 285) {
                                x2 -= 280;
                                y2 += 350;
                            } else if (x2 == 445 && y2 == 285) {
                                x2 += 70;
                                y2 -= 140;
                            } else if (x2 == 235 && y2 == 285) {
                                x2 += 140;
                                y2 += 210;
                            } else if (x2 == 235 && y2 == 215) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 585 && y2 == 145) {
                                x2 += 140;
                                y2 += 350;
                            } else if (x2 == 725 && y2 == 145) {
                                x2 -= 140;
                                y2 += 70;
                            } else if (x2 == 865 && y2 == 75) {
                                x2 -= 140;
                                y2 += 280;
                            } else if (x2 == 725 && y2 == 75) {
                                x2 -= 140;
                                y2 -= 70;
                            } else if (x2 == 515 && y2 == 75) {
                                x2 -= 210;
                                y2 += 210;
                            } else if (x2 == 375 && y2 == 75) {
                                x2 += 140;
                                y2 += 280;
                            } else if (x2 == 235 && y2 == 75) {
                                x2 += 140;
                                y2 -= 70;
                            } else if (x2 == 795 && y2 == 5) {
                                x2 -= 280;
                                y2 += 490;
                            } else if (x2 == 445 && y2 == 5) {
                                x2 += 210;
                                y2 += 70;
                            } else if (x2 == 305 && y2 == 5) {
                                x2 += 70;
                                y2 += 210;
                            }


                            break;
                    }
                    if (x2 == 235 && y2 == 5) {
                        l3.setText(s2 + " WON");
                        l3.setBackground(Color.black);
                        l3.setForeground(Color.red);
                        l3.setOpaque(true);
                        l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        l3.setHorizontalAlignment(SwingConstants.CENTER);
                        l3.setBounds(220, 300, 700, 100);
//                    b3.setEnabled(false);
                        l3.setFont(new Font("Arial", Font.BOLD, 70));
                        l3.setVisible(true);
                        add(l3);


                    }
                    repaint();
                    if (s3 == "2 Players") {
                        chance = 1;
                    } else if (s3 == "3 Players" || s3 == "4 Players") {
                        chance = 3;
                    }
                    // tx3.setBackground(Color.black);
                    // tx3.setVisible(true);

                } else if (chance == 3) {
                    // tx3.setBackground(Color.white);
                    // tx3.setForeground(Color.black);
                    // tx3.setVisible(true);

                    tx5.setForeground(Color.green);
                    tx5.setBackground(Color.black);
                    tx5.setVisible(true);
                    if(s3=="3 Players"){
                        tx2.setBackground(Color.white);
                    tx2.setForeground(Color.black);
                    tx2.setVisible(true);
                    }
                    if(s3=="4 Players"){
                        tx6.setBackground(Color.white);
                    tx6.setForeground(Color.black);
                    tx6.setVisible(true);
                    }
                    switch (random) {
                        case 1:
                            tx4.setText("1");
                            if ((x3 < 875) && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 70;
                            } else if (x3 == 875 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
//                        x3 -= 70;
                                //875 Ladder()
                                y3 -= 70;
                            } else if (x3 > 245 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145 || y3 == 5)) {
                                x3 -= 70;
                            } else if (x3 == 245 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145)) {
                                y3 -= 70;
                            }

                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            }
                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            } else if (x3 == 875 && y3 == 565) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 565) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 455 && y3 == 565) {
                                x3 += 210;
                                y3 -= 420;
                            } else if (x3 == 385 && y3 == 565) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 595 & y3 == 495) {
                                x3 += 280;
                                y3 += 140;
                            } else if (x3 == 315 && y3 == 495) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 385 && y3 == 425) {
                                x3 -= 70;
                                y3 -= 140;
                            } else if (x3 == 315 && y3 == 425) {
                                x3 += 210;
                                y3 += 210;
                            } else if (x3 == 805 && y3 == 355) {
                                x3 -= 140;
                                y3 -= 140;
                            } else if (x3 == 875 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 665 && y3 == 285) {
                                x3 -= 140;
                                y3 += 140;
                            } else if (x3 == 525 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 455 && y3 == 285) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 245 && y3 == 285) {
                                x3 += 140;
                                y3 += 210;
                            } else if (x3 == 245 && y3 == 215) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 145) {
                                x3 += 140;
                                y3 += 350;
                            } else if (x3 == 735 && y3 == 145) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 875 && y3 == 75) {
                                x3 -= 140;
                                y3 += 280;
                            } else if (x3 == 735 && y3 == 75) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 525 && y3 == 75) {
                                x3 -= 210;
                                y3 += 210;
                            } else if (x3 == 385 && y3 == 75) {
                                x3 += 140;
                                y3 += 280;
                            } else if (x3 == 245 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 805 && y3 == 5) {
                                x3 -= 280;
                                y3 += 490;
                            } else if (x3 == 455 && y3 == 5) {
                                x3 += 210;
                                y3 += 70;
                            } else if (x3 == 315 && y3 == 5) {
                                x3 += 70;
                                y3 += 210;
                            }


                            break;
                        case 2:
                            tx4.setText("2");
                            if ((x3 < 805) && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 140;
                            } else if (x3 > 315 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145 || y3 == 5)) {
                                x3 -= 140;
                            } else if (x3 == 805 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 875 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 -= 70;
                                y3 -= 70;
                            } else if (x3 == 245 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145)) {
                                y3 -= 70;
                                x3 += 70;
                            } else if (x3 == 315 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145)) {
                                x3 -= 70;
                                y3 -= 70;
                            }

                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            }
                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            } else if (x3 == 875 && y3 == 565) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 565) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 455 && y3 == 565) {
                                x3 += 210;
                                y3 -= 420;
                            } else if (x3 == 385 && y3 == 565) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 595 & y3 == 495) {
                                x3 += 280;
                                y3 += 140;
                            } else if (x3 == 315 && y3 == 495) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 385 && y3 == 425) {
                                x3 -= 70;
                                y3 -= 140;
                            } else if (x3 == 315 && y3 == 425) {
                                x3 += 210;
                                y3 += 210;
                            } else if (x3 == 805 && y3 == 355) {
                                x3 -= 140;
                                y3 -= 140;
                            } else if (x3 == 875 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 665 && y3 == 285) {
                                x3 -= 140;
                                y3 += 140;
                            } else if (x3 == 525 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 455 && y3 == 285) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 245 && y3 == 285) {
                                x3 += 140;
                                y3 += 210;
                            } else if (x3 == 245 && y3 == 215) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 145) {
                                x3 += 140;
                                y3 += 350;
                            } else if (x3 == 735 && y3 == 145) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 875 && y3 == 75) {
                                x3 -= 140;
                                y3 += 280;
                            } else if (x3 == 735 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 525 && y3 == 75) {
                                x3 -= 210;
                                y3 += 210;
                            } else if (x3 == 385 && y3 == 75) {
                                x3 += 140;
                                y3 += 280;
                            } else if (x3 == 245 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 805 && y3 == 5) {
                                x3 -= 280;
                                y3 += 490;
                            } else if (x3 == 455 && y3 == 5) {
                                x3 += 210;
                                y3 += 70;
                            } else if (x3 == 315 && y3 == 5) {
                                x3 += 70;
                                y3 += 210;
                            }
                            break;
                        case 3:
                            tx4.setText("3");
                            if (x3 < 735 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 210;
                            } else if ((x3 == 805) && (y3 == 635 || y3 == 495 || y3 == 215 || y3 == 75)) {
//                        x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 875 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 735 && (y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 > 385 && (y3 == 565 || y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145 || y3 == 5)) {
                                x3 -= 210;
                            } else if ((x3 == 385) && (y3 == 285 || y3 == 145)) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if ((x3 == 315) && (y3 == 565 || y3 == 285 || y3 == 145)) {
                                y3 -= 70;
                            } else if ((x3 == 245) && (y3 == 565 || y3 == 425 || y3 == 145)) {
                                x3 += 140;
                                y3 -= 70;
                            }


                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            } else if (x3 == 875 && y3 == 565) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 565) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 455 && y3 == 565) {
                                x3 += 210;
                                y3 -= 420;
                            } else if (x3 == 385 && y3 == 565) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 595 & y3 == 495) {
                                x3 += 280;
                                y3 += 140;
                            } else if (x3 == 315 && y3 == 495) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 385 && y3 == 425) {
                                x3 -= 70;
                                y3 -= 140;
                            } else if (x3 == 315 && y3 == 425) {
                                x3 += 210;
                                y3 += 210;
                            } else if (x3 == 805 && y3 == 355) {
                                x3 -= 140;
                                y3 -= 140;
                            } else if (x3 == 875 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 665 && y3 == 285) {
                                x3 -= 140;
                                y3 += 140;
                            } else if (x3 == 525 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 455 && y3 == 285) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 245 && y3 == 285) {
                                x3 += 140;
                                y3 += 210;
                            } else if (x3 == 245 && y3 == 215) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 145) {
                                x3 += 140;
                                y3 += 350;
                            } else if (x3 == 735 && y3 == 145) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 875 && y3 == 75) {
                                x3 -= 140;
                                y3 += 280;
                            } else if (x3 == 735 && y3 == 75) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 525 && y3 == 75) {
                                x3 -= 210;
                                y3 += 210;
                            } else if (x3 == 385 && y3 == 75) {
                                x3 += 140;
                                y3 += 280;
                            } else if (x3 == 245 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 805 && y3 == 5) {
                                x3 -= 280;
                                y3 += 490;
                            } else if (x3 == 455 && y3 == 5) {
                                x3 += 210;
                                y3 += 70;
                            } else if (x3 == 315 && y3 == 5) {
                                x3 += 70;
                                y3 += 210;
                            }


                            break;
                        case 4:
                            tx4.setText("4");
                            if (x3 < 665 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 280;
                            } else if (x3 == 665 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 210;
                                y3 -= 70;
                            } else if (x3 == 805 && (y3 == 635 || y3 == 495 || y3 == 215 || y3 == 75)) {
                                x3 -= 70;
                                y3 -= 70;
                            } else if (x3 == 875 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 -= 210;
                                y3 -= 70;
                            } else if (x3 == 735 && (y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 > 455 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145 || y3 == 5)) {
                                x3 -= 280;
                            } else if (x3 == 455 && (y3 == 425 || y3 == 145)) {
                                x3 -= 210;
                                y3 -= 70;
                            } else if (x3 == 385 && (y3 == 285 || y3 == 145)) {
                                x3 -= 70;
                                y3 -= 70;
                            } else if (x3 == 315 && (y3 == 565 || y3 == 285 || y3 == 145)) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 245 && (y3 == 565 || y3 == 425 || y3 == 145)) {
                                x3 += 210;
                                y3 -= 70;
                            }


                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            } else if (x3 == 875 && y3 == 565) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 565) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 455 && y3 == 565) {
                                x3 += 210;
                                y3 -= 420;
                            } else if (x3 == 385 && y3 == 565) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 595 & y3 == 495) {
                                x3 += 280;
                                y3 += 140;
                            } else if (x3 == 315 && y3 == 495) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 385 && y3 == 425) {
                                x3 -= 70;
                                y3 -= 140;
                            } else if (x3 == 315 && y3 == 425) {
                                x3 += 210;
                                y3 += 210;
                            } else if (x3 == 805 && y3 == 355) {
                                x3 -= 140;
                                y3 -= 140;
                            } else if (x3 == 875 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 665 && y3 == 285) {
                                x3 -= 140;
                                y3 += 140;
                            } else if (x3 == 525 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 455 && y3 == 285) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 245 && y3 == 285) {
                                x3 += 140;
                                y3 += 210;
                            } else if (x3 == 245 && y3 == 215) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 145) {
                                x3 += 140;
                                y3 += 350;
                            } else if (x3 == 735 && y3 == 145) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 875 && y3 == 75) {
                                x3 -= 140;
                                y3 += 280;
                            } else if (x3 == 735 && y3 == 75) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 525 && y3 == 75) {
                                x3 -= 210;
                                y3 += 210;
                            } else if (x3 == 385 && y3 == 75) {
                                x3 += 140;
                                y3 += 280;
                            } else if (x3 == 245 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 805 && y3 == 5) {
                                x3 -= 280;
                                y3 += 490;
                            } else if (x3 == 455 && y3 == 5) {
                                x3 += 210;
                                y3 += 70;
                            } else if (x3 == 315 && y3 == 5) {
                                x3 += 70;
                                y3 += 210;
                            }


                            break;
                        case 5:
                            tx4.setText("5");
                            if (x3 < 595 && ((y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75))) {
                                x3 += 350;
                            } else if (x3 == 595 && (y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 280;
                                y3 -= 70;
                            } else if (x3 == 665 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 735 && (y3 == 495 || y3 == 355 || y3 == 215)) {
                                y3 -= 70;
                            } else if (x3 == 805 && (y3 == 635 || y3 == 495 || y3 == 215 || y3 == 75)) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 875 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 -= 280;
                                y3 -= 70;
                            } else if (x3 > 525 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145 || y3 == 5)) {
                                x3 -= 350;
                            } else if (x3 == 525 && (y3 == 565 || y3 == 425 || y3 == 145)) {
                                x3 -= 280;
                                y3 -= 70;
                            } else if (x3 == 455 && (y3 == 425 || y3 == 145)) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 385 && (y3 == 285 || y3 == 145)) {
                                y3 -= 70;
                            } else if (x3 == 315 && (y3 == 565 || y3 == 285 || y3 == 145)) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 245 && (y3 == 565 || y3 == 425 || y3 == 145)) {
                                x3 += 280;
                                y3 -= 70;
                            }

                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            } else if (x3 == 875 && y3 == 565) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 565) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 455 && y3 == 565) {
                                x3 += 210;
                                y3 -= 420;
                            } else if (x3 == 385 && y3 == 565) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 595 & y3 == 495) {
                                x3 += 280;
                                y3 += 140;
                            } else if (x3 == 315 && y3 == 495) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 385 && y3 == 425) {
                                x3 -= 70;
                                y3 -= 140;
                            } else if (x3 == 315 && y3 == 425) {
                                x3 += 210;
                                y3 += 210;
                            } else if (x3 == 805 && y3 == 355) {
                                x3 -= 140;
                                y3 -= 140;
                            } else if (x3 == 875 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 665 && y3 == 285) {
                                x3 -= 140;
                                y3 += 140;
                            } else if (x3 == 525 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 455 && y3 == 285) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 245 && y3 == 285) {
                                x3 += 140;
                                y3 += 210;
                            } else if (x3 == 245 && y3 == 215) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 145) {
                                x3 += 140;
                                y3 += 350;
                            } else if (x3 == 735 && y3 == 145) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 875 && y3 == 75) {
                                x3 -= 140;
                                y3 += 280;
                            } else if (x3 == 735 && y3 == 75) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 525 && y3 == 75) {
                                x3 -= 210;
                                y3 += 210;
                            } else if (x3 == 385 && y3 == 75) {
                                x3 += 140;
                                y3 += 280;
                            } else if (x3 == 245 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 805 && y3 == 5) {
                                x3 -= 280;
                                y3 += 490;
                            } else if (x3 == 455 && y3 == 5) {
                                x3 += 210;
                                y3 += 70;
                            } else if (x3 == 315 && y3 == 5) {
                                x3 += 70;
                                y3 += 210;
                            }


                            break;
                        case 6:
                            tx4.setText("6");
                            if (x3 < 525 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 420;
                            } else if (x3 == 525 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 += 350;
                                y3 -= 70;
                            } else if (x3 == 595 && (y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 210;
                                y3 -= 70;
                            } else if (x3 == 665 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215 || y3 == 75)) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && (y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 -= 70;
                                y3 -= 70;
                            } else if (x3 == 805 && (y3 == 635 || y3 == 495 || y3 == 215 || y3 == 75)) {
                                x3 -= 210;
                                y3 -= 70;
                            } else if (x3 == 875 && (y3 == 635 || y3 == 495 || y3 == 355 || y3 == 215)) {
                                x3 -= 350;
                                y3 -= 70;
                            } else if (x3 > 595 && (y3 == 565 || y3 == 425 || y3 == 285 || y3 == 145 || y3 == 5)) {
                                x3 -= 420;
                            } else if (x3 == 245 && (y3 == 565 || y3 == 425 || y3 == 145)) {
                                x3 += 350;
                                y3 -= 70;
                            } else if (x3 == 315 && (y3 == 565 || y3 == 285 || y3 == 145)) {
                                x3 += 210;
                                y3 -= 70;
                            } else if (x3 == 385 && (y3 == 285 || y3 == 145)) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 455 && (y3 == 425 || y3 == 145)) {
                                x3 -= 70;
                                y3 -= 70;
                            } else if (x3 == 525 && (y3 == 565 || y3 == 425 || y3 == 145)) {
                                x3 -= 210;
                                y3 -= 70;
                            } else if (x3 == 595 && (y3 == 425 || y3 == 285)) {
                                x3 -= 350;
                                y3 -= 70;
                            }


                            if (x3 == 385 && y3 == 635) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 635) {
                                x3 += 70;
                                y3 -= 70;
                            } else if (x3 == 735 && y3 == 635) {
                                x3 -= 280;
                            } else if (x3 == 875 && y3 == 565) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 565) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 455 && y3 == 565) {
                                x3 += 210;
                                y3 -= 420;
                            } else if (x3 == 385 && y3 == 565) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 595 & y3 == 495) {
                                x3 += 280;
                                y3 += 140;
                            } else if (x3 == 315 && y3 == 495) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 385 && y3 == 425) {
                                x3 -= 70;
                                y3 -= 140;
                            } else if (x3 == 315 && y3 == 425) {
                                x3 += 210;
                                y3 += 210;
                            } else if (x3 == 805 && y3 == 355) {
                                x3 -= 140;
                                y3 -= 140;
                            } else if (x3 == 875 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 665 && y3 == 285) {
                                x3 -= 140;
                                y3 += 140;
                            } else if (x3 == 525 && y3 == 285) {
                                x3 -= 280;
                                y3 += 350;
                            } else if (x3 == 455 && y3 == 285) {
                                x3 += 70;
                                y3 -= 140;
                            } else if (x3 == 245 && y3 == 285) {
                                x3 += 140;
                                y3 += 210;
                            } else if (x3 == 245 && y3 == 215) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 595 && y3 == 145) {
                                x3 += 140;
                                y3 += 350;
                            } else if (x3 == 735 && y3 == 145) {
                                x3 -= 140;
                                y3 += 70;
                            } else if (x3 == 875 && y3 == 75) {
                                x3 -= 140;
                                y3 += 280;
                            } else if (x3 == 735 && y3 == 75) {
                                x3 -= 140;
                                y3 -= 70;
                            } else if (x3 == 525 && y3 == 75) {
                                x3 -= 210;
                                y3 += 210;
                            } else if (x3 == 385 && y3 == 75) {
                                x3 += 140;
                                y3 += 280;
                            } else if (x3 == 245 && y3 == 75) {
                                x3 += 140;
                                y3 -= 70;
                            } else if (x3 == 805 && y3 == 5) {
                                x3 -= 280;
                                y3 += 490;
                            } else if (x3 == 455 && y3 == 5) {
                                x3 += 210;
                                y3 += 70;
                            } else if (x3 == 315 && y3 == 5) {
                                x3 += 70;
                                y3 += 210;
                            }


                            break;
                    }
                    if (x3 == 245 && y3 == 5) {
                        l3.setText(s4 + " WON");
                        l3.setBackground(Color.black);
                        l3.setForeground(Color.red);
                        l3.setOpaque(true);
                        l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        l3.setHorizontalAlignment(SwingConstants.CENTER);
                        l3.setBounds(220, 300, 700, 100);
//                    b3.setEnabled(false);
                        l3.setFont(new Font("Arial", Font.BOLD, 70));
                        l3.setVisible(true);
                        add(l3);


                    }
                    repaint();
//            System.out.println(random);
                    if (s3 == "3 Players") {
                        chance = 1;
                    } else if (s3 == "4 Players") {
                        chance = 4;
                    }
                    // tx6.setBackground(Color.black);
                    // tx6.setVisible(true);
                } else if (chance == 4) {
                    // tx6.setBackground(Color.white);
                    // tx6.setForeground(Color.black);
                    // tx6.setVisible(true);

                    tx6.setBackground(Color.black);
                    tx6.setForeground(Color.green);
                    tx6.setVisible(true);

                        tx2.setBackground(Color.white);
                    tx2.setForeground(Color.black);
                    tx2.setVisible(true);
                    

                    switch (random) {
                        case 1:
                            tx4.setText("1");
                            if ((x4 < 860) && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 70;
                            } else if (x4 == 860 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
//                        x4 -= 70;
                                //860 Ladder()
                                y4 -= 70;
                            } else if (x4 > 230 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145 || y4 == 5)) {
                                x4 -= 70;
                            } else if (x4 == 230 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145)) {
                                y4 -= 70;
                            }

                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            }
                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            } else if (x4 == 860 && y4 == 565) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 565) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 440 && y4 == 565) {
                                x4 += 210;
                                y4 -= 420;
                            } else if (x4 == 370 && y4 == 565) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 580 & y4 == 495) {
                                x4 += 280;
                                y4 += 140;
                            } else if (x4 == 300 && y4 == 495) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 370 && y4 == 425) {
                                x4 -= 70;
                                y4 -= 140;
                            } else if (x4 == 300 && y4 == 425) {
                                x4 += 210;
                                y4 += 210;
                            } else if (x4 == 790 && y4 == 355) {
                                x4 -= 140;
                                y4 -= 140;
                            } else if (x4 == 860 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 650 && y4 == 285) {
                                x4 -= 140;
                                y4 += 140;
                            } else if (x4 == 510 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 440 && y4 == 285) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 230 && y4 == 285) {
                                x4 += 140;
                                y4 += 210;
                            } else if (x4 == 230 && y4 == 215) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 145) {
                                x4 += 140;
                                y4 += 350;
                            } else if (x4 == 720 && y4 == 145) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 860 && y4 == 75) {
                                x4 -= 140;
                                y4 += 280;
                            } else if (x4 == 720 && y4 == 75) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 510 && y4 == 75) {
                                x4 -= 210;
                                y4 += 210;
                            } else if (x4 == 370 && y4 == 75) {
                                x4 += 140;
                                y4 += 280;
                            } else if (x4 == 230 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 790 && y4 == 5) {
                                x4 -= 280;
                                y4 += 490;
                            } else if (x4 == 440 && y4 == 5) {
                                x4 += 210;
                                y4 += 70;
                            } else if (x4 == 300 && y4 == 5) {
                                x4 += 70;
                                y4 += 210;
                            }


                            break;
                        case 2:
                            tx4.setText("2");
                            if ((x4 < 790) && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 140;
                            } else if (x4 > 300 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145 || y4 == 5)) {
                                x4 -= 140;
                            } else if (x4 == 790 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 860 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 -= 70;
                                y4 -= 70;
                            } else if (x4 == 230 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145)) {
                                y4 -= 70;
                                x4 += 70;
                            } else if (x4 == 300 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145)) {
                                x4 -= 70;
                                y4 -= 70;
                            }

                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            }
                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            } else if (x4 == 860 && y4 == 565) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 565) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 440 && y4 == 565) {
                                x4 += 210;
                                y4 -= 420;
                            } else if (x4 == 370 && y4 == 565) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 580 & y4 == 495) {
                                x4 += 280;
                                y4 += 140;
                            } else if (x4 == 300 && y4 == 495) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 370 && y4 == 425) {
                                x4 -= 70;
                                y4 -= 140;
                            } else if (x4 == 300 && y4 == 425) {
                                x4 += 210;
                                y4 += 210;
                            } else if (x4 == 790 && y4 == 355) {
                                x4 -= 140;
                                y4 -= 140;
                            } else if (x4 == 860 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 650 && y4 == 285) {
                                x4 -= 140;
                                y4 += 140;
                            } else if (x4 == 510 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 440 && y4 == 285) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 230 && y4 == 285) {
                                x4 += 140;
                                y4 += 210;
                            } else if (x4 == 230 && y4 == 215) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 145) {
                                x4 += 140;
                                y4 += 350;
                            } else if (x4 == 720 && y4 == 145) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 860 && y4 == 75) {
                                x4 -= 140;
                                y4 += 280;
                            } else if (x4 == 720 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 510 && y4 == 75) {
                                x4 -= 210;
                                y4 += 210;
                            } else if (x4 == 370 && y4 == 75) {
                                x4 += 140;
                                y4 += 280;
                            } else if (x4 == 230 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 790 && y4 == 5) {
                                x4 -= 280;
                                y4 += 490;
                            } else if (x4 == 440 && y4 == 5) {
                                x4 += 210;
                                y4 += 70;
                            } else if (x4 == 300 && y4 == 5) {
                                x4 += 70;
                                y4 += 210;
                            }
                            break;
                        case 3:
                            tx4.setText("3");
                            if (x4 < 720 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 210;
                            } else if ((x4 == 790) && (y4 == 635 || y4 == 495 || y4 == 215 || y4 == 75)) {
//                        x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 860 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 720 && (y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 > 370 && (y4 == 565 || y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145 || y4 == 5)) {
                                x4 -= 210;
                            } else if ((x4 == 370) && (y4 == 285 || y4 == 145)) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if ((x4 == 300) && (y4 == 565 || y4 == 285 || y4 == 145)) {
                                y4 -= 70;
                            } else if ((x4 == 230) && (y4 == 565 || y4 == 425 || y4 == 145)) {
                                x4 += 140;
                                y4 -= 70;
                            }


                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            } else if (x4 == 860 && y4 == 565) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 565) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 440 && y4 == 565) {
                                x4 += 210;
                                y4 -= 420;
                            } else if (x4 == 370 && y4 == 565) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 580 & y4 == 495) {
                                x4 += 280;
                                y4 += 140;
                            } else if (x4 == 300 && y4 == 495) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 370 && y4 == 425) {
                                x4 -= 70;
                                y4 -= 140;
                            } else if (x4 == 300 && y4 == 425) {
                                x4 += 210;
                                y4 += 210;
                            } else if (x4 == 790 && y4 == 355) {
                                x4 -= 140;
                                y4 -= 140;
                            } else if (x4 == 860 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 650 && y4 == 285) {
                                x4 -= 140;
                                y4 += 140;
                            } else if (x4 == 510 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 440 && y4 == 285) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 230 && y4 == 285) {
                                x4 += 140;
                                y4 += 210;
                            } else if (x4 == 230 && y4 == 215) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 145) {
                                x4 += 140;
                                y4 += 350;
                            } else if (x4 == 720 && y4 == 145) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 860 && y4 == 75) {
                                x4 -= 140;
                                y4 += 280;
                            } else if (x4 == 720 && y4 == 75) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 510 && y4 == 75) {
                                x4 -= 210;
                                y4 += 210;
                            } else if (x4 == 370 && y4 == 75) {
                                x4 += 140;
                                y4 += 280;
                            } else if (x4 == 230 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 790 && y4 == 5) {
                                x4 -= 280;
                                y4 += 490;
                            } else if (x4 == 440 && y4 == 5) {
                                x4 += 210;
                                y4 += 70;
                            } else if (x4 == 300 && y4 == 5) {
                                x4 += 70;
                                y4 += 210;
                            }


                            break;
                        case 4:
                            tx4.setText("4");
                            if (x4 < 650 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 280;
                            } else if (x4 == 650 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 210;
                                y4 -= 70;
                            } else if (x4 == 790 && (y4 == 635 || y4 == 495 || y4 == 215 || y4 == 75)) {
                                x4 -= 70;
                                y4 -= 70;
                            } else if (x4 == 860 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 -= 210;
                                y4 -= 70;
                            } else if (x4 == 720 && (y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 > 440 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145 || y4 == 5)) {
                                x4 -= 280;
                            } else if (x4 == 440 && (y4 == 425 || y4 == 145)) {
                                x4 -= 210;
                                y4 -= 70;
                            } else if (x4 == 370 && (y4 == 285 || y4 == 145)) {
                                x4 -= 70;
                                y4 -= 70;
                            } else if (x4 == 300 && (y4 == 565 || y4 == 285 || y4 == 145)) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 230 && (y4 == 565 || y4 == 425 || y4 == 145)) {
                                x4 += 210;
                                y4 -= 70;
                            }


                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            } else if (x4 == 860 && y4 == 565) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 565) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 440 && y4 == 565) {
                                x4 += 210;
                                y4 -= 420;
                            } else if (x4 == 370 && y4 == 565) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 580 & y4 == 495) {
                                x4 += 280;
                                y4 += 140;
                            } else if (x4 == 300 && y4 == 495) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 370 && y4 == 425) {
                                x4 -= 70;
                                y4 -= 140;
                            } else if (x4 == 300 && y4 == 425) {
                                x4 += 210;
                                y4 += 210;
                            } else if (x4 == 790 && y4 == 355) {
                                x4 -= 140;
                                y4 -= 140;
                            } else if (x4 == 860 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 650 && y4 == 285) {
                                x4 -= 140;
                                y4 += 140;
                            } else if (x4 == 510 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 440 && y4 == 285) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 230 && y4 == 285) {
                                x4 += 140;
                                y4 += 210;
                            } else if (x4 == 230 && y4 == 215) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 145) {
                                x4 += 140;
                                y4 += 350;
                            } else if (x4 == 720 && y4 == 145) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 860 && y4 == 75) {
                                x4 -= 140;
                                y4 += 280;
                            } else if (x4 == 720 && y4 == 75) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 510 && y4 == 75) {
                                x4 -= 210;
                                y4 += 210;
                            } else if (x4 == 370 && y4 == 75) {
                                x4 += 140;
                                y4 += 280;
                            } else if (x4 == 230 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 790 && y4 == 5) {
                                x4 -= 280;
                                y4 += 490;
                            } else if (x4 == 440 && y4 == 5) {
                                x4 += 210;
                                y4 += 70;
                            } else if (x4 == 300 && y4 == 5) {
                                x4 += 70;
                                y4 += 210;
                            }


                            break;
                        case 5:
                            tx4.setText("5");
                            if (x4 < 580 && ((y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75))) {
                                x4 += 350;
                            } else if (x4 == 580 && (y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 280;
                                y4 -= 70;
                            } else if (x4 == 650 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 720 && (y4 == 495 || y4 == 355 || y4 == 215)) {
                                y4 -= 70;
                            } else if (x4 == 790 && (y4 == 635 || y4 == 495 || y4 == 215 || y4 == 75)) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 860 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 -= 280;
                                y4 -= 70;
                            } else if (x4 > 510 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145 || y4 == 5)) {
                                x4 -= 350;
                            } else if (x4 == 510 && (y4 == 565 || y4 == 425 || y4 == 145)) {
                                x4 -= 280;
                                y4 -= 70;
                            } else if (x4 == 440 && (y4 == 425 || y4 == 145)) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 370 && (y4 == 285 || y4 == 145)) {
                                y4 -= 70;
                            } else if (x4 == 300 && (y4 == 565 || y4 == 285 || y4 == 145)) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 230 && (y4 == 565 || y4 == 425 || y4 == 145)) {
                                x4 += 280;
                                y4 -= 70;
                            }

                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            } else if (x4 == 860 && y4 == 565) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 565) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 440 && y4 == 565) {
                                x4 += 210;
                                y4 -= 420;
                            } else if (x4 == 370 && y4 == 565) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 580 & y4 == 495) {
                                x4 += 280;
                                y4 += 140;
                            } else if (x4 == 300 && y4 == 495) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 370 && y4 == 425) {
                                x4 -= 70;
                                y4 -= 140;
                            } else if (x4 == 300 && y4 == 425) {
                                x4 += 210;
                                y4 += 210;
                            } else if (x4 == 790 && y4 == 355) {
                                x4 -= 140;
                                y4 -= 140;
                            } else if (x4 == 860 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 650 && y4 == 285) {
                                x4 -= 140;
                                y4 += 140;
                            } else if (x4 == 510 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 440 && y4 == 285) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 230 && y4 == 285) {
                                x4 += 140;
                                y4 += 210;
                            } else if (x4 == 230 && y4 == 215) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 145) {
                                x4 += 140;
                                y4 += 350;
                            } else if (x4 == 720 && y4 == 145) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 860 && y4 == 75) {
                                x4 -= 140;
                                y4 += 280;
                            } else if (x4 == 720 && y4 == 75) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 510 && y4 == 75) {
                                x4 -= 210;
                                y4 += 210;
                            } else if (x4 == 370 && y4 == 75) {
                                x4 += 140;
                                y4 += 280;
                            } else if (x4 == 230 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 790 && y4 == 5) {
                                x4 -= 280;
                                y4 += 490;
                            } else if (x4 == 440 && y4 == 5) {
                                x4 += 210;
                                y4 += 70;
                            } else if (x4 == 300 && y4 == 5) {
                                x4 += 70;
                                y4 += 210;
                            }


                            break;
                        case 6:
                            tx4.setText("6");
                            if (x4 < 510 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 420;
                            } else if (x4 == 510 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 += 350;
                                y4 -= 70;
                            } else if (x4 == 580 && (y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 210;
                                y4 -= 70;
                            } else if (x4 == 650 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215 || y4 == 75)) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && (y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 -= 70;
                                y4 -= 70;
                            } else if (x4 == 790 && (y4 == 635 || y4 == 495 || y4 == 215 || y4 == 75)) {
                                x4 -= 210;
                                y4 -= 70;
                            } else if (x4 == 860 && (y4 == 635 || y4 == 495 || y4 == 355 || y4 == 215)) {
                                x4 -= 350;
                                y4 -= 70;
                            } else if (x4 > 580 && (y4 == 565 || y4 == 425 || y4 == 285 || y4 == 145 || y4 == 5)) {
                                x4 -= 420;
                            } else if (x4 == 230 && (y4 == 565 || y4 == 425 || y4 == 145)) {
                                x4 += 350;
                                y4 -= 70;
                            } else if (x4 == 300 && (y4 == 565 || y4 == 285 || y4 == 145)) {
                                x4 += 210;
                                y4 -= 70;
                            } else if (x4 == 370 && (y4 == 285 || y4 == 145)) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 440 && (y4 == 425 || y4 == 145)) {
                                x4 -= 70;
                                y4 -= 70;
                            } else if (x4 == 510 && (y4 == 565 || y4 == 425 || y4 == 145)) {
                                x4 -= 210;
                                y4 -= 70;
                            } else if (x4 == 580 && (y4 == 425 || y4 == 285)) {
                                x4 -= 350;
                                y4 -= 70;
                            }


                            if (x4 == 370 && y4 == 635) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 635) {
                                x4 += 70;
                                y4 -= 70;
                            } else if (x4 == 720 && y4 == 635) {
                                x4 -= 280;
                            } else if (x4 == 860 && y4 == 565) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 565) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 440 && y4 == 565) {
                                x4 += 210;
                                y4 -= 420;
                            } else if (x4 == 370 && y4 == 565) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 580 & y4 == 495) {
                                x4 += 280;
                                y4 += 140;
                            } else if (x4 == 300 && y4 == 495) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 370 && y4 == 425) {
                                x4 -= 70;
                                y4 -= 140;
                            } else if (x4 == 300 && y4 == 425) {
                                x4 += 210;
                                y4 += 210;
                            } else if (x4 == 790 && y4 == 355) {
                                x4 -= 140;
                                y4 -= 140;
                            } else if (x4 == 860 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 650 && y4 == 285) {
                                x4 -= 140;
                                y4 += 140;
                            } else if (x4 == 510 && y4 == 285) {
                                x4 -= 280;
                                y4 += 350;
                            } else if (x4 == 440 && y4 == 285) {
                                x4 += 70;
                                y4 -= 140;
                            } else if (x4 == 230 && y4 == 285) {
                                x4 += 140;
                                y4 += 210;
                            } else if (x4 == 230 && y4 == 215) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 580 && y4 == 145) {
                                x4 += 140;
                                y4 += 350;
                            } else if (x4 == 720 && y4 == 145) {
                                x4 -= 140;
                                y4 += 70;
                            } else if (x4 == 860 && y4 == 75) {
                                x4 -= 140;
                                y4 += 280;
                            } else if (x4 == 720 && y4 == 75) {
                                x4 -= 140;
                                y4 -= 70;
                            } else if (x4 == 510 && y4 == 75) {
                                x4 -= 210;
                                y4 += 210;
                            } else if (x4 == 370 && y4 == 75) {
                                x4 += 140;
                                y4 += 280;
                            } else if (x4 == 230 && y4 == 75) {
                                x4 += 140;
                                y4 -= 70;
                            } else if (x4 == 790 && y4 == 5) {
                                x4 -= 280;
                                y4 += 490;
                            } else if (x4 == 440 && y4 == 5) {
                                x4 += 210;
                                y4 += 70;
                            } else if (x4 == 300 && y4 == 5) {
                                x4 += 70;
                                y4 += 210;
                            }


                            break;
                    }
                    if (x4 == 230 && y4 == 5) {
                        l3.setText(s5 + " WON");
                        l3.setBackground(Color.black);
                        l3.setForeground(Color.red);
                        l3.setOpaque(true);
                        l3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        l3.setHorizontalAlignment(SwingConstants.CENTER);
                        l3.setBounds(220, 300, 700, 100);
//                    b3.setEnabled(false);
                        l3.setFont(new Font("Arial", Font.BOLD, 70));
                        l3.setVisible(true);
                        add(l3);
                    }
                    chance = 1;
                    repaint();


                }

            }
        }
    }
}
 
class SnakeLadder {
    public static void main(String[] args) {
        FSnakeLadder f = new FSnakeLadder();
        f.setVisible(true);
        f.setBounds(200, 10, 990, 735);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }
}