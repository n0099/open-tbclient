package com.kwad.sdk.splashscreen.b;

import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public String f34799a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f34800b;

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f34801c;

    /* renamed from: d  reason: collision with root package name */
    public long f34802d;

    /* renamed from: e  reason: collision with root package name */
    public VideoPlayerStatus f34803e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34804f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f34805g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34806h;

    /* renamed from: i  reason: collision with root package name */
    public final List<g.a> f34807i = new ArrayList();
    public g.a j = new g.a() { // from class: com.kwad.sdk.splashscreen.b.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.f34807i) {
                for (g.a aVar : a.this.f34807i) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.f34807i) {
                for (g.a aVar : a.this.f34807i) {
                    aVar.b();
                }
            }
        }
    };
    public long k;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.k = -1L;
        this.f34805g = adTemplate;
        this.f34801c = ksVideoPlayConfig;
        String D = com.kwad.sdk.core.response.b.a.D(com.kwad.sdk.core.response.b.c.g(adTemplate));
        this.f34803e = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(D);
        if (b2 != null && b2.exists()) {
            this.f34799a = b2.getAbsolutePath();
        }
        this.f34800b = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f34802d = com.kwad.sdk.core.response.b.a.i(com.kwad.sdk.core.response.b.c.g(adTemplate));
        this.k = adTemplate.mKsPlayerClickTimeParam;
        this.f34800b.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                boolean a2 = an.a((View) detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a2);
                if (a2) {
                    a.this.f34800b.e();
                }
            }
        });
        b.a().a(this.j);
    }

    private void h() {
        this.f34800b.a(new c.a().a(this.f34803e).a(this.f34799a).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f34805g))).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f34802d, this.k)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f34801c;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f34800b.d();
    }

    public long a() {
        return this.f34800b.l();
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f34800b.a(dVar);
    }

    public void a(g.a aVar) {
        this.f34807i.add(aVar);
    }

    public void a(boolean z) {
        this.f34806h = z;
    }

    public void a(boolean z, boolean z2) {
        this.f34804f = z;
        if (!z) {
            this.f34800b.a(0.0f, 0.0f);
            return;
        }
        this.f34800b.a(1.0f, 1.0f);
        if (z2) {
            b.a().a(true);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void a_() {
        c();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f34800b.b(dVar);
    }

    public void b(g.a aVar) {
        this.f34807i.remove(aVar);
    }

    public void c() {
        this.f34800b.f();
        if (this.f34804f && this.f34806h) {
            b.a().a(false);
            if (b.a().b()) {
                this.f34804f = false;
                a(false, false);
            }
        }
    }

    public void d() {
        this.f34800b.g();
    }

    @Override // com.kwad.sdk.core.i.c
    public void e() {
        d();
    }

    @MainThread
    public void f() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f34800b;
        if (aVar != null) {
            aVar.m();
            this.f34800b.h();
        }
        b.a().b(this.j);
    }

    public void g() {
        if (this.f34800b.a() == null) {
            h();
        }
        this.f34800b.e();
    }
}
