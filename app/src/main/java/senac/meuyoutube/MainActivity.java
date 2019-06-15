package senac.meuyoutube;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RadioButton culinaria = findViewById(R.id.rbCulinaria);
                    RadioButton animais = findViewById(R.id.rbAnimais);
                    RadioButton tecnologia = findViewById(R.id.rbTecnologia);
                    RadioButton beleza = findViewById(R.id.rbBeleza);
                    RadioButton esporte = findViewById(R.id.rbEsporte);
                    WebView youtube = findViewById(R.id.viewYoutube);
                    String videoID = "";

                    if (culinaria.isChecked()){
                        videoID = "yfKhiFXv8qs";
                    } else if (animais.isChecked()){
                        videoID = "IsJ3F2JWmeE";
                    } else if (tecnologia.isChecked()){
                        videoID = "9Pa-q2ydmSc";
                    } else if (beleza.isChecked()){
                        videoID = "YdSvO830QHE";
                    } else {
                        videoID = "znhVNUJB9MQ";
                    }


                    youtube.getSettings().setJavaScriptEnabled(true);
                    youtube.getSettings().setPluginState(WebSettings.PluginState.ON);
                    youtube.loadUrl("https://www.youtube.com/embed/" + videoID + "?autoplay=1&vq=small");
                    youtube.setWebChromeClient(new WebChromeClient());
                } catch (Exception ex){
                    Log.e("onClick fab", ex.getMessage());
                    Toast.makeText(getApplicationContext(), "Houve um erro..",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
