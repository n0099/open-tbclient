package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public d f35625c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f35626d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f35627e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView f35628f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f35629g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35630h;

    /* renamed from: i  reason: collision with root package name */
    public KSPageLoadingView.a f35631i = new KSPageLoadingView.a() { // from class: com.kwad.sdk.feed.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (b.this.f35627e != null) {
                b.this.f35627e.k();
            }
        }
    };
    public f j = new g() { // from class: com.kwad.sdk.feed.a.c.b.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i2, String str) {
            b.this.f35628f.a();
            if (z) {
                if (b.this.f35626d.i()) {
                    if (com.kwad.sdk.core.network.f.f34601g.k == i2) {
                        b.this.f35628f.c();
                    } else if (v.a(b.this.f35628f.getContext())) {
                        b.this.f35628f.b(b.this.f35630h.e());
                    } else {
                        b.this.f35628f.a(b.this.f35630h.e());
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                p.a(b.this.o());
            } else if (com.kwad.sdk.core.network.f.f34601g.k != i2) {
                p.b(b.this.o());
            }
            b.this.f35629g.a(b.this.f35627e.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                b.this.f35629g.a();
            } else if (b.this.f35626d.i()) {
                b.this.f35628f.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            b.this.f35628f.a();
            if (z) {
                if (b.this.f35626d.i()) {
                    b.this.f35628f.b(b.this.f35630h.e());
                } else if (!b.this.f35625c.d(b.this.f35629g)) {
                    b.this.f35625c.c(b.this.f35629g);
                }
            }
            b.this.f35629g.a(b.this.f35627e.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f35614a;
        this.f35630h = bVar.f35616b;
        com.kwad.sdk.lib.b.c cVar = bVar.f36706g;
        this.f35627e = cVar;
        this.f35626d = bVar.f36707h;
        this.f35625c = bVar.f36708i;
        cVar.a(this.j);
        this.f35628f.setRetryClickListener(this.f35631i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35627e.b(this.j);
        this.f35628f.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35628f = (KSPageLoadingView) b(R.id.ksad_page_loading);
        this.f35629g = new com.kwad.sdk.contentalliance.widget.d(o(), true);
    }
}
