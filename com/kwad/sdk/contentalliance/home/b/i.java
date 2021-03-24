package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32694b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32695c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32696d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f32697e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f32698f;

    /* renamed from: g  reason: collision with root package name */
    public long f32699g;

    /* renamed from: h  reason: collision with root package name */
    public String f32700h;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32768a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f32774f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f32788a;
        this.f32694b = aVar;
        if (aVar == null) {
            return;
        }
        this.f32697e = fVar.f32773e;
        KsFragment ksFragment = fVar.f32769a;
        this.f32698f = ksFragment;
        this.f32700h = String.valueOf(ksFragment.hashCode());
        if (this.f32695c == null) {
            com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                @Override // com.kwad.sdk.core.i.c
                public void b() {
                    if (i.this.f32697e == null || i.this.f32698f == null || i.this.f32699g <= 0) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(i.this.f32697e, System.currentTimeMillis() - i.this.f32699g);
                    i.this.f32699g = 0L;
                }

                @Override // com.kwad.sdk.core.i.c
                public void c_() {
                    if (i.this.f32696d) {
                        com.kwad.sdk.core.report.e.c(i.this.f32697e);
                    } else {
                        i.this.f32696d = true;
                        com.kwad.sdk.core.report.e.b(i.this.f32697e);
                    }
                    i.this.f32699g = System.currentTimeMillis();
                }
            };
            this.f32695c = cVar;
            this.f32694b.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        super.b_();
        com.kwad.sdk.core.i.c cVar = this.f32695c;
        if (cVar == null || (aVar = this.f32694b) == null) {
            return;
        }
        aVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f32700h);
    }
}
