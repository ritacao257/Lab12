package edu.illinois.cs.cs125.spring2019.lab12;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mitch on 2016-05-13.
 */
public class ViewListContents extends AppCompatActivity {

    /**
     * comment.
     */
    private DataBaseHelper myDB;

    /**
     * comment.
     */
    private ArrayList<ToDos> todoList;

    /**
     * comment.
     */
    private ListView listView;

    /**
     * comments.
     *
     */
    private ToDos todos;

    /**
     * comments.
     * @param savedInstanceState state.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsecond);

        myDB = new DataBaseHelper(this);

        todoList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(ViewListContents.this, "The TodoList is empty  :(.", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                todos = new ToDos(data.getString(1));
                todoList.add(i, todos);
                System.out.println(data.getString(1));
                System.out.println(todoList.get(i).getThing());
                i++;
            }
            MainActivitySecond adapter =  new MainActivitySecond(this, R.layout.list_adapter, todoList);
            listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }
    }
}
