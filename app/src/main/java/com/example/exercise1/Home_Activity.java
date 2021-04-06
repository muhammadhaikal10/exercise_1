package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {

    SearchView searchView;
    private ListView list;
    private ListViewAdapter adapter;
    String[] listnama;
    public static ArrayList<com.example.exercise1.ClassNama> classNamaArrayList = new ArrayList<com.example.exercise1.ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    ArrayAdapter<String > arrayAdapter;
    String namakontak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView = findViewById(R.id.search_bar);
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina",
                "Gita", "Vian", "Luthfi"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listnama);
        list = findViewById(R.id.listkontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.exercise1.ClassNama classNama = new com.example.exercise1.ClassNama(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new ListViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    namakontak = classNamaArrayList.get(position).getName();
                    bundle.putString("a", namakontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(Home_Activity.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();



                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Home_Activity.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Home_Activity.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor = namakontak.trim();
                String isinomor = "";
                if (nomor == "Inayah"){
                    isinomor = "082208220822";
                }
                else if (nomor == "Ilham"){
                    isinomor = "082222222222";
                }
                else if (nomor == "Eris"){
                    isinomor = "082222222223";
                }
                else if (nomor == "Fikri"){
                    isinomor = "082222222224";
                }
                else if (nomor == "Maul"){
                    isinomor = "082222222225";
                }
                else if (nomor == "Intan"){
                    isinomor = "082222222226";
                }
                else if (nomor == "Vina"){
                    isinomor = "082222222227";
                }
                else if (nomor == "Gita"){
                    isinomor = "082222222228";
                }
                else if (nomor == "Vian"){
                    isinomor = "082222222229";
                }
                else if (nomor == "Luthfi"){
                    isinomor = "082222222220";
                }

                Toast.makeText(getApplicationContext(), isinomor,
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

}