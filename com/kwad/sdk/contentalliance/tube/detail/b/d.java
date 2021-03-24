package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33194b;

    /* renamed from: c  reason: collision with root package name */
    public long f33195c;

    /* renamed from: d  reason: collision with root package name */
    public String f33196d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33197e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33198f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33199g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33195c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33197e, System.currentTimeMillis() - d.this.f33195c);
                d.this.f33195c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33194b) {
                com.kwad.sdk.core.report.e.c(d.this.f33197e);
            } else {
                d.this.f33194b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33197e);
            }
            d.this.f33195c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33160c;
        this.f33198f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33199g);
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a;
        this.f33197e = bVar.f33163f;
        this.f33196d = String.valueOf(bVar.f33158a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33198f;
        if (aVar != null) {
            aVar.b(this.f33199g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33196d);
    }
}
