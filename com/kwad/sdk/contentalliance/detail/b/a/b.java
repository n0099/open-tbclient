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
    public KsContentPage.SubShowItem f32429b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32430c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.b.b f32431d;

    /* renamed from: e  reason: collision with root package name */
    public int f32432e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32433f;

    /* renamed from: g  reason: collision with root package name */
    public int f32434g;

    /* renamed from: h  reason: collision with root package name */
    public c f32435h = new c() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (b.this.f32434g == -1) {
                return;
            }
            b.this.f32434g = -1;
            if (b.this.f32429b != null) {
                b.this.f32429b.onPageVisibleChange(false);
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (b.this.f32434g == 1) {
                return;
            }
            b.this.f32434g = 1;
            if (b.this.f32429b != null) {
                b.this.f32429b.onPageVisibleChange(true);
            }
        }
    };
    public com.kwad.sdk.contentalliance.a.c i = new d() { // from class: com.kwad.sdk.contentalliance.detail.b.a.b.2
        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void c() {
            if (b.this.f32429b != null) {
                b.this.f32429b.onPageResume();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void d() {
            if (b.this.f32429b != null) {
                b.this.f32429b.onPagePause();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void e() {
            if (b.this.f32429b != null) {
                b.this.f32429b.onPageCreate();
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.d, com.kwad.sdk.contentalliance.a.c
        public void f() {
            if (b.this.f32429b != null) {
                b.this.f32429b.onPageDestroy();
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
            if (b.this.f32433f == null) {
                return;
            }
            b.this.f32433f.a(b.this.f32435h);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.this.f32433f == null) {
                return;
            }
            b.this.f32435h.b();
            b.this.f32433f.b(b.this.f32435h);
        }
    };

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32441a;
        if (hVar != null) {
            this.f32433f = hVar.f33078a;
        }
        this.f32434g = 0;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        AdTemplate adTemplate = cVar.j;
        this.f32430c = adTemplate;
        com.kwad.sdk.contentalliance.detail.b.b bVar = cVar.q;
        this.f32431d = bVar;
        this.f32432e = cVar.i;
        if (bVar == null || adTemplate == null) {
            return;
        }
        KsContentPage.SubShowItem a2 = bVar.a(adTemplate);
        this.f32429b = a2;
        if (a2 == null) {
            return;
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32443c.add(this.i);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        if (cVar != null) {
            cVar.f32442b.remove(this.j);
        }
    }
}
