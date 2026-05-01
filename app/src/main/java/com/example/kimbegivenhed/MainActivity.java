package com.example.kimbegivenhed;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kimbegivenhed.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EventAdapter adapter;
    private List<Event> eventList;
    private List<Event> filteredList;
    private ActivityResultLauncher<Intent> addEventLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(
                binding.getRoot(),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                }
        );

        // ActivityResultLauncher
        addEventLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                        Intent data = result.getData();

                        String name = data.getStringExtra("name");
                        String date = data.getStringExtra("date");
                        String desc = data.getStringExtra("desc");

                        eventList.add(new Event(
                                R.drawable.begivn,
                                name,
                                date,
                                desc,
                                "https://novocento.dk"
                        ));

                        filteredList.clear();
                        filteredList.addAll(eventList);

                        adapter.notifyDataSetChanged();

                        Toast.makeText(this, "Event tilføjet", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Data
        eventList = new ArrayList<>();

        eventList.add(new Event(
                R.drawable.begivn,
                "Hjemmeside",
                "10/05/2026",
                "Snak om hjemmeside",
                "https://novocento.dk"
        ));

        eventList.add(new Event(
                R.drawable.skak,
                "Skak",
                "12/05/2026",
                "Min ven og jeg skal spille skak",
                "https://chess.com"
        ));

        eventList.add(new Event(
                R.drawable.risk,
                "Spileftermiddag",
                "15/05/2026",
                "Brætspil i Ballerup",
                "https://tec.dk"
        ));

        filteredList = new ArrayList<>(eventList);

        adapter = new EventAdapter(filteredList, this);
        binding.recyclerView.setAdapter(adapter);

        // Søgning
        binding.btnSearch.setOnClickListener(v -> filterEvents());

        // Tilføj event (NY metode)
        binding.btnAddEvent.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEventActivity.class);
            addEventLauncher.launch(intent);
        });
    }

    // Filtrerer events baseret på søgning
    private void filterEvents() {

        String query = binding.etSearch.getText().toString().toLowerCase().trim();

        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(eventList);
        } else {
            for (Event e : eventList) {
                if (e.getName().toLowerCase().contains(query)) {
                    filteredList.add(e);
                }
            }
        }

        adapter.notifyDataSetChanged();
    }
}