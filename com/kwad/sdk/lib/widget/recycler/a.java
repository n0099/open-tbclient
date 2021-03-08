package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public abstract class a<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    protected List<M> f6881a;
    public final boolean b;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.b = z;
        this.f6881a = new com.kwad.sdk.lib.widget.b(new CopyOnWriteArrayList());
    }

    public void a(List<M> list) {
        this.f6881a.clear();
        this.f6881a.addAll(list);
    }

    @Nullable
    public M c(int i) {
        if (i < 0 || i >= this.f6881a.size()) {
            return null;
        }
        return this.f6881a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6881a.size();
    }

    public List<M> h() {
        return this.f6881a;
    }

    public boolean i() {
        return this.f6881a.isEmpty();
    }
}
