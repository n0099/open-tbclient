package com.kwad.sdk.reward.c;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.b;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.reward.a.a {

    /* renamed from: a  reason: collision with root package name */
    public String f33755a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f33756b;

    /* renamed from: c  reason: collision with root package name */
    public long f33757c;

    /* renamed from: d  reason: collision with root package name */
    public long f33758d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f33759e;

    /* renamed from: f  reason: collision with root package name */
    public KsVideoPlayConfig f33760f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayerStatus f33761g;

    /* renamed from: h  reason: collision with root package name */
    public e f33762h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33763i;
    public final List<g.a> j = new ArrayList();
    public g.a k = new g.a() { // from class: com.kwad.sdk.reward.c.a.1
        @Override // com.kwad.sdk.utils.g.a
        public void a() {
            synchronized (a.this.j) {
                for (g.a aVar : a.this.j) {
                    aVar.a();
                }
            }
        }

        @Override // com.kwad.sdk.utils.g.a
        public void b() {
            synchronized (a.this.j) {
                for (g.a aVar : a.this.j) {
                    aVar.b();
                }
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.f33758d = -1L;
        this.f33760f = ksVideoPlayConfig;
        this.f33756b = adTemplate;
        this.f33761g = adTemplate.mVideoPlayerStatus;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.g(adTemplate));
        this.f33757c = com.kwad.sdk.core.response.b.a.i(c.g(adTemplate));
        this.f33758d = adTemplate.mKsPlayerClickTimeParam;
        int i2 = com.kwad.sdk.core.config.c.i();
        if (i2 < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                a2 = b2.getAbsolutePath();
            }
            this.f33759e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            k();
            e eVar = new e() { // from class: com.kwad.sdk.reward.c.a.2
                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i3, int i4) {
                    super.a(i3, i4);
                    com.kwad.sdk.core.report.e.a(adTemplate, i3, i4);
                }
            };
            this.f33762h = eVar;
            this.f33759e.a(eVar);
            this.f33759e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
                @Override // com.kwad.sdk.core.video.a.c.e
                public void a(com.kwad.sdk.core.video.a.c cVar) {
                    a.this.f33759e.e();
                }
            });
            b.a().a(this.k);
        } else if (i2 != 0) {
            a2 = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.f33755a = a2;
        this.f33759e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        k();
        e eVar2 = new e() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i3, int i4) {
                super.a(i3, i4);
                com.kwad.sdk.core.report.e.a(adTemplate, i3, i4);
            }
        };
        this.f33762h = eVar2;
        this.f33759e.a(eVar2);
        this.f33759e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.f33759e.e();
            }
        });
        b.a().a(this.k);
    }

    private void k() {
        this.f33759e.a(new c.a().a(this.f33755a).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f33756b))).a(this.f33761g).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f33757c, this.f33758d)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f33760f;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f33759e.d();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        if (this.f33759e.a() == null) {
            k();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33759e.a(dVar);
    }

    public void a(g.a aVar) {
        this.j.add(aVar);
    }

    public void a(boolean z, boolean z2) {
        this.f33763i = z;
        if (!z) {
            this.f33759e.a(0.0f, 0.0f);
            return;
        }
        this.f33759e.a(1.0f, 1.0f);
        if (z2) {
            b.a().a(true);
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        e();
        if (this.f33763i) {
            b.a().a(false);
            if (b.a().b()) {
                this.f33763i = false;
                a(false, false);
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33759e.b(dVar);
    }

    public void b(g.a aVar) {
        this.j.remove(aVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c() {
        f();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f33759e;
        if (aVar != null) {
            aVar.b(this.f33762h);
            this.f33759e.h();
        }
    }

    public void e() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f33759e.f();
    }

    public void f() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f33759e.g();
    }

    public void g() {
        this.f33759e.a(9);
        this.f33759e.h();
    }

    @MainThread
    public void h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f33759e;
        if (aVar != null) {
            aVar.m();
            this.f33759e.h();
        }
        b.a().b(this.k);
    }

    public int i() {
        return this.f33759e.i();
    }

    public int j() {
        return this.f33759e.j();
    }
}
