package breadboy.com.tribe.eventmanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText username, password;
    Intent ViewUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        ViewUsers = new Intent(this, ViewUsers.class);
        createDatabase("event");
        createTable();
    }




    public void createDatabase(String dbname){
        db = openOrCreateDatabase(dbname, MODE_PRIVATE, null);
    }

    public void createTable(){
        db.execSQL("CREATE TABLE IF NOT EXISTS users(username VARCHAR,password VARCHAR);");
    }

    public void register(View view){
        String muser = username.getText().toString();
        String mpass = password.getText().toString();
        createAccount(muser, mpass);
    }

    public void createAccount(String username, String password){
        db.execSQL("INSERT INTO users VALUES('"+username+"','"+password+"');");
    }

    public void view(View view){
        startActivity(ViewUsers);
    }
}
