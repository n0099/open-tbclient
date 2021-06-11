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
/* loaded from: classes7.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35248a;

    /* renamed from: b  reason: collision with root package name */
    public long f35249b;

    /* renamed from: c  reason: collision with root package name */
    public g f35250c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f35251d;

    /* renamed from: e  reason: collision with root package name */
    public c f35252e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f35253f = new g.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.g.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.f35252e == null) {
                a aVar = a.this;
                aVar.f35252e = new c(aVar.f35249b, System.currentTimeMillis());
                a.this.f35251d.a(a.this.f35252e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f35248a = adTemplate;
        this.f35249b = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f35250c = gVar;
        this.f35251d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f35251d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f35250c.d()) {
            this.f35251d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f35249b, j));
            this.f35251d.f();
        }
    }

    private void f() {
        this.f35251d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f35248a)).a(this.f35248a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f35248a)).a());
        this.f35251d.e();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f35251d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.f35250c.a(this.f35253f);
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f35251d.a(eVar);
    }

    public void b() {
        this.f35252e = null;
        this.f35250c.b(this.f35253f);
        this.f35251d.k();
    }

    @MainThread
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f35251d.b(eVar);
    }

    public void c() {
        this.f35251d.h();
        b.a().a(false);
    }

    public void d() {
        this.f35251d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f35251d;
        if (aVar != null) {
            aVar.p();
            this.f35251d.k();
        }
    }
}
