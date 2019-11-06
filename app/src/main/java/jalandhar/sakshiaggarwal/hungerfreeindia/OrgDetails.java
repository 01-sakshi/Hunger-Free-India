package jalandhar.sakshiaggarwal.hungerfreeindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class OrgDetails extends AppCompatActivity {
    CardView c11,c12;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orgdetails);
        c11=findViewById(R.id.c11);
        c12=findViewById(R.id.c12);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrgDetails.this,OrgInfo.class));
            }
        });
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrgDetails.this,ListOrg.class));
            }
        });
    }
}
