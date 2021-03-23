package Activities;

import Models.GsonRequest;
import Models.Visiteur;
import Models.Visiteurs;
import Models.VolleyHelper;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.Activities.R;

public class MainActivity extends AppCompatActivity {
    private String VisiteursUrl = "192.168.210.4/cakephp/visiteurs.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void openVisitesDatas() {

        final GsonRequest gsonRequest = new GsonRequest(VisiteursUrl, Visiteurs.class, null, new Response.Listener<Visiteurs>() {
            @Override
            public void onResponse(Visiteurs visiteurs) {
                String resultat="";
                for (Visiteur prev : visiteurs.getLesVisiteurs()) {
                    resultat+=prev.toString();
                }

                textViewPrevisions.setText(resultat);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (volleyError != null) Log.e("MainActivity", volleyError.getMessage());
                    }
                });
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);
    }
}