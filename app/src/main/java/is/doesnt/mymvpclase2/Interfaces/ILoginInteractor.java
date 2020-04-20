package is.doesnt.mymvpclase2.Interfaces;

public interface ILoginInteractor {

    void validarUser(String user, String pass, OnLoginFinishListener listener);
}
