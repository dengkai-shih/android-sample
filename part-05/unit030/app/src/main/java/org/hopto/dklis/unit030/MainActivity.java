package org.hopto.dklis.unit030;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 設定顯示AlertDialog的按鈕
        Button btnAlertDlg = findViewById(R.id.btnAlertDlg);
        btnAlertDlg.setOnClickListener(btnAlertDlgOnClick);

        // 設定顯示AlertDialog的按鈕
        Button btnListViewDlg = findViewById(R.id.btnListViewDlg);
        btnListViewDlg.setOnClickListener(btnListViewDlgOnClick);

        // 設定顯示AlertDialog的按鈕
        Button btnLayoutDlg = findViewById(R.id.btnLayoutDlg);
        btnLayoutDlg.setOnClickListener(btnLayoutDlgOnClick);
    }

    private View.OnClickListener btnAlertDlgOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder altDlgBuilder = new AlertDialog.Builder(MainActivity.this);
            altDlgBuilder.setTitle("AlertDialog");
            altDlgBuilder.setMessage("這是AlertDialog對話盒");
            altDlgBuilder.setIcon(android.R.drawable.ic_dialog_info);
            altDlgBuilder.setCancelable(false);

            // 設定AlertDialog對話盒的按鈕
            altDlgBuilder.setPositiveButton("是",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 用Toast訊息顯示按下的按鈕
                            Toast.makeText(MainActivity.this, "你按下「是」按鈕", Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
            altDlgBuilder.setNegativeButton("否",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 用Toast訊息顯示按下的按鈕
                            Toast.makeText(MainActivity.this, "你按下「否」按鈕", Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
            altDlgBuilder.setNeutralButton("取消",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 用Toast訊息顯示按下的按鈕
                            Toast.makeText(MainActivity.this, "你按下「取消」按鈕", Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

            altDlgBuilder.show();

        }
    };

    /**
     * 第二、我們來討論在AlertDialog裡利用List來呈現：
     * 接著，第二個處理事件，我們先建一個陣列，並且把字串丟進去AlertDialog，這樣它就會自動變成一個List
     */
    private View.OnClickListener btnListViewDlgOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String[] dinner = {"腿庫","雞蛋糕","沙威瑪","澳美客","麵線","麵疙瘩"};

            AlertDialog.Builder altDlgBuilder = new AlertDialog.Builder(MainActivity.this);
            altDlgBuilder.setTitle("利用List呈現");
            altDlgBuilder.setCancelable(false);
            altDlgBuilder.setItems(dinner,  new DialogInterface.OnClickListener(){
                /**
                 * 只要你在onClick處理事件內，使用 which 參數，就可以知道按下陣列裡的哪一個了
                 * @param dialog
                 * @param which
                 */
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    Toast.makeText(MainActivity.this, "你選的是" + dinner[which], Toast.LENGTH_SHORT).show();
                }
            });

            altDlgBuilder.show();

        }
    };

    /**
     * 第三、最後一個是把寫好的Layout丟進來，首先我們要先準備好一個xml
     *
     */
    private View.OnClickListener btnLayoutDlgOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 取得載入畫面配置資源用的物件
            LayoutInflater inflater = getLayoutInflater();

            // 載入對話框使用的畫面配置資源
            final View dialogView = inflater.inflate(R.layout.listview_dailog, null);

            // 建立對話框物件
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

            dialog.setView(dialogView).setTitle("Layout 塞入 AlertDlg");

            dialog.show();
        }
    };
}
