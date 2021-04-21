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
    public d f33307a;

    /* renamed from: c  reason: collision with root package name */
    public c<AdTemplate, ?> f33308c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f33309d;

    /* renamed from: e  reason: collision with root package name */
    public KSProfilePageLoadingView f33310e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f33311f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f33312g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f33309d != null) {
                a.this.f33309d.k();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public f f33313h = new g() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            a.this.f33310e.a();
            if (z) {
                if (a.this.f33308c.i()) {
                    if (v.a(a.this.f33310e.getContext())) {
                        a.this.f33310e.d();
                    } else {
                        a.this.f33310e.c();
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                p.a(a.this.o());
            } else {
                p.b(a.this.o());
            }
            a.this.f33311f.a(a.this.f33309d.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                a.this.f33311f.a();
            } else if (a.this.f33308c.i()) {
                a.this.f33310e.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            a.this.f33310e.a();
            if (z) {
                if (a.this.f33308c.i()) {
                    a.this.f33310e.d();
                } else if (!a.this.f33307a.d(a.this.f33311f)) {
                    a.this.f33307a.c(a.this.f33311f);
                }
            }
            a.this.f33311f.a(a.this.f33309d.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36286b;
        com.kwad.sdk.lib.b.c cVar = callercontext.f36290g;
        this.f33309d = cVar;
        this.f33307a = callercontext.i;
        this.f33308c = callercontext.f36291h;
        cVar.a(this.f33313h);
        this.f33310e.setRetryClickListener(this.f33312g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33309d.b(this.f33313h);
        this.f33310e.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33310e = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
        this.f33311f = new com.kwad.sdk.contentalliance.widget.d(o(), false);
    }
}
