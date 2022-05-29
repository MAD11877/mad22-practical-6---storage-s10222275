package sg.np.edu.mad.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBhandler extends SQLiteOpenHelper {
    public DBhandler(Context c){

        super(c,"Practical6.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql ="CREATE TABLE User(Username TEXT, Id INTEGER PRIMARY KEY AUTOINCREMENT,Followed BOOLEAN,Description TEXT)";
        Log.e("test","test");
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Username",u.getName());

        cv.put("Followed",u.getFollowed());
        cv.put("Description",u.getDescription());
        db.insert("User",null,cv);


        db.close();

    }
    public void onUpdate(User u){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        int status = 1;
        if(u.getFollowed()){
            status=0;
        }


        values.put("Username", u.getName());
        values.put("Id", u.getId());
        values.put("Followed", status);
        values.put("Description", u.getDescription());

        // Inserting Row
        db.update("User",values,"Id ="+u.getId(),null);
        db.close(); // Closing database connection



    }
    public ArrayList<User> getUsers(){

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<User> List = new ArrayList<User>();
        Cursor cursor = db.rawQuery("SELECT * FROM USER",null);
        while(cursor.moveToNext()){//.movetext return bool when there is data or not
            User m =new User();
            m.setName(cursor.getString(0));
            m.setId(cursor.getInt(1));
            m.setDescirption(cursor.getString(3));
            boolean value = cursor.getInt(2) == 0;
            m.setFollowed(value);
            List.add(m);

        }

        return List;
    }
}
