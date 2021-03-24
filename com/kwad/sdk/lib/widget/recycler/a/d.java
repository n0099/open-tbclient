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
    public volatile boolean f35986a;

    /* renamed from: b  reason: collision with root package name */
    public final ListUpdateCallback f35987b;

    /* renamed from: c  reason: collision with root package name */
    public final b<T> f35988c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.Adapter f35989d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public List<T> f35990e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public List<T> f35991f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public int f35992g;

    public d(@NonNull ListUpdateCallback listUpdateCallback, @NonNull b<T> bVar, @NonNull RecyclerView.Adapter adapter) {
        this.f35987b = listUpdateCallback;
        this.f35988c = bVar;
        this.f35989d = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.f35990e = list;
        this.f35991f = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f35987b);
        this.f35986a = false;
        if (this.f35988c.d() != null) {
            this.f35988c.d().run();
        }
    }

    @NonNull
    public List<T> a() {
        return this.f35991f;
    }

    public void a(final List<T> list) {
        List<T> list2 = this.f35990e;
        if (list == list2) {
            return;
        }
        final int i = this.f35992g + 1;
        this.f35992g = i;
        if (list == null) {
            this.f35987b.onRemoved(0, list2.size());
            this.f35990e = null;
            this.f35991f = Collections.emptyList();
        } else if (list2 == null) {
            this.f35987b.onInserted(0, list.size());
            this.f35990e = list;
            this.f35991f = Collections.unmodifiableList(list);
        } else {
            this.f35986a = true;
            final List<T> list3 = this.f35990e;
            this.f35988c.b().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areContentsTheSame(int i2, int i3) {
                            return d.this.f35988c.c().a((T) list3.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areItemsTheSame(int i2, int i3) {
                            return d.this.f35988c.c().b((T) list3.get(i2), (T) list.get(i3));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        @Nullable
                        public Object getChangePayload(int i2, int i3) {
                            return d.this.f35988c.c().c((T) list3.get(i2), (T) list.get(i3));
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
                    d.this.f35988c.a().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2 = d.this.f35992g;
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
        this.f35990e = list;
        this.f35991f = Collections.unmodifiableList(list);
        this.f35989d.notifyDataSetChanged();
    }
}
