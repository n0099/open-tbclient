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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.lib.a.a.a<AdTemplate, b<?, AdTemplate>> {

    /* renamed from: a  reason: collision with root package name */
    public d f33619a;

    /* renamed from: c  reason: collision with root package name */
    public c<AdTemplate, ?> f33620c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f33621d;

    /* renamed from: e  reason: collision with root package name */
    public KSProfilePageLoadingView f33622e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f33623f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f33624g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f33621d != null) {
                a.this.f33621d.k();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public f f33625h = new g() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i2, String str) {
            a.this.f33622e.a();
            if (z) {
                if (a.this.f33620c.i()) {
                    if (v.a(a.this.f33622e.getContext())) {
                        a.this.f33622e.d();
                    } else {
                        a.this.f33622e.c();
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                p.a(a.this.o());
            } else {
                p.b(a.this.o());
            }
            a.this.f33623f.a(a.this.f33621d.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                a.this.f33623f.a();
            } else if (a.this.f33620c.i()) {
                a.this.f33622e.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            a.this.f33622e.a();
            if (z) {
                if (a.this.f33620c.i()) {
                    a.this.f33622e.d();
                } else if (!a.this.f33619a.d(a.this.f33623f)) {
                    a.this.f33619a.c(a.this.f33623f);
                }
            }
            a.this.f33623f.a(a.this.f33621d.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36702b;
        com.kwad.sdk.lib.b.c cVar = callercontext.f36706g;
        this.f33621d = cVar;
        this.f33619a = callercontext.f36708i;
        this.f33620c = callercontext.f36707h;
        cVar.a(this.f33625h);
        this.f33622e.setRetryClickListener(this.f33624g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33621d.b(this.f33625h);
        this.f33622e.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33622e = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
        this.f33623f = new com.kwad.sdk.contentalliance.widget.d(o(), false);
    }
}
