import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AplikasiStudiKasus extends JFrame {

    private JTextField txtNama;
    private JTextArea txtAlamat;
    private JRadioButton rbLaki, rbPerempuan;
    private JCheckBox cbProgramming, cbDesain, cbSeni;
    private JComboBox<String> cbKota;
    private JList<String> listPendidikan;
    private JSlider sliderUsia;
    private JSpinner spinnerPengalaman;
    private JTable tableData;
    private DefaultTableModel tableModel;

    public AplikasiStudiKasus() {
        setTitle("Aplikasi Studi Kasus");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(e -> System.exit(0));
        menuFile.add(menuExit);
        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        JPanel panelUtama = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelUtama.add(new JLabel("Nama:"), gbc);

        gbc.gridx = 1;
        txtNama = new JTextField(20);
        panelUtama.add(txtNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelUtama.add(new JLabel("Alamat:"), gbc);

        gbc.gridx = 1;
        txtAlamat = new JTextArea(3, 20);
        panelUtama.add(new JScrollPane(txtAlamat), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelUtama.add(new JLabel("Gender:"), gbc);

        gbc.gridx = 1;
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbLaki);
        bgGender.add(rbPerempuan);
        JPanel panelGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);
        panelUtama.add(panelGender, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelUtama.add(new JLabel("Minat:"), gbc);

        gbc.gridx = 1;
        cbProgramming = new JCheckBox("Programming");
        cbDesain = new JCheckBox("Desain");
        cbSeni = new JCheckBox("Seni");
        JPanel panelMinat = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelMinat.add(cbProgramming);
        panelMinat.add(cbDesain);
        panelMinat.add(cbSeni);
        panelUtama.add(panelMinat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelUtama.add(new JLabel("Kota:"), gbc);

        gbc.gridx = 1;
        cbKota = new JComboBox<>(new String[] { "Jakarta", "Bandung", "Surabaya", "Yogyakarta" });
        panelUtama.add(cbKota, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelUtama.add(new JLabel("Pendidikan:"), gbc);

        gbc.gridx = 1;
        listPendidikan = new JList<>(new String[] { "SD", "SMP", "SMA", "D3", "S1", "S2" });
        listPendidikan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelUtama.add(new JScrollPane(listPendidikan), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panelUtama.add(new JLabel("Usia:"), gbc);

        gbc.gridx = 1;
        sliderUsia = new JSlider(15, 60, 25);
        sliderUsia.setMajorTickSpacing(5);
        sliderUsia.setPaintTicks(true);
        sliderUsia.setPaintLabels(true);
        panelUtama.add(sliderUsia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panelUtama.add(new JLabel("Pengalaman (tahun):"), gbc);

        gbc.gridx = 1;
        spinnerPengalaman = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
        panelUtama.add(spinnerPengalaman, gbc);

        JPanel panelTombol = new JPanel();
        JButton btnTambah = new JButton("Tambah");
        btnTambah.addActionListener(new TambahDataAction());
        panelTombol.add(btnTambah);

        tableModel = new DefaultTableModel(
                new Object[] { "Nama", "Alamat", "Gender", "Minat", "Kota", "Pendidikan", "Usia", "Pengalaman" }, 0);
        tableData = new JTable(tableModel);
        JScrollPane scrollTable = new JScrollPane(tableData);

        add(panelUtama, BorderLayout.NORTH);
        add(panelTombol, BorderLayout.CENTER);
        add(scrollTable, BorderLayout.SOUTH);
    }

    private class TambahDataAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = txtNama.getText();
            String alamat = txtAlamat.getText();
            String gender = rbLaki.isSelected() ? "Laki-laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
            String minat = (cbProgramming.isSelected() ? "Programming " : "") +
                    (cbDesain.isSelected() ? "Desain " : "") +
                    (cbSeni.isSelected() ? "Seni" : "");
            String kota = (String) cbKota.getSelectedItem();
            String pendidikan = listPendidikan.getSelectedValue();
            int usia = sliderUsia.getValue();
            int pengalaman = (int) spinnerPengalaman.getValue();

            tableModel.addRow(new Object[] { nama, alamat, gender, minat, kota, pendidikan, usia, pengalaman });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AplikasiStudiKasus frame = new AplikasiStudiKasus();
            frame.setVisible(true);
        });
    }
}
