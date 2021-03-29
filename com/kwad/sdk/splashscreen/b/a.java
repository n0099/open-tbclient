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
    public String f36647a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f36648b;

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f36649c;

    /* renamed from: d  reason: collision with root package name */
    public long f36650d;

    /* renamed from: e  reason: collision with root package name */
    public VideoPlayerStatus f36651e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36652f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36653g;

    /* renamed from: h  reason: collision with root package name */
    public final List<g.a> f36654h = new ArrayList();
    public g.a i = new g.a() { // from class: com.kwad.sdk.splashscreen.b.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.f36654h) {
                for (g.a aVar : a.this.f36654h) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.f36654h) {
                for (g.a aVar : a.this.f36654h) {
                    aVar.b();
                }
            }
        }
    };
    public long j;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.j = -1L;
        this.f36649c = ksVideoPlayConfig;
        String H = com.kwad.sdk.core.response.b.a.H(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f36651e = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(H);
        if (b2 != null && b2.exists()) {
            this.f36647a = b2.getAbsolutePath();
        }
        this.f36648b = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f36650d = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.j = adTemplate.mKsPlayerClickTimeParam;
        this.f36648b.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                boolean a2 = ao.a((View) detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                if (a2) {
                    a.this.f36648b.f();
                }
            }
        });
        b.a().a(this.i);
    }

    private void h() {
        this.f36648b.a(new d.a().a(this.f36651e).a(this.f36647a).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f36650d, this.j)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f36649c;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f36648b.e();
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f36648b.a(eVar);
    }

    public void a(g.a aVar) {
        this.f36654h.add(aVar);
    }

    public void a(boolean z) {
        this.f36653g = z;
    }

    public void a(boolean z, boolean z2) {
        this.f36652f = z;
        if (!z) {
            this.f36648b.a(0.0f, 0.0f);
            return;
        }
        this.f36648b.a(1.0f, 1.0f);
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
        this.f36648b.b(eVar);
    }

    public void b(g.a aVar) {
        this.f36654h.remove(aVar);
    }

    public long c() {
        return this.f36648b.o();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        d();
    }

    public void d() {
        this.f36648b.h();
        if (this.f36652f && this.f36653g) {
            b.a().a(false);
            if (b.a().b()) {
                this.f36652f = false;
                a(false, false);
            }
        }
    }

    public void e() {
        this.f36648b.j();
    }

    @MainThread
    public void f() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f36648b;
        if (aVar != null) {
            aVar.p();
            this.f36648b.k();
        }
        b.a().b(this.i);
    }

    public void g() {
        if (this.f36648b.a() == null) {
            h();
        }
        this.f36648b.f();
    }
}
