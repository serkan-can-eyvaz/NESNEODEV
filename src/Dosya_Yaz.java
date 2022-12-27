import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dosya_Yaz {
    public JComponent frame;
    private JTextField txtAdSoyad;
        private JTextField txtNumara;
        private JTextField txtBolum;
        private JTextField txtDosyaAdı;
        public  Dosya_Yaz()
        {
            initialize();
        }
        private void initialize()
        {
            JFrame frame = new JFrame();
            frame.setBounds(100,100,450,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.getContentPane().setLayout(null);
            JLabel lblAdSoyad = new JLabel("Ad\u0131 Soyad\u0131");
            lblAdSoyad.setBounds(10, 46, 107, 24);
            frame.getContentPane().add(lblAdSoyad);
            JLabel lblNumara = new JLabel("Numaras\u0131");
            lblNumara.setBounds(10, 73, 107, 24);
            frame.getContentPane().add(lblNumara);
            JLabel lblBolum = new JLabel("B\u00F6l\u00FCm\u00FC");
            lblBolum.setBounds(10, 103, 107, 24);
            frame.getContentPane().add(lblBolum);
            txtAdSoyad = new JTextField();
            txtAdSoyad.setBounds(127, 44, 143, 24);
            frame.getContentPane().add(txtAdSoyad);
            txtAdSoyad.setColumns(10);
            txtNumara = new JTextField();
            txtNumara.setBounds(127, 75, 86, 22);
            frame.getContentPane().add(txtNumara);
            txtNumara.setColumns(10);
            final JLabel lblMesaj = new JLabel("");
            lblMesaj.setForeground(Color.RED);
            lblMesaj.setHorizontalAlignment(SwingConstants.CENTER);
            lblMesaj.setBounds(127, 193, 266, 22);
            frame.getContentPane().add(lblMesaj);
            txtBolum = new JTextField();
            txtBolum.setBounds(127, 105, 258, 22);
            frame.getContentPane().add(txtBolum);
            txtBolum.setColumns(10);
            JButton btnTemizle = new JButton("Temizle");
                    btnTemizle.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            txtDosyaAdı.setText("");
                                    txtAdSoyad.setText("");
                                            txtNumara.setText("");
                                                    txtBolum.setText("");
                                                            lblMesaj.setText("");
                        }
                    });
            btnTemizle.setBounds(124, 138, 89, 23);
            frame.getContentPane().add(btnTemizle);
            JButton btnDosyayaYaz = new JButton("Dosyaya Yaz");
                    btnDosyayaYaz.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent arg0)
                        {
                            // String adSoyad=txtAdSoyad.getText();
                            // String numara=txtNumara.getText();
                            // String bolum=txtBolum.getText();
                            String str=txtAdSoyad.getText() + "#" + txtNumara.getText() + "#" + txtBolum.getText();
                            String dosyaAdi=txtDosyaAdı.getText();
                            File dosya = new File(dosyaAdi);
                            if(dosya.exists())
                            {
                                try
                                {
                                    dosyaYaz(dosyaAdi, str, true);
                                }
                                catch (IOException e)
                                {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                lblMesaj.setText("Yazma İşlemi Başarılı");
                            }
                            else
                            {
                                try {
                                    dosyaYaz(dosyaAdi, str, false);
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                lblMesaj.setText("Yazma İşlemi Başarılı");
                            }
                        }
                    });
            btnDosyayaYaz.setBounds(225, 138, 107, 23);
            frame.getContentPane().add(btnDosyayaYaz);
            JLabel lblDosyaAd = new JLabel("Dosya Ad\u0131");
            lblDosyaAd.setBackground(Color.CYAN);
            lblDosyaAd.setBounds(10, 11, 107, 24);
            frame.getContentPane().add(lblDosyaAd);
            txtDosyaAdı = new JTextField();
            txtDosyaAdı.setBackground(Color.CYAN);
            txtDosyaAdı.setBounds(127, 13, 143, 24);
            frame.getContentPane().add(txtDosyaAdı);
            txtDosyaAdı.setColumns(10);
        }
        private static void dosyaYaz(String dosyaAdi, String str,boolean uzerineYaz ) throws IOException
        {
            FileWriter f = new FileWriter(dosyaAdi, uzerineYaz);
          BufferedWriter out = new BufferedWriter(f);
            out.write(str);
            out.newLine();
            out.close();
            f.close();
        }
    }


