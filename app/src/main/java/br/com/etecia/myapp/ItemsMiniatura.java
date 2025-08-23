package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;

public class ItemsMiniatura extends AppCompatActivity {
    MaterialToolbar toolbar;
    ViewPager2 idViewPagerItensMiniatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.items_miniatura_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.idToolbar);
        toolbar.setNavigationOnClickListener((ev) -> {
            startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
        });

        idViewPagerItensMiniatura = findViewById(R.id.idViewPagerItensMiniatura);
    }
}