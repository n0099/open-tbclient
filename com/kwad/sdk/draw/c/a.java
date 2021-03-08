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
/* loaded from: classes3.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f6428a;
    private long b;
    private g c;
    private com.kwad.sdk.contentalliance.detail.video.a d;
    private c e;
    private g.a f = new g.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.g.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.e == null) {
                a.this.e = new c(a.this.b, System.currentTimeMillis());
                a.this.d.a(a.this.e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f6428a = adTemplate;
        this.b = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(this.f6428a));
        this.c = gVar;
        this.d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.c.d()) {
            this.d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.b, j));
            this.d.f();
        }
    }

    private void f() {
        this.d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f6428a)).a(this.f6428a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f6428a)).a());
        this.d.e();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.c.a(this.f);
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.d.a(eVar);
    }

    public void b() {
        this.e = null;
        this.c.b(this.f);
        this.d.k();
    }

    @MainThread
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.d.b(eVar);
    }

    public void c() {
        this.d.h();
        b.a().a(false);
    }

    public void d() {
        this.d.j();
    }

    @MainThread
    public void e() {
        if (this.d != null) {
            this.d.p();
            this.d.k();
        }
    }
}
