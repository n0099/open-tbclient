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
    private LinearLayout otC;
    private RecyclerView.Adapter otD;
    private tv.chushou.zues.widget.adapterview.a otE;
    private c otF;
    private int otG = 0;
    private int otH = 0;
    private RecyclerView.AdapterDataObserver otI = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.otE != null) {
                if (b.this.otD.getItemCount() == 0) {
                    b.this.otE.ys(true);
                } else {
                    b.this.otE.ys(false);
                }
            }
            if (b.this.otF != null) {
                b.this.otG = b.this.otH;
                b.this.otH = b.this.otD.getItemCount();
                if (b.this.otH != b.this.otG) {
                    b.this.otF.Md(b.this.otH - b.this.otG);
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
            if (b.this.otF != null) {
                if (b.this.otF.eam()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.otG = b.this.otH;
                b.this.otH = b.this.otD.getItemCount();
                if (b.this.otH != b.this.otG) {
                    b.this.otF.Md(b.this.otH - b.this.otG);
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
        this.otG = 0;
        this.otH = 0;
        if (this.otD != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.otD.getItemCount());
            this.otD.unregisterAdapterDataObserver(this.otI);
        }
        this.otD = adapter;
        this.otD.registerAdapterDataObserver(this.otI);
        notifyItemRangeInserted(getHeaderViewsCount(), this.otD.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.otE = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.otF = cVar;
    }

    public void ean() {
        this.otG = 0;
        this.otH = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.otD.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.otD.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.otC);
        }
        return this.otD.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.otD.getItemCount() + headerViewsCount) {
            this.otD.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.otD.getItemCount() + headerViewsCount) {
            this.otD.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.otD.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.otC == null || this.otC.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        r(view, i, 1);
    }

    public void r(View view, int i, int i2) {
        if (this.otC == null) {
            this.otC = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.otC.setOrientation(1);
                this.otC.setClipChildren(false);
                this.otC.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.otC.setOrientation(0);
                this.otC.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.otC.getChildCount()) {
            i = -1;
        }
        this.otC.addView(view, i);
        if (this.otC.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.otD.getItemCount());
        }
    }

    public void dD(final View view) {
        if (getFooterViewsCount() != 0) {
            this.otC.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.otC.removeView(view);
                    if (b.this.otC.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.otD.getItemCount());
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
        if (this.otC == null || this.otC.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.otC.getChildCount(); i++) {
            if (this.otC.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean Mf(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.otD.getItemCount() && i < getItemCount();
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
