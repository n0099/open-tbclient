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
/* loaded from: classes5.dex */
public class a implements d {
    public Bitmap a;
    public String b;
    public com.kwad.sdk.contentalliance.detail.video.a c;
    public KsVideoPlayConfig d;
    public long e;
    public VideoPlayerStatus f;
    public boolean g;
    public AdTemplate h;
    public Context i;
    public DetailVideoView j;
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
        this.h = adTemplate;
        this.d = ksVideoPlayConfig;
        this.i = detailVideoView.getContext();
        String N = com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f = adTemplate.mVideoPlayerStatus;
        File b = com.kwad.sdk.core.diskcache.a.a.a().b(N);
        if (b != null && b.exists()) {
            this.b = b.getAbsolutePath();
        }
        this.j = detailVideoView;
        this.c = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.e = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.c.a(new c.e() { // from class: com.kwad.sdk.splashscreen.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                boolean a = bb.a(detailVideoView, 50, true);
                com.kwad.sdk.core.d.a.a("SplashPlayModule", " onPrepared" + a);
                if (a) {
                    a.this.c.e();
                }
            }
        });
        b.a(this.i).a(this.m);
    }

    private void k() {
        this.c.a(new c.a(this.h).a(this.f).a(this.b).b(f.b(com.kwad.sdk.core.response.a.d.k(this.h))).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.h)).a(), this.j);
        KsVideoPlayConfig ksVideoPlayConfig = this.d;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.c.d();
    }

    public TextureView a() {
        return this.j.a;
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.c.a(dVar);
    }

    public void a(j.a aVar) {
        this.l.add(aVar);
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(boolean z, boolean z2) {
        this.g = z;
        if (!z) {
            this.c.a(0.0f, 0.0f);
            return;
        }
        this.c.a(1.0f, 1.0f);
        if (z2) {
            b.a(this.i).a(true);
        }
    }

    public AdTemplate b() {
        return this.h;
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.c.b(dVar);
    }

    public void b(j.a aVar) {
        this.l.remove(aVar);
    }

    public long c() {
        return this.c.m();
    }

    public void d() {
        this.c.f();
        if (this.g && this.k) {
            b.a(this.i).a(false);
            if (b.a(this.i).a()) {
                this.g = false;
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
        this.c.g();
    }

    @MainThread
    public void h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.c;
        if (aVar != null) {
            aVar.n();
            this.c.h();
        }
        b.a(this.i).b(this.m);
    }

    @MainThread
    public void i() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.c;
        if (aVar != null) {
            aVar.n();
            this.c.g();
        }
    }

    public void j() {
        if (this.c.a() == null) {
            k();
        }
        this.c.e();
    }
}
