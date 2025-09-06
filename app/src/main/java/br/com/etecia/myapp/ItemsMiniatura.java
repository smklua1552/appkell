package br.com.etecia.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ItemsMiniatura extends AppCompatActivity {
    MaterialToolbar toolbar;

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.items_miniatura_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0, systemBars.top, 0, 0);
            return insets;
        });
        toolbar = findViewById(R.id.idToolbar);
        toolbar.setNavigationOnClickListener((ev) -> {
            startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
        });

        bottomNavigationView = findViewById(R.id.idBottomNavigationView);
        frameLayout = findViewById(R.id.idFrameLayout);

        bottomNavigationView.setOnItemSelectedListener((MenuItem item) -> {
            Fragment fragment = null;

            if (item.getItemId() == R.id.mMiniaturas) {
                fragment = new MiniaturasFragment();
            } else if (item.getItemId() == R.id.mAcessorios) {
                fragment = new AcessoriosFragment();
            } else if (item.getItemId() == R.id.mLoja) {
                fragment = new LojaFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.idFrameLayout, fragment).commit();

            return true;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.idFrameLayout, new MiniaturasFragment()).commit();
        }
    }
}