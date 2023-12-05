package com.example.practica4_implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practica4_implicitintents.databinding.ActivityDetailBinding;
import com.example.practica4_implicitintents.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Book book = extras.getParcelable("BOOK_EXTRA");

            binding.bookTitle.setText(book.getTitle());
            binding.autorsText.setText(book.getAuthor());
            binding.commentsText.setText(book.getComment());
            binding.ratingBar.setRating(book.getRate());
        }
    }
}