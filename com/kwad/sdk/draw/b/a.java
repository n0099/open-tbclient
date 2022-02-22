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
/* loaded from: classes4.dex */
public class a {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f56943b;

    /* renamed from: c  reason: collision with root package name */
    public f f56944c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f56945d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f56946e;

    /* renamed from: f  reason: collision with root package name */
    public b f56947f;

    /* renamed from: g  reason: collision with root package name */
    public Context f56948g;

    /* renamed from: h  reason: collision with root package name */
    public final d f56949h = new d() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            if (a.this.f56947f == null) {
                a aVar = a.this;
                aVar.f56947f = b.a(aVar.a);
                a.this.f56946e.a(a.this.f56947f);
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
        this.f56943b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f56944c = fVar;
        this.f56948g = detailVideoView.getContext();
        this.f56945d = detailVideoView;
        this.f56946e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f56946e.a(new c.e() { // from class: com.kwad.sdk.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.a(m.d(a.this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        if (this.f56944c.c()) {
            this.f56946e.a(new b(this.a, j2));
            this.f56946e.e();
        }
    }

    private void f() {
        this.f56946e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(new b(this.a, System.currentTimeMillis())).a(), this.f56945d);
        this.f56946e.d();
    }

    public void a() {
        long d2 = m.d(this.a);
        if (this.f56946e.a() == null) {
            f();
        }
        a(d2);
        this.f56944c.a(this.f56949h);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56946e.a(dVar);
    }

    public void b() {
        this.f56947f = null;
        this.f56944c.b(this.f56949h);
        this.f56946e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56946e.b(dVar);
    }

    public void c() {
        this.f56946e.f();
        com.kwad.sdk.utils.b.a(this.f56948g).a(false);
    }

    public void d() {
        this.f56946e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f56946e;
        if (aVar != null) {
            aVar.n();
            this.f56946e.h();
        }
    }
}
