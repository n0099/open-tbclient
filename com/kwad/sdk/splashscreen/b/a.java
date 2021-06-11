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
/* loaded from: classes7.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public String f37401a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f37402b;

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f37403c;

    /* renamed from: d  reason: collision with root package name */
    public long f37404d;

    /* renamed from: e  reason: collision with root package name */
    public VideoPlayerStatus f37405e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37406f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37407g;

    /* renamed from: h  reason: collision with root package name */
    public final List<g.a> f37408h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public g.a f37409i = new g.a() { // from class: com.kwad.sdk.splashscreen.b.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.f37408h) {
                for (g.a aVar : a.this.f37408h) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.f37408h) {
                for (g.a aVar : a.this.f37408h) {
                    aVar.b();
                }
            }
        }
    };
    public long j;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.j = -1L;
        this.f37403c = ksVideoPlayConfig;
        String H = com.kwad.sdk.core.response.b.a.H(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.f37405e = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(H);
        if (b2 != null && b2.exists()) {
            this.f37401a = b2.getAbsolutePath();
        }
        this.f37402b = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f37404d = com.kwad.sdk.core.response.b.a.k(com.kwad.sdk.core.response.b.c.j(adTemplate));
        this.j = adTemplate.mKsPlayerClickTimeParam;
        this.f37402b.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                boolean a2 = ao.a((View) detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                if (a2) {
                    a.this.f37402b.f();
                }
            }
        });
        b.a().a(this.f37409i);
    }

    private void h() {
        this.f37402b.a(new d.a().a(this.f37405e).a(this.f37401a).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f37404d, this.j)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f37403c;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f37402b.e();
    }

    @MainThread
    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.f37402b.a(eVar);
    }

    public void a(g.a aVar) {
        this.f37408h.add(aVar);
    }

    public void a(boolean z) {
        this.f37407g = z;
    }

    public void a(boolean z, boolean z2) {
        this.f37406f = z;
        if (!z) {
            this.f37402b.a(0.0f, 0.0f);
            return;
        }
        this.f37402b.a(1.0f, 1.0f);
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
        this.f37402b.b(eVar);
    }

    public void b(g.a aVar) {
        this.f37408h.remove(aVar);
    }

    public long c() {
        return this.f37402b.o();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        d();
    }

    public void d() {
        this.f37402b.h();
        if (this.f37406f && this.f37407g) {
            b.a().a(false);
            if (b.a().b()) {
                this.f37406f = false;
                a(false, false);
            }
        }
    }

    public void e() {
        this.f37402b.j();
    }

    @MainThread
    public void f() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f37402b;
        if (aVar != null) {
            aVar.p();
            this.f37402b.k();
        }
        b.a().b(this.f37409i);
    }

    public void g() {
        if (this.f37402b.a() == null) {
            h();
        }
        this.f37402b.f();
    }
}
