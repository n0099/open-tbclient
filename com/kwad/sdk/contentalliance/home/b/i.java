package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33079b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33080c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33081d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33082e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f33083f;

    /* renamed from: g  reason: collision with root package name */
    public long f33084g;

    /* renamed from: h  reason: collision with root package name */
    public String f33085h;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33153a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33159f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f33173a;
        this.f33079b = aVar;
        if (aVar == null) {
            return;
        }
        this.f33082e = fVar.f33158e;
        KsFragment ksFragment = fVar.f33154a;
        this.f33083f = ksFragment;
        this.f33085h = String.valueOf(ksFragment.hashCode());
        if (this.f33080c == null) {
            com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                @Override // com.kwad.sdk.core.i.c
                public void b() {
                    if (i.this.f33082e == null || i.this.f33083f == null || i.this.f33084g <= 0) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(i.this.f33082e, System.currentTimeMillis() - i.this.f33084g);
                    i.this.f33084g = 0L;
                }

                @Override // com.kwad.sdk.core.i.c
                public void c_() {
                    if (i.this.f33081d) {
                        com.kwad.sdk.core.report.e.c(i.this.f33082e);
                    } else {
                        i.this.f33081d = true;
                        com.kwad.sdk.core.report.e.b(i.this.f33082e);
                    }
                    i.this.f33084g = System.currentTimeMillis();
                }
            };
            this.f33080c = cVar;
            this.f33079b.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        super.b_();
        com.kwad.sdk.core.i.c cVar = this.f33080c;
        if (cVar == null || (aVar = this.f33079b) == null) {
            return;
        }
        aVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33085h);
    }
}
