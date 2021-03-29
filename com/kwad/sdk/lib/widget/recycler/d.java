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
/* loaded from: classes6.dex */
public class d extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public final a f36016a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36017b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView.Adapter f36018c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f36019d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f36020e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f36021f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f36022g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f36023h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public Set<WeakReference<b>> o;
    public boolean p;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<View> f36029a;

        /* renamed from: b  reason: collision with root package name */
        public int f36030b;

        public a() {
            this(null);
        }

        public a(List<View> list) {
            this.f36029a = new SparseArray<>();
            this.f36030b = 0;
            if (list != null) {
                for (View view : list) {
                    SparseArray<View> sparseArray = this.f36029a;
                    int i = this.f36030b;
                    this.f36030b = i + 1;
                    sparseArray.put(i, view);
                }
            }
        }

        public int a() {
            return this.f36029a.size();
        }

        public View a(int i) {
            return this.f36029a.get(i);
        }

        public boolean a(View view) {
            return this.f36029a.indexOfValue(view) >= 0;
        }

        public int b(int i) {
            if (i < 0 || i >= this.f36029a.size()) {
                return -1;
            }
            return this.f36029a.keyAt(i);
        }

        public boolean b(View view) {
            if (a(view)) {
                return false;
            }
            SparseArray<View> sparseArray = this.f36029a;
            int i = this.f36030b;
            this.f36030b = i + 1;
            sparseArray.put(i, view);
            return true;
        }

        public boolean c(View view) {
            int indexOfValue = this.f36029a.indexOfValue(view);
            if (indexOfValue < 0) {
                return false;
            }
            this.f36029a.removeAt(indexOfValue);
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
        this.f36018c = adapter;
        this.f36016a = new a(list);
        this.f36017b = new a(list2);
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.kwad.sdk.lib.widget.recycler.d.1
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
                } catch (Exception unused) {
                }
                d.this.l = i;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                d.this.d();
                if (d.this.m) {
                    d.this.notifyDataSetChanged();
                } else if (d.this.p) {
                    a(d.this.f36018c.getItemCount());
                } else {
                    int itemCount = d.this.f36018c.getItemCount();
                    try {
                        if (d.this.l == -1 || (itemCount != 0 && itemCount == d.this.l)) {
                            d.this.notifyItemRangeChanged(d.this.a(), itemCount);
                        } else {
                            d.this.notifyDataSetChanged();
                        }
                    } catch (Exception unused) {
                    }
                    d.this.l = itemCount;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                d dVar = d.this;
                dVar.l = dVar.f36018c.getItemCount();
                try {
                    d.this.notifyItemRangeChanged(i + d.this.a(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                d dVar = d.this;
                dVar.l = dVar.f36018c.getItemCount();
                try {
                    d.this.notifyItemRangeChanged(i + d.this.a(), i2, obj);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                d dVar = d.this;
                dVar.l = dVar.f36018c.getItemCount();
                try {
                    d.this.notifyItemRangeInserted(i + d.this.a(), i2);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                try {
                    d.this.notifyItemMoved(i + d.this.a(), i2 + d.this.a());
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                try {
                    d.this.notifyItemRangeRemoved(i + d.this.a(), i2);
                } catch (Exception unused) {
                }
            }
        };
        this.f36019d = adapterDataObserver;
        this.f36020e = adapterDataObserver;
        this.f36021f = adapterDataObserver;
        this.f36018c.registerAdapterDataObserver(adapterDataObserver);
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
        } catch (Exception unused) {
        }
    }

    private RecyclerView.ViewHolder f(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        int i = layoutParams2 == null ? -1 : layoutParams2.width;
        int i2 = layoutParams2 == null ? -2 : layoutParams2.height;
        if (this.n) {
            if (this.k) {
                StaggeredGridLayoutManager.LayoutParams layoutParams3 = new StaggeredGridLayoutManager.LayoutParams(i, i2);
                layoutParams3.setFullSpan(true);
                layoutParams = layoutParams3;
            } else {
                layoutParams = new RecyclerView.LayoutParams(i, i2);
            }
            view.setLayoutParams(layoutParams);
        }
        return new RecyclerView.ViewHolder(view) { // from class: com.kwad.sdk.lib.widget.recycler.d.2
        };
    }

    public int a() {
        RecyclerView.Adapter adapter = this.f36022g;
        return adapter != null ? adapter.getItemCount() : this.f36016a.a();
    }

    public void a(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null");
        }
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (this.f36016a.b(view)) {
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
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i);
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
        boolean c2 = this.f36017b.c(view);
        if (c2) {
            e();
        }
        return c2;
    }

    public int b() {
        RecyclerView.Adapter adapter = this.f36023h;
        return adapter != null ? adapter.getItemCount() : this.f36017b.a();
    }

    public void b(View view) {
        a(view, (ViewGroup.LayoutParams) null);
    }

    public void b(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null!");
        }
        if ((view.getParent() instanceof ViewGroup) && view.getParent() != this.f36017b) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (this.f36017b.b(view)) {
            e();
        }
    }

    public boolean b(int i) {
        return i >= a() + this.f36018c.getItemCount();
    }

    public RecyclerView.Adapter c() {
        return this.f36018c;
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
        return this.f36017b.a(view);
    }

    public int e(int i) {
        return i + 2048;
    }

    public boolean e(View view) {
        return this.f36016a.a(view);
    }

    public int f(int i) {
        return i + 1024;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return b() + a() + this.f36018c.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (a(i)) {
            RecyclerView.Adapter adapter = this.f36022g;
            return adapter != null ? adapter.getItemId(i) : getItemViewType(i);
        } else if (b(i)) {
            RecyclerView.Adapter adapter2 = this.f36023h;
            return adapter2 != null ? adapter2.getItemId(i) : getItemViewType(i);
        } else {
            return this.f36018c.getItemId(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (a(i)) {
            RecyclerView.Adapter adapter = this.f36022g;
            int itemViewType = (adapter != null ? adapter.getItemViewType(i) : this.f36016a.b(i)) - 1024;
            this.j = Math.max(itemViewType, this.j);
            return itemViewType;
        } else if (b(i)) {
            int itemCount = (i - this.f36018c.getItemCount()) - a();
            RecyclerView.Adapter adapter2 = this.f36023h;
            int itemViewType2 = (adapter2 != null ? adapter2.getItemViewType(itemCount) : this.f36017b.b(itemCount)) - 2048;
            this.i = Math.max(itemViewType2, this.i);
            return itemViewType2;
        } else {
            return this.f36018c.getItemViewType(i - a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.f36018c.hasObservers()) {
            this.f36018c.unregisterAdapterDataObserver(this.f36019d);
        }
        this.f36018c.registerAdapterDataObserver(this.f36019d);
        this.f36018c.onAttachedToRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f36022g;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
            this.f36022g.unregisterAdapterDataObserver(this.f36020e);
            this.f36022g.registerAdapterDataObserver(this.f36020e);
        }
        RecyclerView.Adapter adapter2 = this.f36023h;
        if (adapter2 != null) {
            adapter2.onAttachedToRecyclerView(recyclerView);
            this.f36023h.unregisterAdapterDataObserver(this.f36021f);
            this.f36023h.registerAdapterDataObserver(this.f36021f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerView.Adapter adapter;
        if (i >= a() && i < a() + this.f36018c.getItemCount()) {
            this.f36018c.onBindViewHolder(viewHolder, i - a());
            return;
        }
        if (i >= a() || (adapter = this.f36022g) == null) {
            if (i < a() + this.f36018c.getItemCount() || (adapter = this.f36023h) == null) {
                return;
            }
            i = (i - a()) - this.f36018c.getItemCount();
        }
        adapter.onBindViewHolder(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        RecyclerView.Adapter adapter;
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
        } else if (i >= a() && i < a() + this.f36018c.getItemCount()) {
            this.f36018c.onBindViewHolder(viewHolder, i - a(), list);
        } else {
            if (i >= a() || (adapter = this.f36022g) == null) {
                if (i < a() + this.f36018c.getItemCount() || (adapter = this.f36023h) == null) {
                    return;
                }
                i = (i - a()) - this.f36018c.getItemCount();
            }
            adapter.onBindViewHolder(viewHolder, i, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (c(i)) {
            int f2 = f(i);
            RecyclerView.Adapter adapter = this.f36022g;
            return adapter == null ? f(this.f36016a.a(f2)) : adapter.onCreateViewHolder(viewGroup, f2);
        } else if (d(i)) {
            int e2 = e(i);
            RecyclerView.Adapter adapter2 = this.f36023h;
            return adapter2 == null ? f(this.f36017b.a(e2)) : adapter2.onCreateViewHolder(viewGroup, e2);
        } else {
            return this.f36018c.onCreateViewHolder(viewGroup, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.f36018c.hasObservers()) {
            this.f36018c.unregisterAdapterDataObserver(this.f36019d);
        }
        this.f36018c.onDetachedFromRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f36022g;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
            this.f36022g.unregisterAdapterDataObserver(this.f36020e);
        }
        RecyclerView.Adapter adapter2 = this.f36023h;
        if (adapter2 != null) {
            adapter2.onDetachedFromRecyclerView(recyclerView);
            this.f36023h.unregisterAdapterDataObserver(this.f36021f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        super.onViewAttachedToWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (c(itemViewType)) {
            adapter = this.f36022g;
            if (adapter == null) {
                return;
            }
        } else if (d(itemViewType)) {
            adapter = this.f36023h;
            if (adapter == null) {
                return;
            }
        } else {
            adapter = this.f36018c;
        }
        adapter.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        super.onViewDetachedFromWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (c(itemViewType)) {
            adapter = this.f36022g;
            if (adapter == null) {
                return;
            }
        } else if (d(itemViewType)) {
            adapter = this.f36023h;
            if (adapter == null) {
                return;
            }
        } else {
            adapter = this.f36018c;
        }
        adapter.onViewDetachedFromWindow(viewHolder);
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
