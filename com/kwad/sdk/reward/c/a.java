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
    public String f33826a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f33827b;

    /* renamed from: c  reason: collision with root package name */
    public long f33828c;

    /* renamed from: d  reason: collision with root package name */
    public long f33829d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f33830e;

    /* renamed from: f  reason: collision with root package name */
    public KsVideoPlayConfig f33831f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayerStatus f33832g;

    /* renamed from: h  reason: collision with root package name */
    public e f33833h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33834i;
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
        this.f33829d = -1L;
        this.f33831f = ksVideoPlayConfig;
        this.f33827b = adTemplate;
        this.f33832g = adTemplate.mVideoPlayerStatus;
        String a2 = com.kwad.sdk.core.response.b.a.a(c.g(adTemplate));
        this.f33828c = com.kwad.sdk.core.response.b.a.i(c.g(adTemplate));
        this.f33829d = adTemplate.mKsPlayerClickTimeParam;
        int i2 = com.kwad.sdk.core.config.c.i();
        if (i2 < 0) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a2);
            if (b2 != null && b2.exists()) {
                a2 = b2.getAbsolutePath();
            }
            this.f33830e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            k();
            e eVar = new e() { // from class: com.kwad.sdk.reward.c.a.2
                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i3, int i4) {
                    super.a(i3, i4);
                    com.kwad.sdk.core.report.e.a(adTemplate, i3, i4);
                }
            };
            this.f33833h = eVar;
            this.f33830e.a(eVar);
            this.f33830e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
                @Override // com.kwad.sdk.core.video.a.c.e
                public void a(com.kwad.sdk.core.video.a.c cVar) {
                    a.this.f33830e.e();
                }
            });
            b.a().a(this.k);
        } else if (i2 != 0) {
            a2 = com.kwad.sdk.core.videocache.c.a.a(detailVideoView.getContext()).a(a2);
        }
        this.f33826a = a2;
        this.f33830e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        k();
        e eVar2 = new e() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i3, int i4) {
                super.a(i3, i4);
                com.kwad.sdk.core.report.e.a(adTemplate, i3, i4);
            }
        };
        this.f33833h = eVar2;
        this.f33830e.a(eVar2);
        this.f33830e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                a.this.f33830e.e();
            }
        });
        b.a().a(this.k);
    }

    private void k() {
        this.f33830e.a(new c.a().a(this.f33826a).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f33827b))).a(this.f33832g).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f33828c, this.f33829d)).a());
        KsVideoPlayConfig ksVideoPlayConfig = this.f33831f;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f33830e.d();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a() {
        if (this.f33830e.a() == null) {
            k();
        }
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33830e.a(dVar);
    }

    public void a(g.a aVar) {
        this.j.add(aVar);
    }

    public void a(boolean z, boolean z2) {
        this.f33834i = z;
        if (!z) {
            this.f33830e.a(0.0f, 0.0f);
            return;
        }
        this.f33830e.a(1.0f, 1.0f);
        if (z2) {
            b.a().a(true);
        }
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b() {
        e();
        if (this.f33834i) {
            b.a().a(false);
            if (b.a().b()) {
                this.f33834i = false;
                a(false, false);
            }
        }
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f33830e.b(dVar);
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
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f33830e;
        if (aVar != null) {
            aVar.b(this.f33833h);
            this.f33830e.h();
        }
    }

    public void e() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f33830e.f();
    }

    public void f() {
        if (com.kwad.sdk.reward.e.a()) {
            return;
        }
        this.f33830e.g();
    }

    public void g() {
        this.f33830e.a(9);
        this.f33830e.h();
    }

    @MainThread
    public void h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f33830e;
        if (aVar != null) {
            aVar.m();
            this.f33830e.h();
        }
        b.a().b(this.k);
    }

    public int i() {
        return this.f33830e.i();
    }

    public int j() {
        return this.f33830e.j();
    }
}
