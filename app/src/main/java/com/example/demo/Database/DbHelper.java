package com.example.demo.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    private static final String TAG = "DbHelper";
    public static String DB_NAME = "demo.sqlite";
    private static String DB_PATH = "";
    Context context;
    private  static  SQLiteDatabase mDb;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        DB_PATH = "/data/data/" + context.getPackageName() + "databases";
        this.context = context;

    }

    private static final String TABLE_CREATE_LOGIN = "create table if not exists login(id integer primary key autoincrement, name text, email_id text, " +
            "contact_no text,address text ,password text)";


    public void createDatabase() throws IOException {
        boolean dbexist = checkDatabase();

        if (dbexist) {
            this.getReadableDatabase();
            this.close();
        } else {
            this.getReadableDatabase();
            try {
                copyDatabase();
                Log.e(TAG, "createDatabase database created");

            } catch (IOException e) {
                throw new Error("Error copying database");
            }

        }
    }


    public boolean checkDatabase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }


    private void copyDatabase() throws  IOException {
        InputStream myInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


    public boolean openDataBase() throws SQLException {
        // Open the database
        String myPath = DB_PATH + DB_NAME;
        mDb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDb != null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.mDb = db;

        db.execSQL(TABLE_CREATE_LOGIN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
