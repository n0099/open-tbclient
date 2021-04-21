package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.core.report.e;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public boolean f35257c;

    /* renamed from: d  reason: collision with root package name */
    public long f35258d;

    /* renamed from: e  reason: collision with root package name */
    public String f35259e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f35260f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35261g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f35262h = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.feed.a.c.c.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (c.this.f35258d > 0) {
                e.a(c.this.f35260f, System.currentTimeMillis() - c.this.f35258d);
                c.this.f35258d = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (c.this.f35257c) {
                e.c(c.this.f35260f);
            } else {
                c.this.f35257c = true;
                e.b(c.this.f35260f);
            }
            c.this.f35258d = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.feed.a.b.a) this).f35238a.f35240b;
        this.f35261g = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f35262h);
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f35238a;
        this.f35260f = bVar.f35239a;
        this.f35259e = String.valueOf(bVar.f36288e.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f35261g;
        if (aVar != null) {
            aVar.b(this.f35262h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f35259e);
    }
}
