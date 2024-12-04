public class Evento {

    int idEvento;
    int idOrganizador;
    int idLocal;
    String dataEvento;

    public Evento(

            int idEvento,
            int idOrganizador,
            int idLocal,
            String dataEvento

    ) {
        this.idEvento = idEvento;
        this.idOrganizador = idOrganizador;
        this.idLocal = idLocal;
        this.dataEvento = dataEvento;
    }

}
