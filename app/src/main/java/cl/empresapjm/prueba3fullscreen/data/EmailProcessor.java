package cl.empresapjm.prueba3fullscreen.data;

/**
 * Created by Pablo on 04-10-2017.
 */

public class EmailProcessor {

    public String sanitizedEmail(String email){
        return email.replace("@","AT").replace(".","DOT");
    }

}
