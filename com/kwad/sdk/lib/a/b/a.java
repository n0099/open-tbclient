package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes6.dex */
public class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f35907a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f35908c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f35909d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f35910e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.lib.a.b.a.1
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
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f35901b;
        RecyclerView recyclerView = callercontext.f35904f;
        this.f35907a = recyclerView;
        this.f35908c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f35905g;
        this.f35909d = callercontext.f35906h;
        recyclerView.addOnScrollListener(this.f35910e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35907a.removeOnScrollListener(this.f35910e);
    }

    public void e() {
        RecyclerView.LayoutManager layoutManager = this.f35907a.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !f()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f35909d.getItemCount() - ((com.kwad.sdk.lib.a.a.a) this).f35901b.l || this.f35909d.j()) {
            return;
        }
        this.f35908c.m();
    }

    public boolean f() {
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = this.f35908c;
        return (cVar == null || cVar.f() == null || this.f35908c.f().isEmpty()) ? false : true;
    }
}
