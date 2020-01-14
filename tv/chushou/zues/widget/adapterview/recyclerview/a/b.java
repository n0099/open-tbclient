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
    private LinearLayout nWm;
    private RecyclerView.Adapter nWn;
    private tv.chushou.zues.widget.adapterview.a nWo;
    private c nWp;
    private int nWq = 0;
    private int nWr = 0;
    private RecyclerView.AdapterDataObserver nWs = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.nWo != null) {
                if (b.this.nWn.getItemCount() == 0) {
                    b.this.nWo.xd(true);
                } else {
                    b.this.nWo.xd(false);
                }
            }
            if (b.this.nWp != null) {
                b.this.nWq = b.this.nWr;
                b.this.nWr = b.this.nWn.getItemCount();
                if (b.this.nWr != b.this.nWq) {
                    b.this.nWp.Ok(b.this.nWr - b.this.nWq);
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
            if (b.this.nWp != null) {
                if (b.this.nWp.dPj()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.nWq = b.this.nWr;
                b.this.nWr = b.this.nWn.getItemCount();
                if (b.this.nWr != b.this.nWq) {
                    b.this.nWp.Ok(b.this.nWr - b.this.nWq);
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
        this.nWq = 0;
        this.nWr = 0;
        if (this.nWn != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.nWn.getItemCount());
            this.nWn.unregisterAdapterDataObserver(this.nWs);
        }
        this.nWn = adapter;
        this.nWn.registerAdapterDataObserver(this.nWs);
        notifyItemRangeInserted(getHeaderViewsCount(), this.nWn.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.nWo = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.nWp = cVar;
    }

    public void dPk() {
        this.nWq = 0;
        this.nWr = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.nWn.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.nWn.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.nWm);
        }
        return this.nWn.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.nWn.getItemCount() + headerViewsCount) {
            this.nWn.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.nWn.getItemCount() + headerViewsCount) {
            this.nWn.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.nWn.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.nWm == null || this.nWm.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        n(view, i, 1);
    }

    public void n(View view, int i, int i2) {
        if (this.nWm == null) {
            this.nWm = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.nWm.setOrientation(1);
                this.nWm.setClipChildren(false);
                this.nWm.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.nWm.setOrientation(0);
                this.nWm.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.nWm.getChildCount()) {
            i = -1;
        }
        this.nWm.addView(view, i);
        if (this.nWm.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.nWn.getItemCount());
        }
    }

    public void dC(final View view) {
        if (getFooterViewsCount() != 0) {
            this.nWm.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.nWm.removeView(view);
                    if (b.this.nWm.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.nWn.getItemCount());
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
        if (this.nWm == null || this.nWm.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.nWm.getChildCount(); i++) {
            if (this.nWm.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean On(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.nWn.getItemCount() && i < getItemCount();
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
