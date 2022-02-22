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
/* loaded from: classes4.dex */
public class a implements d {
    public Bitmap a;

    /* renamed from: b  reason: collision with root package name */
    public String f58054b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f58055c;

    /* renamed from: d  reason: collision with root package name */
    public KsVideoPlayConfig f58056d;

    /* renamed from: e  reason: collision with root package name */
    public long f58057e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f58058f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58059g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f58060h;

    /* renamed from: i  reason: collision with root package name */
    public Context f58061i;

    /* renamed from: j  reason: collision with root package name */
    public DetailVideoView f58062j;
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
        this.f58060h = adTemplate;
        this.f58056d = ksVideoPlayConfig;
        this.f58061i = detailVideoView.getContext();
        String N = com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f58058f = adTemplate.mVideoPlayerStatus;
        File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(N);
        if (b2 != null && b2.exists()) {
            this.f58054b = b2.getAbsolutePath();
        }
        this.f58062j = detailVideoView;
        this.f58055c = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.f58057e = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f58055c.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                boolean a = bb.a(detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a);
                if (a) {
                    a.this.f58055c.e();
                }
            }
        });
        b.a(this.f58061i).a(this.m);
    }

    private void k() {
        this.f58055c.a(new c.a(this.f58060h).a(this.f58058f).a(this.f58054b).b(f.b(com.kwad.sdk.core.response.a.d.k(this.f58060h))).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f58060h)).a(), this.f58062j);
        KsVideoPlayConfig ksVideoPlayConfig = this.f58056d;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f58055c.d();
    }

    public TextureView a() {
        return this.f58062j.a;
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f58055c.a(dVar);
    }

    public void a(j.a aVar) {
        this.l.add(aVar);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(boolean z, boolean z2) {
        this.f58059g = z;
        if (!z) {
            this.f58055c.a(0.0f, 0.0f);
            return;
        }
        this.f58055c.a(1.0f, 1.0f);
        if (z2) {
            b.a(this.f58061i).a(true);
        }
    }

    public AdTemplate b() {
        return this.f58060h;
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f58055c.b(dVar);
    }

    public void b(j.a aVar) {
        this.l.remove(aVar);
    }

    public long c() {
        return this.f58055c.m();
    }

    public void d() {
        this.f58055c.f();
        if (this.f58059g && this.k) {
            b.a(this.f58061i).a(false);
            if (b.a(this.f58061i).a()) {
                this.f58059g = false;
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
        this.f58055c.g();
    }

    @MainThread
    public void h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f58055c;
        if (aVar != null) {
            aVar.n();
            this.f58055c.h();
        }
        b.a(this.f58061i).b(this.m);
    }

    @MainThread
    public void i() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f58055c;
        if (aVar != null) {
            aVar.n();
            this.f58055c.g();
        }
    }

    public void j() {
        if (this.f58055c.a() == null) {
            k();
        }
        this.f58055c.e();
    }
}
