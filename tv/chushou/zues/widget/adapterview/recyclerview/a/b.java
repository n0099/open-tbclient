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
    private int oNA = 0;
    private int oNB = 0;
    private RecyclerView.AdapterDataObserver oNC = new RecyclerView.AdapterDataObserver() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.2
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b.this.notifyDataSetChanged();
            if (b.this.oNy != null) {
                if (b.this.oNx.getItemCount() == 0) {
                    b.this.oNy.zk(true);
                } else {
                    b.this.oNy.zk(false);
                }
            }
            if (b.this.oNz != null) {
                b.this.oNA = b.this.oNB;
                b.this.oNB = b.this.oNx.getItemCount();
                if (b.this.oNB != b.this.oNA) {
                    b.this.oNz.OG(b.this.oNB - b.this.oNA);
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
            if (b.this.oNz != null) {
                if (b.this.oNz.emq()) {
                    b.this.notifyItemRangeChanged(b.this.getHeaderViewsCount() + i, 1);
                    b.this.notifyItemRangeInserted(i + 1 + b.this.getHeaderViewsCount(), i2);
                } else {
                    b.this.notifyItemRangeInserted(b.this.getHeaderViewsCount() + i, i2);
                }
                b.this.oNA = b.this.oNB;
                b.this.oNB = b.this.oNx.getItemCount();
                if (b.this.oNB != b.this.oNA) {
                    b.this.oNz.OG(b.this.oNB - b.this.oNA);
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
    private LinearLayout oNw;
    private RecyclerView.Adapter oNx;
    private tv.chushou.zues.widget.adapterview.a oNy;
    private c oNz;

    public b(RecyclerView.Adapter adapter) {
        setAdapter(adapter);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.oNA = 0;
        this.oNB = 0;
        if (this.oNx != null) {
            notifyItemRangeRemoved(getHeaderViewsCount(), this.oNx.getItemCount());
            this.oNx.unregisterAdapterDataObserver(this.oNC);
        }
        this.oNx = adapter;
        this.oNx.registerAdapterDataObserver(this.oNC);
        notifyItemRangeInserted(getHeaderViewsCount(), this.oNx.getItemCount());
    }

    public void a(tv.chushou.zues.widget.adapterview.a aVar) {
        this.oNy = aVar;
    }

    public void setLoadMoreProvider(c cVar) {
        this.oNz = cVar;
    }

    public void emr() {
        this.oNA = 0;
        this.oNB = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemCount = this.oNx.getItemCount();
        int headerViewsCount = getHeaderViewsCount();
        if (i < headerViewsCount) {
            return Integer.MIN_VALUE;
        }
        if (i >= headerViewsCount && i < itemCount + headerViewsCount) {
            int itemViewType = this.oNx.getItemViewType(i - getHeaderViewsCount());
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
            return new a(this.oNw);
        }
        return this.oNx.createViewHolder(viewGroup, i - 1073741823);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int headerViewsCount = getHeaderViewsCount();
        if (i >= headerViewsCount && i < this.oNx.getItemCount() + headerViewsCount) {
            this.oNx.onBindViewHolder(viewHolder, i - headerViewsCount, list);
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
        if (i >= headerViewsCount && i < this.oNx.getItemCount() + headerViewsCount) {
            this.oNx.onBindViewHolder(viewHolder, i - headerViewsCount);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHeaderViewsCount() + this.oNx.getItemCount() + getFooterViewsCount();
    }

    public int getHeaderViewsCount() {
        return (this.mHeaderLayout == null || this.mHeaderLayout.getChildCount() == 0) ? 0 : 1;
    }

    public int getFooterViewsCount() {
        return (this.oNw == null || this.oNw.getChildCount() == 0) ? 0 : 1;
    }

    public void addFooterView(View view, int i) {
        q(view, i, 1);
    }

    public void q(View view, int i, int i2) {
        if (this.oNw == null) {
            this.oNw = new LinearLayout(view.getContext());
            if (i2 == 1) {
                this.oNw.setOrientation(1);
                this.oNw.setClipChildren(false);
                this.oNw.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.oNw.setOrientation(0);
                this.oNw.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        if (i >= this.oNw.getChildCount()) {
            i = -1;
        }
        this.oNw.addView(view, i);
        if (this.oNw.getChildCount() == 1) {
            notifyItemInserted(getHeaderViewsCount() + this.oNx.getItemCount());
        }
    }

    public void dF(final View view) {
        if (getFooterViewsCount() != 0) {
            this.oNw.post(new Runnable() { // from class: tv.chushou.zues.widget.adapterview.recyclerview.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.oNw.removeView(view);
                    if (b.this.oNw.getChildCount() == 0) {
                        b.this.notifyItemRemoved(b.this.getHeaderViewsCount() + b.this.oNx.getItemCount());
                    }
                }
            });
        }
    }

    public boolean OH(int i) {
        int headerViewsCount = getHeaderViewsCount();
        return headerViewsCount > 0 && i >= 0 && i < headerViewsCount;
    }

    public boolean dG(View view) {
        if (this.oNw == null || this.oNw.getChildCount() == 0) {
            return false;
        }
        for (int i = 0; i < this.oNw.getChildCount(); i++) {
            if (this.oNw.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public boolean OI(int i) {
        return getFooterViewsCount() > 0 && i >= getHeaderViewsCount() + this.oNx.getItemCount() && i < getItemCount();
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
        if (OI(i)) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
