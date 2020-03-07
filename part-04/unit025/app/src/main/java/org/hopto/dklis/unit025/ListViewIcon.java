package org.hopto.dklis.unit025;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewIcon extends AppCompatActivity {

    private static final String ITEM_TITLE = "Item title";
    private static final String ITEM_ICON = "Item icon";

    private TextView mTxtR;
    private ListView mListViewRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_icon);

        mTxtR = findViewById(R.id.txtR);
        mListViewRegion = findViewById(R.id.listViewRegion);

        String[] regionList = getResources().getStringArray(R.array.region_list);
        TypedArray regionIconList =
                getResources().obtainTypedArray(R.array.region_icon_list);
        List<Map<String, Object>> itemList = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < regionList.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put(ITEM_TITLE, regionList[i]);
            item.put(ITEM_ICON, regionIconList.getResourceId(i, 0));
            itemList.add(item);
        }

        SimpleAdapter simAdapListViewRegion = new SimpleAdapter(
                ListViewIcon.this, itemList,
                R.layout.list_view_item,
                new String[] {ITEM_TITLE, ITEM_ICON},
                new int[] {R.id.txtView, R.id.imgView}){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Cast the current view as a TextView
                View view = super.getView(position,convertView,parent);
                LinearLayout v = (LinearLayout) view.findViewById(R.id.loutItems);

                /*
                    setGravity
                        void setGravity (int gravity)

                        Sets the horizontal alignment of the text and the vertical gravity that
                        will be used when there is extra space in the TextView beyond what
                        is required for the text itself.
                */
                /*
                    Gravity
                        END
                            Push object to x-axis position at the end of its container, not changing its size.

                        RIGHT
                            Push object to the right of its container, not changing its size.

                        CENTER_VERTICAL
                            Place object in the vertical center of its container, not changing its size.
                */
                // Set the item text gravity to right/end and vertical center
                v.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);

                // Return the view
                return v;
            }
        };
        mListViewRegion.setAdapter(simAdapListViewRegion);

        mListViewRegion.setOnItemClickListener(listViewRegionOnItemClick);
    }

    private AdapterView.OnItemClickListener listViewRegionOnItemClick
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String s = getString(R.string.region_selected);
            TextView txtView = view.findViewById(R.id.txtView);
            mTxtR.setText(s + txtView.getText());
        }
    };
}
