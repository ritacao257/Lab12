package edu.illinois.cs.cs125.spring2019.lab12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mitch on 2016-05-06.
 */
public class MainActivitySecond extends ArrayAdapter<ToDos> {

    /**
     * comments.
     */
    private LayoutInflater mInflater;
    /**
     * comments.
     */
    private ArrayList<ToDos> toDos;
    /**
     * comments.
     */
    private int mViewResourceId;

    /**
     * comments.
     * @param context context.
     * @param textViewResourceId id.
     * @param todos todos.
     */
    public MainActivitySecond(Context context, int textViewResourceId, ArrayList<ToDos> todos) {
        super(context, textViewResourceId, todos);
        this.toDos = todos;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    /**
     * comments.
     * @param position position.
     * @param convertView view.
     * @param parent parent.
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        ToDos user = toDos.get(position);

        if (user != null) {
            TextView thing = (TextView) convertView.findViewById(R.id.textView);
            if (thing != null) {
                thing.setText(user.getThing());
            }
        }

        return convertView;
    }
}
