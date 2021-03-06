package com.example.sowmyaram.popup_with_gridview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import static com.example.sowmyaram.popup_with_gridview.R.id.categoryimage;

public class MainActivity extends Activity {
    public final int CATEGORY_ID =0;
    private Context mContext;
    Dialog dialog;
    Button button ;
    private Object a;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        setContentView(R.layout.activity_main);
       button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                showDialog(CATEGORY_ID);
            }
        });
    }
    protected Dialog onCreateDialog(int id) {

        switch(id) {

            case CATEGORY_ID:

                AlertDialog.Builder builder;
                Context mContext = this;
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.categeory,(ViewGroup) findViewById(R.id.layout_root));
                final GridView gridview = (GridView)layout.findViewById(R.id.gridview);
                gridview.setAdapter(new ImageAdapter(this));

                gridview.setOnItemClickListener(new OnItemClickListener()
                {
                    public void onItemClick(AdapterView parent, View v,int position, long id) {
                        Toast.makeText(v.getContext(), "Position is "+position, Toast.LENGTH_LONG).show();
                        if(position==0){
                            button.setBackgroundResource(R.drawable.aqu_off);
                            dialog.dismiss();
                        }else  if(position==1){
                            button.setBackgroundResource(R.drawable.aqu_on);
                            dialog.dismiss();
                        }else  if(position==2){
                            button.setBackgroundResource(R.drawable.curt_on);
                            dialog.dismiss();
                        }else  if(position==3){
                            button.setBackgroundResource(R.drawable.curt_off);
                            dialog.dismiss();
                        }else  if(position==4){
                            button.setBackgroundResource(R.drawable.rgb_on);
                            dialog.dismiss();
                        }else  if(position==5){
                            button.setBackgroundResource(R.drawable.rgb_off);
                            dialog.dismiss();
                        }else  if(position==6){
                            button.setBackgroundResource(R.drawable.dimr_on);
                            dialog.dismiss();
                        }else  if(position==7){
                            button.setBackgroundResource(R.drawable.dimr_off);
                            dialog.dismiss();
                        }else  if(position==8){
                            button.setBackgroundResource(R.drawable.tv);
                            dialog.dismiss();
                        }else  if(position==9) {
                            button.setBackgroundResource(R.drawable.tv_on);
                            dialog.dismiss();
                        }


                    }
                });

                builder = new AlertDialog.Builder(mContext);
                builder.setView(layout);
                dialog = builder.create();
                break;
            default:
                dialog = null;
        }
        return dialog;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        public ImageAdapter(Context c) {
            mInflater = LayoutInflater.from(c);
            mContext = c;
        }
        public int getCount() {
            return mThumbIds.length;
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return 0;
        }
        // create a new ImageView for each item referenced by the
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {  // if it's not recycled,
                convertView = mInflater.inflate(R.layout.grid_custom_item, null);
                convertView.setLayoutParams(new GridView.LayoutParams(90, 90));
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.categoryText);
                holder.icon = (ImageView )convertView.findViewById(categoryimage);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.icon.setAdjustViewBounds(true);
            holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.icon.setPadding(8, 8, 8, 8);
          //  holder.title.setText(categoryContent[position]);
            holder.icon.setImageResource(mThumbIds[position]);
            return convertView;
        }
        class ViewHolder {
            TextView title;
            ImageView icon;
        }
        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.aqu_off, R.drawable.aqu_on,R.drawable.curt_on,
                R.drawable.curt_off,R.drawable.rgb_on, R.drawable.rgb_off,
                R.drawable.dimr_on, R.drawable.dimr_off,R.drawable.tv,R.drawable.tv_on
        };

    }
   /* private String[] categoryContent = {
            "Pubs", "Restuarants","shopping",
            "theatre","train", "taxi",
            "gas", "police","hospital","hospital"
    };
*/

}
