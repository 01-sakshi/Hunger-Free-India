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
    EditText phone,otp;
    Button signin,signup;
   // ImageView accessicon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        //getSupportActionBar().hide();
        add=findViewById(R.id.add);
        t1=findViewById(R.id.t1);
        Typeface aller=Typeface.createFromAsset(getAssets(),"Aller_Bd.ttf");
        add.setTypeface(aller);
        t1.setTypeface(aller);
        //accessicon=findViewById(R.id.accessicon);
        procard=findViewById(R.id.procard);
        phone=findViewById(R.id.phone);
        otp=findViewById(R.id.otp);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);

        /*accessicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, RestInfo.class));

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this,HomeActivity.class));

            }
        });
    }
}
