package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public abstract class a<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public List<M> f35971a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35972b;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.f35972b = z;
        this.f35971a = new com.kwad.sdk.lib.widget.b(new CopyOnWriteArrayList());
    }

    public void a(List<M> list) {
        this.f35971a.clear();
        this.f35971a.addAll(list);
    }

    @Nullable
    public M c(int i) {
        if (i < 0 || i >= this.f35971a.size()) {
            return null;
        }
        return this.f35971a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f35971a.size();
    }

    public List<M> h() {
        return this.f35971a;
    }

    public boolean i() {
        return this.f35971a.isEmpty();
    }
}
