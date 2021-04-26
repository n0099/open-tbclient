package com.kwad.sdk.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class d extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    public List<Presenter> f33304a = new ArrayList();

    public abstract c a(ViewGroup viewGroup, int i2);

    public void a() {
        for (Presenter presenter : this.f33304a) {
            presenter.g();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.f33302a.f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(c cVar, int i2) {
        cVar.f33302a.a(cVar.f33303b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public final c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        c a2 = a(viewGroup, i2);
        this.f33304a.add(a2.f33302a);
        return a2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        a();
    }
}
