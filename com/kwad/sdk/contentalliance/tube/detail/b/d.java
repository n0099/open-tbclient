package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33484b;

    /* renamed from: c  reason: collision with root package name */
    public long f33485c;

    /* renamed from: d  reason: collision with root package name */
    public String f33486d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33487e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33488f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33489g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33485c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33487e, System.currentTimeMillis() - d.this.f33485c);
                d.this.f33485c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33484b) {
                com.kwad.sdk.core.report.e.c(d.this.f33487e);
            } else {
                d.this.f33484b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33487e);
            }
            d.this.f33485c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33450c;
        this.f33488f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33489g);
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a;
        this.f33487e = bVar.f33453f;
        this.f33486d = String.valueOf(bVar.f33448a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33488f;
        if (aVar != null) {
            aVar.b(this.f33489g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33486d);
    }
}
