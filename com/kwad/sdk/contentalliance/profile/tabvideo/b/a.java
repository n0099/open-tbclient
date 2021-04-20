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
    public d f33212a;

    /* renamed from: c  reason: collision with root package name */
    public c<AdTemplate, ?> f33213c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f33214d;

    /* renamed from: e  reason: collision with root package name */
    public KSProfilePageLoadingView f33215e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f33216f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f33217g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f33214d != null) {
                a.this.f33214d.k();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public f f33218h = new g() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            a.this.f33215e.a();
            if (z) {
                if (a.this.f33213c.i()) {
                    if (v.a(a.this.f33215e.getContext())) {
                        a.this.f33215e.d();
                    } else {
                        a.this.f33215e.c();
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f34158a.k == i) {
                p.a(a.this.o());
            } else {
                p.b(a.this.o());
            }
            a.this.f33216f.a(a.this.f33214d.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                a.this.f33216f.a();
            } else if (a.this.f33213c.i()) {
                a.this.f33215e.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            a.this.f33215e.a();
            if (z) {
                if (a.this.f33213c.i()) {
                    a.this.f33215e.d();
                } else if (!a.this.f33212a.d(a.this.f33216f)) {
                    a.this.f33212a.c(a.this.f33216f);
                }
            }
            a.this.f33216f.a(a.this.f33214d.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f36191b;
        com.kwad.sdk.lib.b.c cVar = callercontext.f36195g;
        this.f33214d = cVar;
        this.f33212a = callercontext.i;
        this.f33213c = callercontext.f36196h;
        cVar.a(this.f33218h);
        this.f33215e.setRetryClickListener(this.f33217g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33214d.b(this.f33218h);
        this.f33215e.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33215e = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
        this.f33216f = new com.kwad.sdk.contentalliance.widget.d(o(), false);
    }
}
