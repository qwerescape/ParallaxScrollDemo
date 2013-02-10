package com.chao.parallaxscrolldemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity implements OnScrollListener {
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.list_view);
		listView.setAdapter(new ImageAdapter(this));
		listView.setOnScrollListener(this);
	}

	@Override
	public void onScroll(AbsListView listView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		if (visibleItemCount > 0){
			View topItem = listView.getChildAt(0);
			ImageView image = (ImageView)topItem.findViewById(R.id.image_view);
			int scrollOffset = topItem.getTop();
			image.setTranslationY((float)(scrollOffset*-0.5));
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {}

	public class ImageAdapter extends BaseAdapter {
		private List<Integer> imageResourceList;
		private Context context;

		public ImageAdapter(Context context) {
			this.context = context;
			imageResourceList = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {
				imageResourceList.add(R.drawable.img1);
				imageResourceList.add(R.drawable.img2);
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageResourceList.size();
		}

		@Override
		public Object getItem(int position) {
			return imageResourceList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertedView, ViewGroup parent) {
			View listItem;
			listItem = new ListViewItem(context);
			ImageView imgView = (ImageView) listItem.findViewById(R.id.image_view);
			imgView.setImageResource((Integer) this.getItem(position));
			return listItem;
		}

	}
}
