package com.example.practica4_implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.practica4_implicitintents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(v->{
            String titulo = binding.bookTitle.getText().toString();
            String autor = binding.bookAuthors.getText().toString();
            String comentario = binding.bookComment.getText().toString();
            float rate = binding.ratingBook.getRating();

            Book book = new Book(titulo, autor, comentario, rate);

            openDetailActivity(book);
        });
    }

    private void openDetailActivity(Book book) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("BOOK_EXTRA", book);
        startActivity(intent);
    }
}