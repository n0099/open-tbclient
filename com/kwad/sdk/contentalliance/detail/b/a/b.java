package com.kwad.sdk.contentalliance.detail.b.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.contentalliance.a.d;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.SubShowItem f32140b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32141c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.b.b f32142d;

    /* renamed from: e  reason: collision with root package name */
    public int f32143e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32144f;

    /* renamed from: g  reason: collision with root package name */
    public int f32145g;

    /* renamed from: h  reason: collision with root package name */
    public c f32146h = new c() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (b.this.f32145g == -1) {
                return;
            }
            b.this.f32145g = -1;
            if (b.this.f32140b != null) {
                b.this.f32140b.onPageVisibleChange(false);
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (b.this.f32145g == 1) {
                return;
            }
            b.this.f32145g = 1;
            if (b.this.f32140b != null) {
                b.this.f32140b.onPageVisibleChange(true);
            }
        }
    };
    public com.kwad.sdk.contentalliance.a.c i = new d() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void c() {
            if (b.this.f32140b != null) {
                b.this.f32140b.onPageResume();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void d() {
            if (b.this.f32140b != null) {
                b.this.f32140b.onPagePause();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void e() {
            if (b.this.f32140b != null) {
                b.this.f32140b.onPageCreate();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void f() {
            if (b.this.f32140b != null) {
                b.this.f32140b.onPageDestroy();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void g() {
        }
    };
    public com.kwad.sdk.contentalliance.a.a j = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.3
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.this.f32144f == null) {
                return;
            }
            b.this.f32144f.a(b.this.f32146h);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.this.f32144f == null) {
                return;
            }
            b.this.f32146h.b();
            b.this.f32144f.b(b.this.f32146h);
        }
    };

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32152a;
        if (hVar != null) {
            this.f32144f = hVar.f32789a;
        }
        this.f32145g = 0;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        AdTemplate adTemplate = cVar.j;
        this.f32141c = adTemplate;
        com.kwad.sdk.contentalliance.detail.b.b bVar = cVar.q;
        this.f32142d = bVar;
        this.f32143e = cVar.i;
        if (bVar == null || adTemplate == null) {
            return;
        }
        KsContentPage.SubShowItem a2 = bVar.a(adTemplate);
        this.f32140b = a2;
        if (a2 == null) {
            return;
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32154c.add(this.i);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        if (cVar != null) {
            cVar.f32153b.remove(this.j);
        }
    }
}
