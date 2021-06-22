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
    public AdTemplate f35346a;

    /* renamed from: b  reason: collision with root package name */
    public long f35347b;

    /* renamed from: c  reason: collision with root package name */
    public g f35348c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f35349d;

    /* renamed from: e  reason: collision with root package name */
    public c f35350e;

    /* renamed from: f  reason: collision with root package name */
    public g.a f35351f = new g.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.g.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.f35350e == null) {
                a aVar = a.this;
                aVar.f35350e = new c(aVar.f35347b, System.currentTimeMillis());
                a.this.f35349d.a(a.this.f35350e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f35346a = adTemplate;
        this.f35347b = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f35348c = gVar;
        this.f35349d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f35349d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f35348c.d()) {
            this.f35349d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f35347b, j));
            this.f35349d.f();
        }
    }

    private void f() {
        this.f35349d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f35346a)).a(this.f35346a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f35346a)).a());
        this.f35349d.e();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f35349d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.f35348c.a(this.f35351f);
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f35349d.a(eVar);
    }

    public void b() {
        this.f35350e = null;
        this.f35348c.b(this.f35351f);
        this.f35349d.k();
    }

    @MainThread
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f35349d.b(eVar);
    }

    public void c() {
        this.f35349d.h();
        b.a().a(false);
    }

    public void d() {
        this.f35349d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f35349d;
        if (aVar != null) {
            aVar.p();
            this.f35349d.k();
        }
    }
}
