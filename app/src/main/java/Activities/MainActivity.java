package Activities;

import Adapters.RecyclerViewAdapterVisiteurs;
import Interfaces.RecyclerViewClickListener;
import Listeners.RecyclerTouchListener;
import Models.GsonRequest;
import Models.Visite;
import Models.Visiteur;
import Models.Visiteurs;
import Models.VolleyHelper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.Activities.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    final private String visiteursUrl = "http://192.168.210.4/cakephp/visiteurs.json";
    private RecyclerViewAdapterVisiteurs adapter;
    private ArrayList<Visiteur> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        initializeUI();
        openVisitesDatas();

        binding.rvVisiteurs.addOnItemTouchListener(new RecyclerTouchListener(this, binding.rvVisiteurs, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "vous avez cliquer", Toast.LENGTH_SHORT).show();
                Intent intentVisiteurDetails = new Intent(getApplicationContext(), VisiteurActivity.class);

                intentVisiteurDetails.putExtra("visiteur", list.get(position));
                startActivity(intentVisiteurDetails);
            }
        }));
    }

    private void initializeUI() {
        binding.rvVisiteurs.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvVisiteurs.setLayoutManager(layoutManager);
        binding.rvVisiteurs.setFocusable(false);

    }

    private void openVisitesDatas() {

        final GsonRequest gsonRequest = new GsonRequest(visiteursUrl, Visiteurs.class, null, new Response.Listener<Visiteurs>() {
            @Override
            public void onResponse(Visiteurs visiteurs) {
                list = new ArrayList<>(visiteurs.getVisiteurs());
                adapter = new RecyclerViewAdapterVisiteurs(list);
                binding.rvVisiteurs.setAdapter(adapter);
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