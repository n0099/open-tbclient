package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.core.report.e;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public boolean f34873c;

    /* renamed from: d  reason: collision with root package name */
    public long f34874d;

    /* renamed from: e  reason: collision with root package name */
    public String f34875e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f34876f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34877g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f34878h = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.feed.a.c.c.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (c.this.f34874d > 0) {
                e.a(c.this.f34876f, System.currentTimeMillis() - c.this.f34874d);
                c.this.f34874d = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (c.this.f34873c) {
                e.c(c.this.f34876f);
            } else {
                c.this.f34873c = true;
                e.b(c.this.f34876f);
            }
            c.this.f34874d = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.feed.a.b.a) this).f34854a.f34856b;
        this.f34877g = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f34878h);
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f34854a;
        this.f34876f = bVar.f34855a;
        this.f34875e = String.valueOf(bVar.f35904e.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f34877g;
        if (aVar != null) {
            aVar.b(this.f34878h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f34875e);
    }
}
