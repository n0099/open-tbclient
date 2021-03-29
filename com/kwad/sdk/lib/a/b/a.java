package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes6.dex */
public class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f35908a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f35909c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f35910d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f35911e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.lib.a.b.a.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                a.this.e();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i > 0 || i2 > 0) {
                a.this.e();
            }
        }
    };

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f35902b;
        RecyclerView recyclerView = callercontext.f35905f;
        this.f35908a = recyclerView;
        this.f35909c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f35906g;
        this.f35910d = callercontext.f35907h;
        recyclerView.addOnScrollListener(this.f35911e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35908a.removeOnScrollListener(this.f35911e);
    }

    public void e() {
        RecyclerView.LayoutManager layoutManager = this.f35908a.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !f()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f35910d.getItemCount() - ((com.kwad.sdk.lib.a.a.a) this).f35902b.l || this.f35910d.j()) {
            return;
        }
        this.f35909c.m();
    }

    public boolean f() {
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = this.f35909c;
        return (cVar == null || cVar.f() == null || this.f35909c.f().isEmpty()) ? false : true;
    }
}
