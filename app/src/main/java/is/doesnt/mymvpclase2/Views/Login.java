package is.doesnt.mymvpclase2.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import is.doesnt.mymvpclase2.Interfaces.ILoginPresenter;
import is.doesnt.mymvpclase2.Interfaces.ILoginView;
import is.doesnt.mymvpclase2.Presenters.LoginPresenterImpl;
import is.doesnt.mymvpclase2.R;

public class Login extends AppCompatActivity implements ILoginView {

    EditText edtEmail, edtPassword;
    Button btnLogin;
    ProgressBar progressBar;

    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        initComponents();

        presenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion(v);
            }
        });
    }

    private void initComponents() {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        edtEmail.setError("Campo Obligatorio!");
    }

    @Override
    public void setErrorPassword() {
        edtPassword.setError("Campo Oblitatorio");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(Login.this, PrincipalMenu.class));
    }

    public void validacion(View v){
        presenter.validarUsuario(edtEmail.getText().toString(), edtPassword.getText().toString());
    }
}
