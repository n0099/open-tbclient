package com.kwad.sdk.contentalliance.profile.tabvideo.b;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSProfilePageLoadingView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.recycler.c;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.lib.a.a.a<AdTemplate, b<?, AdTemplate>> {

    /* renamed from: a  reason: collision with root package name */
    private d f5863a;
    private c<AdTemplate, ?> c;
    private com.kwad.sdk.lib.b.c<?, AdTemplate> d;
    private KSProfilePageLoadingView e;
    private com.kwad.sdk.contentalliance.widget.d f;
    private KSPageLoadingView.a g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.d != null) {
                a.this.d.k();
            }
        }
    };
    private f h = new g() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            a.this.e.a();
            if (z) {
                if (a.this.c.i()) {
                    if (v.a(a.this.e.getContext())) {
                        a.this.e.d();
                    } else {
                        a.this.e.c();
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f6187a.k == i) {
                p.a(a.this.o());
            } else {
                p.b(a.this.o());
            }
            a.this.f.a(a.this.d.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                a.this.f.a();
            } else if (a.this.c.i()) {
                a.this.e.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            a.this.e.a();
            if (z) {
                if (a.this.c.i()) {
                    a.this.e.d();
                } else if (!a.this.f5863a.d(a.this.f)) {
                    a.this.f5863a.c(a.this.f);
                }
            }
            a.this.f.a(a.this.d.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<PAGE, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.b.g;
        this.f5863a = this.b.i;
        this.c = this.b.h;
        this.d.a(this.h);
        this.e.setRetryClickListener(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.d.b(this.h);
        this.e.setRetryClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.e = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
        this.f = new com.kwad.sdk.contentalliance.widget.d(o(), false);
    }
}
