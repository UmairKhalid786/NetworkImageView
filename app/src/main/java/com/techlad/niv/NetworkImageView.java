package com.techlad.niv;

/*
 *   Created     : Mar 15, 2019 11:48 PM
 *   Author      : Umair
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class NetworkImageView extends AppCompatImageView {

	private boolean enableCache         = false;

	private int defaultImage = R.drawable.ic_launcher_background;

	public NetworkImageView(Context context) {
		super(context);
	}

	public NetworkImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public NetworkImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	public void init(Context context, AttributeSet attrs) {

		TypedArray a = context.getTheme().obtainStyledAttributes(
			attrs,
			R.styleable.NetworkImageView,
			0, 0);

		try {

			String url = a.getString(R.styleable.NetworkImageView_networkUrl);

			enableCache = a.getBoolean(R.styleable.NetworkImageView_cacheEnable , false);
			defaultImage = a.getResourceId(R.styleable.NetworkImageView_defaultImage , R.drawable.ic_launcher_background);

			loadImage(url);
		} finally {
			a.recycle();
		}

	}

	public void setEnableCache(boolean enableCache) {
		this.enableCache = enableCache;
	}

	public void loadFromURL(String url){
		loadImage(url);
	}

	public void loadFromURL(String url , boolean enableCache){
		this.enableCache = enableCache;

		loadImage(url);
	}

	public void loadFromURL(String url , boolean enableCache , int defaultImage){
		this.defaultImage = defaultImage;

		loadFromURL(url,enableCache);
	}

	public void loadFromURL(String url , boolean enableCache ,int defaultImage , int errorImage){
		this.defaultImage = defaultImage;

		loadFromURL(url,enableCache);
	}

	private void loadImage(String url){

		Glide.with(getContext()).load(url)
			.diskCacheStrategy(enableCache ? DiskCacheStrategy.ALL : DiskCacheStrategy.NONE)
			.error(defaultImage)
			.placeholder(defaultImage)
			.into(this);

		invalidate();
	}
}
