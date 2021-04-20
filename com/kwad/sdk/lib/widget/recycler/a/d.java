package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f36276a;

    /* renamed from: b  reason: collision with root package name */
    public final ListUpdateCallback f36277b;

    /* renamed from: c  reason: collision with root package name */
    public final b<T> f36278c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.Adapter f36279d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public List<T> f36280e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public List<T> f36281f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public int f36282g;

    public d(@NonNull ListUpdateCallback listUpdateCallback, @NonNull b<T> bVar, @NonNull RecyclerView.Adapter adapter) {
        this.f36277b = listUpdateCallback;
        this.f36278c = bVar;
        this.f36279d = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.f36280e = list;
        this.f36281f = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f36277b);
        this.f36276a = false;
        if (this.f36278c.d() != null) {
            this.f36278c.d().run();
        }
    }

    @NonNull
    public List<T> a() {
        return this.f36281f;
    }

    public void a(final List<T> list) {
        List<T> list2 = this.f36280e;
        if (list == list2) {
            return;
        }
        final int i = this.f36282g + 1;
        this.f36282g = i;
        if (list == null) {
            this.f36277b.onRemoved(0, list2.size());
            this.f36280e = null;
            this.f36281f = Collections.emptyList();
        } else if (list2 == null) {
            this.f36277b.onInserted(0, list.size());
            this.f36280e = list;
            this.f36281f = Collections.unmodifiableList(list);
        } else {
            this.f36276a = true;
            final List<T> list3 = this.f36280e;
            this.f36278c.b().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areContentsTheSame(int i2, int i3) {
                            return d.this.f36278c.c().a((T) list3.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areItemsTheSame(int i2, int i3) {
                            return d.this.f36278c.c().b((T) list3.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        @Nullable
                        public Object getChangePayload(int i2, int i3) {
                            return d.this.f36278c.c().c((T) list3.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getNewListSize() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getOldListSize() {
                            return list3.size();
                        }
                    });
                    d.this.f36278c.a().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2 = d.this.f36282g;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (i2 == i) {
                                d.this.a(list, calculateDiff);
                            }
                        }
                    });
                }
            });
        }
    }

    public void b(List<T> list) {
        this.f36280e = list;
        this.f36281f = Collections.unmodifiableList(list);
        this.f36279d.notifyDataSetChanged();
    }
}
