package Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.Activities.databinding.ActivityVisitesBinding;

import java.util.ArrayList;

import Adapters.RecyclerViewAdapterVisites;
import Adapters.RecyclerViewAdapterVisiteurs;
import Interfaces.RecyclerViewClickListener;
import Models.GsonRequest;
import Models.Visiteur;
import Models.Visiteurs;
import Models.VolleyHelper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

public class VisiteurActivity extends AppCompatActivity {
    final private String visiteurUrl = "http://192.168.210.4/cakephp/visiteurs/view/6.json";
    private ActivityVisitesBinding binding;
    private RecyclerViewAdapterVisites adapter;
    private ArrayList<Visiteur> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityVisitesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        initializeUI();
        openVisitesDatas();
    }

    private void initializeUI() {
        binding.rvVisites.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvVisites.setLayoutManager(layoutManager);
        binding.rvVisites.setFocusable(false);

    }

    private void openVisitesDatas() {

        final GsonRequest gsonRequest = new GsonRequest(visiteurUrl, Visiteur.class, null, new Response.Listener<Visiteur>() {
            @Override
            public void onResponse(Visiteur visiteur) {
                adapter = new RecyclerViewAdapterVisites(visiteur.getVisites());
                binding.rvVisites.setAdapter(adapter);
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
