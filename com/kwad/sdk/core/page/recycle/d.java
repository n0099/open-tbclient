package com.kwad.sdk.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    public List<Presenter> a = new ArrayList();

    public abstract c a(ViewGroup viewGroup, int i2);

    public void a() {
        for (Presenter presenter : this.a) {
            presenter.k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.a.j();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i2) {
        cVar.a.a(cVar.f55984b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public final c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        c a = a(viewGroup, i2);
        this.a.add(a.a);
        return a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        a();
    }
}
