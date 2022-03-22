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
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.reward.a.a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40756b;

    /* renamed from: c  reason: collision with root package name */
    public long f40757c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f40758d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f40759e;

    /* renamed from: f  reason: collision with root package name */
    public KsVideoPlayConfig f40760f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayerStatus f40761g;

    /* renamed from: h  reason: collision with root package name */
    public e f40762h;
    public Context i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final List<j.a> m;
    public j.a n;

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this(adTemplate, detailVideoView, ksVideoPlayConfig, false);
        this.i = detailVideoView.getContext();
    }

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig, boolean z) {
        this.k = false;
        this.l = false;
        this.m = new ArrayList();
        this.n = new j.a() { // from class: com.kwad.sdk.reward.c.a.1
            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                a.this.l = true;
                if (a.this.f40759e != null) {
                    a.this.f40759e.a(false);
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
        this.f40760f = ksVideoPlayConfig;
        this.f40756b = adTemplate;
        this.i = detailVideoView.getContext();
        this.f40761g = adTemplate.mVideoPlayerStatus;
        this.k = z;
        String a = com.kwad.sdk.core.response.a.a.a(d.j(adTemplate));
        this.f40757c = com.kwad.sdk.core.response.a.a.l(d.j(adTemplate));
        int C = b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a);
            if (b2 != null && b2.exists()) {
                a = b2.getAbsolutePath();
            }
            this.f40758d = detailVideoView;
            this.f40759e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            i();
            e eVar = new e() { // from class: com.kwad.sdk.reward.c.a.2
                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i, int i2) {
                    super.a(i, i2);
                    com.kwad.sdk.core.report.d.b(adTemplate, i, i2);
                }
            };
            this.f40762h = eVar;
            this.f40759e.a(eVar);
            this.f40759e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
                @Override // com.kwad.sdk.core.video.kwai.c.e
                public void a(c cVar) {
                    a.this.f40759e.e();
                }
            });
            com.kwad.sdk.utils.b.a(this.i).a(this.n);
        } else if (C != 0) {
            a = com.kwad.sdk.core.videocache.b.a.a(detailVideoView.getContext()).a(a);
        }
        this.a = a;
        this.f40758d = detailVideoView;
        this.f40759e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        i();
        e eVar2 = new e() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i, int i2) {
                super.a(i, i2);
                com.kwad.sdk.core.report.d.b(adTemplate, i, i2);
            }
        };
        this.f40762h = eVar2;
        this.f40759e.a(eVar2);
        this.f40759e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.f40759e.e();
            }
        });
        com.kwad.sdk.utils.b.a(this.i).a(this.n);
    }

    private void i() {
        this.f40759e.a(new c.a(this.f40756b).a(this.a).b(f.b(d.k(this.f40756b))).a(this.f40761g).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f40756b)).a(), this.f40758d);
        KsVideoPlayConfig ksVideoPlayConfig = this.f40760f;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f40759e.d();
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f40759e.a(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a(com.kwad.sdk.core.e.a aVar) {
        this.l = false;
        if (this.f40759e.a() == null) {
            i();
        }
    }

    public void a(j.a aVar) {
        this.m.add(aVar);
    }

    public void a(boolean z) {
        long k = this.f40759e.k();
        if (z) {
            this.f40759e.a(9);
        } else {
            this.f40759e.a(k);
        }
        if (z) {
            this.f40759e.h();
        }
    }

    public void a(boolean z, boolean z2) {
        this.j = z;
        if (!z) {
            this.f40759e.a(0.0f, 0.0f);
            return;
        }
        this.f40759e.a(1.0f, 1.0f);
        if (z2) {
            com.kwad.sdk.utils.b.a(this.i).a(true);
        }
    }

    public boolean a() {
        return this.k;
    }

    public void b() {
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f40759e.f();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f40759e.b(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b(com.kwad.sdk.core.e.a aVar) {
        if (((aVar instanceof KSRewardVideoActivityProxy) && ((KSRewardVideoActivityProxy) aVar).isRefluxVisible()) ? false : true) {
            b();
        }
        if (this.j || (b.F() && this.l)) {
            com.kwad.sdk.utils.b.a(this.i).a(b.F());
            if (b.F() && this.l) {
                this.l = false;
                this.j = true;
                a(true, false);
            } else if (this.k || !com.kwad.sdk.utils.b.a(this.i).a()) {
            } else {
                this.j = false;
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
        AdTemplate adTemplate = this.f40756b;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.f40759e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c(com.kwad.sdk.core.e.a aVar) {
        c();
    }

    public void d() {
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f40759e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d(com.kwad.sdk.core.e.a aVar) {
        this.l = false;
        com.kwad.sdk.contentalliance.detail.video.a aVar2 = this.f40759e;
        if (aVar2 != null) {
            aVar2.b(this.f40762h);
            this.f40759e.h();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f40759e;
        if (aVar != null) {
            aVar.n();
            this.f40759e.h();
        }
        com.kwad.sdk.utils.b.a(this.i).b(this.n);
    }

    public int f() {
        return this.f40759e.i();
    }

    public int g() {
        return this.f40759e.j();
    }

    public long h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f40759e;
        if (aVar != null) {
            return aVar.l();
        }
        return 0L;
    }
}
