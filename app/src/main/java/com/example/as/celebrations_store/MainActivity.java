package com.example.as.celebrations_store;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private SliderAdapter sliderAdapter;
	private ViewPager sliderViewPager;
	private LinearLayout dotsLayout;
	private Button backButton;
	private Button nextButton;
	private Button finishButton;
	private TextView[] mDots;
	private  int currentPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sliderViewPager = (ViewPager) findViewById (R.id.slider_view_pager);
		dotsLayout = (LinearLayout) findViewById(R.id.dots_layout);
		backButton = (Button) findViewById(R.id.back_button);
		nextButton = (Button) findViewById(R.id.next_btn);
		finishButton = (Button) findViewById(R.id.finish_btn);

		sliderAdapter = new SliderAdapter(this);
		sliderViewPager.setAdapter(sliderAdapter);
		addDotsIndicator(sliderAdapter.getCount(), 0);
		sliderViewPager.addOnPageChangeListener(onPageChangeListener);

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sliderViewPager.setCurrentItem(currentPage + 1);
			}
		});

		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sliderViewPager.setCurrentItem(currentPage - 1);
			}
		});

		finishButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), Login.class);
				startActivity(intent);
			}
		});
	}




	public void addDotsIndicator(int dotCount, int selectedPagePostion){

		mDots = new TextView[dotCount];
		dotsLayout.removeAllViews();

		for(int i=0; i<mDots.length; i++){
			mDots[i] = new TextView(this);
			mDots[i].setText(Html.fromHtml("&#8226"));
			mDots[i].setTextSize(35);
			mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
			dotsLayout.addView(mDots[i]);
		}

		if(mDots.length > 0){
			mDots[selectedPagePostion].setTextColor(getResources().getColor(R.color.colorWhite));
		}
	}

	ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageScrolled(int i, float v, int i1) {

		}

		@Override
		public void onPageSelected(int i) {
			addDotsIndicator(sliderAdapter.getCount(), i);
			currentPage = i;
			if(i == 0){
				setButtonStateText(true, true, View.INVISIBLE,  View.VISIBLE,  View.GONE,"Next", "");
			}
			else if(i == mDots.length - 1){
				setButtonStateText(true, true, View.VISIBLE,  View.GONE, View.VISIBLE,"Finish", "Back");
			}
			else {
				setButtonStateText(true, true, View.VISIBLE,  View.VISIBLE, View.GONE,"Next", "Back");
			}
		}

		@Override
		public void onPageScrollStateChanged(int i) {

		}
	};
	public void setButtonStateText(boolean enableNextBtn, boolean enableBackBtn, int backBtnVisibility, int nextBtnVisibility, int finishBtnVisibility, String nextBtnText, String backBtnText){
		nextButton.setEnabled(enableNextBtn);
		backButton.setEnabled(enableBackBtn);
		backButton.setVisibility(backBtnVisibility);
		nextButton.setVisibility(nextBtnVisibility);
		finishButton.setVisibility(finishBtnVisibility);
		nextButton.setText(nextBtnText);
		backButton.setText(backBtnText);
	}
}

