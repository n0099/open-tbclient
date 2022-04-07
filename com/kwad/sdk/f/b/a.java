package com.kwad.sdk.f.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.m;
/* loaded from: classes5.dex */
public class a {
    public AdTemplate a;
    public long b;
    public f c;
    public DetailVideoView d;
    public com.kwad.sdk.contentalliance.detail.video.a e;
    public boolean f;
    public boolean g;
    public Context h;
    public e i;
    public boolean j;
    public final d k = new d() { // from class: com.kwad.sdk.f.b.a.3
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            a.this.c();
        }

        @Override // com.kwad.sdk.core.j.d
        public void f() {
            a.this.d();
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull f fVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        boolean z = false;
        this.j = false;
        this.a = adTemplate;
        this.b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.c = fVar;
        this.f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.g = z;
        this.h = detailVideoView.getContext();
        this.d = detailVideoView;
        this.e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.j = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        e eVar = new e() { // from class: com.kwad.sdk.f.b.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i, int i2) {
                super.a(i, i2);
                com.kwad.sdk.core.report.d.b(adTemplate, i, i2);
            }
        };
        this.i = eVar;
        this.e.a(eVar);
        g();
        this.e.a(new c.e() { // from class: com.kwad.sdk.f.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                if (a.this.h() && a.this.c.c()) {
                    a.this.e.a(b.a(a.this.a));
                    a.this.e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f;
        if (z) {
            aVar = this.e;
            f = 1.0f;
        } else {
            aVar = this.e;
            f = 0.0f;
        }
        aVar.a(f, f);
    }

    private void g() {
        this.e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.j).a(b.a(this.a)).a(), true, true, this.d);
        a(this.f);
        if (h()) {
            this.e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.g) {
            this.g = com.ksad.download.c.b.b(this.h);
        }
        return this.g;
    }

    public void a() {
        m.c(this.a);
        if (this.e.a() == null) {
            g();
        }
        if (h() && this.c.c()) {
            this.e.a(b.a(this.a));
            this.e.e();
        }
        this.c.a(this.k);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.e.a(dVar);
    }

    public void b() {
        m.a(this.a);
        this.c.b(this.k);
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
        if (h()) {
            if (this.f) {
                com.kwad.sdk.utils.b.a(this.h).a(false);
                if (com.kwad.sdk.utils.b.a(this.h).a()) {
                    this.f = false;
                    a(false);
                }
            }
            this.e.f();
        }
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

    public void f() {
        this.g = true;
        if (this.c.c()) {
            m.b(this.a);
            this.e.a(b.a(this.a));
            this.e.e();
        }
    }
}
