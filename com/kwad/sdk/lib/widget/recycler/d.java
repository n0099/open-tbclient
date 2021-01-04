package com.kwad.sdk.lib.widget.recycler;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class d extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final a f10753a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10754b;
    private RecyclerView.Adapter c;
    private final RecyclerView.AdapterDataObserver d;
    private RecyclerView.AdapterDataObserver e;
    private RecyclerView.AdapterDataObserver f;
    private RecyclerView.Adapter g;
    private RecyclerView.Adapter h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private Set<WeakReference<b>> o;
    private boolean p;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<View> f10759a;

        /* renamed from: b  reason: collision with root package name */
        public int f10760b;

        a() {
            this(null);
        }

        a(List<View> list) {
            this.f10759a = new SparseArray<>();
            this.f10760b = 0;
            if (list != null) {
                for (View view : list) {
                    SparseArray<View> sparseArray = this.f10759a;
                    int i = this.f10760b;
                    this.f10760b = i + 1;
                    sparseArray.put(i, view);
                }
            }
        }

        int a() {
            return this.f10759a.size();
        }

        View a(int i) {
            return this.f10759a.get(i);
        }

        boolean a(View view) {
            return this.f10759a.indexOfValue(view) >= 0;
        }

        int b(int i) {
            if (i < 0 || i >= this.f10759a.size()) {
                return -1;
            }
            return this.f10759a.keyAt(i);
        }

        boolean b(View view) {
            if (a(view)) {
                return false;
            }
            SparseArray<View> sparseArray = this.f10759a;
            int i = this.f10760b;
            this.f10760b = i + 1;
            sparseArray.put(i, view);
            return true;
        }

        boolean c(View view) {
            int indexOfValue = this.f10759a.indexOfValue(view);
            if (indexOfValue < 0) {
                return false;
            }
            this.f10759a.removeAt(indexOfValue);
            return true;
        }
    }

    public d(RecyclerView.Adapter adapter) {
        this(adapter, null, null);
    }

    public d(RecyclerView.Adapter adapter, List<View> list, List<View> list2) {
        this.i = -2048;
        this.j = -1024;
        this.l = -1;
        this.m = false;
        this.n = true;
        this.o = new HashSet();
        this.c = adapter;
        this.f10753a = new a(list);
        this.f10754b = new a(list2);
        this.d = new RecyclerView.AdapterDataObserver() { // from class: com.kwad.sdk.lib.widget.recycler.d.1
            private void a(int i) {
                try {
                    int i2 = d.this.l;
                    int a2 = d.this.a();
                    if (i2 == -1) {
                        d.this.notifyDataSetChanged();
                    } else if (i == i2) {
                        d.this.notifyItemRangeChanged(a2, i);
                    } else if (i > i2) {
                        d.this.notifyItemRangeChanged(a2, i2);
                        d.this.notifyItemRangeInserted(a2 + i2, i - i2);
                    } else {
                        d.this.notifyItemRangeChanged(a2, i);
                        d.this.notifyItemRangeRemoved(a2 + i, i2 - i);
                    }
                } catch (Exception e) {
                }
                d.this.l = i;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                d.this.d();
                if (d.this.m) {
                    d.this.notifyDataSetChanged();
                } else if (d.this.p) {
                    a(d.this.c.getItemCount());
                } else {
                    int itemCount = d.this.c.getItemCount();
                    if (d.this.l == -1 || (itemCount != 0 && itemCount == d.this.l)) {
                        try {
                            d.this.notifyItemRangeChanged(d.this.a(), itemCount);
                        } catch (Exception e) {
                        }
                    } else {
                        try {
                            d.this.notifyDataSetChanged();
                        } catch (Exception e2) {
                        }
                    }
                    d.this.l = itemCount;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                d.this.l = d.this.c.getItemCount();
                try {
                    d.this.notifyItemRangeChanged(d.this.a() + i, i2);
                } catch (Exception e) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                d.this.l = d.this.c.getItemCount();
                try {
                    d.this.notifyItemRangeChanged(d.this.a() + i, i2, obj);
                } catch (Exception e) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                d.this.l = d.this.c.getItemCount();
                try {
                    d.this.notifyItemRangeInserted(d.this.a() + i, i2);
                } catch (Exception e) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                try {
                    d.this.notifyItemMoved(d.this.a() + i, d.this.a() + i2);
                } catch (Exception e) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                try {
                    d.this.notifyItemRangeRemoved(d.this.a() + i, i2);
                } catch (Exception e) {
                }
            }
        };
        this.e = this.d;
        this.f = this.d;
        this.c.registerAdapterDataObserver(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        for (WeakReference<b> weakReference : this.o) {
            b bVar = weakReference.get();
            if (bVar != null) {
                bVar.a(this);
            }
        }
    }

    private void e() {
        try {
            notifyDataSetChanged();
        } catch (Exception e) {
        }
    }

    private RecyclerView.ViewHolder f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = layoutParams == null ? -1 : layoutParams.width;
        int i2 = layoutParams == null ? -2 : layoutParams.height;
        if (this.n) {
            if (this.k) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(i, i2);
                layoutParams2.setFullSpan(true);
                view.setLayoutParams(layoutParams2);
            } else {
                view.setLayoutParams(new RecyclerView.LayoutParams(i, i2));
            }
        }
        return new RecyclerView.ViewHolder(view) { // from class: com.kwad.sdk.lib.widget.recycler.d.2
        };
    }

    public int a() {
        return this.g != null ? this.g.getItemCount() : this.f10753a.a();
    }

    public void a(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null");
        }
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (this.f10753a.b(view)) {
            e();
        }
        d();
    }

    public void a(RecyclerView recyclerView) {
        a(recyclerView, (GridLayoutManager.SpanSizeLookup) null);
    }

    public void a(RecyclerView recyclerView, final GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.kwad.sdk.lib.widget.recycler.d.3
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    if (d.this.a(i) || d.this.b(i)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    if (spanSizeLookup != null) {
                        return spanSizeLookup.getSpanSize(i);
                    }
                    return 1;
                }
            });
        }
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            this.k = true;
        }
    }

    public boolean a(int i) {
        return i < a();
    }

    public boolean a(View view) {
        boolean c = this.f10754b.c(view);
        if (c) {
            e();
        }
        return c;
    }

    public int b() {
        return this.h != null ? this.h.getItemCount() : this.f10754b.a();
    }

    public void b(View view) {
        a(view, (ViewGroup.LayoutParams) null);
    }

    public void b(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null!");
        }
        if ((view.getParent() instanceof ViewGroup) && view.getParent() != this.f10754b) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (this.f10754b.b(view)) {
            e();
        }
    }

    public boolean b(int i) {
        return i >= a() + this.c.getItemCount();
    }

    public RecyclerView.Adapter c() {
        return this.c;
    }

    public void c(View view) {
        b(view, null);
    }

    public boolean c(int i) {
        return i >= -1024 && i <= this.j;
    }

    public boolean d(int i) {
        return i >= -2048 && i <= this.i;
    }

    public boolean d(View view) {
        return this.f10754b.a(view);
    }

    public int e(int i) {
        return i + 2048;
    }

    public boolean e(View view) {
        return this.f10753a.a(view);
    }

    public int f(int i) {
        return i + 1024;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return b() + a() + this.c.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return a(i) ? this.g != null ? this.g.getItemId(i) : getItemViewType(i) : b(i) ? this.h != null ? this.h.getItemId(i) : getItemViewType(i) : this.c.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (a(i)) {
            int itemViewType = (this.g != null ? this.g.getItemViewType(i) : this.f10753a.b(i)) - 1024;
            this.j = Math.max(itemViewType, this.j);
            return itemViewType;
        } else if (b(i)) {
            int itemCount = (i - this.c.getItemCount()) - a();
            int itemViewType2 = (this.h != null ? this.h.getItemViewType(itemCount) : this.f10754b.b(itemCount)) - 2048;
            this.i = Math.max(itemViewType2, this.i);
            return itemViewType2;
        } else {
            return this.c.getItemViewType(i - a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.c.hasObservers()) {
            this.c.unregisterAdapterDataObserver(this.d);
        }
        this.c.registerAdapterDataObserver(this.d);
        this.c.onAttachedToRecyclerView(recyclerView);
        if (this.g != null) {
            this.g.onAttachedToRecyclerView(recyclerView);
            this.g.unregisterAdapterDataObserver(this.e);
            this.g.registerAdapterDataObserver(this.e);
        }
        if (this.h != null) {
            this.h.onAttachedToRecyclerView(recyclerView);
            this.h.unregisterAdapterDataObserver(this.f);
            this.h.registerAdapterDataObserver(this.f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= a() && i < a() + this.c.getItemCount()) {
            this.c.onBindViewHolder(viewHolder, i - a());
        } else if (i < a() && this.g != null) {
            this.g.onBindViewHolder(viewHolder, i);
        } else if (i < a() + this.c.getItemCount() || this.h == null) {
        } else {
            this.h.onBindViewHolder(viewHolder, (i - a()) - this.c.getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
        } else if (i >= a() && i < a() + this.c.getItemCount()) {
            this.c.onBindViewHolder(viewHolder, i - a(), list);
        } else if (i < a() && this.g != null) {
            this.g.onBindViewHolder(viewHolder, i, list);
        } else if (i < a() + this.c.getItemCount() || this.h == null) {
        } else {
            this.h.onBindViewHolder(viewHolder, (i - a()) - this.c.getItemCount(), list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (c(i)) {
            int f = f(i);
            return this.g == null ? f(this.f10753a.a(f)) : this.g.onCreateViewHolder(viewGroup, f);
        } else if (d(i)) {
            int e = e(i);
            return this.h == null ? f(this.f10754b.a(e)) : this.h.onCreateViewHolder(viewGroup, e);
        } else {
            return this.c.onCreateViewHolder(viewGroup, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.c.hasObservers()) {
            this.c.unregisterAdapterDataObserver(this.d);
        }
        this.c.onDetachedFromRecyclerView(recyclerView);
        if (this.g != null) {
            this.g.onDetachedFromRecyclerView(recyclerView);
            this.g.unregisterAdapterDataObserver(this.e);
        }
        if (this.h != null) {
            this.h.onDetachedFromRecyclerView(recyclerView);
            this.h.unregisterAdapterDataObserver(this.f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (c(itemViewType)) {
            if (this.g != null) {
                this.g.onViewAttachedToWindow(viewHolder);
            }
        } else if (!d(itemViewType)) {
            this.c.onViewAttachedToWindow(viewHolder);
        } else if (this.h != null) {
            this.h.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (c(itemViewType)) {
            if (this.g != null) {
                this.g.onViewDetachedFromWindow(viewHolder);
            }
        } else if (!d(itemViewType)) {
            this.c.onViewDetachedFromWindow(viewHolder);
        } else if (this.h != null) {
            this.h.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
