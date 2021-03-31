package Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.Activities.databinding.ActivityVisiteurBinding;

import java.util.ArrayList;

import Adapters.RecyclerViewAdapterVisites;
import Adapters.RecyclerViewAdapterVisiteurs;
import Interfaces.RecyclerViewClickListener;
import Models.GsonRequest;
import Models.Visite;
import Models.Visiteur;
import Models.Visiteurs;
import Models.VolleyHelper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

public class VisiteurActivity extends AppCompatActivity {
    final private String visiteurUrl = "http://192.168.210.4/cakephp/visiteurs/view/";
    private  Visiteur visiteur;
    private ActivityVisiteurBinding binding;
    private RecyclerViewAdapterVisites adapter;
    private ArrayList<Visite> list;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityVisiteurBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        Intent intentVisiteur = getIntent();
        visiteur = (Visiteur)intentVisiteur.getSerializableExtra("visiteur");

        binding.tvNom.setText(visiteur.getNom());
        binding.tvPrenom.setText(visiteur.getPrenom());
        binding.tvTel.setText(visiteur.getTel());
        binding.tvMail.setText(visiteur.getMail());

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

        final GsonRequest gsonRequest = new GsonRequest(visiteurUrl + visiteur.getId() + ".json", Visiteur.class, null, new Response.Listener<Visiteur>() {
            @Override
            public void onResponse(Visiteur visiteur) {
                list = new ArrayList<>(visiteur.getVisites());
                adapter = new RecyclerViewAdapterVisites(list);
                binding.rvVisites.setAdapter(adapter);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (volleyError != null) Log.e("VisiteurActivity", volleyError.getMessage());
                    }
                });
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);

    }

}
