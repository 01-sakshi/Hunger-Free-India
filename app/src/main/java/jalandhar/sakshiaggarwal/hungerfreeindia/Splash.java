package jalandhar.sakshiaggarwal.hungerfreeindia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        int SPLASH_DISPLAY_LENGTH = 1000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                /* Create an Intent that will start the Menu-Activity. */
                /*if (user==null){

                    Intent mainIntent = new Intent(splashScreen.this,myphnno.class);
                    splashScreen.this.startActivity(mainIntent);
                    splashScreen.this.finish();
                }
                else {*/

                    startActivity(new Intent(Splash.this,SignIn.class));
                    Splash.this.finish();
                //}
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
