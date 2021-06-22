package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f36789a;

    /* renamed from: b  reason: collision with root package name */
    public final ListUpdateCallback f36790b;

    /* renamed from: c  reason: collision with root package name */
    public final b<T> f36791c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView.Adapter f36792d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public List<T> f36793e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public List<T> f36794f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public int f36795g;

    public d(@NonNull ListUpdateCallback listUpdateCallback, @NonNull b<T> bVar, @NonNull RecyclerView.Adapter adapter) {
        this.f36790b = listUpdateCallback;
        this.f36791c = bVar;
        this.f36792d = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.f36793e = list;
        this.f36794f = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f36790b);
        this.f36789a = false;
        if (this.f36791c.d() != null) {
            this.f36791c.d().run();
        }
    }

    @NonNull
    public List<T> a() {
        return this.f36794f;
    }

    public void a(final List<T> list) {
        List<T> list2 = this.f36793e;
        if (list == list2) {
            return;
        }
        final int i2 = this.f36795g + 1;
        this.f36795g = i2;
        if (list == null) {
            this.f36790b.onRemoved(0, list2.size());
            this.f36793e = null;
            this.f36794f = Collections.emptyList();
        } else if (list2 == null) {
            this.f36790b.onInserted(0, list.size());
            this.f36793e = list;
            this.f36794f = Collections.unmodifiableList(list);
        } else {
            this.f36789a = true;
            final List<T> list3 = this.f36793e;
            this.f36791c.b().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areContentsTheSame(int i3, int i4) {
                            return d.this.f36791c.c().a((T) list3.get(i3), (T) list.get(i4));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areItemsTheSame(int i3, int i4) {
                            return d.this.f36791c.c().b((T) list3.get(i3), (T) list.get(i4));
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        @Nullable
                        public Object getChangePayload(int i3, int i4) {
                            return d.this.f36791c.c().c((T) list3.get(i3), (T) list.get(i4));
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
                    d.this.f36791c.a().execute(new Runnable() { // from class: com.kwad.sdk.lib.widget.recycler.a.d.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int i3 = d.this.f36795g;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (i3 == i2) {
                                d.this.a(list, calculateDiff);
                            }
                        }
                    });
                }
            });
        }
    }

    public void b(List<T> list) {
        this.f36793e = list;
        this.f36794f = Collections.unmodifiableList(list);
        this.f36792d.notifyDataSetChanged();
    }
}
