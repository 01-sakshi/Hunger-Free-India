package jalandhar.sakshiaggarwal.hungerfreeindia;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    CardView procard;
    TextView add;
    EditText name,phone,address,state,city,email,pass,cpass;
    Button save;
    Spinner spinner1;
    FirebaseAuth firebaseAuth;
    String emaill,passs,addresss,cpasss,cityy,phonee,statee;
    DatabaseReference dbr;
    Rest rest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        add=findViewById(R.id.add);
        Typeface aller=Typeface.createFromAsset(getAssets(),"Aller_Bd.ttf");
        add.setTypeface(aller);
        spinner1=findViewById(R.id.spinner1);

        dbr= FirebaseDatabase.getInstance().getReference("rest");
        rest=new Rest();

        procard=findViewById(R.id.procard);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        state=findViewById(R.id.state);
        city=findViewById(R.id.city);
        save=findViewById(R.id.save);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        cpass=findViewById(R.id.cpass);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emaill = email.getText().toString().trim();
                passs = pass.getText().toString().trim();
                phonee = phone.getText().toString().trim();
                addresss = address.getText().toString().trim();
                statee = state.getText().toString().trim();
                cityy = city.getText().toString().trim();
                cpasss = cpass.getText().toString().trim();

                registerUser();
                registerInFirebase();
                startActivity(new Intent(SignUp.this,RestInfo.class));

            }
        });
    }
    void registerUser(){

       // progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(emaill,passs).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this,email+" Registered Successful!!",Toast.LENGTH_LONG).show();
                    String uid = task.getResult().getUser().getUid();
                    Log.i("User","User's id "+uid);
                   // progressDialog.dismiss();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.i("User","registration Unsuccessful!! "+e.getMessage());
                e.printStackTrace();
              //  progressDialog.dismiss();
            }
        });
    }

    void registerInFirebase(){

        String idDatabaser = dbr.push().getKey();
        rest.id = idDatabaser;
        dbr.child(idDatabaser).setValue(rest);
        Toast.makeText(this, "Rest Added Successfully!!", Toast.LENGTH_LONG).show();
    }
}
