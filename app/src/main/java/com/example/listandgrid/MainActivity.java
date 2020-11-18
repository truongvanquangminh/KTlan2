package com.example.listandgrid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListviewBaseAdapter adapter;
    ArrayList<ListviewModel> listviewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        listviewData = new ArrayList<>();

        listviewData.add(new ListviewModel(R.drawable.a1, "Vinmart", "Chuỗi siêu thị uy tín. Sản phẩm đa dạng, vận chuyển siêu tốc", R.drawable.ic_baseline_control_point,"Tích 3%"));
        listviewData.add(new ListviewModel(R.drawable.a2, "Meiji","Nhãn hiệu sữa bán chạy số 1 Nhật Bản", R.drawable.ic_baseline_control_point,"Tích 5%"));
        listviewData.add(new ListviewModel(R.drawable.a3, "Bác Tôm","Thực phẩm sạch đặc sản vùng miền", R.drawable.ic_baseline_control_point,"Tích 5%"));
        listviewData.add(new ListviewModel(R.drawable.a4, "Fruit shop", "Nhà bán lẻ trái cây nhập khẩu", R.drawable.ic_baseline_control_point,"Tích 5%"));
        listviewData.add(new ListviewModel(R.drawable.a5, "Dũng Hà", "Bring nature to your home", R.drawable.ic_baseline_control_point,"Tích 5%"));

        adapter = new ListviewBaseAdapter(this, listviewData);

        listView.setAdapter(adapter);
        //Chuyển đến trang khác
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
        listView.setOnItemLongClickListener(new ItemLongClickRemove()); //Gọi lại sự kiện xóa
    }
//Sự kiện xóa 1 list
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bạn có muốn xóa sản phẩm này không?");
            alertDialogBuilder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    listviewData.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}