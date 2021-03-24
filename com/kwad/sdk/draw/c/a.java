package com.kwad.sdk.draw.c;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.utils.b;
/* loaded from: classes6.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34594a;

    /* renamed from: b  reason: collision with root package name */
    public long f34595b;

    /* renamed from: c  reason: collision with root package name */
    public g f34596c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f34597d;

    /* renamed from: e  reason: collision with root package name */
    public c f34598e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f34599f = new g.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.g.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.f34598e == null) {
                a aVar = a.this;
                aVar.f34598e = new c(aVar.f34595b, System.currentTimeMillis());
                a.this.f34597d.a(a.this.f34598e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f34594a = adTemplate;
        this.f34595b = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f34596c = gVar;
        this.f34597d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f34597d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f34596c.d()) {
            this.f34597d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f34595b, j));
            this.f34597d.f();
        }
    }

    private void f() {
        this.f34597d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f34594a)).a(this.f34594a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f34594a)).a());
        this.f34597d.e();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f34597d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.f34596c.a(this.f34599f);
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f34597d.a(eVar);
    }

    public void b() {
        this.f34598e = null;
        this.f34596c.b(this.f34599f);
        this.f34597d.k();
    }

    @MainThread
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f34597d.b(eVar);
    }

    public void c() {
        this.f34597d.h();
        b.a().a(false);
    }

    public void d() {
        this.f34597d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f34597d;
        if (aVar != null) {
            aVar.p();
            this.f34597d.k();
        }
    }
}
