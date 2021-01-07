package com.kwad.sdk.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class d extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    private List<Presenter> f9658a = new ArrayList();

    protected abstract c a(ViewGroup viewGroup, int i);

    public void a() {
        for (Presenter presenter : this.f9658a) {
            presenter.j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.f9656a.i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i) {
        cVar.f9656a.a(cVar.f9657b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public final c onCreateViewHolder(ViewGroup viewGroup, int i) {
        c a2 = a(viewGroup, i);
        this.f9658a.add(a2.f9656a);
        return a2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        a();
    }
}
