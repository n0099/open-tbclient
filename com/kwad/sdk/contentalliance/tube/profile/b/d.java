package com.kwad.sdk.contentalliance.tube.profile.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33264b;

    /* renamed from: c  reason: collision with root package name */
    public long f33265c;

    /* renamed from: d  reason: collision with root package name */
    public String f33266d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33267e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33268f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33269g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33265c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33267e, System.currentTimeMillis() - d.this.f33265c);
                d.this.f33265c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33264b) {
                com.kwad.sdk.core.report.e.c(d.this.f33267e);
            } else {
                d.this.f33264b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33267e);
            }
            d.this.f33265c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33230a.f33234d;
        this.f33268f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33269g);
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33230a;
        this.f33267e = bVar.f33236f;
        this.f33266d = String.valueOf(bVar.f33231a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33268f;
        if (aVar != null) {
            aVar.b(this.f33269g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33266d);
    }
}
