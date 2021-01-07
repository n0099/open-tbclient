package com.kwad.sdk.reward.c;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements com.kwad.sdk.reward.a.a {

    /* renamed from: a  reason: collision with root package name */
    private String f10944a;

    /* renamed from: b  reason: collision with root package name */
    private long f10945b;
    private long c;
    private com.kwad.sdk.contentalliance.detail.video.a d;
    private KsVideoPlayConfig e;
    private VideoPlayerStatus f;
    private f g;
    private boolean h;
    private final List<g.a> i = new ArrayList();
    private g.a j = new g.a() { // from class: com.kwad.sdk.reward.c.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.i) {
                for (g.a aVar : a.this.i) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.i) {
                for (g.a aVar : a.this.i) {
                    aVar.b();
                }
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.c = -1L;
        this.e = ksVideoPlayConfig;
        this.f = adTemplate.mVideoPlayerStatus;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.j(adTemplate));
        this.f10945b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.c = adTemplate.mKsPlayerClickTimeParam;
        int v = com.kwad.sdk.core.config.c.v();
        if (v < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                this.f10944a = b2.getAbsolutePath();
            }
        } else if (v == 0) {
            this.f10944a = a2;
        } else {
            this.f10944a = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        k();
        this.g = new f() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i, int i2) {
                super.a(i, i2);
                e.b(adTemplate, i, i2);
            }
        };
        this.d.a(this.g);
        this.d.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.d.f();
            }
        });
        b.a().a(this.j);
    }

    private void k() {
        this.d.a(new d.a().a(this.f10944a).a(this.f).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f10945b, this.c)).a());
        if (this.e != null) {
            a(this.e.isVideoSoundEnable(), false);
        }
        this.d.e();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        if (this.d.a() == null) {
            k();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.d.a(eVar);
    }

    public void a(g.a aVar) {
        this.i.add(aVar);
    }

    public void a(boolean z, boolean z2) {
        this.h = z;
        if (!z) {
            this.d.a(0.0f, 0.0f);
            return;
        }
        this.d.a(1.0f, 1.0f);
        if (z2) {
            b.a().a(true);
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        e();
        if (this.h) {
            b.a().a(false);
            if (b.a().b()) {
                this.h = false;
                a(this.h, false);
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.d.b(eVar);
    }

    public void b(g.a aVar) {
        this.i.remove(aVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c() {
        f();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d() {
        if (this.d != null) {
            this.d.b(this.g);
            this.d.k();
        }
    }

    public void e() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.d.h();
    }

    public void f() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.d.j();
    }

    public void g() {
        this.d.a(9);
        this.d.k();
    }

    @MainThread
    public void h() {
        if (this.d != null) {
            this.d.p();
            this.d.k();
        }
        b.a().b(this.j);
    }

    public int i() {
        return this.d.l();
    }

    public int j() {
        return this.d.m();
    }
}
