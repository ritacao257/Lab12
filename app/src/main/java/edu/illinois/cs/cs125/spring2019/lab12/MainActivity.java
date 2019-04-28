package edu.illinois.cs.cs125.spring2019.lab12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /**
     * comment.
     */
    private EditText input;

    /**
     * comment.
     */
    private Button btnAdd, btnView;

    /**
     * comment.
     */
    private DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.simpleEditText);
        btnAdd = (Button) findViewById(R.id.button);
        btnView = (Button) findViewById(R.id.button2);
        myDB = new DataBaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thing = input.getText().toString();
                if (thing.length() != 0) {
                    addData(thing);
                    input.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /**
     * comments
     * @param thing
     */
    public void addData(String thing) {
        boolean insertData = myDB.addData(thing);
        if (insertData == true) {
            Toast.makeText(MainActivity.this, "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}
