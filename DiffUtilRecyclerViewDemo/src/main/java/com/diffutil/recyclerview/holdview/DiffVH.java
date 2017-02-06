package com.diffutil.recyclerview.holdview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.diffutil.recyclerview.R;

/**
 * Created by bobo on 2017/2/6.
 */

public class DiffVH extends ViewHolder {
    public TextView tv1, tv2;
    public ImageView iv;

    public DiffVH(View itemView) {
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.tv1);
        tv2 = (TextView) itemView.findViewById(R.id.tv2);
        iv = (ImageView) itemView.findViewById(R.id.iv);
    }
}
