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
/* loaded from: classes6.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public String f36646a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f36647b;

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f36648c;

    /* renamed from: d  reason: collision with root package name */
    public long f36649d;

    /* renamed from: e  reason: collision with root package name */
    public VideoPlayerStatus f36650e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36651f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36652g;

    /* renamed from: h  reason: collision with root package name */
    public final List<g.a> f36653h = new ArrayList();
    public g.a i = new g.a() { // from class: com.kwad.sdk.splashscreen.b.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.f36653h) {
                for (g.a aVar : a.this.f36653h) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.f36653h) {
                for (g.a aVar : a.this.f36653h) {
                    aVar.b();
                }
            }
        }
    };
    public long j;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.j = -1L;
        this.f36648c = ksVideoPlayConfig;
        String H = com.kwad.sdk.core.response.b.a.H(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f36650e = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(H);
        if (b2 != null && b2.exists()) {
            this.f36646a = b2.getAbsolutePath();
        }
        this.f36647b = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f36649d = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.j = adTemplate.mKsPlayerClickTimeParam;
        this.f36647b.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                boolean a2 = ao.a((View) detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                if (a2) {
                    a.this.f36647b.f();
                }
            }
        });
        b.a().a(this.i);
    }

    private void h() {
        this.f36647b.a(new d.a().a(this.f36650e).a(this.f36646a).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f36649d, this.j)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f36648c;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f36647b.e();
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f36647b.a(eVar);
    }

    public void a(g.a aVar) {
        this.f36653h.add(aVar);
    }

    public void a(boolean z) {
        this.f36652g = z;
    }

    public void a(boolean z, boolean z2) {
        this.f36651f = z;
        if (!z) {
            this.f36647b.a(0.0f, 0.0f);
            return;
        }
        this.f36647b.a(1.0f, 1.0f);
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
        this.f36647b.b(eVar);
    }

    public void b(g.a aVar) {
        this.f36653h.remove(aVar);
    }

    public long c() {
        return this.f36647b.o();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        d();
    }

    public void d() {
        this.f36647b.h();
        if (this.f36651f && this.f36652g) {
            b.a().a(false);
            if (b.a().b()) {
                this.f36651f = false;
                a(false, false);
            }
        }
    }

    public void e() {
        this.f36647b.j();
    }

    @MainThread
    public void f() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f36647b;
        if (aVar != null) {
            aVar.p();
            this.f36647b.k();
        }
        b.a().b(this.i);
    }

    public void g() {
        if (this.f36647b.a() == null) {
            h();
        }
        this.f36647b.f();
    }
}
