package com.diffutil.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.diffutil.recyclerview.R;
import com.diffutil.recyclerview.Utils.L;
import com.diffutil.recyclerview.bean.TestBean;
import com.diffutil.recyclerview.holdview.DiffVH;

import java.util.List;

/**
 * Created by bobo on 2017/2/6.
 */

public class DiffAdapter extends RecyclerView.Adapter<DiffVH> {
    private final static String TAG = "zxt";
    private List<TestBean> mDatas;
    private Context mContext;
    private LayoutInflater mInflater;
    private RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            L.i("DiffAdapter observer onChanged :");
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            super.onItemRangeChanged(positionStart, itemCount);
            L.i("DiffAdapter observer onItemRangeChanged positionStart:" + positionStart
                    + ",itemCount:" + itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            super.onItemRangeChanged(positionStart, itemCount, payload);
            L.i("DiffAdapter observer onItemRangeChanged positionStart:" + positionStart
                    + ",itemCount:" + itemCount + ",payload:" + payload);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            L.i("DiffAdapter observer onItemRangeInserted positionStart:" + positionStart
                    + ",itemCount:" + itemCount);
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            L.i("DiffAdapter observer onItemRangeMoved fromPosition:" + fromPosition
                    + ",toPosition:" + toPosition + ",itemCount:" + itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            super.onItemRangeRemoved(positionStart, itemCount);
            L.i("DiffAdapter observer onItemRangeRemoved positionStart:" + positionStart
                    + ",itemCount:" + itemCount);
        }
    };

    public DiffAdapter(Context mContext, List<TestBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    public void register(boolean isRegister) {
        if (isRegister) {
            registerAdapterDataObserver(observer);
        } else {
            unregisterAdapterDataObserver(observer);
        }

    }


    public void setDatas(List<TestBean> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public DiffVH onCreateViewHolder(ViewGroup parent, int viewType) {
        DiffVH diffVH = new DiffVH(mInflater.inflate(R.layout.recyclerview_diff_item, parent, false));
        L.i("DiffAdapter onCreateViewHolder diffVH:" + diffVH);
        return diffVH;
    }

    @Override
    public void onBindViewHolder(final DiffVH holder, final int position) {
        L.i("DiffAdapter onBindViewHolder holder:" + holder + ",position:" + position);
        TestBean bean = mDatas.get(position);
        holder.tv1.setText(bean.getName());
        holder.tv2.setText(bean.getDesc());
        holder.iv.setImageResource(bean.getPic());
    }

    //TODO
    // @see android.support.v7.util.DiffUtil.Callback.getChangePayload
    @Override
    public void onBindViewHolder(DiffVH holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        L.i("DiffAdapter onBindViewHolder holder:" + holder + ",position:" + position + ",payloads:" + payloads);
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            DiffVH myViewHolder = (DiffVH) holder;
            Bundle bundle = (Bundle) payloads.get(0);
            if (bundle.getString("name") != null) {
                myViewHolder.tv1.setText(bundle.getString("name"));
                myViewHolder.tv1.setTextColor(Color.BLUE);
            }
        }


    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }


    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        L.i("DiffAdapter onDetachedFromRecyclerView");
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        L.i("DiffAdapter onDetachedFromRecyclerView");
    }

    @Override
    public void onViewAttachedToWindow(DiffVH holder) {
        super.onViewAttachedToWindow(holder);
        L.i("DiffAdapter onViewAttachedToWindow holder:" + holder);
    }

    @Override
    public void onViewDetachedFromWindow(DiffVH holder) {
        super.onViewDetachedFromWindow(holder);
        L.i("DiffAdapter onViewDetachedFromWindow holder:" + holder);
    }

    @Override
    public long getItemId(int position) {
        L.i("DiffAdapter getItemId position:" + position);
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        L.i("DiffAdapter getItemViewType position:" + position);
        return super.getItemViewType(position);
    }


    @Override
    public boolean onFailedToRecycleView(DiffVH holder) {
        L.i("DiffAdapter onFailedToRecycleView holder:" + holder);
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public void onViewRecycled(DiffVH holder) {
        super.onViewRecycled(holder);
        L.i("DiffAdapter onViewRecycled holder:" + holder);
    }

    @Override
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.registerAdapterDataObserver(observer);
        L.i("DiffAdapter registerAdapterDataObserver observer:" + observer);
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
        L.i("DiffAdapter setHasStableIds hasStableIds:" + hasStableIds);
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        super.unregisterAdapterDataObserver(observer);
        L.i("DiffAdapter unregisterAdapterDataObserver observer:" + observer);
    }
}
