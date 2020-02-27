package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;
import tv.chushou.zues.widget.adapterview.c;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LinearLayout mHeaderLayout;
    private LinearLayout nXb;
    private RecyclerView.Adapter nXc;
    private tv.chushou.zues.widget.adapterview.a nXd;
    private c nXe;
    private int nXf = 0;
    private int nXg = 0;
    private RecyclerView.AdapterDataObserver nXh = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.nXd != null) {
                if (b.this.nXc.getItemCount() == 0) {
                    b.this.nXd.xg(true);
                } else {
                    b.this.nXd.xg(false);
                }
            }
            if (b.this.nXe != null) {
                b.this.nXf = b.this.nXg;
                b.this.nXg = b.this.nXc.getItemCount();
                if (b.this.nXg != b.this.nXf) {
                    b.this.nXe.On(b.this.nXg - b.this.nXf);
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
            if (b.this.nXe != null) {
                if (b.this.nXe.dQw()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.nXf = b.this.nXg;
                b.this.nXg = b.this.nXc.getItemCount();
                if (b.this.nXg != b.this.nXf) {
                    b.this.nXe.On(b.this.nXg - b.this.nXf);
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
        this.nXf = 0;
        this.nXg = 0;
        if (this.nXc != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.nXc.getItemCount());
            this.nXc.unregisterAdapterDataObserver(this.nXh);
        }
        this.nXc = adapter;
        this.nXc.registerAdapterDataObserver(this.nXh);
        notifyItemRangeInserted(getHeaderViewsCount(), this.nXc.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.nXd = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.nXe = cVar;
    }

    public void dQx() {
        this.nXf = 0;
        this.nXg = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.nXc.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.nXc.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.nXb);
        }
        return this.nXc.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.nXc.getItemCount() + headerViewsCount) {
            this.nXc.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.nXc.getItemCount() + headerViewsCount) {
            this.nXc.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.nXc.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.nXb == null || this.nXb.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        n(view, i, 1);
    }

    public void n(View view, int i, int i2) {
        if (this.nXb == null) {
            this.nXb = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.nXb.setOrientation(1);
                this.nXb.setClipChildren(false);
                this.nXb.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.nXb.setOrientation(0);
                this.nXb.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.nXb.getChildCount()) {
            i = -1;
        }
        this.nXb.addView(view, i);
        if (this.nXb.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.nXc.getItemCount());
        }
    }

    public void dE(final View view) {
        if (getFooterViewsCount() != 0) {
            this.nXb.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nXb.removeView(view);
                    if (b.this.nXb.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.nXc.getItemCount());
                    }
                }
            });
        }
    }

    public boolean Op(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dF(View view) {
        if (this.nXb == null || this.nXb.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.nXb.getChildCount(); i++) {
            if (this.nXb.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean Oq(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.nXc.getItemCount() && i < getItemCount();
    }

    /* loaded from: classes5.dex */
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
        if (Oq(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
