package login;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import manager.FormsManager;
import raven.toast.Notifications;

import javax.management.Notification;
import javax.swing.*;
import java.awt.*;
import java.lang.ModuleLayer.Controller;
import logic.UserController;

public class Login extends JPanel {

    UserController control;

    public Login() {
        init();
        control = new UserController();

    }

    private void init() {
        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        chRememberMe = new JCheckBox("Recuerdame");
        cmdLogin = new JButton("Iniciar sesión");
        cmdClear = new JButton("Limpiar");
        cmdGoogle = new JButton("Iniciar sesión con Google");
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:20;"
                + "[light]background:darken(@background,3%);"
                + "[dark]background:lighten(@background,3%)");

        txtPassword.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true");

        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");
        cmdLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdLogin.addActionListener(e -> {
            String user = txtUsername.getText();
            String password = txtPassword.getText();
            String message = control.validarUsuario(user, password);

            System.out.println(message);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, String.valueOf(message));

        });

        cmdGoogle.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");

        cmdClear.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");
        cmdClear.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cmdClear.addActionListener(e -> {

            if (txtUsername.getText().equals("") && txtPassword.getText().equals("")) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Los campos ya se encuentran vacios");
            } else {
                txtUsername.setText("");
                txtPassword.setText("");
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Datos limpiados con éxito");

            }

        });

        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa tu usuario");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa tu contraseña");

        JLabel lbTitle = new JLabel("Bienvenido de vuelta!");
        JLabel description = new JLabel("Por favor, inicia sesión en tu cuenta");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +10");
        description.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%)");

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Usuario"), "gapy 8");
        panel.add(txtUsername);
        panel.add(new JLabel("Contraseña"), "gapy 8");
        panel.add(txtPassword);
        panel.add(chRememberMe, "grow 0");
        panel.add(cmdLogin, "gapy 10");
        panel.add(cmdGoogle, "gapy 7");
        panel.add(cmdClear, "gapy 7");
        panel.add(createSignupLabel(), "gapy 10");
        add(panel);

    }

    private Component createSignupLabel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:null");
        JButton cmdRegister = new JButton("<html><a href=\"#\">Registrarse</a></html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(e -> {
            FormsManager.getInstance().showForm(new Register());
        });
        JLabel label = new JLabel("No tienes cuenta ?");
        label.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%)");
        panel.add(label);
        panel.add(cmdRegister);
        return panel;

    }

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chRememberMe;
    private JButton cmdLogin;
    private JButton cmdClear;
    private JButton cmdGoogle;
}
