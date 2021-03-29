package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public d f34865c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f34866d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f34867e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView f34868f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f34869g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34870h;
    public KSPageLoadingView.a i = new KSPageLoadingView.a() { // from class: com.kwad.sdk.feed.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (b.this.f34867e != null) {
                b.this.f34867e.k();
            }
        }
    };
    public f j = new g() { // from class: com.kwad.sdk.feed.a.c.b.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            b.this.f34868f.a();
            if (z) {
                if (b.this.f34866d.i()) {
                    if (com.kwad.sdk.core.network.f.f33875g.k == i) {
                        b.this.f34868f.c();
                    } else if (v.a(b.this.f34868f.getContext())) {
                        b.this.f34868f.b(b.this.f34870h.e());
                    } else {
                        b.this.f34868f.a(b.this.f34870h.e());
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f33869a.k == i) {
                p.a(b.this.o());
            } else if (com.kwad.sdk.core.network.f.f33875g.k != i) {
                p.b(b.this.o());
            }
            b.this.f34869g.a(b.this.f34867e.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                b.this.f34869g.a();
            } else if (b.this.f34866d.i()) {
                b.this.f34868f.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            b.this.f34868f.a();
            if (z) {
                if (b.this.f34866d.i()) {
                    b.this.f34868f.b(b.this.f34870h.e());
                } else if (!b.this.f34865c.d(b.this.f34869g)) {
                    b.this.f34865c.c(b.this.f34869g);
                }
            }
            b.this.f34869g.a(b.this.f34867e.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f34854a;
        this.f34870h = bVar.f34856b;
        com.kwad.sdk.lib.b.c cVar = bVar.f35906g;
        this.f34867e = cVar;
        this.f34866d = bVar.f35907h;
        this.f34865c = bVar.i;
        cVar.a(this.j);
        this.f34868f.setRetryClickListener(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f34867e.b(this.j);
        this.f34868f.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34868f = (KSPageLoadingView) b(R.id.ksad_page_loading);
        this.f34869g = new com.kwad.sdk.contentalliance.widget.d(o(), true);
    }
}
