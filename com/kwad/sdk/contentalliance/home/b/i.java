package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33378b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33379c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33380d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33381e;

    /* renamed from: f  reason: collision with root package name */
    public KsFragment f33382f;

    /* renamed from: g  reason: collision with root package name */
    public long f33383g;

    /* renamed from: h  reason: collision with root package name */
    public String f33384h;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33455a;
        com.kwad.sdk.contentalliance.home.h hVar = fVar.f33461f;
        if (hVar == null) {
            return;
        }
        com.kwad.sdk.core.i.a aVar = hVar.f33477a;
        this.f33378b = aVar;
        if (aVar == null) {
            return;
        }
        this.f33381e = fVar.f33460e;
        KsFragment ksFragment = fVar.f33456a;
        this.f33382f = ksFragment;
        this.f33384h = String.valueOf(ksFragment.hashCode());
        if (this.f33379c == null) {
            com.kwad.sdk.core.i.c cVar = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.home.b.i.1
                @Override // com.kwad.sdk.core.i.c
                public void b() {
                    if (i.this.f33381e == null || i.this.f33382f == null || i.this.f33383g <= 0) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(i.this.f33381e, System.currentTimeMillis() - i.this.f33383g);
                    i.this.f33383g = 0L;
                }

                @Override // com.kwad.sdk.core.i.c
                public void c_() {
                    if (i.this.f33380d) {
                        com.kwad.sdk.core.report.e.c(i.this.f33381e);
                    } else {
                        i.this.f33380d = true;
                        com.kwad.sdk.core.report.e.b(i.this.f33381e);
                    }
                    i.this.f33383g = System.currentTimeMillis();
                }
            };
            this.f33379c = cVar;
            this.f33378b.a(cVar);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        com.kwad.sdk.core.i.a aVar;
        super.b_();
        com.kwad.sdk.core.i.c cVar = this.f33379c;
        if (cVar == null || (aVar = this.f33378b) == null) {
            return;
        }
        aVar.b(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33384h);
    }
}
