package cl.empresapjm.prueba3fullscreen.views.main.finder;

/**
 * Created by Pablo on 05-10-2017.
 */

public interface FinderCallback {

    void error(String error);
    void success();
    void notFound();

}
