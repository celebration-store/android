package com.example.as.celebrations_store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

	Context context;
	LayoutInflater layoutInflater;

	public SliderAdapter(Context context){
		this.context = context;
	}

	// Arrays
	public int[] slide_images = {
		R.drawable.cake,
		R.drawable.gifts,
		R.drawable.cake
	};

	public String[] slide_heading = {
		"Cake",
		"Sleep",
		"Code"
	};


	@Override
	public int getCount() {
		return slide_heading.length;
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
		return view == (RelativeLayout) o;
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
		ImageView slideImageView = view.findViewById(R.id.slide_image);
		TextView slideHeading = view.findViewById(R.id.slide_heading);

		slideImageView.setImageResource(slide_images[position]);
		slideHeading.setText(slide_heading[position]);
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
		container.removeView((RelativeLayout)object);
	}
}
