package jalandhar.sakshiaggarwal.hungerfreeindia;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
    CardView procard;
    TextView add,t1;
    EditText email,password;
    Button signin,signup;
    String emaill,passs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        add=findViewById(R.id.add);
        t1=findViewById(R.id.t1);
        Typeface aller=Typeface.createFromAsset(getAssets(),"Aller_Bd.ttf");
        add.setTypeface(aller);
        t1.setTypeface(aller);
        procard=findViewById(R.id.procard);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emaill = email.getText().toString().trim();
                passs = password.getText().toString().trim();
                if (!isValidPass(emaill)) {

                    email.setError("Enter valid Email");
                }
                else if (!isValidPass(passs)) {

                    password.setError("Enter Password");
                }
                else{
                startActivity(new Intent(SignIn.this, RestInfo.class));}

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this,SignUp.class));

            }
        });
    }
    private boolean isValidEmail(String email1) {
        if (!email1.equals("") ) {
            return true;
        }
        return false; }
    private boolean isValidPass(String pass1) {
        if (!pass1.equals("") ) {
            return true;
        }
        return false; }
}
