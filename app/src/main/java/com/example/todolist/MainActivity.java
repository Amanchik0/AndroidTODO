package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private ArrayList<String> items;
private LastView list;
private Button button;
private ArrayAdapter<String> itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        button = findViewById(R.id.button);

        button.setOnClickListenner(new View.OnClickListenner(){
            @Override
            public void OnClick(View view ){
                addItem(view);
            }
        });
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items) ;
        list.setAdapter(itemsAdapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Вызываем метод remove для удаления элемента на долгом нажатии
                remove(position);
                return true;
            }
        });
    }
    // Метод для удаления элемента из списка
    private void remove(int position) {
        Context context = getApplicationContext();
        Toast.makeText(context, "Item Remove", Toast.LENGTH_LONG).show();
        items.remove(position);
        itemsAdapter.notifyDataSetChanged();
        return true;
    }
    private void addItem(View view){
        EditText input = findViewById(R.id.edit_text);
        String itemText = input.getText().toString();
        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("")
        }
        else{
            Toast.makeText(getApplicationContext() , "Please enter text " , Toast.LENGTH_LONG)show();
        }
    }
}