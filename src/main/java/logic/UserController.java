package logic;

import java.util.List;

import login.persistence.persistenceController;

public class UserController {

    persistenceController persisControl;

    public UserController() {
        persisControl = new persistenceController();
    }

    public String validarUsuario(String user, String password) {

        String message = "";

        List<Usuario> userList = persisControl.getUsers();

        for (Usuario use : userList) {
            if (use.getUser().equals(user)) {
                if (use.getPassword().equals(password)) {

                    message = "Usuario y contraseña correctos, bienvenido/a";
                    return message;

                } else {
                    message = "Contraseña incorrecta";
                    return message;
                }

            } else {
                message = "Usuario no encontrado";
            }

        }
        return message;

    }

}
