package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33905b;

    /* renamed from: c  reason: collision with root package name */
    public long f33906c;

    /* renamed from: d  reason: collision with root package name */
    public String f33907d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33908e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33909f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33910g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33906c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33908e, System.currentTimeMillis() - d.this.f33906c);
                d.this.f33906c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33905b) {
                com.kwad.sdk.core.report.e.c(d.this.f33908e);
            } else {
                d.this.f33905b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33908e);
            }
            d.this.f33906c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33869c;
        this.f33909f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33910g);
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a;
        this.f33908e = bVar.f33872f;
        this.f33907d = String.valueOf(bVar.f33867a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33909f;
        if (aVar != null) {
            aVar.b(this.f33910g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33907d);
    }
}
