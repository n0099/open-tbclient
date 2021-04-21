package com.kwad.sdk.contentalliance.tube.profile.b;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33649b;

    /* renamed from: c  reason: collision with root package name */
    public long f33650c;

    /* renamed from: d  reason: collision with root package name */
    public String f33651d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33652e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33653f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33654g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33650c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33652e, System.currentTimeMillis() - d.this.f33650c);
                d.this.f33650c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33649b) {
                com.kwad.sdk.core.report.e.c(d.this.f33652e);
            } else {
                d.this.f33649b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33652e);
            }
            d.this.f33650c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33615a.f33619d;
        this.f33653f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33654g);
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33615a;
        this.f33652e = bVar.f33621f;
        this.f33651d = String.valueOf(bVar.f33616a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33653f;
        if (aVar != null) {
            aVar.b(this.f33654g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33651d);
    }
}
