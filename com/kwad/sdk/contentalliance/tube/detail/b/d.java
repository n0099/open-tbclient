package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33807b;

    /* renamed from: c  reason: collision with root package name */
    public long f33808c;

    /* renamed from: d  reason: collision with root package name */
    public String f33809d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33810e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33811f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33812g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33808c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33810e, System.currentTimeMillis() - d.this.f33808c);
                d.this.f33808c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33807b) {
                com.kwad.sdk.core.report.e.c(d.this.f33810e);
            } else {
                d.this.f33807b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33810e);
            }
            d.this.f33808c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33771c;
        this.f33811f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33812g);
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a;
        this.f33810e = bVar.f33774f;
        this.f33809d = String.valueOf(bVar.f33769a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33811f;
        if (aVar != null) {
            aVar.b(this.f33812g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33809d);
    }
}
