package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public abstract class a<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public List<M> f36355a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36356b;

    public a() {
        this(true);
    }

    public a(boolean z) {
        this.f36356b = z;
        this.f36355a = new com.kwad.sdk.lib.widget.b(new CopyOnWriteArrayList());
    }

    public void a(List<M> list) {
        this.f36355a.clear();
        this.f36355a.addAll(list);
    }

    @Nullable
    public M c(int i) {
        if (i < 0 || i >= this.f36355a.size()) {
            return null;
        }
        return this.f36355a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f36355a.size();
    }

    public List<M> h() {
        return this.f36355a;
    }

    public boolean i() {
        return this.f36355a.isEmpty();
    }
}
