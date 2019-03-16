package com.techlad.niv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		NetworkImageView imageView = findViewById(R.id.network_img);
		//No need write 10 to 20 lines of code to load network image
		imageView.loadFromURL("https://dummyimage.com/600x400/000/fff&text=Network+Image");
		//Cache image for next time
		imageView.setEnableCache(true);
	}
}
