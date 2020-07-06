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
    private LinearLayout okW;
    private RecyclerView.Adapter okX;
    private tv.chushou.zues.widget.adapterview.a okY;
    private c okZ;
    private int ola = 0;
    private int olb = 0;
    private RecyclerView.AdapterDataObserver olc = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.okY != null) {
                if (b.this.okX.getItemCount() == 0) {
                    b.this.okY.xN(true);
                } else {
                    b.this.okY.xN(false);
                }
            }
            if (b.this.okZ != null) {
                b.this.ola = b.this.olb;
                b.this.olb = b.this.okX.getItemCount();
                if (b.this.olb != b.this.ola) {
                    b.this.okZ.LJ(b.this.olb - b.this.ola);
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
            if (b.this.okZ != null) {
                if (b.this.okZ.dWQ()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.ola = b.this.olb;
                b.this.olb = b.this.okX.getItemCount();
                if (b.this.olb != b.this.ola) {
                    b.this.okZ.LJ(b.this.olb - b.this.ola);
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
        this.ola = 0;
        this.olb = 0;
        if (this.okX != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.okX.getItemCount());
            this.okX.unregisterAdapterDataObserver(this.olc);
        }
        this.okX = adapter;
        this.okX.registerAdapterDataObserver(this.olc);
        notifyItemRangeInserted(getHeaderViewsCount(), this.okX.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.okY = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.okZ = cVar;
    }

    public void dWR() {
        this.ola = 0;
        this.olb = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.okX.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.okX.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.okW);
        }
        return this.okX.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.okX.getItemCount() + headerViewsCount) {
            this.okX.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.okX.getItemCount() + headerViewsCount) {
            this.okX.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.okX.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.okW == null || this.okW.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        p(view, i, 1);
    }

    public void p(View view, int i, int i2) {
        if (this.okW == null) {
            this.okW = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.okW.setOrientation(1);
                this.okW.setClipChildren(false);
                this.okW.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.okW.setOrientation(0);
                this.okW.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.okW.getChildCount()) {
            i = -1;
        }
        this.okW.addView(view, i);
        if (this.okW.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.okX.getItemCount());
        }
    }

    public void dx(final View view) {
        if (getFooterViewsCount() != 0) {
            this.okW.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.okW.removeView(view);
                    if (b.this.okW.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.okX.getItemCount());
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
        if (this.okW == null || this.okW.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.okW.getChildCount(); i++) {
            if (this.okW.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean LL(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.okX.getItemCount() && i < getItemCount();
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
