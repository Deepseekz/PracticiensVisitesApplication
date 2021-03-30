package Activities;

import Adapters.RecyclerViewAdapter;
import Models.GsonRequest;
import Models.Visiteur;
import Models.Visiteurs;
import Models.VolleyHelper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.Activities.R;
import com.example.Activities.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String visiteursUrl = "http://192.168.210.4/cakephp/visiteurs.json";
    private RecyclerViewAdapter adapter;
    private ArrayList<Visiteur> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        initializeUI();
        openVisitesDatas();
    }

    private void initializeUI() {
        binding.rvPraticiens.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvPraticiens.setLayoutManager(layoutManager);
        binding.rvPraticiens.setFocusable(false);

    }

    private void openVisitesDatas() {

        final GsonRequest gsonRequest = new GsonRequest(visiteursUrl, Visiteurs.class, null, new Response.Listener<Visiteurs>() {
            @Override
            public void onResponse(Visiteurs visiteurs) {
                adapter = new RecyclerViewAdapter(visiteurs.getVisiteurs());
                binding.rvPraticiens.setAdapter(adapter);
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