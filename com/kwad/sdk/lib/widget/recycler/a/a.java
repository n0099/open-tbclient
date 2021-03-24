package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public final class a implements ListUpdateCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.Adapter f35972a;

    public a(@NonNull RecyclerView.Adapter adapter) {
        this.f35972a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.f35972a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f35972a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f35972a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f35972a.notifyItemRangeRemoved(i, i2);
    }
}
