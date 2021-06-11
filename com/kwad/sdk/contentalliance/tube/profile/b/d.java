package com.kwad.sdk.contentalliance.tube.profile.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33879b;

    /* renamed from: c  reason: collision with root package name */
    public long f33880c;

    /* renamed from: d  reason: collision with root package name */
    public String f33881d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33882e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33883f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33884g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33880c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33882e, System.currentTimeMillis() - d.this.f33880c);
                d.this.f33880c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33879b) {
                com.kwad.sdk.core.report.e.c(d.this.f33882e);
            } else {
                d.this.f33879b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33882e);
            }
            d.this.f33880c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a.f33848d;
        this.f33883f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33884g);
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a;
        this.f33882e = bVar.f33850f;
        this.f33881d = String.valueOf(bVar.f33845a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33883f;
        if (aVar != null) {
            aVar.b(this.f33884g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33881d);
    }
}
