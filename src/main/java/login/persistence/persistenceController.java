package login.persistence;

import java.util.List;

import logic.Usuario;

public class persistenceController {

    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public List<Usuario> getUsers() {

        return usuJpa.findUsuarioEntities();
        //SELECT * FROM USERS

    }

}
