package com.example.kimbegivenhed;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kimbegivenhed.databinding.ActivityAddEventBinding;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddEventActivity extends AppCompatActivity {

    private ActivityAddEventBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // DatePicker
        binding.etDate.setOnClickListener(v -> showDatePicker());

        // Gem event og returnér til MainActivity
        binding.btnSave.setOnClickListener(v -> {

            String name = binding.etName.getText().toString().trim();
            String date = binding.etDate.getText().toString().trim();
            String desc = binding.etDesc.getText().toString().trim();

            Intent result = new Intent();
            result.putExtra("name", name);
            result.putExtra("date", date);
            result.putExtra("desc", desc);

            setResult(RESULT_OK, result);
            finish();
        });
    }

    // Få DatePicker frem og hent dato og indsæt det i etText felt med formateret dato: dd/MM/yyyy
    private void showDatePicker() {

        MaterialDatePicker<Long> picker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Vælg dato")
                        .build();

        picker.addOnPositiveButtonClickListener(selection -> {

            SimpleDateFormat sdf =
                    new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

            String date = sdf.format(new Date(selection));

            binding.etDate.setText(date);
        });

        picker.show(getSupportFragmentManager(), "DATE_PICKER");
    }
}