package com.example.as.celebrations_store;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrStore.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrStore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrStore extends Fragment {

	private static final String TAG = "MainActivity";

	//vars
	private ArrayList<String> mNames = new ArrayList<>();
	private ArrayList<String> mImageUrls = new ArrayList<>();



	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	private OnFragmentInteractionListener mListener;

	public FrStore() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment FrStore.
	 */
	// TODO: Rename and change types and number of parameters
	public static FrStore newInstance(String param1, String param2) {
		FrStore fragment = new FrStore();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	private void getImages(Context context){
		Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

		mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
		mNames.add("Havasu Falls");

		mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
		mNames.add("Trondheim");

		mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
		mNames.add("Portugal");

		mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
		mNames.add("Rocky Mountain National Park");


		mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
		mNames.add("Mahahual");

		mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
		mNames.add("Frozen Lake");


		mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
		mNames.add("White Sands Desert");

		mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
		mNames.add("Austrailia");

		mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
		mNames.add("Washington");

		initRecyclerView(context);

	}

	private void initRecyclerView(Context context){
		Log.d(TAG, "initRecyclerView: init recyclerview");

		LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
		RecyclerView recyclerView = getView().findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(layoutManager);
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, mNames, mImageUrls);
		recyclerView.setAdapter(adapter);
	}



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		getImages(getContext());
		return inflater.inflate(R.layout.fragment_fr_store, container, false);
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}
}
