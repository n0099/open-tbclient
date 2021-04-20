package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32984b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32985c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32986d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f32987e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f32988f;

    /* renamed from: g  reason: collision with root package name */
    public long f32989g;

    /* renamed from: h  reason: collision with root package name */
    public String f32990h;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33058a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33064f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f33078a;
        this.f32984b = aVar;
        if (aVar == null) {
            return;
        }
        this.f32987e = fVar.f33063e;
        KsFragment ksFragment = fVar.f33059a;
        this.f32988f = ksFragment;
        this.f32990h = String.valueOf(ksFragment.hashCode());
        if (this.f32985c == null) {
            com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                @Override // com.kwad.sdk.core.i.c
                public void b() {
                    if (i.this.f32987e == null || i.this.f32988f == null || i.this.f32989g <= 0) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(i.this.f32987e, System.currentTimeMillis() - i.this.f32989g);
                    i.this.f32989g = 0L;
                }

                @Override // com.kwad.sdk.core.i.c
                public void c_() {
                    if (i.this.f32986d) {
                        com.kwad.sdk.core.report.e.c(i.this.f32987e);
                    } else {
                        i.this.f32986d = true;
                        com.kwad.sdk.core.report.e.b(i.this.f32987e);
                    }
                    i.this.f32989g = System.currentTimeMillis();
                }
            };
            this.f32985c = cVar;
            this.f32984b.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        super.b_();
        com.kwad.sdk.core.i.c cVar = this.f32985c;
        if (cVar == null || (aVar = this.f32984b) == null) {
            return;
        }
        aVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f32990h);
    }
}
