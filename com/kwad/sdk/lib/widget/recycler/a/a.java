package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes7.dex */
public final class a implements ListUpdateCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.Adapter f36775a;

    public a(@NonNull RecyclerView.Adapter adapter) {
        this.f36775a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i2, int i3, Object obj) {
        this.f36775a.notifyItemRangeChanged(i2, i3, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i2, int i3) {
        this.f36775a.notifyItemRangeInserted(i2, i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i2, int i3) {
        this.f36775a.notifyItemMoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i2, int i3) {
        this.f36775a.notifyItemRangeRemoved(i2, i3);
    }
}
