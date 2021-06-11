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
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.reward.a.a {

    /* renamed from: a  reason: collision with root package name */
    public String f37188a;

    /* renamed from: b  reason: collision with root package name */
    public long f37189b;

    /* renamed from: c  reason: collision with root package name */
    public long f37190c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f37191d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f37192e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPlayerStatus f37193f;

    /* renamed from: g  reason: collision with root package name */
    public f f37194g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37195h;

    /* renamed from: i  reason: collision with root package name */
    public final List<g.a> f37196i = new ArrayList();
    public g.a j = new g.a() { // from class: com.kwad.sdk.reward.c.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.f37196i) {
                for (g.a aVar : a.this.f37196i) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.f37196i) {
                for (g.a aVar : a.this.f37196i) {
                    aVar.b();
                }
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.f37190c = -1L;
        this.f37192e = ksVideoPlayConfig;
        this.f37193f = adTemplate.mVideoPlayerStatus;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.j(adTemplate));
        this.f37189b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f37190c = adTemplate.mKsPlayerClickTimeParam;
        int v = com.kwad.sdk.core.config.c.v();
        if (v < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                a2 = b2.getAbsolutePath();
            }
            this.f37191d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            k();
            f fVar = new f() { // from class: com.kwad.sdk.reward.c.a.2
                @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
                public void a(int i2, int i3) {
                    super.a(i2, i3);
                    e.b(adTemplate, i2, i3);
                }
            };
            this.f37194g = fVar;
            this.f37191d.a(fVar);
            this.f37191d.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
                @Override // com.kwad.sdk.core.video.a.c.e
                public void a(com.kwad.sdk.core.video.a.c cVar) {
                    a.this.f37191d.f();
                }
            });
            b.a().a(this.j);
        } else if (v != 0) {
            a2 = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.f37188a = a2;
        this.f37191d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        k();
        f fVar2 = new f() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i2, int i3) {
                super.a(i2, i3);
                e.b(adTemplate, i2, i3);
            }
        };
        this.f37194g = fVar2;
        this.f37191d.a(fVar2);
        this.f37191d.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.f37191d.f();
            }
        });
        b.a().a(this.j);
    }

    private void k() {
        this.f37191d.a(new d.a().a(this.f37188a).a(this.f37193f).a(new com.kwad.sdk.contentalliance.detail.video.c(this.f37189b, this.f37190c)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f37192e;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f37191d.e();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        if (this.f37191d.a() == null) {
            k();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f37191d.a(eVar);
    }

    public void a(g.a aVar) {
        this.f37196i.add(aVar);
    }

    public void a(boolean z, boolean z2) {
        this.f37195h = z;
        if (!z) {
            this.f37191d.a(0.0f, 0.0f);
            return;
        }
        this.f37191d.a(1.0f, 1.0f);
        if (z2) {
            b.a().a(true);
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        e();
        if (this.f37195h) {
            b.a().a(false);
            if (b.a().b()) {
                this.f37195h = false;
                a(false, false);
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f37191d.b(eVar);
    }

    public void b(g.a aVar) {
        this.f37196i.remove(aVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c() {
        f();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f37191d;
        if (aVar != null) {
            aVar.b(this.f37194g);
            this.f37191d.k();
        }
    }

    public void e() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f37191d.h();
    }

    public void f() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f37191d.j();
    }

    public void g() {
        this.f37191d.a(9);
        this.f37191d.k();
    }

    @MainThread
    public void h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f37191d;
        if (aVar != null) {
            aVar.p();
            this.f37191d.k();
        }
        b.a().b(this.j);
    }

    public int i() {
        return this.f37191d.l();
    }

    public int j() {
        return this.f37191d.m();
    }
}
