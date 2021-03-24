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
    public d f32922a;

    /* renamed from: c  reason: collision with root package name */
    public c<AdTemplate, ?> f32923c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f32924d;

    /* renamed from: e  reason: collision with root package name */
    public KSProfilePageLoadingView f32925e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f32926f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f32927g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (a.this.f32924d != null) {
                a.this.f32924d.k();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public f f32928h = new g() { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, int i, String str) {
            a.this.f32925e.a();
            if (z) {
                if (a.this.f32923c.i()) {
                    if (v.a(a.this.f32925e.getContext())) {
                        a.this.f32925e.d();
                    } else {
                        a.this.f32925e.c();
                    }
                }
            } else if (com.kwad.sdk.core.network.f.f33868a.k == i) {
                p.a(a.this.o());
            } else {
                p.b(a.this.o());
            }
            a.this.f32926f.a(a.this.f32924d.j());
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void a(boolean z, boolean z2) {
            if (!z) {
                a.this.f32926f.a();
            } else if (a.this.f32923c.i()) {
                a.this.f32925e.b();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public void b(boolean z, boolean z2) {
            a.this.f32925e.a();
            if (z) {
                if (a.this.f32923c.i()) {
                    a.this.f32925e.d();
                } else if (!a.this.f32922a.d(a.this.f32926f)) {
                    a.this.f32922a.c(a.this.f32926f);
                }
            }
            a.this.f32926f.a(a.this.f32924d.j());
        }
    };

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f35901b;
        com.kwad.sdk.lib.b.c cVar = callercontext.f35905g;
        this.f32924d = cVar;
        this.f32922a = callercontext.i;
        this.f32923c = callercontext.f35906h;
        cVar.a(this.f32928h);
        this.f32925e.setRetryClickListener(this.f32927g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32924d.b(this.f32928h);
        this.f32925e.setRetryClickListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32925e = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
        this.f32926f = new com.kwad.sdk.contentalliance.widget.d(o(), false);
    }
}
