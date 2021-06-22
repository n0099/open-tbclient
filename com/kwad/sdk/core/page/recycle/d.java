package com.kwad.sdk.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class d extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    public List<Presenter> f34668a = new ArrayList();

    public abstract c a(ViewGroup viewGroup, int i2);

    public void a() {
        for (Presenter presenter : this.f34668a) {
            presenter.j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.f34666a.i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i2) {
        cVar.f34666a.a(cVar.f34667b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public final c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        c a2 = a(viewGroup, i2);
        this.f34668a.add(a2.f34666a);
        return a2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        a();
    }
}
