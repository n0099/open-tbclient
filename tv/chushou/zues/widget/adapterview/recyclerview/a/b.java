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
    private LinearLayout nXd;
    private RecyclerView.Adapter nXe;
    private tv.chushou.zues.widget.adapterview.a nXf;
    private c nXg;
    private int nXh = 0;
    private int nXi = 0;
    private RecyclerView.AdapterDataObserver nXj = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.nXf != null) {
                if (b.this.nXe.getItemCount() == 0) {
                    b.this.nXf.xg(true);
                } else {
                    b.this.nXf.xg(false);
                }
            }
            if (b.this.nXg != null) {
                b.this.nXh = b.this.nXi;
                b.this.nXi = b.this.nXe.getItemCount();
                if (b.this.nXi != b.this.nXh) {
                    b.this.nXg.On(b.this.nXi - b.this.nXh);
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
            if (b.this.nXg != null) {
                if (b.this.nXg.dQy()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.nXh = b.this.nXi;
                b.this.nXi = b.this.nXe.getItemCount();
                if (b.this.nXi != b.this.nXh) {
                    b.this.nXg.On(b.this.nXi - b.this.nXh);
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
        this.nXh = 0;
        this.nXi = 0;
        if (this.nXe != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.nXe.getItemCount());
            this.nXe.unregisterAdapterDataObserver(this.nXj);
        }
        this.nXe = adapter;
        this.nXe.registerAdapterDataObserver(this.nXj);
        notifyItemRangeInserted(getHeaderViewsCount(), this.nXe.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.nXf = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.nXg = cVar;
    }

    public void dQz() {
        this.nXh = 0;
        this.nXi = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.nXe.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.nXe.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.nXd);
        }
        return this.nXe.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.nXe.getItemCount() + headerViewsCount) {
            this.nXe.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.nXe.getItemCount() + headerViewsCount) {
            this.nXe.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.nXe.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.nXd == null || this.nXd.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        n(view, i, 1);
    }

    public void n(View view, int i, int i2) {
        if (this.nXd == null) {
            this.nXd = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.nXd.setOrientation(1);
                this.nXd.setClipChildren(false);
                this.nXd.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.nXd.setOrientation(0);
                this.nXd.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.nXd.getChildCount()) {
            i = -1;
        }
        this.nXd.addView(view, i);
        if (this.nXd.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.nXe.getItemCount());
        }
    }

    public void dE(final View view) {
        if (getFooterViewsCount() != 0) {
            this.nXd.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nXd.removeView(view);
                    if (b.this.nXd.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.nXe.getItemCount());
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
        if (this.nXd == null || this.nXd.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.nXd.getChildCount(); i++) {
            if (this.nXd.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean Oq(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.nXe.getItemCount() && i < getItemCount();
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
