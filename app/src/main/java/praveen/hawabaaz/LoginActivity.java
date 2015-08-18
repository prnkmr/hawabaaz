package praveen.hawabaaz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void LoginCheck(View v) {
        Intent i1 = new Intent(this, Locations.class);
        EditText usrname = (EditText) findViewById(R.id.email);
        String uname = usrname.getText().toString();
        i1.putExtra("email", uname);
        startActivity(i1);
    }

    public void RegisterActivity(View v) {
        Intent i2 = new Intent(this, RegisterActivity.class);
        startActivity(i2);
    }
}
