package com.kwad.sdk.splashscreen.b;

import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private String f11042a;

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.detail.video.a f11043b;
    private KsVideoPlayConfig c;
    private long d;
    private VideoPlayerStatus e;
    private boolean f;
    private boolean g;
    private final List<g.a> h = new ArrayList();
    private g.a i = new g.a() { // from class: com.kwad.sdk.splashscreen.b.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.h) {
                for (g.a aVar : a.this.h) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.h) {
                for (g.a aVar : a.this.h) {
                    aVar.b();
                }
            }
        }
    };
    private long j;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.j = -1L;
        this.c = ksVideoPlayConfig;
        String H = com.kwad.sdk.core.response.b.a.H(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.e = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(H);
        if (b2 != null && b2.exists()) {
            this.f11042a = b2.getAbsolutePath();
        }
        this.f11043b = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.d = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.j = adTemplate.mKsPlayerClickTimeParam;
        this.f11043b.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                boolean a2 = ao.a((View) detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                if (a2) {
                    a.this.f11043b.f();
                }
            }
        });
        b.a().a(this.i);
    }

    private void h() {
        this.f11043b.a(new d.a().a(this.e).a(this.f11042a).a(new com.kwad.sdk.contentalliance.detail.video.c(this.d, this.j)).a());
        if (this.c != null) {
            a(this.c.isVideoSoundEnable(), false);
        }
        this.f11043b.e();
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f11043b.a(eVar);
    }

    public void a(g.a aVar) {
        this.h.add(aVar);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(boolean z, boolean z2) {
        this.f = z;
        if (!z) {
            this.f11043b.a(0.0f, 0.0f);
            return;
        }
        this.f11043b.a(1.0f, 1.0f);
        if (z2) {
            b.a().a(true);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        e();
    }

    @MainThread
    public void b(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f11043b.b(eVar);
    }

    public void b(g.a aVar) {
        this.h.remove(aVar);
    }

    public long c() {
        return this.f11043b.o();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        d();
    }

    public void d() {
        this.f11043b.h();
        if (this.f && this.g) {
            b.a().a(false);
            if (b.a().b()) {
                this.f = false;
                a(this.f, false);
            }
        }
    }

    public void e() {
        this.f11043b.j();
    }

    @MainThread
    public void f() {
        if (this.f11043b != null) {
            this.f11043b.p();
            this.f11043b.k();
        }
        b.a().b(this.i);
    }

    public void g() {
        if (this.f11043b.a() == null) {
            h();
        }
        this.f11043b.f();
    }
}
