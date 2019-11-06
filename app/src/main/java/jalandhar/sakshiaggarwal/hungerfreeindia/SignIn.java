package jalandhar.sakshiaggarwal.hungerfreeindia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    CardView procard;
    TextView add,t1;
    EditText email,password;
    Button signin,signup;
    String emaill,passs;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    Register register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        setContentView(R.layout.signin);
        add=findViewById(R.id.add);
        t1=findViewById(R.id.t1);
        register=new Register();
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
                /*register.email = email.getText().toString().trim();
                register.pass = password.getText().toString().trim();*/
                /*if (!isValidPass(emaill)) {

                    email.setError("Enter valid Email");
                }
                else if (!isValidPass(passs)) {

                    password.setError("Enter Password");
                }*/


                loginUser();
                startActivity(new Intent(SignIn.this, RestDetails.class));

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

    void initViews() {


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        register = new Register();

    }

    void loginUser(){

        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(emaill,passs).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(SignIn.this,"Login Successful!!",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(SignInActivity.this,ViewRoomActivity.class);
//                    startActivity(intent);
                    progressDialog.dismiss();
                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignIn.this,"Email Id or Password doesn't match",Toast.LENGTH_LONG).show();
                        Log.i("User","Login Unsuccessful!! "+e.getMessage());
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
        );

    }
}
