package cl.empresapjm.prueba3fullscreen.views.main.drawer;

import android.content.Context;

import cl.empresapjm.prueba3fullscreen.data.PhotoPreference;

/**
 * Created by Pablo on 04-10-2017.
 */

public class PhotoValidation {

    private Context context;
    private PhotoCallback callback;

    public PhotoValidation(Context context, PhotoCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void validate()
    {
        String url = new PhotoPreference(context).getPhoto();

        if (url != null)
        {
            callback.photoAvailable(url);
        }else
        {
            callback.emptyPhoto();
        }
    }
}
