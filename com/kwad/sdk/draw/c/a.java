package com.kwad.sdk.draw.c;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.b;
/* loaded from: classes6.dex */
public class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33124a;

    /* renamed from: b  reason: collision with root package name */
    public long f33125b;

    /* renamed from: c  reason: collision with root package name */
    public b f33126c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f33127d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f33128e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f33129f = new b.a() { // from class: com.kwad.sdk.draw.c.a.2
        @Override // com.kwad.sdk.core.view.b.a
        public void a(boolean z) {
            if (!z) {
                a.this.d();
                return;
            }
            if (a.this.f33128e == null) {
                a aVar = a.this;
                aVar.f33128e = new com.kwad.sdk.contentalliance.detail.video.b(aVar.f33125b, System.currentTimeMillis());
                a.this.f33127d.a(a.this.f33128e);
            }
            a.this.c();
        }
    };

    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView) {
        adTemplate.mKsPlayerClickTimeParam = System.currentTimeMillis();
        this.f33124a = adTemplate;
        this.f33125b = com.kwad.sdk.core.response.b.a.i(c.g(adTemplate));
        this.f33126c = bVar;
        this.f33127d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f33127d.a(new c.e() { // from class: com.kwad.sdk.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.a(System.currentTimeMillis());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f33126c.d()) {
            this.f33127d.a(new com.kwad.sdk.contentalliance.detail.video.b(this.f33125b, j));
            this.f33127d.e();
        }
    }

    private void f() {
        this.f33127d.a(new c.a().a(com.kwad.sdk.core.response.b.c.i(this.f33124a)).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f33124a))).a(this.f33124a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f33124a)).a());
        this.f33127d.d();
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f33127d.a() == null) {
            f();
        }
        a(currentTimeMillis);
        this.f33126c.a(this.f33129f);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33127d.a(dVar);
    }

    public void b() {
        this.f33128e = null;
        this.f33126c.b(this.f33129f);
        this.f33127d.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33127d.b(dVar);
    }

    public void c() {
        this.f33127d.f();
        com.kwad.sdk.utils.b.a().a(false);
    }

    public void d() {
        this.f33127d.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f33127d;
        if (aVar != null) {
            aVar.m();
            this.f33127d.h();
        }
    }
}
