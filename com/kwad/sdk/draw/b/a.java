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
/* loaded from: classes5.dex */
public class a {
    @NonNull
    public AdTemplate a;
    public long b;
    public f c;
    public DetailVideoView d;
    public com.kwad.sdk.contentalliance.detail.video.a e;
    public b f;
    public Context g;
    public final d h = new d() { // from class: com.kwad.sdk.draw.b.a.2
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            if (a.this.f == null) {
                a aVar = a.this;
                aVar.f = b.a(aVar.a);
                a.this.e.a(a.this.f);
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
        this.b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.c = fVar;
        this.g = detailVideoView.getContext();
        this.d = detailVideoView;
        this.e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f();
        this.e.a(new c.e() { // from class: com.kwad.sdk.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.a(m.d(a.this.a));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.c.c()) {
            this.e.a(new b(this.a, j));
            this.e.e();
        }
    }

    private void f() {
        this.e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(new b(this.a, System.currentTimeMillis())).a(), this.d);
        this.e.d();
    }

    public void a() {
        long d = m.d(this.a);
        if (this.e.a() == null) {
            f();
        }
        a(d);
        this.c.a(this.h);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.e.a(dVar);
    }

    public void b() {
        this.f = null;
        this.c.b(this.h);
        this.e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.e.b(dVar);
    }

    public void c() {
        this.e.f();
        com.kwad.sdk.utils.b.a(this.g).a(false);
    }

    public void d() {
        this.e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.e;
        if (aVar != null) {
            aVar.n();
            this.e.h();
        }
    }
}
