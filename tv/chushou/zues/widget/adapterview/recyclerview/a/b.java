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
    private LinearLayout oXq;
    private RecyclerView.Adapter oXr;
    private tv.chushou.zues.widget.adapterview.a oXs;
    private c oXt;
    private int oXu = 0;
    private int oXv = 0;
    private RecyclerView.AdapterDataObserver oXw = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.oXs != null) {
                if (b.this.oXr.getItemCount() == 0) {
                    b.this.oXs.zu(true);
                } else {
                    b.this.oXs.zu(false);
                }
            }
            if (b.this.oXt != null) {
                b.this.oXu = b.this.oXv;
                b.this.oXv = b.this.oXr.getItemCount();
                if (b.this.oXv != b.this.oXu) {
                    b.this.oXt.Pl(b.this.oXv - b.this.oXu);
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
            if (b.this.oXt != null) {
                if (b.this.oXt.eqx()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.oXu = b.this.oXv;
                b.this.oXv = b.this.oXr.getItemCount();
                if (b.this.oXv != b.this.oXu) {
                    b.this.oXt.Pl(b.this.oXv - b.this.oXu);
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
        this.oXu = 0;
        this.oXv = 0;
        if (this.oXr != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.oXr.getItemCount());
            this.oXr.unregisterAdapterDataObserver(this.oXw);
        }
        this.oXr = adapter;
        this.oXr.registerAdapterDataObserver(this.oXw);
        notifyItemRangeInserted(getHeaderViewsCount(), this.oXr.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.oXs = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.oXt = cVar;
    }

    public void eqy() {
        this.oXu = 0;
        this.oXv = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.oXr.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.oXr.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.oXq);
        }
        return this.oXr.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.oXr.getItemCount() + headerViewsCount) {
            this.oXr.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.oXr.getItemCount() + headerViewsCount) {
            this.oXr.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.oXr.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.oXq == null || this.oXq.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        q(view, i, 1);
    }

    public void q(View view, int i, int i2) {
        if (this.oXq == null) {
            this.oXq = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.oXq.setOrientation(1);
                this.oXq.setClipChildren(false);
                this.oXq.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.oXq.setOrientation(0);
                this.oXq.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.oXq.getChildCount()) {
            i = -1;
        }
        this.oXq.addView(view, i);
        if (this.oXq.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.oXr.getItemCount());
        }
    }

    public void dO(final View view) {
        if (getFooterViewsCount() != 0) {
            this.oXq.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oXq.removeView(view);
                    if (b.this.oXq.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.oXr.getItemCount());
                    }
                }
            });
        }
    }

    public boolean Pm(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dP(View view) {
        if (this.oXq == null || this.oXq.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.oXq.getChildCount(); i++) {
            if (this.oXq.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean Pn(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.oXr.getItemCount() && i < getItemCount();
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
        if (Pn(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
