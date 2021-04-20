package com.kwad.sdk.contentalliance.tube.profile.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33554b;

    /* renamed from: c  reason: collision with root package name */
    public long f33555c;

    /* renamed from: d  reason: collision with root package name */
    public String f33556d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33557e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33558f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33559g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33555c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33557e, System.currentTimeMillis() - d.this.f33555c);
                d.this.f33555c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33554b) {
                com.kwad.sdk.core.report.e.c(d.this.f33557e);
            } else {
                d.this.f33554b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33557e);
            }
            d.this.f33555c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a.f33524d;
        this.f33558f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33559g);
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a;
        this.f33557e = bVar.f33526f;
        this.f33556d = String.valueOf(bVar.f33521a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33558f;
        if (aVar != null) {
            aVar.b(this.f33559g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33556d);
    }
}
