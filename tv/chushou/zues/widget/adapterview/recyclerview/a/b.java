package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;
import tv.chushou.zues.widget.adapterview.c;
/* loaded from: classes4.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LinearLayout mHeaderLayout;
    private LinearLayout nWh;
    private RecyclerView.Adapter nWi;
    private tv.chushou.zues.widget.adapterview.a nWj;
    private c nWk;
    private int nWl = 0;
    private int nWm = 0;
    private RecyclerView.AdapterDataObserver nWn = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.nWj != null) {
                if (b.this.nWi.getItemCount() == 0) {
                    b.this.nWj.xd(true);
                } else {
                    b.this.nWj.xd(false);
                }
            }
            if (b.this.nWk != null) {
                b.this.nWl = b.this.nWm;
                b.this.nWm = b.this.nWi.getItemCount();
                if (b.this.nWm != b.this.nWl) {
                    b.this.nWk.Ok(b.this.nWm - b.this.nWl);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, i2);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, i2, obj);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (b.this.nWk != null) {
                if (b.this.nWk.dPh()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.nWl = b.this.nWm;
                b.this.nWm = b.this.nWi.getItemCount();
                if (b.this.nWm != b.this.nWl) {
                    b.this.nWk.Ok(b.this.nWm - b.this.nWl);
                    return;
                }
                return;
            }
            b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            b.this.notifyItemRangeRemoved(b.this.getHeaderViewsCount() + i, i2);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            int headerViewsCount = b.this.getHeaderViewsCount();
            b.this.notifyItemRangeChanged(i + headerViewsCount, headerViewsCount + i2 + i3);
        }
    };

    public b(RecyclerView.Adapter adapter) {
        setAdapter(adapter);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.nWl = 0;
        this.nWm = 0;
        if (this.nWi != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.nWi.getItemCount());
            this.nWi.unregisterAdapterDataObserver(this.nWn);
        }
        this.nWi = adapter;
        this.nWi.registerAdapterDataObserver(this.nWn);
        notifyItemRangeInserted(getHeaderViewsCount(), this.nWi.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.nWj = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.nWk = cVar;
    }

    public void dPi() {
        this.nWl = 0;
        this.nWm = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.nWi.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.nWi.getItemViewType(i - getHeaderViewsCount());
            if (itemViewType >= 1073741823) {
                throw new IllegalArgumentException("item view type in inner adapter should not be greater than Integer.MAX_VALUE / 2  ");
            }
            return itemViewType + 1073741823;
        }
        return -2147483647;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        getHeaderViewsCount();
        if (i == Integer.MIN_VALUE) {
            return new a(this.mHeaderLayout);
        }
        if (i == -2147483647) {
            return new a(this.nWh);
        }
        return this.nWi.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.nWi.getItemCount() + headerViewsCount) {
            this.nWi.onBindViewHolder(viewHolder, i - headerViewsCount, list);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.nWi.getItemCount() + headerViewsCount) {
            this.nWi.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.nWi.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.nWh == null || this.nWh.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        n(view, i, 1);
    }

    public void n(View view, int i, int i2) {
        if (this.nWh == null) {
            this.nWh = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.nWh.setOrientation(1);
                this.nWh.setClipChildren(false);
                this.nWh.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.nWh.setOrientation(0);
                this.nWh.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.nWh.getChildCount()) {
            i = -1;
        }
        this.nWh.addView(view, i);
        if (this.nWh.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.nWi.getItemCount());
        }
    }

    public void dC(final View view) {
        if (getFooterViewsCount() != 0) {
            this.nWh.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nWh.removeView(view);
                    if (b.this.nWh.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.nWi.getItemCount());
                    }
                }
            });
        }
    }

    public boolean Om(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dD(View view) {
        if (this.nWh == null || this.nWh.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.nWh.getChildCount(); i++) {
            if (this.nWh.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean On(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.nWi.getItemCount() && i < getItemCount();
    }

    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (c(viewHolder)) {
            a(viewHolder, viewHolder.getLayoutPosition());
        }
    }

    private boolean c(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        return layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams);
    }

    protected void a(RecyclerView.ViewHolder viewHolder, int i) {
        if (On(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
