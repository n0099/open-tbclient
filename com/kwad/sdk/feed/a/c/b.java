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
    public d f35249c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f35250d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f35251e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView f35252f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f35253g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35254h;
    public KSPageLoadingView.a i = new KSPageLoadingView.a() { // from class: com.kwad.sdk.feed.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (b.this.f35251e != null) {
                b.this.f35251e.k();
            }
        }
    };
    public f j = new g() { // from class: com.kwad.sdk.feed.a.c.b.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            b.this.f35252f.a();
            if (z) {
                if (b.this.f35250d.i()) {
                    if (com.kwad.sdk.core.network.f.f34259g.k == i) {
                        b.this.f35252f.c();
                    } else if (v.a(b.this.f35252f.getContext())) {
                        b.this.f35252f.b(b.this.f35254h.e());
                    } else {
                        b.this.f35252f.a(b.this.f35254h.e());
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                p.a(b.this.o());
            } else if (com.kwad.sdk.core.network.f.f34259g.k != i) {
                p.b(b.this.o());
            }
            b.this.f35253g.a(b.this.f35251e.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                b.this.f35253g.a();
            } else if (b.this.f35250d.i()) {
                b.this.f35252f.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            b.this.f35252f.a();
            if (z) {
                if (b.this.f35250d.i()) {
                    b.this.f35252f.b(b.this.f35254h.e());
                } else if (!b.this.f35249c.d(b.this.f35253g)) {
                    b.this.f35249c.c(b.this.f35253g);
                }
            }
            b.this.f35253g.a(b.this.f35251e.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f35238a;
        this.f35254h = bVar.f35240b;
        com.kwad.sdk.lib.b.c cVar = bVar.f36290g;
        this.f35251e = cVar;
        this.f35250d = bVar.f36291h;
        this.f35249c = bVar.i;
        cVar.a(this.j);
        this.f35252f.setRetryClickListener(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35251e.b(this.j);
        this.f35252f.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35252f = (KSPageLoadingView) b(R.id.ksad_page_loading);
        this.f35253g = new com.kwad.sdk.contentalliance.widget.d(o(), true);
    }
}
