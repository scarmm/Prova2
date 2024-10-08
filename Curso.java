public class Curso {

    int idCurso;
    String nomeCurso;
    int carga_horaria;
    Professor professorCurso; 

    public Curso(

            int idCurso,
            String nomeCurso,
            int carga_horaria,
            Professor professorCurso

        ){
            this.idCurso = idCurso;
            this.nomeCurso = nomeCurso;
            this.carga_horaria = carga_horaria;
            this.professorCurso = professorCurso;
        }

}


