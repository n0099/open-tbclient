package com.kwad.sdk.contentalliance.tube.detail.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33579b;

    /* renamed from: c  reason: collision with root package name */
    public long f33580c;

    /* renamed from: d  reason: collision with root package name */
    public String f33581d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33582e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33583f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33584g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33580c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33582e, System.currentTimeMillis() - d.this.f33580c);
                d.this.f33580c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33579b) {
                com.kwad.sdk.core.report.e.c(d.this.f33582e);
            } else {
                d.this.f33579b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33582e);
            }
            d.this.f33580c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a.f33545c;
        this.f33583f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33584g);
        com.kwad.sdk.contentalliance.tube.detail.a.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a;
        this.f33582e = bVar.f33548f;
        this.f33581d = String.valueOf(bVar.f33543a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33583f;
        if (aVar != null) {
            aVar.b(this.f33584g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33581d);
    }
}
