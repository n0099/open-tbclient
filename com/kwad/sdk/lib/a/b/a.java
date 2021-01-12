package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes4.dex */
public class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f10406a;
    private com.kwad.sdk.lib.b.c<?, MODEL> c;
    private com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d;
    private RecyclerView.OnScrollListener e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.lib.a.b.a.1
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10406a = this.f10405b.f;
        this.c = (com.kwad.sdk.lib.b.c<?, MODEL>) this.f10405b.g;
        this.d = this.f10405b.h;
        this.f10406a.addOnScrollListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10406a.removeOnScrollListener(this.e);
    }

    public void e() {
        RecyclerView.LayoutManager layoutManager = this.f10406a.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !f()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.d.getItemCount() - this.f10405b.l || this.d.j()) {
            return;
        }
        this.c.m();
    }

    protected boolean f() {
        return (this.c == null || this.c.f() == null || this.c.f().isEmpty()) ? false : true;
    }
}
