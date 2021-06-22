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
/* loaded from: classes7.dex */
public class d extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public final a f36820a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36821b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView.Adapter f36822c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f36823d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f36824e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f36825f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f36826g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.Adapter f36827h;

    /* renamed from: i  reason: collision with root package name */
    public int f36828i;
    public int j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public Set<WeakReference<b>> o;
    public boolean p;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<View> f36834a;

        /* renamed from: b  reason: collision with root package name */
        public int f36835b;

        public a() {
            this(null);
        }

        public a(List<View> list) {
            this.f36834a = new SparseArray<>();
            this.f36835b = 0;
            if (list != null) {
                for (View view : list) {
                    SparseArray<View> sparseArray = this.f36834a;
                    int i2 = this.f36835b;
                    this.f36835b = i2 + 1;
                    sparseArray.put(i2, view);
                }
            }
        }

        public int a() {
            return this.f36834a.size();
        }

        public View a(int i2) {
            return this.f36834a.get(i2);
        }

        public boolean a(View view) {
            return this.f36834a.indexOfValue(view) >= 0;
        }

        public int b(int i2) {
            if (i2 < 0 || i2 >= this.f36834a.size()) {
                return -1;
            }
            return this.f36834a.keyAt(i2);
        }

        public boolean b(View view) {
            if (a(view)) {
                return false;
            }
            SparseArray<View> sparseArray = this.f36834a;
            int i2 = this.f36835b;
            this.f36835b = i2 + 1;
            sparseArray.put(i2, view);
            return true;
        }

        public boolean c(View view) {
            int indexOfValue = this.f36834a.indexOfValue(view);
            if (indexOfValue < 0) {
                return false;
            }
            this.f36834a.removeAt(indexOfValue);
            return true;
        }
    }

    public d(RecyclerView.Adapter adapter) {
        this(adapter, null, null);
    }

    public d(RecyclerView.Adapter adapter, List<View> list, List<View> list2) {
        this.f36828i = -2048;
        this.j = -1024;
        this.l = -1;
        this.m = false;
        this.n = true;
        this.o = new HashSet();
        this.f36822c = adapter;
        this.f36820a = new a(list);
        this.f36821b = new a(list2);
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.kwad.sdk.lib.widget.recycler.d.1
            private void a(int i2) {
                try {
                    int i3 = d.this.l;
                    int a2 = d.this.a();
                    if (i3 == -1) {
                        d.this.notifyDataSetChanged();
                    } else if (i2 == i3) {
                        d.this.notifyItemRangeChanged(a2, i2);
                    } else if (i2 > i3) {
                        d.this.notifyItemRangeChanged(a2, i3);
                        d.this.notifyItemRangeInserted(a2 + i3, i2 - i3);
                    } else {
                        d.this.notifyItemRangeChanged(a2, i2);
                        d.this.notifyItemRangeRemoved(a2 + i2, i3 - i2);
                    }
                } catch (Exception unused) {
                }
                d.this.l = i2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                d.this.d();
                if (d.this.m) {
                    d.this.notifyDataSetChanged();
                } else if (d.this.p) {
                    a(d.this.f36822c.getItemCount());
                } else {
                    int itemCount = d.this.f36822c.getItemCount();
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
            public void onItemRangeChanged(int i2, int i3) {
                d dVar = d.this;
                dVar.l = dVar.f36822c.getItemCount();
                try {
                    d.this.notifyItemRangeChanged(i2 + d.this.a(), i3);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i3, Object obj) {
                d dVar = d.this;
                dVar.l = dVar.f36822c.getItemCount();
                try {
                    d.this.notifyItemRangeChanged(i2 + d.this.a(), i3, obj);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i2, int i3) {
                d dVar = d.this;
                dVar.l = dVar.f36822c.getItemCount();
                try {
                    d.this.notifyItemRangeInserted(i2 + d.this.a(), i3);
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i2, int i3, int i4) {
                try {
                    d.this.notifyItemMoved(i2 + d.this.a(), i3 + d.this.a());
                } catch (Exception unused) {
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i2, int i3) {
                try {
                    d.this.notifyItemRangeRemoved(i2 + d.this.a(), i3);
                } catch (Exception unused) {
                }
            }
        };
        this.f36823d = adapterDataObserver;
        this.f36824e = adapterDataObserver;
        this.f36825f = adapterDataObserver;
        this.f36822c.registerAdapterDataObserver(adapterDataObserver);
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
        int i2 = layoutParams2 == null ? -1 : layoutParams2.width;
        int i3 = layoutParams2 == null ? -2 : layoutParams2.height;
        if (this.n) {
            if (this.k) {
                StaggeredGridLayoutManager.LayoutParams layoutParams3 = new StaggeredGridLayoutManager.LayoutParams(i2, i3);
                layoutParams3.setFullSpan(true);
                layoutParams = layoutParams3;
            } else {
                layoutParams = new RecyclerView.LayoutParams(i2, i3);
            }
            view.setLayoutParams(layoutParams);
        }
        return new RecyclerView.ViewHolder(view) { // from class: com.kwad.sdk.lib.widget.recycler.d.2
        };
    }

    public int a() {
        RecyclerView.Adapter adapter = this.f36826g;
        return adapter != null ? adapter.getItemCount() : this.f36820a.a();
    }

    public void a(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null");
        }
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (this.f36820a.b(view)) {
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
                public int getSpanSize(int i2) {
                    if (d.this.a(i2) || d.this.b(i2)) {
                        return gridLayoutManager.getSpanCount();
                    }
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    if (spanSizeLookup2 != null) {
                        return spanSizeLookup2.getSpanSize(i2);
                    }
                    return 1;
                }
            });
        }
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            this.k = true;
        }
    }

    public boolean a(int i2) {
        return i2 < a();
    }

    public boolean a(View view) {
        boolean c2 = this.f36821b.c(view);
        if (c2) {
            e();
        }
        return c2;
    }

    public int b() {
        RecyclerView.Adapter adapter = this.f36827h;
        return adapter != null ? adapter.getItemCount() : this.f36821b.a();
    }

    public void b(View view) {
        a(view, (ViewGroup.LayoutParams) null);
    }

    public void b(View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new IllegalArgumentException("the view to add must not be null!");
        }
        if ((view.getParent() instanceof ViewGroup) && view.getParent() != this.f36821b) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (this.f36821b.b(view)) {
            e();
        }
    }

    public boolean b(int i2) {
        return i2 >= a() + this.f36822c.getItemCount();
    }

    public RecyclerView.Adapter c() {
        return this.f36822c;
    }

    public void c(View view) {
        b(view, null);
    }

    public boolean c(int i2) {
        return i2 >= -1024 && i2 <= this.j;
    }

    public boolean d(int i2) {
        return i2 >= -2048 && i2 <= this.f36828i;
    }

    public boolean d(View view) {
        return this.f36821b.a(view);
    }

    public int e(int i2) {
        return i2 + 2048;
    }

    public boolean e(View view) {
        return this.f36820a.a(view);
    }

    public int f(int i2) {
        return i2 + 1024;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return b() + a() + this.f36822c.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        if (a(i2)) {
            RecyclerView.Adapter adapter = this.f36826g;
            return adapter != null ? adapter.getItemId(i2) : getItemViewType(i2);
        } else if (b(i2)) {
            RecyclerView.Adapter adapter2 = this.f36827h;
            return adapter2 != null ? adapter2.getItemId(i2) : getItemViewType(i2);
        } else {
            return this.f36822c.getItemId(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (a(i2)) {
            RecyclerView.Adapter adapter = this.f36826g;
            int itemViewType = (adapter != null ? adapter.getItemViewType(i2) : this.f36820a.b(i2)) - 1024;
            this.j = Math.max(itemViewType, this.j);
            return itemViewType;
        } else if (b(i2)) {
            int itemCount = (i2 - this.f36822c.getItemCount()) - a();
            RecyclerView.Adapter adapter2 = this.f36827h;
            int itemViewType2 = (adapter2 != null ? adapter2.getItemViewType(itemCount) : this.f36821b.b(itemCount)) - 2048;
            this.f36828i = Math.max(itemViewType2, this.f36828i);
            return itemViewType2;
        } else {
            return this.f36822c.getItemViewType(i2 - a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.f36822c.hasObservers()) {
            this.f36822c.unregisterAdapterDataObserver(this.f36823d);
        }
        this.f36822c.registerAdapterDataObserver(this.f36823d);
        this.f36822c.onAttachedToRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f36826g;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
            this.f36826g.unregisterAdapterDataObserver(this.f36824e);
            this.f36826g.registerAdapterDataObserver(this.f36824e);
        }
        RecyclerView.Adapter adapter2 = this.f36827h;
        if (adapter2 != null) {
            adapter2.onAttachedToRecyclerView(recyclerView);
            this.f36827h.unregisterAdapterDataObserver(this.f36825f);
            this.f36827h.registerAdapterDataObserver(this.f36825f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        RecyclerView.Adapter adapter;
        if (i2 >= a() && i2 < a() + this.f36822c.getItemCount()) {
            this.f36822c.onBindViewHolder(viewHolder, i2 - a());
            return;
        }
        if (i2 >= a() || (adapter = this.f36826g) == null) {
            if (i2 < a() + this.f36822c.getItemCount() || (adapter = this.f36827h) == null) {
                return;
            }
            i2 = (i2 - a()) - this.f36822c.getItemCount();
        }
        adapter.onBindViewHolder(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        RecyclerView.Adapter adapter;
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i2);
        } else if (i2 >= a() && i2 < a() + this.f36822c.getItemCount()) {
            this.f36822c.onBindViewHolder(viewHolder, i2 - a(), list);
        } else {
            if (i2 >= a() || (adapter = this.f36826g) == null) {
                if (i2 < a() + this.f36822c.getItemCount() || (adapter = this.f36827h) == null) {
                    return;
                }
                i2 = (i2 - a()) - this.f36822c.getItemCount();
            }
            adapter.onBindViewHolder(viewHolder, i2, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (c(i2)) {
            int f2 = f(i2);
            RecyclerView.Adapter adapter = this.f36826g;
            return adapter == null ? f(this.f36820a.a(f2)) : adapter.onCreateViewHolder(viewGroup, f2);
        } else if (d(i2)) {
            int e2 = e(i2);
            RecyclerView.Adapter adapter2 = this.f36827h;
            return adapter2 == null ? f(this.f36821b.a(e2)) : adapter2.onCreateViewHolder(viewGroup, e2);
        } else {
            return this.f36822c.onCreateViewHolder(viewGroup, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.f36822c.hasObservers()) {
            this.f36822c.unregisterAdapterDataObserver(this.f36823d);
        }
        this.f36822c.onDetachedFromRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f36826g;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
            this.f36826g.unregisterAdapterDataObserver(this.f36824e);
        }
        RecyclerView.Adapter adapter2 = this.f36827h;
        if (adapter2 != null) {
            adapter2.onDetachedFromRecyclerView(recyclerView);
            this.f36827h.unregisterAdapterDataObserver(this.f36825f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        super.onViewAttachedToWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (c(itemViewType)) {
            adapter = this.f36826g;
            if (adapter == null) {
                return;
            }
        } else if (d(itemViewType)) {
            adapter = this.f36827h;
            if (adapter == null) {
                return;
            }
        } else {
            adapter = this.f36822c;
        }
        adapter.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter;
        super.onViewDetachedFromWindow(viewHolder);
        int itemViewType = viewHolder.getItemViewType();
        if (c(itemViewType)) {
            adapter = this.f36826g;
            if (adapter == null) {
                return;
            }
        } else if (d(itemViewType)) {
            adapter = this.f36827h;
            if (adapter == null) {
                return;
            }
        } else {
            adapter = this.f36822c;
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
