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
    public long f58952b;

    /* renamed from: c  reason: collision with root package name */
    public f f58953c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f58954d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f58955e;

    /* renamed from: f  reason: collision with root package name */
    public b f58956f;

    /* renamed from: g  reason: collision with root package name */
    public Context f58957g;

    /* renamed from: h  reason: collision with root package name */
    public final d f58958h = new d() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            if (a.this.f58956f == null) {
                a aVar = a.this;
                aVar.f58956f = b.a(aVar.a);
                a.this.f58955e.a(a.this.f58956f);
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
        this.f58952b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f58953c = fVar;
        this.f58957g = detailVideoView.getContext();
        this.f58954d = detailVideoView;
        this.f58955e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.f58955e.a(new c.e() { // from class: com.kwad.sdk.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.a(m.d(a.this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        if (this.f58953c.c()) {
            this.f58955e.a(new b(this.a, j2));
            this.f58955e.e();
        }
    }

    private void f() {
        this.f58955e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(new b(this.a, System.currentTimeMillis())).a(), this.f58954d);
        this.f58955e.d();
    }

    public void a() {
        long d2 = m.d(this.a);
        if (this.f58955e.a() == null) {
            f();
        }
        a(d2);
        this.f58953c.a(this.f58958h);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f58955e.a(dVar);
    }

    public void b() {
        this.f58956f = null;
        this.f58953c.b(this.f58958h);
        this.f58955e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f58955e.b(dVar);
    }

    public void c() {
        this.f58955e.f();
        com.kwad.sdk.utils.b.a(this.f58957g).a(false);
    }

    public void d() {
        this.f58955e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f58955e;
        if (aVar != null) {
            aVar.n();
            this.f58955e.h();
        }
    }
}
