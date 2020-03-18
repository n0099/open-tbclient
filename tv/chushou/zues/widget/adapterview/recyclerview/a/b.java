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
    private LinearLayout nZb;
    private RecyclerView.Adapter nZc;
    private tv.chushou.zues.widget.adapterview.a nZd;
    private c nZe;
    private int nZf = 0;
    private int nZg = 0;
    private RecyclerView.AdapterDataObserver nZh = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.nZd != null) {
                if (b.this.nZc.getItemCount() == 0) {
                    b.this.nZd.xo(true);
                } else {
                    b.this.nZd.xo(false);
                }
            }
            if (b.this.nZe != null) {
                b.this.nZf = b.this.nZg;
                b.this.nZg = b.this.nZc.getItemCount();
                if (b.this.nZg != b.this.nZf) {
                    b.this.nZe.Ot(b.this.nZg - b.this.nZf);
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
            if (b.this.nZe != null) {
                if (b.this.nZe.dQZ()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.nZf = b.this.nZg;
                b.this.nZg = b.this.nZc.getItemCount();
                if (b.this.nZg != b.this.nZf) {
                    b.this.nZe.Ot(b.this.nZg - b.this.nZf);
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
        this.nZf = 0;
        this.nZg = 0;
        if (this.nZc != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.nZc.getItemCount());
            this.nZc.unregisterAdapterDataObserver(this.nZh);
        }
        this.nZc = adapter;
        this.nZc.registerAdapterDataObserver(this.nZh);
        notifyItemRangeInserted(getHeaderViewsCount(), this.nZc.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.nZd = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.nZe = cVar;
    }

    public void dRa() {
        this.nZf = 0;
        this.nZg = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.nZc.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.nZc.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.nZb);
        }
        return this.nZc.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.nZc.getItemCount() + headerViewsCount) {
            this.nZc.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.nZc.getItemCount() + headerViewsCount) {
            this.nZc.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.nZc.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.nZb == null || this.nZb.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        o(view, i, 1);
    }

    public void o(View view, int i, int i2) {
        if (this.nZb == null) {
            this.nZb = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.nZb.setOrientation(1);
                this.nZb.setClipChildren(false);
                this.nZb.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.nZb.setOrientation(0);
                this.nZb.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.nZb.getChildCount()) {
            i = -1;
        }
        this.nZb.addView(view, i);
        if (this.nZb.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.nZc.getItemCount());
        }
    }

    public void dE(final View view) {
        if (getFooterViewsCount() != 0) {
            this.nZb.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nZb.removeView(view);
                    if (b.this.nZb.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.nZc.getItemCount());
                    }
                }
            });
        }
    }

    public boolean Ov(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dF(View view) {
        if (this.nZb == null || this.nZb.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.nZb.getChildCount(); i++) {
            if (this.nZb.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean Ow(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.nZc.getItemCount() && i < getItemCount();
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
        if (Ow(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
