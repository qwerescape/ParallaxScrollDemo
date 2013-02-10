package com.chao.parallaxscrolldemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ListViewItem extends LinearLayout {

	public ListViewItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater.from(context).inflate(R.layout.image_view_layout, this);
	}
	
	public ListViewItem(Context context, AttributeSet attrs){
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.image_view_layout, this);
	}
	
	public ListViewItem(Context context){
		super(context);
		LayoutInflater.from(context).inflate(R.layout.image_view_layout, this);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
}
