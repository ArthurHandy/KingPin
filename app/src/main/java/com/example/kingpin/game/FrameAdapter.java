package com.example.kingpin.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kingpin.R;

import java.util.List;

public class FrameAdapter extends ArrayAdapter<Frame>  {
    private int resourceId;
    public FrameAdapter(Context context, int textViewResourceId,
                       List<Frame> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Frame g = getItem(position);
        View view;
        FrameAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new FrameAdapter.ViewHolder();
            viewHolder.frameName = (TextView) view.findViewById(R.id.frame_name);
            viewHolder.frameScore = (TextView) view.findViewById(R.id.frame_score);
            viewHolder.frameType = (TextView) view.findViewById(R.id.frame_type);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (FrameAdapter.ViewHolder) view.getTag();
        }
        viewHolder.frameName.setText(g.getName());
        viewHolder.frameScore.setText(g.getScore());
        viewHolder.frameType.setText(g.getType());
        return view;
    }

    class ViewHolder{
        TextView frameName;
        TextView frameScore;
        TextView frameType;
    }
}
