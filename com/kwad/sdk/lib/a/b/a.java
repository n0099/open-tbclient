package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes6.dex */
public class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f36197a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f36198c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36199d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f36200e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.lib.a.b.a.1
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
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36191b;
        RecyclerView recyclerView = callercontext.f36194f;
        this.f36197a = recyclerView;
        this.f36198c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f36195g;
        this.f36199d = callercontext.f36196h;
        recyclerView.addOnScrollListener(this.f36200e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36197a.removeOnScrollListener(this.f36200e);
    }

    public void e() {
        RecyclerView.LayoutManager layoutManager = this.f36197a.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !f()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f36199d.getItemCount() - ((com.kwad.sdk.lib.a.a.a) this).f36191b.l || this.f36199d.j()) {
            return;
        }
        this.f36198c.m();
    }

    public boolean f() {
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = this.f36198c;
        return (cVar == null || cVar.f() == null || this.f36198c.f().isEmpty()) ? false : true;
    }
}
