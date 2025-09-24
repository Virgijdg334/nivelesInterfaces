import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BlocNotas3 {
    private JPanel imagenFondo;
    private JTabbedPane tabs;
    private JTextField campoUsuarioLogin, campoUsuarioRegistro;
    private JPasswordField campoContraLogin, campoContraRegistro;
    private JButton botonLogin, botonRegistro;
    private JCheckBox checkTerminosLogin, checkTerminosRegistro;
    private JProgressBar progressBar;
    private JSlider sliderNivel;
    private JSpinner spinnerEdad;
    private JComboBox<String> comboIdiomas; // Combo para seleccionar idioma

    public BlocNotas3() {
        // Fondo temático
        String url = "https://media.istockphoto.com/id/1023119736/es/foto/national-banderas.jpg?s=612x612&w=0&k=20&c=4St8qqGVGEDT6hTeuo1lhitoa3hbRBT-EqXXIljRyjc=";
        imagenFondo = new JPanel(new BorderLayout()) {
            private Image imagen;
            {
                try {
                    imagen = new ImageIcon(new URL(url)).getImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagen != null) {
                    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        // Título
        JLabel titulo = new JLabel("🌍 Aprende Idiomas", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);
        imagenFondo.add(titulo, BorderLayout.NORTH);

        // Pestañas
        tabs = new JTabbedPane();
        tabs.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tabs.setOpaque(false);
        tabs.setBackground(new Color(0,0,0,0)); // fondo completamente transparente

        // Panel Login
        JPanel panelLogin = new JPanel(new GridBagLayout());
        panelLogin.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panelLogin.setOpaque(false);

        gbc.gridx = 0; gbc.gridy = 0;
        panelLogin.add(new JLabel("Correo o Usuario:", SwingConstants.RIGHT), gbc);
        campoUsuarioLogin = new JTextField(15);
        gbc.gridx = 1;
        panelLogin.add(campoUsuarioLogin, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelLogin.add(new JLabel("Contraseña:", SwingConstants.RIGHT), gbc);
        campoContraLogin = new JPasswordField(15);
        gbc.gridx = 1;
        panelLogin.add(campoContraLogin, gbc);

        checkTerminosLogin = new JCheckBox("Aceptar términos de uso");
        checkTerminosLogin.setOpaque(false);
        checkTerminosLogin.setForeground(Color.BLACK);
        gbc.gridx = 1; gbc.gridy = 2;
        panelLogin.add(checkTerminosLogin, gbc);

        botonLogin = new JButton("🌐 Iniciar Sesión");
        gbc.gridx = 1; gbc.gridy = 3;
        panelLogin.add(botonLogin, gbc);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(30, 144, 255));
        gbc.gridx = 1; gbc.gridy = 4;
        panelLogin.add(progressBar, gbc);

        botonLogin.addActionListener(e -> {
            if (!checkTerminosLogin.isSelected()) {
                JOptionPane.showMessageDialog(imagenFondo, "Debes aceptar los términos.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new Thread(() -> {
                for (int i = 0; i <= 100; i+=10) {
                    progressBar.setValue(i);
                    try { Thread.sleep(120); } catch (InterruptedException ex) {}
                }
                JOptionPane.showMessageDialog(imagenFondo,
                        "¡Bienvenido/a, " + campoUsuarioLogin.getText() + "! 🌎\nTu experiencia de idiomas está lista.",
                        "Inicio de Sesión",
                        JOptionPane.INFORMATION_MESSAGE);
            }).start();
        });

        // Panel Registro
        JPanel panelRegistro = new JPanel(new GridBagLayout());
        panelRegistro.setOpaque(false);

        panelRegistro.setOpaque(false);

        gbc.gridx = 0; gbc.gridy = 0;
        panelRegistro.add(new JLabel("Nombre de usuario:", SwingConstants.RIGHT), gbc);
        campoUsuarioRegistro = new JTextField(15);
        gbc.gridx = 1;
        panelRegistro.add(campoUsuarioRegistro, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelRegistro.add(new JLabel("Contraseña:", SwingConstants.RIGHT), gbc);
        campoContraRegistro = new JPasswordField(15);
        gbc.gridx = 1;
        panelRegistro.add(campoContraRegistro, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelRegistro.add(new JLabel("Edad:", SwingConstants.RIGHT), gbc);
        spinnerEdad = new JSpinner(new SpinnerNumberModel(18, 5, 100, 1));
        gbc.gridx = 1;
        panelRegistro.add(spinnerEdad, gbc);

        // ComboBox Idiomas
        gbc.gridx = 0; gbc.gridy = 3;
        panelRegistro.add(new JLabel("Idioma principal:", SwingConstants.RIGHT), gbc);
        comboIdiomas = new JComboBox<>(new String[]{"Inglés", "Español", "Francés"});
        gbc.gridx = 1;
        panelRegistro.add(comboIdiomas, gbc);

        // Slider Nivel
        gbc.gridx = 0; gbc.gridy = 4;
        panelRegistro.add(new JLabel("Nivel de fluidez:", SwingConstants.RIGHT), gbc);
        sliderNivel = new JSlider(0, 10, 3);
        sliderNivel.setMajorTickSpacing(2);
        sliderNivel.setPaintTicks(true);
        sliderNivel.setPaintLabels(true);
        gbc.gridx = 1;
        panelRegistro.add(sliderNivel, gbc);

        checkTerminosRegistro = new JCheckBox("Aceptar política de privacidad");
        checkTerminosRegistro.setOpaque(false);
        checkTerminosRegistro.setForeground(Color.BLACK);
        gbc.gridx = 1; gbc.gridy = 5;
        panelRegistro.add(checkTerminosRegistro, gbc);

        botonRegistro = new JButton("📝 Registrarse");
        gbc.gridx = 1; gbc.gridy = 6;
        panelRegistro.add(botonRegistro, gbc);

        botonRegistro.addActionListener(e -> {
            if (!checkTerminosRegistro.isSelected()) {
                JOptionPane.showMessageDialog(imagenFondo, "Debes aceptar la política de privacidad.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(imagenFondo,
                    "¡Registro exitoso! 🎉\nUsuario: " + campoUsuarioRegistro.getText() +
                            "\nEdad: " + spinnerEdad.getValue() +
                            "\nIdioma elegido: " + comboIdiomas.getSelectedItem() +
                            "\nNivel de fluidez: " + sliderNivel.getValue() + "/10",
                    "Registro",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Añadir pestañas
        tabs.addTab("🔑 Iniciar Sesión", panelLogin);
        tabs.addTab("🆕 Registrarse", panelRegistro);

        imagenFondo.add(tabs, BorderLayout.CENTER);

        // Crear ventana
        JFrame frame = new JFrame("App de Idiomas - BlocNotas3Idiomas");
        frame.setContentPane(imagenFondo);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public static void main(String[] args) {
        new BlocNotas3();
    }
}
