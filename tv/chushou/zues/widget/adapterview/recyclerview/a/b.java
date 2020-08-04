package tv.chushou.zues.widget.adapterview.recyclerview.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;
import tv.chushou.zues.widget.adapterview.c;
/* loaded from: classes6.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LinearLayout mHeaderLayout;
    private LinearLayout otE;
    private RecyclerView.Adapter otF;
    private tv.chushou.zues.widget.adapterview.a otG;
    private c otH;
    private int otI = 0;
    private int otJ = 0;
    private RecyclerView.AdapterDataObserver otK = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.otG != null) {
                if (b.this.otF.getItemCount() == 0) {
                    b.this.otG.ys(true);
                } else {
                    b.this.otG.ys(false);
                }
            }
            if (b.this.otH != null) {
                b.this.otI = b.this.otJ;
                b.this.otJ = b.this.otF.getItemCount();
                if (b.this.otJ != b.this.otI) {
                    b.this.otH.Md(b.this.otJ - b.this.otI);
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
            if (b.this.otH != null) {
                if (b.this.otH.ean()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.otI = b.this.otJ;
                b.this.otJ = b.this.otF.getItemCount();
                if (b.this.otJ != b.this.otI) {
                    b.this.otH.Md(b.this.otJ - b.this.otI);
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
        this.otI = 0;
        this.otJ = 0;
        if (this.otF != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.otF.getItemCount());
            this.otF.unregisterAdapterDataObserver(this.otK);
        }
        this.otF = adapter;
        this.otF.registerAdapterDataObserver(this.otK);
        notifyItemRangeInserted(getHeaderViewsCount(), this.otF.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.otG = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.otH = cVar;
    }

    public void eao() {
        this.otI = 0;
        this.otJ = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.otF.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.otF.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.otE);
        }
        return this.otF.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.otF.getItemCount() + headerViewsCount) {
            this.otF.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.otF.getItemCount() + headerViewsCount) {
            this.otF.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.otF.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.otE == null || this.otE.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        r(view, i, 1);
    }

    public void r(View view, int i, int i2) {
        if (this.otE == null) {
            this.otE = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.otE.setOrientation(1);
                this.otE.setClipChildren(false);
                this.otE.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.otE.setOrientation(0);
                this.otE.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.otE.getChildCount()) {
            i = -1;
        }
        this.otE.addView(view, i);
        if (this.otE.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.otF.getItemCount());
        }
    }

    public void dD(final View view) {
        if (getFooterViewsCount() != 0) {
            this.otE.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.otE.removeView(view);
                    if (b.this.otE.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.otF.getItemCount());
                    }
                }
            });
        }
    }

    public boolean Me(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dE(View view) {
        if (this.otE == null || this.otE.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.otE.getChildCount(); i++) {
            if (this.otE.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean Mf(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.otF.getItemCount() && i < getItemCount();
    }

    /* loaded from: classes6.dex */
    private static class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (e(viewHolder)) {
            a(viewHolder, viewHolder.getLayoutPosition());
        }
    }

    private boolean e(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        return layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams);
    }

    protected void a(RecyclerView.ViewHolder viewHolder, int i) {
        if (Mf(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
