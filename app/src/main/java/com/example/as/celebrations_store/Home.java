package com.example.as.celebrations_store;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Home extends AppCompatActivity {



	private TextView mTextMessage;
	Fragment selectedFragment = null;

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
		= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_store:
					selectedFragment = FrStore.newInstance("sdadad", "dsadadd");
					break;
				case R.id.navigation_offer:
					selectedFragment = FrOffer.newInstance("", "");
					break;
				case R.id.navigation_cart:
					selectedFragment = FrCart.newInstance("", "");
					break;
				case R.id.navigation_profile:
					selectedFragment = FrProfile.newInstance("", "");
					break;
			}
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.frame_layout, selectedFragment);
			transaction.commit();
			//Manually displaying the first fragment - one time only

			return true;

		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mTextMessage = (TextView) findViewById(R.id.message);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.frame_layout, FrStore.newInstance("", ""));
		transaction.commit();

	}


}
