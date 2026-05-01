package com.example.kimbegivenhed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kimbegivenhed.databinding.ItemEventBinding;

import java.util.List;

//EventAdapter er en bro mellem RecyclerView og data (Event-listen).
//Den sørger for at vise hvert event i en række ved at binde data (navn og dato) til layoutet i onBindViewHolder
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> events;
    private Context context;

//    Constructor til EventAdapter
//    Modtager listen af events og context (bruges til intents, dialogs osv.)
    public EventAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    // ViewHolder holder referencer til UI-elementerne i ét item i RecyclerView
    // Bruger ViewBinding istedet for findViewById
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemEventBinding binding;

        public ViewHolder(ItemEventBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    // Opretter en ny ViewHolder når RecyclerView har brug for en ny række
    // Inflater item layoutet (item_event.xml)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEventBinding binding = ItemEventBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = events.get(position);

        holder.binding.tvName.setText(event.getName());
        holder.binding.tvDate.setText(event.getDate());

        // Detaljer
        holder.binding.btnDetails.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("image", event.getImageResId());
            intent.putExtra("name", event.getName());
            intent.putExtra("date", event.getDate());
            intent.putExtra("desc", event.getDescription());
            intent.putExtra("url", event.getUrl());
            context.startActivity(intent);
        });

        // Tilmeldings-dialog
        holder.binding.btnSignup.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Tilmelding")
                    .setMessage("Er du sikker på, du vil tilmelde dig " + event.getName() + "?")
                    .setPositiveButton("Ja", (dialog, which) -> {
                        Toast.makeText(context, "Tilmeldt!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Nej", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}