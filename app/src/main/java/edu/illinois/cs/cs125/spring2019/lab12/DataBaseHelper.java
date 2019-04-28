package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * comment.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    /**
     * comments.
     */
    public static final String DATABASE_NAME = "users.db";
    /**
     * comments.
     */
    public static final String TABLE_NAME = "users_data";
    /**
     * comments.
     */
    public static final String COL1 = "ID";

    /**
     * COMMENTS.
     */
    public static final String COL2 = "TODOS";
    /**
     * comments.
     * @param context
     */
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * comments
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " TODOS TEXT)";
        db.execSQL(createTable);
    }

    /**
     * COMMENTS.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * COMMENTS.
     * @param things
     * @return
     */
    public boolean addData(String things) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, things);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * comments.
     */
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
