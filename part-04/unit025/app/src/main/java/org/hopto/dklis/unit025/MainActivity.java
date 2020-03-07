package org.hopto.dklis.unit025;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtR;
    private ListView mListViewRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtR = findViewById(R.id.txtR);
        mListViewRegion = findViewById(R.id.listViewRegion);

        /* 設定選單給 ListView 元件 */
        ArrayAdapter<CharSequence> arrAdapRegion
                = ArrayAdapter.createFromResource(getApplication(),
                R.array.region_list,
                android.R.layout.simple_list_item_1);
        mListViewRegion.setAdapter(arrAdapRegion);
        mListViewRegion.setOnItemClickListener(listViewRegionOnItemClick);
    }

    private AdapterView.OnItemClickListener listViewRegionOnItemClick
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (i == 4) {
                mTxtR.setText("GG");
                Intent intent = new Intent(getApplicationContext(), ListViewIcon.class);
                startActivity(intent);
            }  else {
                String s = getString(R.string.region_selected);
                mTxtR.setText(s + ((TextView) view).getText());
            }
        }
    };
}
