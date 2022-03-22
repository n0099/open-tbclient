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
/* loaded from: classes7.dex */
public class a {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f40352b;

    /* renamed from: c  reason: collision with root package name */
    public f f40353c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f40354d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f40355e;

    /* renamed from: f  reason: collision with root package name */
    public b f40356f;

    /* renamed from: g  reason: collision with root package name */
    public Context f40357g;

    /* renamed from: h  reason: collision with root package name */
    public final d f40358h = new d() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            if (a.this.f40356f == null) {
                a aVar = a.this;
                aVar.f40356f = b.a(aVar.a);
                a.this.f40355e.a(a.this.f40356f);
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
        this.f40352b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f40353c = fVar;
        this.f40357g = detailVideoView.getContext();
        this.f40354d = detailVideoView;
        this.f40355e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f40355e.a(new c.e() { // from class: com.kwad.sdk.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.a(m.d(a.this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f40353c.c()) {
            this.f40355e.a(new b(this.a, j));
            this.f40355e.e();
        }
    }

    private void f() {
        this.f40355e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(new b(this.a, System.currentTimeMillis())).a(), this.f40354d);
        this.f40355e.d();
    }

    public void a() {
        long d2 = m.d(this.a);
        if (this.f40355e.a() == null) {
            f();
        }
        a(d2);
        this.f40353c.a(this.f40358h);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f40355e.a(dVar);
    }

    public void b() {
        this.f40356f = null;
        this.f40353c.b(this.f40358h);
        this.f40355e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f40355e.b(dVar);
    }

    public void c() {
        this.f40355e.f();
        com.kwad.sdk.utils.b.a(this.f40357g).a(false);
    }

    public void d() {
        this.f40355e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f40355e;
        if (aVar != null) {
            aVar.n();
            this.f40355e.h();
        }
    }
}
