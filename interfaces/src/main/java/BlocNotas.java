import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BlocNotas {
    private JPanel imagenFondo;
    private JLabel titulo, textInicio, textContra, logo;
    private JTextField campoUsuario;
    private JPasswordField campoContra;
    private JButton botonLogin;
    private JCheckBox checkTerminos;

    public BlocNotas() {
        // Imagen de fondo
        String urlFondo = "https://static.vecteezy.com/system/resources/previews/013/260/603/non_2x/abstract-dark-blue-blurred-background-for-web-and-mobile-applications-business-infographic-and-social-media-modern-decoration-art-illustration-template-design-vector.jpg";
        imagenFondo = new JPanel() {
            private Image imagen;
            {
                try { imagen = new ImageIcon(new URL(urlFondo)).getImage(); }
                catch (Exception e) { e.printStackTrace(); }
                setLayout(null);
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagen != null) g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Título
        titulo = new JLabel("¡Bienvenido!");
        titulo.setBounds(100, 40, 300, 40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);

        // Logo en esquina superior derecha
        logo = new JLabel();
        logo.setBounds(400, 20, 70, 70);

        // Labels centrados
        textInicio = new JLabel("Usuario:");
        textInicio.setBounds(100, 120, 100, 30);
        textInicio.setFont(new Font("Arial", Font.PLAIN, 20));
        textInicio.setForeground(Color.WHITE);

        textContra = new JLabel("Contraseña:");
        textContra.setBounds(100, 170, 120, 30);
        textContra.setFont(new Font("Arial", Font.PLAIN, 20));
        textContra.setForeground(Color.WHITE);

        // Campos centrados
        campoUsuario = new JTextField();
        campoUsuario.setBounds(230, 120, 160, 30);

        campoContra = new JPasswordField();
        campoContra.setBounds(230, 170, 160, 30);

        // Checkbox centrado
        checkTerminos = new JCheckBox("Aceptar términos y condiciones");
        checkTerminos.setBounds(150, 220, 250, 30);
        checkTerminos.setOpaque(false);
        checkTerminos.setForeground(Color.WHITE);

        // Botón centrado
        botonLogin = new JButton("Iniciar Sesión");
        botonLogin.setBounds(175, 270, 150, 40);
        botonLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            if (!checkTerminos.isSelected()) {
                JOptionPane.showMessageDialog(imagenFondo,
                        "Debes aceptar los términos y condiciones.",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(imagenFondo,
                    "El usuario \"" + usuario + "\" ha iniciado sesión correctamente.",
                    "Inicio de Sesión",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Añadir componentes
        imagenFondo.add(titulo);
        imagenFondo.add(logo);
        imagenFondo.add(textInicio);
        imagenFondo.add(textContra);
        imagenFondo.add(campoUsuario);
        imagenFondo.add(campoContra);
        imagenFondo.add(checkTerminos);
        imagenFondo.add(botonLogin);

        // Ventana
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setContentPane(imagenFondo);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // 🔒 evita pantalla completa
        frame.setLocationRelativeTo(null); // centra la ventana en pantalla
        frame.setVisible(true);

        // 🔽 Aquí llamas al método con la URL de tu logo
        setLogo("https://sdmntprukwest.oaiusercontent.com/files/00000000-5348-6243-b0cd-ad15714fb0df/raw?se=2025-09-24T11%3A38%3A18Z&sp=r&sv=2024-08-04&sr=b&scid=318c4b45-2227-518a-91a6-f8317e59e121&skoid=8e0fb8a9-6beb-4b32-9eda-253f61890767&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2025-09-24T06%3A13%3A40Z&ske=2025-09-25T06%3A13%3A40Z&sks=b&skv=2024-08-04&sig=RUW3Rs3GvRFfHhgTnVgli2t28y0z6UC6MarVNjv3vgw%3D");
    }

    // Método para redimensionar y colocar el logo
    private void setLogo(String urlLogo) {
        try {
            ImageIcon iconoOriginal = new ImageIcon(new URL(urlLogo));
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                    logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH
            );
            logo.setIcon(new ImageIcon(imagenEscalada));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BlocNotas();
    }
}
