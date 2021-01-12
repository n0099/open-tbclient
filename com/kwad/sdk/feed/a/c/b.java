package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.feed.a.b.a {
    private d c;
    private com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d;
    private com.kwad.sdk.lib.b.c<?, AdTemplate> e;
    private KSPageLoadingView f;
    private com.kwad.sdk.contentalliance.widget.d g;
    private com.kwad.sdk.core.i.a h;
    private KSPageLoadingView.a i = new KSPageLoadingView.a() { // from class: com.kwad.sdk.feed.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (b.this.e != null) {
                b.this.e.k();
            }
        }
    };
    private f j = new g() { // from class: com.kwad.sdk.feed.a.c.b.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            b.this.f.a();
            if (z) {
                if (b.this.d.i()) {
                    if (com.kwad.sdk.core.network.f.g.k == i) {
                        b.this.f.c();
                    } else if (v.a(b.this.f.getContext())) {
                        b.this.f.b(b.this.h.e());
                    } else {
                        b.this.f.a(b.this.h.e());
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f9321a.k == i) {
                p.a(b.this.o());
            } else if (com.kwad.sdk.core.network.f.g.k != i) {
                p.b(b.this.o());
            }
            b.this.g.a(b.this.e.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                b.this.g.a();
            } else if (b.this.d.i()) {
                b.this.f.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            b.this.f.a();
            if (z) {
                if (b.this.d.i()) {
                    b.this.f.b(b.this.h.e());
                } else if (!b.this.c.d(b.this.g)) {
                    b.this.c.c(b.this.g);
                }
            }
            b.this.g.a(b.this.e.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<PAGE, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.h = this.f9834a.f9836b;
        this.e = this.f9834a.g;
        this.d = this.f9834a.h;
        this.c = this.f9834a.i;
        this.e.a(this.j);
        this.f.setRetryClickListener(this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.e.b(this.j);
        this.f.setRetryClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f = (KSPageLoadingView) b(R.id.ksad_page_loading);
        this.g = new com.kwad.sdk.contentalliance.widget.d(o(), true);
    }
}
