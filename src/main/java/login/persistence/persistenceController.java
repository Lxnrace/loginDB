package login.persistence;

import java.util.List;

import logic.Usuario;

public class persistenceController {

    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public List<Usuario> getUsers() {
        List<Usuario> userList = usuJpa.findUsuarioEntities();
        return userList;

    }

}
