import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class TugasPP2 extends JFrame {

    private JTextField textNama, textNomor;
    private JRadioButton radioButton1, radioButton2;
    private JCheckBox checkBox;
    private JList<String> listTabungan;
    private JTextArea txtOutput;
    private JSlider sliderTransaksi;
    private JLabel labelSliderValue;
    private JPasswordField passwordField, confirmPasswordField;
    private JSpinner dateSpinner;

    public TugasPP2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textNama.setText("");
                textNomor.setText("");
                listTabungan.clearSelection();
                txtOutput.setText("");
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                checkBox.setSelected(false);
                sliderTransaksi.setValue(1);
                labelSliderValue.setText("1");
                passwordField.setText("");
                confirmPasswordField.setText("");
                dateSpinner.setValue(new Date());
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        textNama = new JTextField();
        textNama.setBounds(15, 60, 350, 30);

        JLabel labelNomor = new JLabel("Nomor HP: ");
        labelNomor.setBounds(15, 105, 350, 10);

        textNomor = new JTextField();
        textNomor.setBounds(15, 130, 350, 30);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir: ");
        labelTanggalLahir.setBounds(15, 175, 350, 20);

        SpinnerDateModel model = new SpinnerDateModel();
        dateSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(editor);
        dateSpinner.setBounds(15, 200, 150, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin: ");
        labelRadio.setBounds(15, 250, 100, 20);

        radioButton1 = new JRadioButton("Laki-Laki");
        radioButton1.setBounds(15, 275, 80, 30);

        radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 310, 95, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 350, 145, 30);

        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(220, 250, 350, 20);

        String[] jenisTabungan = { "Tabungan Reguler", "Tabungan Pendidikan", "Tabungan Bisnis", "Tabungan Investasi",
                "Tabungan Konvensional", "Tabungan Giro" };
        listTabungan = new JList<>(jenisTabungan);
        listTabungan.setVisibleRowCount(4);

        JScrollPane scrollTabungan = new JScrollPane(listTabungan);
        scrollTabungan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTabungan.setBounds(220, 280, 200, 75);

        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelFrekuensi.setBounds(15, 405, 200, 20);

        sliderTransaksi = new JSlider(1, 100, 1);
        sliderTransaksi.setMajorTickSpacing(10);
        sliderTransaksi.setMinorTickSpacing(1);
        sliderTransaksi.setPaintTicks(true);
        sliderTransaksi.setPaintLabels(true);
        sliderTransaksi.setBounds(15, 430, 300, 50);

        labelSliderValue = new JLabel("1");
        labelSliderValue.setBounds(320, 430, 50, 30);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(15, 490, 100, 20);
        passwordField = new JPasswordField();
        passwordField.setBounds(15, 510, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password: ");
        labelConfirmPassword.setBounds(15, 550, 150, 20);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 570, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 610, 100, 40);

        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 660, 450, 150);

        sliderTransaksi.addChangeListener(e -> {
            labelSliderValue.setText(String.valueOf(sliderTransaksi.getValue()));
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                String nama = textNama.getText();
                String nomor = textNomor.getText();
                String jenisTabunganTerpilih = listTabungan.getSelectedValue();
                int frekuensiTransaksi = sliderTransaksi.getValue();

                Date tanggalLahir = (Date) dateSpinner.getValue();

                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                txtOutput.setText("");
                txtOutput.append("Nama                      :" + nama + "\n");
                txtOutput.append("Nomor HP              :" + nomor + "\n");
                txtOutput.append("Tanggal Lahir         :"
                        + new java.text.SimpleDateFormat("dd/MM/yyyy").format(tanggalLahir) + "\n");
                txtOutput.append("Jenis Kelamin       :" + jenisKelamin + "\n");
                txtOutput.append("WNA                        :");
                if (checkBox.isSelected()) {
                    txtOutput.append("Ya \n");
                } else {
                    txtOutput.append("Bukan \n");
                }
                if (jenisTabunganTerpilih != null) {
                    txtOutput.append("Jenis Tabungan    : " + jenisTabunganTerpilih + "\n");
                } else {
                    txtOutput.append("Jenis Tabungan    : Belum dipilih\n");
                }
                txtOutput.append("Frekuensi Transaksi : " + frekuensiTransaksi + "\n");

                if (password.equals(confirmPassword)) {
                    txtOutput.append("Password cocok.\n");
                } else {
                    txtOutput.append("Password tidak cocok.\n");
                }

                txtOutput.append("===========================================\n");
                textNama.setText("");
                textNomor.setText("");
                listTabungan.clearSelection();
                sliderTransaksi.setValue(1);
                labelSliderValue.setText("1");
                passwordField.setText("");
                confirmPasswordField.setText("");
                dateSpinner.setValue(new Date());
            }
        });

        this.add(button);
        this.add(textNama);
        this.add(textNomor);
        this.add(labelTanggalLahir);
        this.add(dateSpinner);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelNama);
        this.add(labelNomor);
        this.add(labelTabungan);
        this.add(scrollTabungan);
        this.add(labelFrekuensi);
        this.add(sliderTransaksi);
        this.add(labelSliderValue);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(txtOutput);

        this.setSize(500, 900);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TugasPP2 h = new TugasPP2();
                h.setVisible(true);
            }
        });
    }
}
