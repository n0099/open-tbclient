package com.kwad.sdk.splashscreen.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements d {
    public Bitmap a;

    /* renamed from: b  reason: collision with root package name */
    public String f57842b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f57843c;

    /* renamed from: d  reason: collision with root package name */
    public KsVideoPlayConfig f57844d;

    /* renamed from: e  reason: collision with root package name */
    public long f57845e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f57846f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57847g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f57848h;

    /* renamed from: i  reason: collision with root package name */
    public Context f57849i;

    /* renamed from: j  reason: collision with root package name */
    public DetailVideoView f57850j;
    public boolean k;
    public final List<j.a> l = new ArrayList();
    public j.a m = new j.a() { // from class: com.kwad.sdk.splashscreen.b.a.1
        @Override // com.kwad.sdk.utils.j.a
        public void a() {
            synchronized (a.this.l) {
                for (j.a aVar : a.this.l) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.j.a
        public void b() {
            synchronized (a.this.l) {
                for (j.a aVar : a.this.l) {
                    aVar.b();
                }
            }
        }
    };
    public long n = -1;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.f57848h = adTemplate;
        this.f57844d = ksVideoPlayConfig;
        this.f57849i = detailVideoView.getContext();
        String N = com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f57846f = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(N);
        if (b2 != null && b2.exists()) {
            this.f57842b = b2.getAbsolutePath();
        }
        this.f57850j = detailVideoView;
        this.f57843c = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f57845e = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f57843c.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                boolean a = bb.a(detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a);
                if (a) {
                    a.this.f57843c.e();
                }
            }
        });
        b.a(this.f57849i).a(this.m);
    }

    private void k() {
        this.f57843c.a(new c.a(this.f57848h).a(this.f57846f).a(this.f57842b).b(f.b(com.kwad.sdk.core.response.a.d.k(this.f57848h))).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f57848h)).a(), this.f57850j);
        KsVideoPlayConfig ksVideoPlayConfig = this.f57844d;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f57843c.d();
    }

    public TextureView a() {
        return this.f57850j.a;
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f57843c.a(dVar);
    }

    public void a(j.a aVar) {
        this.l.add(aVar);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(boolean z, boolean z2) {
        this.f57847g = z;
        if (!z) {
            this.f57843c.a(0.0f, 0.0f);
            return;
        }
        this.f57843c.a(1.0f, 1.0f);
        if (z2) {
            b.a(this.f57849i).a(true);
        }
    }

    public AdTemplate b() {
        return this.f57848h;
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f57843c.b(dVar);
    }

    public void b(j.a aVar) {
        this.l.remove(aVar);
    }

    public long c() {
        return this.f57843c.m();
    }

    public void d() {
        this.f57843c.f();
        if (this.f57847g && this.k) {
            b.a(this.f57849i).a(false);
            if (b.a(this.f57849i).a()) {
                this.f57847g = false;
                a(false, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        d();
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        g();
    }

    public void g() {
        this.f57843c.g();
    }

    @MainThread
    public void h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f57843c;
        if (aVar != null) {
            aVar.n();
            this.f57843c.h();
        }
        b.a(this.f57849i).b(this.m);
    }

    @MainThread
    public void i() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f57843c;
        if (aVar != null) {
            aVar.n();
            this.f57843c.g();
        }
    }

    public void j() {
        if (this.f57843c.a() == null) {
            k();
        }
        this.f57843c.e();
    }
}
