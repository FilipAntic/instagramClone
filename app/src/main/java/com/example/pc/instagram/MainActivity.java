package com.example.pc.instagram;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.pc.instagram.database.mongodb.FirebaseDatabaseHelper;
import com.example.pc.instagram.profileTabs.GridViewProfile;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        if (mAuth.getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this, Login.class));
        }
        FirebaseDatabaseHelper db = new FirebaseDatabaseHelper();

        viewPager = findViewById(R.id.mainViewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.mainTabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.search);
        tabLayout.getTabAt(2).setIcon(R.drawable.addpost);
        tabLayout.getTabAt(3).setIcon(R.drawable.heartgrey);
        tabLayout.getTabAt(4).setIcon(R.drawable.testimg);

    }

    private void setupViewPager(ViewPager viewPager) {
        ProfilePagerAdapter adapter = new ProfilePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GridViewProfile(), "");
        adapter.addFragment(new GridViewProfile(), "");
        adapter.addFragment(new GridViewProfile(), "");
        adapter.addFragment(new GridViewProfile(), "");
        adapter.addFragment(new Profile(), "");
        viewPager.setAdapter(adapter);
    }

}
