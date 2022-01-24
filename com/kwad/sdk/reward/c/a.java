package com.kwad.sdk.reward.c;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.reward.a.a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57263b;

    /* renamed from: c  reason: collision with root package name */
    public long f57264c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f57265d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f57266e;

    /* renamed from: f  reason: collision with root package name */
    public KsVideoPlayConfig f57267f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayerStatus f57268g;

    /* renamed from: h  reason: collision with root package name */
    public e f57269h;

    /* renamed from: i  reason: collision with root package name */
    public Context f57270i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57271j;
    public boolean k;
    public boolean l;
    public final List<j.a> m;
    public j.a n;

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this(adTemplate, detailVideoView, ksVideoPlayConfig, false);
        this.f57270i = detailVideoView.getContext();
    }

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig, boolean z) {
        this.k = false;
        this.l = false;
        this.m = new ArrayList();
        this.n = new j.a() { // from class: com.kwad.sdk.reward.c.a.1
            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                a.this.l = true;
                if (a.this.f57266e != null) {
                    a.this.f57266e.a(false);
                }
                synchronized (a.this.m) {
                    for (j.a aVar : a.this.m) {
                        aVar.a();
                    }
                }
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                synchronized (a.this.m) {
                    for (j.a aVar : a.this.m) {
                        aVar.b();
                    }
                }
            }
        };
        this.f57267f = ksVideoPlayConfig;
        this.f57263b = adTemplate;
        this.f57270i = detailVideoView.getContext();
        this.f57268g = adTemplate.mVideoPlayerStatus;
        this.k = z;
        String a = com.kwad.sdk.core.response.a.a.a(d.j(adTemplate));
        this.f57264c = com.kwad.sdk.core.response.a.a.l(d.j(adTemplate));
        int C = b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a);
            if (b2 != null && b2.exists()) {
                a = b2.getAbsolutePath();
            }
            this.f57265d = detailVideoView;
            this.f57266e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            i();
            e eVar = new e() { // from class: com.kwad.sdk.reward.c.a.2
                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    super.a(i2, i3);
                    com.kwad.sdk.core.report.d.b(adTemplate, i2, i3);
                }
            };
            this.f57269h = eVar;
            this.f57266e.a(eVar);
            this.f57266e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
                @Override // com.kwad.sdk.core.video.kwai.c.e
                public void a(c cVar) {
                    a.this.f57266e.e();
                }
            });
            com.kwad.sdk.utils.b.a(this.f57270i).a(this.n);
        } else if (C != 0) {
            a = com.kwad.sdk.core.videocache.b.a.a(detailVideoView.getContext()).a(a);
        }
        this.a = a;
        this.f57265d = detailVideoView;
        this.f57266e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        i();
        e eVar2 = new e() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i2, int i3) {
                super.a(i2, i3);
                com.kwad.sdk.core.report.d.b(adTemplate, i2, i3);
            }
        };
        this.f57269h = eVar2;
        this.f57266e.a(eVar2);
        this.f57266e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.f57266e.e();
            }
        });
        com.kwad.sdk.utils.b.a(this.f57270i).a(this.n);
    }

    private void i() {
        this.f57266e.a(new c.a(this.f57263b).a(this.a).b(f.b(d.k(this.f57263b))).a(this.f57268g).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f57263b)).a(), this.f57265d);
        KsVideoPlayConfig ksVideoPlayConfig = this.f57267f;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f57266e.d();
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f57266e.a(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a(com.kwad.sdk.core.e.a aVar) {
        this.l = false;
        if (this.f57266e.a() == null) {
            i();
        }
    }

    public void a(j.a aVar) {
        this.m.add(aVar);
    }

    public void a(boolean z) {
        long k = this.f57266e.k();
        if (z) {
            this.f57266e.a(9);
        } else {
            this.f57266e.a(k);
        }
        if (z) {
            this.f57266e.h();
        }
    }

    public void a(boolean z, boolean z2) {
        this.f57271j = z;
        if (!z) {
            this.f57266e.a(0.0f, 0.0f);
            return;
        }
        this.f57266e.a(1.0f, 1.0f);
        if (z2) {
            com.kwad.sdk.utils.b.a(this.f57270i).a(true);
        }
    }

    public boolean a() {
        return this.k;
    }

    public void b() {
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f57266e.f();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f57266e.b(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b(com.kwad.sdk.core.e.a aVar) {
        if (((aVar instanceof KSRewardVideoActivityProxy) && ((KSRewardVideoActivityProxy) aVar).isRefluxVisible()) ? false : true) {
            b();
        }
        if (this.f57271j || (b.F() && this.l)) {
            com.kwad.sdk.utils.b.a(this.f57270i).a(b.F());
            if (b.F() && this.l) {
                this.l = false;
                this.f57271j = true;
                a(true, false);
            } else if (this.k || !com.kwad.sdk.utils.b.a(this.f57270i).a()) {
            } else {
                this.f57271j = false;
                a(false, false);
            }
        }
    }

    public void b(j.a aVar) {
        this.m.remove(aVar);
    }

    public void c() {
        SceneImpl sceneImpl;
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        AdTemplate adTemplate = this.f57263b;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.f57266e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c(com.kwad.sdk.core.e.a aVar) {
        c();
    }

    public void d() {
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f57266e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d(com.kwad.sdk.core.e.a aVar) {
        this.l = false;
        com.kwad.sdk.contentalliance.detail.video.a aVar2 = this.f57266e;
        if (aVar2 != null) {
            aVar2.b(this.f57269h);
            this.f57266e.h();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f57266e;
        if (aVar != null) {
            aVar.n();
            this.f57266e.h();
        }
        com.kwad.sdk.utils.b.a(this.f57270i).b(this.n);
    }

    public int f() {
        return this.f57266e.i();
    }

    public int g() {
        return this.f57266e.j();
    }

    public long h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f57266e;
        if (aVar != null) {
            return aVar.l();
        }
        return 0L;
    }
}
