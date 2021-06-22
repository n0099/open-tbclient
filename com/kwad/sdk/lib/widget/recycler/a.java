package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public abstract class a<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public List<M> f36773a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36774b;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.f36774b = z;
        this.f36773a = new com.kwad.sdk.lib.widget.b(new CopyOnWriteArrayList());
    }

    public void a(List<M> list) {
        this.f36773a.clear();
        this.f36773a.addAll(list);
    }

    @Nullable
    public M c(int i2) {
        if (i2 < 0 || i2 >= this.f36773a.size()) {
            return null;
        }
        return this.f36773a.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f36773a.size();
    }

    public List<M> h() {
        return this.f36773a;
    }

    public boolean i() {
        return this.f36773a.isEmpty();
    }
}
