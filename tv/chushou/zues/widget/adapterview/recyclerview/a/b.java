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
    private LinearLayout oxO;
    private RecyclerView.Adapter qoX;
    private tv.chushou.zues.widget.adapterview.a qoY;
    private c qoZ;
    private int qpa = 0;
    private int qpb = 0;
    private RecyclerView.AdapterDataObserver qpc = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.qoY != null) {
                if (b.this.qoX.getItemCount() == 0) {
                    b.this.qoY.BA(true);
                } else {
                    b.this.qoY.BA(false);
                }
            }
            if (b.this.qoZ != null) {
                b.this.qpa = b.this.qpb;
                b.this.qpb = b.this.qoX.getItemCount();
                if (b.this.qpb != b.this.qpa) {
                    b.this.qoZ.SF(b.this.qpb - b.this.qpa);
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
            if (b.this.qoZ != null) {
                if (b.this.qoZ.eHW()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.qpa = b.this.qpb;
                b.this.qpb = b.this.qoX.getItemCount();
                if (b.this.qpb != b.this.qpa) {
                    b.this.qoZ.SF(b.this.qpb - b.this.qpa);
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
        this.qpa = 0;
        this.qpb = 0;
        if (this.qoX != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.qoX.getItemCount());
            this.qoX.unregisterAdapterDataObserver(this.qpc);
        }
        this.qoX = adapter;
        this.qoX.registerAdapterDataObserver(this.qpc);
        notifyItemRangeInserted(getHeaderViewsCount(), this.qoX.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.qoY = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.qoZ = cVar;
    }

    public void eHX() {
        this.qpa = 0;
        this.qpb = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.qoX.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.qoX.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.oxO);
        }
        return this.qoX.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.qoX.getItemCount() + headerViewsCount) {
            this.qoX.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.qoX.getItemCount() + headerViewsCount) {
            this.qoX.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.qoX.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.oxO == null || this.oxO.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        r(view, i, 1);
    }

    public void r(View view, int i, int i2) {
        if (this.oxO == null) {
            this.oxO = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.oxO.setOrientation(1);
                this.oxO.setClipChildren(false);
                this.oxO.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.oxO.setOrientation(0);
                this.oxO.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.oxO.getChildCount()) {
            i = -1;
        }
        this.oxO.addView(view, i);
        if (this.oxO.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.qoX.getItemCount());
        }
    }

    public void ep(final View view) {
        if (getFooterViewsCount() != 0) {
            this.oxO.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oxO.removeView(view);
                    if (b.this.oxO.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.qoX.getItemCount());
                    }
                }
            });
        }
    }

    public boolean SG(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean eq(View view) {
        if (this.oxO == null || this.oxO.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.oxO.getChildCount(); i++) {
            if (this.oxO.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean SH(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.qoX.getItemCount() && i < getItemCount();
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
        if (SH(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
