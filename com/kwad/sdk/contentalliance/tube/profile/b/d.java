package com.kwad.sdk.contentalliance.tube.profile.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33977b;

    /* renamed from: c  reason: collision with root package name */
    public long f33978c;

    /* renamed from: d  reason: collision with root package name */
    public String f33979d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33980e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33981f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33982g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33978c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33980e, System.currentTimeMillis() - d.this.f33978c);
                d.this.f33978c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33977b) {
                com.kwad.sdk.core.report.e.c(d.this.f33980e);
            } else {
                d.this.f33977b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33980e);
            }
            d.this.f33978c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33942a.f33946d;
        this.f33981f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33982g);
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33942a;
        this.f33980e = bVar.f33948f;
        this.f33979d = String.valueOf(bVar.f33943a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33981f;
        if (aVar != null) {
            aVar.b(this.f33982g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33979d);
    }
}
