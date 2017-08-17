package breadboy.com.tribe.eventmanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewUsers extends AppCompatActivity {
    SQLiteDatabase db;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        display = (TextView)findViewById(R.id.display);
        createDatabase("event");
        display.setText(readData());
    }

    public void createDatabase(String dbname){
        db = openOrCreateDatabase(dbname, MODE_PRIVATE, null);
    }


    public String readData(){
        String result = "";
        Cursor resultSet = db.rawQuery("Select * from users",null);
        if(resultSet != null) {
            while (resultSet.moveToNext()) {
                String username = resultSet.getString(0);
                String password = resultSet.getString(1);
                result += username + "  " + password + "\n";
            }
        }
        return result;

    }

}
