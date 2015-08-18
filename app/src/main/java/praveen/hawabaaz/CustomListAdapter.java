package praveen.hawabaaz;

/**
 * Created by BALA on 8/18/2015.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    //private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] itemname) {
        super(context, R.layout.liststruct, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.liststruct, null,true);
        TextView itname = (TextView) rowView.findViewById(R.id.proname);
        itname.setText(itemname[position]);
        return rowView;
    };
}