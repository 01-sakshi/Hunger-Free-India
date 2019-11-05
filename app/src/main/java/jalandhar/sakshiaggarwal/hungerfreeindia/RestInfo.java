package jalandhar.sakshiaggarwal.hungerfreeindia;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RestInfo extends AppCompatActivity {
    CardView procard;
    TextView add;
    EditText name,phone,type,qty,desc,time,loc,city;
    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restinfo);
        add=findViewById(R.id.add);
        Typeface aller=Typeface.createFromAsset(getAssets(),"Aller_Bd.ttf");
        add.setTypeface(aller);
        procard=findViewById(R.id.procard);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        type=findViewById(R.id.type);
        qty=findViewById(R.id.qty);
        desc=findViewById(R.id.desc);
        time=findViewById(R.id.time);
        loc=findViewById(R.id.loc);
        city=findViewById(R.id.city);
        proceed=findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
