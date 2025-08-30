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
import com.google.android.material.tabs.TabLayout;

public class ItemsMiniatura extends AppCompatActivity {
    MaterialToolbar toolbar;
    ViewPager2 idViewPagerItensMiniatura;
    TabLayout idTableLayoutItemsMiniatura;

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

        idViewPagerItensMiniatura = findViewById(R.id.idViewPagerItensMiniatura);
        idTableLayoutItemsMiniatura = findViewById(R.id.idTableLayoutItemsMiniatura);

        var x = new AdapterItensMiniatura(this);

        idViewPagerItensMiniatura.setAdapter(x);

        idTableLayoutItemsMiniatura.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                idViewPagerItensMiniatura.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        idViewPagerItensMiniatura.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                idTableLayoutItemsMiniatura.getTabAt(position).select();
            }
        });
    }
}