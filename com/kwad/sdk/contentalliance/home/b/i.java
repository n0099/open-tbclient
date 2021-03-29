package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32695b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32696c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32697d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f32698e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f32699f;

    /* renamed from: g  reason: collision with root package name */
    public long f32700g;

    /* renamed from: h  reason: collision with root package name */
    public String f32701h;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32769a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f32775f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f32789a;
        this.f32695b = aVar;
        if (aVar == null) {
            return;
        }
        this.f32698e = fVar.f32774e;
        KsFragment ksFragment = fVar.f32770a;
        this.f32699f = ksFragment;
        this.f32701h = String.valueOf(ksFragment.hashCode());
        if (this.f32696c == null) {
            com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                @Override // com.kwad.sdk.core.i.c
                public void b() {
                    if (i.this.f32698e == null || i.this.f32699f == null || i.this.f32700g <= 0) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(i.this.f32698e, System.currentTimeMillis() - i.this.f32700g);
                    i.this.f32700g = 0L;
                }

                @Override // com.kwad.sdk.core.i.c
                public void c_() {
                    if (i.this.f32697d) {
                        com.kwad.sdk.core.report.e.c(i.this.f32698e);
                    } else {
                        i.this.f32697d = true;
                        com.kwad.sdk.core.report.e.b(i.this.f32698e);
                    }
                    i.this.f32700g = System.currentTimeMillis();
                }
            };
            this.f32696c = cVar;
            this.f32695b.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        super.b_();
        com.kwad.sdk.core.i.c cVar = this.f32696c;
        if (cVar == null || (aVar = this.f32695b) == null) {
            return;
        }
        aVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f32701h);
    }
}
