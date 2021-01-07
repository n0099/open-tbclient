package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public abstract class a<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    protected List<M> f10734a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10735b;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.f10735b = z;
        this.f10734a = new com.kwad.sdk.lib.widget.b(new CopyOnWriteArrayList());
    }

    public void a(List<M> list) {
        this.f10734a.clear();
        this.f10734a.addAll(list);
    }

    @Nullable
    public M c(int i) {
        if (i < 0 || i >= this.f10734a.size()) {
            return null;
        }
        return this.f10734a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10734a.size();
    }

    public List<M> h() {
        return this.f10734a;
    }

    public boolean i() {
        return this.f10734a.isEmpty();
    }
}
