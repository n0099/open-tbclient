package com.kwad.sdk.draw.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.m;
/* loaded from: classes3.dex */
public class a {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f56776b;

    /* renamed from: c  reason: collision with root package name */
    public f f56777c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f56778d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f56779e;

    /* renamed from: f  reason: collision with root package name */
    public b f56780f;

    /* renamed from: g  reason: collision with root package name */
    public Context f56781g;

    /* renamed from: h  reason: collision with root package name */
    public final d f56782h = new d() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            if (a.this.f56780f == null) {
                a aVar = a.this;
                aVar.f56780f = b.a(aVar.a);
                a.this.f56779e.a(a.this.f56780f);
            }
            a.this.c();
        }

        @Override // com.kwad.sdk.core.j.d
        public void f() {
            a.this.d();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull f fVar, @NonNull DetailVideoView detailVideoView) {
        this.a = adTemplate;
        this.f56776b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f56777c = fVar;
        this.f56781g = detailVideoView.getContext();
        this.f56778d = detailVideoView;
        this.f56779e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f56779e.a(new c.e() { // from class: com.kwad.sdk.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.a(m.d(a.this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        if (this.f56777c.c()) {
            this.f56779e.a(new b(this.a, j2));
            this.f56779e.e();
        }
    }

    private void f() {
        this.f56779e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(new b(this.a, System.currentTimeMillis())).a(), this.f56778d);
        this.f56779e.d();
    }

    public void a() {
        long d2 = m.d(this.a);
        if (this.f56779e.a() == null) {
            f();
        }
        a(d2);
        this.f56777c.a(this.f56782h);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56779e.a(dVar);
    }

    public void b() {
        this.f56780f = null;
        this.f56777c.b(this.f56782h);
        this.f56779e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56779e.b(dVar);
    }

    public void c() {
        this.f56779e.f();
        com.kwad.sdk.utils.b.a(this.f56781g).a(false);
    }

    public void d() {
        this.f56779e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f56779e;
        if (aVar != null) {
            aVar.n();
            this.f56779e.h();
        }
    }
}
