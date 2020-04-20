package is.doesnt.mymvpclase2.Presenters;

import is.doesnt.mymvpclase2.Interactors.LoginInteractorImpl;
import is.doesnt.mymvpclase2.Interfaces.ILoginInteractor;
import is.doesnt.mymvpclase2.Interfaces.ILoginPresenter;
import is.doesnt.mymvpclase2.Interfaces.ILoginView;
import is.doesnt.mymvpclase2.Interfaces.OnLoginFinishListener;

public class LoginPresenterImpl implements ILoginPresenter, OnLoginFinishListener {

    private ILoginView view;
    private ILoginInteractor interactor;

    public LoginPresenterImpl(ILoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void usernameError() {
        if(view != null){
            view.hideProgress();
            view.setErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if(view!=null){
            view.hideProgress();
            view.setErrorPassword();
        }
    }

    @Override
    public void exitoOperacion() {
        if(view != null){
            view.hideProgress();
            view.navigateToHome();
        }
    }

    @Override
    public void validarUsuario(String user, String pass) {
        if(view != null){
            view.showProgress();
        }
        interactor.validarUser(user, pass, this);
    }
}
