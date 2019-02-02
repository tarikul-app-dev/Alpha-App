package koffi.simplifiedcodingalpha.com.jonadanapaul.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import koffi.simplifiedcodingalpha.com.jonadanapaul.R;
import koffi.simplifiedcodingalpha.com.jonadanapaul.model.RelevanteFehlebilderModel;

public class RelevanteFehlerbilderAdapter extends BaseAdapter {
    private ArrayList<RelevanteFehlebilderModel> mReleFehler;
    private int mSelectedItem = 0;
    private int TAG_UNSELECTED = 0;
    private int TAG_SELECTED = 1;
    private LayoutInflater mInflater;
    Context mContext;

    public RelevanteFehlerbilderAdapter(ArrayList<RelevanteFehlebilderModel> releFehler, Context context) {
        this.mReleFehler = releFehler;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        // mcontacts = new ArrayList<>();

    }


    @Override
    public int getCount() {

        return mReleFehler.size();
    }

    @Override
    public RelevanteFehlebilderModel getItem(int position) {
        try {
            if (mReleFehler != null) {
                return mReleFehler.get(position);
            } else {
                return null;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return null;
    }
    public void selectItem(int position) {
        mSelectedItem = position;
        notifyDataSetChanged();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final RelevanteFehlebilderModel releFehlerModel = getItem(position);

        LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = vi.inflate(R.layout.relevante_fehlerbilder_list_item, null);
            holder = createViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        String itemName = releFehlerModel.getItemName();

        holder.itemName.setText(itemName);

        int type = getItemViewType(position);
        if(type == TAG_SELECTED) {

            holder.itemName.setTextColor(Color.parseColor("#ffffff"));
        } else {

            holder.itemName.setTextColor(Color.parseColor("#474747"));
        }
        return convertView;
    }





    // /////////// //
    // ViewHolder //
    // ///////// //
    private ViewHolder createViewHolder(View v) {
        ViewHolder holder = new ViewHolder();
        holder.itemName = (TextView) v.findViewById(R.id.txv_item_name);


        return holder;
    }
    private   class ViewHolder {
        TextView itemName;

    }






}
