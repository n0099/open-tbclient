package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public final class a implements ListUpdateCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.Adapter f10735a;

    public a(@NonNull RecyclerView.Adapter adapter) {
        this.f10735a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, Object obj) {
        this.f10735a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f10735a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f10735a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f10735a.notifyItemRangeRemoved(i, i2);
    }
}
