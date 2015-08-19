package praveen.hawabaaz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recipies extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private CustomRecipiesListAdapter defaultAdapter;


    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipies);
        listview = (ListView) findViewById(R.id.recipies);
        ArrayList list= new ArrayList();
        list.add("Recipie One");
        list.add("Recipie Two");
        list.add("Recipie three");
        list.add("Recipie Four");
        list.add("Recipie Five");

        defaultAdapter = new CustomRecipiesListAdapter(this,list);
        listview.setAdapter(defaultAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),RecipieDetails.class));
            }
        });

        ((TextView)findViewById(R.id.cart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_locations, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void orderpage(View v) {
        Intent i2 = new Intent(this, OrdersActivity.class);
        startActivity(i2);
    }


    class CustomRecipiesListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final ArrayList itemname;
        //private final Integer[] imgid;

        public CustomRecipiesListAdapter(Activity context, ArrayList itemname) {
            super(context, R.layout.recipie_list_entry, itemname);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.itemname=itemname;
        }

        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.recipie_list_entry, parent,false);
            TextView name = (TextView) rowView.findViewById(R.id.name);
            name.setText((String)itemname.get(position));
            return rowView;
        };
    }
}
