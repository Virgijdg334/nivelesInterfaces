import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BlocNotas2 {
    private JPanel panelFondo;
    private JTextField campoUsuario;
    private JPasswordField campoContra;
    private JCheckBox checkTerminos;
    private JRadioButton radioRecordar;
    private JComboBox<String> comboIdioma;
    private JButton botonLogin;
    private JLabel logo; // ✅ declarado aquí

    public BlocNotas2() {
        // Fondo con imagen
        String urlFondo = "https://assets.santandermedia.com/adobe/assets/urn:aaid:aem:35513ae5-f1bc-4706-bc42-ffcef9733a1d/as/UUID.webp";
        panelFondo = new JPanel() {
            private Image img;
            {
                try { img = new ImageIcon(new URL(urlFondo)).getImage(); }
                catch (Exception e) { e.printStackTrace(); }
                setLayout(new GridBagLayout()); // 🔹 Usamos GridBagLayout para centrar todo
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img != null) g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Contenedor vertical con logo y formulario
        Box box = Box.createVerticalBox();
        box.setOpaque(false);

        // Logo centrado con margen
        logo = new JLabel();
        logo.setPreferredSize(new Dimension(100, 100));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(Box.createVerticalStrut(20));
        box.add(logo);
        box.add(Box.createVerticalStrut(20));

        // Formulario
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 15));
        form.setOpaque(false);
        form.add(crearLabel("Usuario:"));
        campoUsuario = new JTextField(15);
        form.add(campoUsuario);

        form.add(crearLabel("Contraseña:"));
        campoContra = new JPasswordField(15);
        form.add(campoContra);

        form.add(crearLabel("Idioma:"));
        comboIdioma = new JComboBox<>(new String[]{"Español", "Inglés", "Francés"});
        form.add(comboIdioma);

        box.add(form);
        box.add(Box.createVerticalStrut(15));

        // Opciones
        radioRecordar = new JRadioButton("Recordar usuario");
        checkTerminos = new JCheckBox("Aceptar términos y condiciones");
        for (AbstractButton comp : new AbstractButton[]{radioRecordar, checkTerminos}) {
            comp.setOpaque(false);
            comp.setForeground(Color.WHITE);
        }
        JPanel opciones = new JPanel();
        opciones.setLayout(new BoxLayout(opciones, BoxLayout.Y_AXIS));
        opciones.setOpaque(false);
        opciones.add(radioRecordar);
        opciones.add(checkTerminos);
        opciones.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.add(opciones);
        box.add(Box.createVerticalStrut(20));

        // Botón
        botonLogin = new JButton("Iniciar Sesión");
        botonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(botonLogin);

        // Añadimos todo centrado en panelFondo
        panelFondo.add(box, new GridBagConstraints());

        // Ventana
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setContentPane(panelFondo);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        // Cargar logo (pones aquí tu URL)
        setLogo("https://sdmntprwestus2.oaiusercontent.com/files/00000000-90e8-61f8-a7ce-ae55a19f5095/raw?se=2025-09-24T12%3A20%3A31Z&sp=r&sv=2024-08-04&sr=b&scid=f0ae0913-56f9-531b-86a7-b5e8e0610e39&skoid=6658dbdd-f305-4d30-8f6b-d62218202cb9&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2025-09-24T01%3A54%3A36Z&ske=2025-09-25T01%3A54%3A36Z&sks=b&skv=2024-08-04&sig=cHg61iAo7NK3eofutIGD7Ig4iOK4Ra2AjeYuIuWHhFs%3D");
    }

    // Método auxiliar para labels
    private JLabel crearLabel(String texto) {
        JLabel lbl = new JLabel(texto, SwingConstants.RIGHT);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Arial", Font.PLAIN, 18));
        return lbl;
    }

    // Método para cargar logo redimensionado
    private void setLogo(String urlLogo) {
        try {
            ImageIcon iconoOriginal = new ImageIcon(new URL(urlLogo));
            Image imgEscalada = iconoOriginal.getImage().getScaledInstance(
                    logo.getPreferredSize().width,
                    logo.getPreferredSize().height,
                    Image.SCALE_SMOOTH
            );
            logo.setIcon(new ImageIcon(imgEscalada));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BlocNotas2();
    }
}
