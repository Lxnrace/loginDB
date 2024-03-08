package app;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import login.Login;
import manager.FormsManager;
import raven.toast.Notifications;

import javax.management.Notification;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {
        init();
        Notifications.getInstance().setJFrame(this);

    }

    private void init() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
        setContentPane(new Login());
        FormsManager.getInstance().initApplication(this);
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        EventQueue.invokeLater(() -> new App().setVisible(true));
    }

}
