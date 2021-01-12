package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f10443a;

    /* renamed from: b  reason: collision with root package name */
    private final ListUpdateCallback f10444b;
    private final b<T> c;
    private final RecyclerView.Adapter d;
    @Nullable
    private List<T> e;
    @NonNull
    private List<T> f = Collections.emptyList();
    private int g;

    public d(@NonNull ListUpdateCallback listUpdateCallback, @NonNull b<T> bVar, @NonNull RecyclerView.Adapter adapter) {
        this.f10444b = listUpdateCallback;
        this.c = bVar;
        this.d = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f10444b);
        this.f10443a = false;
        if (this.c.d() != null) {
            this.c.d().run();
        }
    }

    @NonNull
    public List<T> a() {
        return this.f;
    }

    public void a(final List<T> list) {
        if (list == this.e) {
            return;
        }
        final int i = this.g + 1;
        this.g = i;
        if (list == null) {
            this.f10444b.onRemoved(0, this.e.size());
            this.e = null;
            this.f = Collections.emptyList();
        } else if (this.e == null) {
            this.f10444b.onInserted(0, list.size());
            this.e = list;
            this.f = Collections.unmodifiableList(list);
        } else {
            this.f10443a = true;
            final List<T> list2 = this.e;
            this.c.b().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areContentsTheSame(int i2, int i3) {
                            return d.this.c.c().a((T) list2.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areItemsTheSame(int i2, int i3) {
                            return d.this.c.c().b((T) list2.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        @Nullable
                        public Object getChangePayload(int i2, int i3) {
                            return d.this.c.c().c((T) list2.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getNewListSize() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getOldListSize() {
                            return list2.size();
                        }
                    });
                    d.this.c.a().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.g == i) {
                                d.this.a(list, calculateDiff);
                            }
                        }
                    });
                }
            });
        }
    }

    public void b(List<T> list) {
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        this.d.notifyDataSetChanged();
    }
}
