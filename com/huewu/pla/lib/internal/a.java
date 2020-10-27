package com.huewu.pla.lib.internal;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.huewu.pla.lib.internal.PLA_ListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a implements Filterable, WrapperListAdapter {
    static final ArrayList<PLA_ListView.a> bvF = new ArrayList<>();
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    ArrayList<PLA_ListView.a> mFooterViewInfos;
    ArrayList<PLA_ListView.a> mHeaderViewInfos;
    private final boolean mIsFilterable;

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
        this.mAdapter = listAdapter;
        this.mIsFilterable = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.mHeaderViewInfos = bvF;
        } else {
            this.mHeaderViewInfos = arrayList;
        }
        if (arrayList2 == null) {
            this.mFooterViewInfos = bvF;
        } else {
            this.mFooterViewInfos = arrayList2;
        }
        this.mAreAllFixedViewsSelectable = areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos);
    }

    public int getHeadersCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFootersCount() {
        return this.mFooterViewInfos.size();
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.mAdapter == null || this.mAdapter.isEmpty();
    }

    private boolean areAllListInfosSelectable(ArrayList<PLA_ListView.a> arrayList) {
        if (arrayList != null) {
            Iterator<PLA_ListView.a> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().isSelectable) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean removeHeader(View view) {
        boolean z = false;
        for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
            if (this.mHeaderViewInfos.get(i).view == view) {
                this.mHeaderViewInfos.remove(i);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z = true;
                }
                this.mAreAllFixedViewsSelectable = z;
                return true;
            }
        }
        return false;
    }

    public boolean removeFooter(View view) {
        boolean z = false;
        for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
            if (this.mFooterViewInfos.get(i).view == view) {
                this.mFooterViewInfos.remove(i);
                if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                    z = true;
                }
                this.mAreAllFixedViewsSelectable = z;
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mAdapter != null ? getFootersCount() + getHeadersCount() + this.mAdapter.getCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.mAdapter != null) {
            return this.mAreAllFixedViewsSelectable && this.mAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).isSelectable;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.isEnabled(i2);
        }
        return this.mFooterViewInfos.get(i2 - i3).isSelectable;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getItem(i2);
        }
        return this.mFooterViewInfos.get(i2 - i3).data;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (this.mAdapter == null || i < headersCount || (i2 = i - headersCount) >= this.mAdapter.getCount()) {
            return -1L;
        }
        return this.mAdapter.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        if (this.mAdapter != null) {
            return this.mAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.mHeaderViewInfos.get(i).view;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getView(i2, view, viewGroup);
        }
        return this.mFooterViewInfos.get(i2 - i3).view;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (this.mAdapter == null || i < headersCount || (i2 = i - headersCount) >= this.mAdapter.getCount()) {
            return -2;
        }
        return this.mAdapter.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mIsFilterable) {
            return ((Filterable) this.mAdapter).getFilter();
        }
        return null;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }
}
