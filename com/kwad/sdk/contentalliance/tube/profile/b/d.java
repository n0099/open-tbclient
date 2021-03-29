package com.kwad.sdk.contentalliance.tube.profile.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33265b;

    /* renamed from: c  reason: collision with root package name */
    public long f33266c;

    /* renamed from: d  reason: collision with root package name */
    public String f33267d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33268e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33269f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33270g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33266c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33268e, System.currentTimeMillis() - d.this.f33266c);
                d.this.f33266c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33265b) {
                com.kwad.sdk.core.report.e.c(d.this.f33268e);
            } else {
                d.this.f33265b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33268e);
            }
            d.this.f33266c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a.f33235d;
        this.f33269f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33270g);
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a;
        this.f33268e = bVar.f33237f;
        this.f33267d = String.valueOf(bVar.f33232a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33269f;
        if (aVar != null) {
            aVar.b(this.f33270g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33267d);
    }
}
