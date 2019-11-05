package jalandhar.sakshiaggarwal.hungerfreeindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainRestActivity extends AppCompatActivity{

    CardView cardrest1,cardrest2,cardrest3,cardrest4,cardrest5,cardrest6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainrestactivity);
        cardrest1=findViewById(R.id.cardrest1);
        cardrest2=findViewById(R.id.cardrest2);
        cardrest3=findViewById(R.id.cardrest3);
        cardrest4=findViewById(R.id.cardrest4);
        cardrest5=findViewById(R.id.cardrest5);
        cardrest6=findViewById(R.id.cardrest6);

        cardrest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainRestActivity.this, RestInfo.class));
            }
        });
        cardrest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainRestActivity.this, RestInfo.class));
            }
        });
        cardrest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainRestActivity.this, RestInfo.class));
            }
        });
        cardrest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainRestActivity.this, RestInfo.class));
            }
        });
        cardrest5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainRestActivity.this, RestInfo.class));
            }
        });
        cardrest6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainRestActivity.this, RestInfo.class));
            }
        });

    }
}
