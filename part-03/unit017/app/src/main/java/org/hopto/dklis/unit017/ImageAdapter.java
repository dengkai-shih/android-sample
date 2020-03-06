package org.hopto.dklis.unit017;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * ImageAdapter 類別中 getCount() , getItem() ...等 callback function，是供 Android 系統在執行 app 的
 * 過程中，透過 callback function 互動、完成該執行的事項。
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;    // 儲存程式執行的環境
    private Integer[] miImgArr;  // 儲存影像縮圖 id 陣列

    public ImageAdapter(Context context, Integer[] imgarr) {
        mContext = context;
        miImgArr = imgarr;
    }

    @Override
    public int getCount() {
        /* ImageArray 的長度 */
        return miImgArr.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * getView 的功能是回傳一個 ImageView 的物件給 Android 系統顯示使用
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView v;

        /**
         * 如果 convertView 是 null，就建立一個新的 ImageView 物件。
         * 如果 convertView 不是 null，就重複使用。
         */
        if (convertView == null) {
            v = new ImageView(mContext);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            v.setLayoutParams(new GridView.LayoutParams(params));
            v.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            v.setPadding(10, 10, 10,10);
        }  else {
            v = (ImageView) convertView;
        }

        /**
         * 把要顯示的縮圖放到 ImageView 物件中
         */
        v.setImageResource(miImgArr[position]);

        return v;
    }
}
