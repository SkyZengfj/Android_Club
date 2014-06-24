package net.sky.app.android.club;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	private List<ClubItem> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		initClubItems();
		initListView();
	}

	private void initClubItems() {
		items = new ArrayList<ClubItem>();

//		items.add(new ClubItem("11111", MainActivity.this));
	}

	private void initListView() {
		lv = new ListView(getApplicationContext());
		setContentView(lv);
		ArrayAdapter<ClubItem> adapter = new ArrayAdapter<ClubItem>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, items);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				ClubItem item = items.get(arg2);
				startActivity(new Intent(getApplicationContext(), item.activity.getClass()));
			}
		});
	}

	private class ClubItem {
		public String name;
		public Activity activity;

		public ClubItem(String name, Activity activity) {
			this.name = name;
			this.activity = activity;
		}

		@Override
		public String toString() {
			return name;
		}
	}
}
