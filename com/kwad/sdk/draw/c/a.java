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
    public AdTemplate f34979a;

    /* renamed from: b  reason: collision with root package name */
    public long f34980b;

    /* renamed from: c  reason: collision with root package name */
    public g f34981c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f34982d;

    /* renamed from: e  reason: collision with root package name */
    public c f34983e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f34984f = new g.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.g.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.f34983e == null) {
                a aVar = a.this;
                aVar.f34983e = new c(aVar.f34980b, System.currentTimeMillis());
                a.this.f34982d.a(a.this.f34983e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f34979a = adTemplate;
        this.f34980b = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f34981c = gVar;
        this.f34982d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f34982d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f34981c.d()) {
            this.f34982d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f34980b, j));
            this.f34982d.f();
        }
    }

    private void f() {
        this.f34982d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f34979a)).a(this.f34979a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f34979a)).a());
        this.f34982d.e();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f34982d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.f34981c.a(this.f34984f);
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f34982d.a(eVar);
    }

    public void b() {
        this.f34983e = null;
        this.f34981c.b(this.f34984f);
        this.f34982d.k();
    }

    @MainThread
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f34982d.b(eVar);
    }

    public void c() {
        this.f34982d.h();
        b.a().a(false);
    }

    public void d() {
        this.f34982d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f34982d;
        if (aVar != null) {
            aVar.p();
            this.f34982d.k();
        }
    }
}
