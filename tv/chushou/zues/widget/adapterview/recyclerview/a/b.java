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
    private LinearLayout okT;
    private RecyclerView.Adapter okU;
    private tv.chushou.zues.widget.adapterview.a okV;
    private c okW;
    private int okX = 0;
    private int okY = 0;
    private RecyclerView.AdapterDataObserver okZ = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.okV != null) {
                if (b.this.okU.getItemCount() == 0) {
                    b.this.okV.xN(true);
                } else {
                    b.this.okV.xN(false);
                }
            }
            if (b.this.okW != null) {
                b.this.okX = b.this.okY;
                b.this.okY = b.this.okU.getItemCount();
                if (b.this.okY != b.this.okX) {
                    b.this.okW.LJ(b.this.okY - b.this.okX);
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
            if (b.this.okW != null) {
                if (b.this.okW.dWM()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.okX = b.this.okY;
                b.this.okY = b.this.okU.getItemCount();
                if (b.this.okY != b.this.okX) {
                    b.this.okW.LJ(b.this.okY - b.this.okX);
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
        this.okX = 0;
        this.okY = 0;
        if (this.okU != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.okU.getItemCount());
            this.okU.unregisterAdapterDataObserver(this.okZ);
        }
        this.okU = adapter;
        this.okU.registerAdapterDataObserver(this.okZ);
        notifyItemRangeInserted(getHeaderViewsCount(), this.okU.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.okV = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.okW = cVar;
    }

    public void dWN() {
        this.okX = 0;
        this.okY = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.okU.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.okU.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.okT);
        }
        return this.okU.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.okU.getItemCount() + headerViewsCount) {
            this.okU.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.okU.getItemCount() + headerViewsCount) {
            this.okU.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.okU.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.okT == null || this.okT.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        p(view, i, 1);
    }

    public void p(View view, int i, int i2) {
        if (this.okT == null) {
            this.okT = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.okT.setOrientation(1);
                this.okT.setClipChildren(false);
                this.okT.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.okT.setOrientation(0);
                this.okT.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.okT.getChildCount()) {
            i = -1;
        }
        this.okT.addView(view, i);
        if (this.okT.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.okU.getItemCount());
        }
    }

    public void dx(final View view) {
        if (getFooterViewsCount() != 0) {
            this.okT.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.okT.removeView(view);
                    if (b.this.okT.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.okU.getItemCount());
                    }
                }
            });
        }
    }

    public boolean LK(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dy(View view) {
        if (this.okT == null || this.okT.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.okT.getChildCount(); i++) {
            if (this.okT.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean LL(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.okU.getItemCount() && i < getItemCount();
    }

    /* loaded from: classes5.dex */
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
        if (LL(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
