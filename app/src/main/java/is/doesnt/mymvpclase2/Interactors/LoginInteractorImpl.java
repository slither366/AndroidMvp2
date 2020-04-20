package is.doesnt.mymvpclase2.Interactors;

import android.os.Handler;

import is.doesnt.mymvpclase2.Interfaces.ILoginInteractor;
import is.doesnt.mymvpclase2.Interfaces.OnLoginFinishListener;

public class LoginInteractorImpl implements ILoginInteractor {

    @Override
    public void validarUser(final String user, final String pass, final OnLoginFinishListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!user.equals("") && !pass.equals("")){
                    listener.exitoOperacion();
                }else{
                    if(user.equals("")){
                        listener.usernameError();
                    }
                    if(pass.equals("")){
                        listener.passwordError();
                    }
                }
            }
        }, 2000);
    }
}
