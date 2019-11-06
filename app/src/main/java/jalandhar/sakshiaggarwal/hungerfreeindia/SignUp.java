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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    CardView procard;
    TextView add,profile,edetails;
    EditText name,phone,address,state,city,email,pass,cpass;
    Button save;
    Spinner spinner1;
    FirebaseAuth firebaseAuth;
    String emaill,passs,addresss,cpasss,cityy,phonee,statee,name1;
    String text;
    DatabaseReference db;
    Register register;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        initViews();
        setContentView(R.layout.signup);
        add=findViewById(R.id.add);
        profile=findViewById(R.id.profile);
        edetails=findViewById(R.id.edetails);
        Typeface aller=Typeface.createFromAsset(getAssets(),"Aller_Bd.ttf");
        add.setTypeface(aller);
        profile.setTypeface(aller);
        edetails.setTypeface(aller);

        spinner1=findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.choose_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        //dbr= FirebaseDatabase.getInstance().getReference("rest");
       // rest=new Rest();

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
            public void onClick(View view)
            {

                register.email = email.getText().toString().trim();
                register.name = name.getText().toString().trim();
                register.pass = pass.getText().toString().trim();
                register.phone = phone.getText().toString().trim();
                register.address = address.getText().toString().trim();
                register.state = state.getText().toString().trim();
                register.city = city.getText().toString().trim();
                cpasss = cpass.getText().toString().trim();
                phonee=register.phone;
                Intent intent=new Intent();
                //intent.putExtra("phoneno",phonee);

                /*if (!isValidName(name1))
                {
                    name.setError("Enter valid Name");
                }
                else if (!isValidPhone(phonee)) {

                    phone.setError("Enter valid Phone Number");
                }
                else if (!isValidAddress(addresss)) {

                    address.setError("Enter valid Address");
                }
                else if (!isValidState(statee)) {

                    state.setError("Enter valid State");
                }
                else if (!isValidCity(cityy)) {

                    city.setError("Enter valid City");
                }
                else if (!isValidEmail(emaill)) {

                    email.setError("Enter valid Email");
                }
                else if (!isValidPass(passs)) {

                    pass.setError("Enter Password");
                }
                else if (!isValidCpass(cpasss)) {

                    cpass.setError("Confirm Password");
                }
                else{
                    if(text.equals("Restaurant")){
                        startActivity(new Intent(SignUp.this,RestInfo.class));
                    }
                    else if(text.equals("Outlet")){
                        startActivity(new Intent(SignUp.this,OrgInfo.class));
                    }
                }*/

                registerUser();
                registerInFirebase();
                startActivity(new Intent(SignUp.this,myphnotpsend.class));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private boolean isValidName(String name1) {
        if (!name1.equals("") ) {
            return true;
        }
        return false; }
    private boolean isValidPhone(String phone1) {
        if (!phone1.equals("") ) {
            return true;
        }
        return false; }
    private boolean isValidAddress(String address1) {
        if (!address1.equals("") ) {
            return true;
        }
        return false; }
    private boolean isValidCity(String city1) {
        if (!city1.equals("") ) {
            return true;
        }
        return false; }
    private boolean isValidState(String state1) {
        if (!state1.equals("") ) {
            return true;
        }
        return false; }
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
    private boolean isValidCpass(String cpass1) {
        if (!cpass1.equals("") ) {
            return true;
        }
        return false; }


    void initViews() {
        register = new Register();

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        db = FirebaseDatabase.getInstance().getReference("register");
    }

    void registerUser() {

        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(register.email, register.pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, email + " Registered Successful!!", Toast.LENGTH_LONG).show();
                    String uid = task.getResult().getUser().getUid();
                    Log.i("User", "User's id " + uid);
                    progressDialog.dismiss();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Log.i("User", "Registration Unsuccessful!! " + e.getMessage());
                e.printStackTrace();
                progressDialog.dismiss();
            }
        });
    }

    void registerInFirebase(){

        String idDatabase = db.push().getKey();
        register.id = idDatabase;
        db.child(idDatabase).setValue(register);
        Toast.makeText(this, "Registered Successfully!!", Toast.LENGTH_LONG).show();
    }
}
