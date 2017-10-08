package cl.empresapjm.prueba3fullscreen.views.login;

import cl.empresapjm.prueba3fullscreen.data.CurrentUser;

/**
 * Created by Pablo on 03-09-2017.
 */

public class TipsValidateLogin {

    private LoginCallback callback;

    public TipsValidateLogin(LoginCallback callback) {
        this.callback = callback;
    }

    public void LoginValidate (){
        if (new CurrentUser().getCurrentUser() != null){
            callback.logged();
        }else{
            callback.signUp();
        }

    }

}
