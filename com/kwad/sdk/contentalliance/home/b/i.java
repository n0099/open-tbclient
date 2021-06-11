package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33280b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33281c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33282d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33283e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f33284f;

    /* renamed from: g  reason: collision with root package name */
    public long f33285g;

    /* renamed from: h  reason: collision with root package name */
    public String f33286h;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33357a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33363f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f33379a;
        this.f33280b = aVar;
        if (aVar == null) {
            return;
        }
        this.f33283e = fVar.f33362e;
        KsFragment ksFragment = fVar.f33358a;
        this.f33284f = ksFragment;
        this.f33286h = String.valueOf(ksFragment.hashCode());
        if (this.f33281c == null) {
            com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                @Override // com.kwad.sdk.core.i.c
                public void b() {
                    if (i.this.f33283e == null || i.this.f33284f == null || i.this.f33285g <= 0) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(i.this.f33283e, System.currentTimeMillis() - i.this.f33285g);
                    i.this.f33285g = 0L;
                }

                @Override // com.kwad.sdk.core.i.c
                public void c_() {
                    if (i.this.f33282d) {
                        com.kwad.sdk.core.report.e.c(i.this.f33283e);
                    } else {
                        i.this.f33282d = true;
                        com.kwad.sdk.core.report.e.b(i.this.f33283e);
                    }
                    i.this.f33285g = System.currentTimeMillis();
                }
            };
            this.f33281c = cVar;
            this.f33280b.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        super.b_();
        com.kwad.sdk.core.i.c cVar = this.f33281c;
        if (cVar == null || (aVar = this.f33280b) == null) {
            return;
        }
        aVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33286h);
    }
}
