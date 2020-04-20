package is.doesnt.mymvpclase2.Interfaces;

public interface ILoginView {

    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPassword();

    void navigateToHome();
}
