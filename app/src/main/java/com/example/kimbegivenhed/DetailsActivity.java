package com.example.kimbegivenhed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kimbegivenhed.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private String url;

    // Starter activity og sætter UI op med viewBinding. Navn, dato og beskrivelse bliver vist via intent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String date = intent.getStringExtra("date");
        String desc = intent.getStringExtra("desc");
        url = intent.getStringExtra("url");
        int image = getIntent().getIntExtra("image", R.drawable.begivn);

        binding.imgEvent.setImageResource(image);
        binding.tvTitle.setText(name);
        binding.tvDate.setText(date);
        binding.tvDesc.setText(desc);

        // Åbner browser med eventets URL, hvis der er sendt en url
        binding.btnOpenBrowser.setOnClickListener(v -> {

            if (url != null && !url.isEmpty()) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browser);
            }
        });

        // Lukker DetailsActivity og går tilbage til forrige skærm
        binding.btnBack.setOnClickListener(v -> finish());
    }
    @Override public boolean onSupportNavigateUp() { finish(); return true; }

}