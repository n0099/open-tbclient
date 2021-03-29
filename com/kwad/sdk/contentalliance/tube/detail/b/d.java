package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33195b;

    /* renamed from: c  reason: collision with root package name */
    public long f33196c;

    /* renamed from: d  reason: collision with root package name */
    public String f33197d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33198e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33199f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33200g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33196c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33198e, System.currentTimeMillis() - d.this.f33196c);
                d.this.f33196c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33195b) {
                com.kwad.sdk.core.report.e.c(d.this.f33198e);
            } else {
                d.this.f33195b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33198e);
            }
            d.this.f33196c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33158a.f33161c;
        this.f33199f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33200g);
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33158a;
        this.f33198e = bVar.f33164f;
        this.f33197d = String.valueOf(bVar.f33159a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33199f;
        if (aVar != null) {
            aVar.b(this.f33200g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33197d);
    }
}
