package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes7.dex */
public class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f36611a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f36612c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f36613d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f36614e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.lib.a.b.a.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                a.this.e();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i2 > 0 || i3 > 0) {
                a.this.e();
            }
        }
    };

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36604b;
        RecyclerView recyclerView = callercontext.f36607f;
        this.f36611a = recyclerView;
        this.f36612c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f36608g;
        this.f36613d = callercontext.f36609h;
        recyclerView.addOnScrollListener(this.f36614e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36611a.removeOnScrollListener(this.f36614e);
    }

    public void e() {
        RecyclerView.LayoutManager layoutManager = this.f36611a.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !f()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f36613d.getItemCount() - ((com.kwad.sdk.lib.a.a.a) this).f36604b.l || this.f36613d.j()) {
            return;
        }
        this.f36612c.m();
    }

    public boolean f() {
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = this.f36612c;
        return (cVar == null || cVar.f() == null || this.f36612c.f().isEmpty()) ? false : true;
    }
}
