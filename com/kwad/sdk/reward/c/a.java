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
    public AdTemplate f59467b;

    /* renamed from: c  reason: collision with root package name */
    public long f59468c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f59469d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f59470e;

    /* renamed from: f  reason: collision with root package name */
    public KsVideoPlayConfig f59471f;

    /* renamed from: g  reason: collision with root package name */
    public VideoPlayerStatus f59472g;

    /* renamed from: h  reason: collision with root package name */
    public e f59473h;

    /* renamed from: i  reason: collision with root package name */
    public Context f59474i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59475j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59476k;
    public boolean l;
    public final List<j.a> m;
    public j.a n;

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this(adTemplate, detailVideoView, ksVideoPlayConfig, false);
        this.f59474i = detailVideoView.getContext();
    }

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig, boolean z) {
        this.f59476k = false;
        this.l = false;
        this.m = new ArrayList();
        this.n = new j.a() { // from class: com.kwad.sdk.reward.c.a.1
            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                a.this.l = true;
                if (a.this.f59470e != null) {
                    a.this.f59470e.a(false);
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
        this.f59471f = ksVideoPlayConfig;
        this.f59467b = adTemplate;
        this.f59474i = detailVideoView.getContext();
        this.f59472g = adTemplate.mVideoPlayerStatus;
        this.f59476k = z;
        String a = com.kwad.sdk.core.response.a.a.a(d.j(adTemplate));
        this.f59468c = com.kwad.sdk.core.response.a.a.l(d.j(adTemplate));
        int C = b.C();
        if (C < 0) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(a);
            if (b2 != null && b2.exists()) {
                a = b2.getAbsolutePath();
            }
            this.f59469d = detailVideoView;
            this.f59470e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
            i();
            e eVar = new e() { // from class: com.kwad.sdk.reward.c.a.2
                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    super.a(i2, i3);
                    com.kwad.sdk.core.report.d.b(adTemplate, i2, i3);
                }
            };
            this.f59473h = eVar;
            this.f59470e.a(eVar);
            this.f59470e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
                @Override // com.kwad.sdk.core.video.kwai.c.e
                public void a(c cVar) {
                    a.this.f59470e.e();
                }
            });
            com.kwad.sdk.utils.b.a(this.f59474i).a(this.n);
        } else if (C != 0) {
            a = com.kwad.sdk.core.videocache.b.a.a(detailVideoView.getContext()).a(a);
        }
        this.a = a;
        this.f59469d = detailVideoView;
        this.f59470e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        i();
        e eVar2 = new e() { // from class: com.kwad.sdk.reward.c.a.2
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i2, int i3) {
                super.a(i2, i3);
                com.kwad.sdk.core.report.d.b(adTemplate, i2, i3);
            }
        };
        this.f59473h = eVar2;
        this.f59470e.a(eVar2);
        this.f59470e.a(new c.e() { // from class: com.kwad.sdk.reward.c.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                a.this.f59470e.e();
            }
        });
        com.kwad.sdk.utils.b.a(this.f59474i).a(this.n);
    }

    private void i() {
        this.f59470e.a(new c.a(this.f59467b).a(this.a).b(f.b(d.k(this.f59467b))).a(this.f59472g).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f59467b)).a(), this.f59469d);
        KsVideoPlayConfig ksVideoPlayConfig = this.f59471f;
        if (ksVideoPlayConfig != null) {
            a(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f59470e.d();
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f59470e.a(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void a(com.kwad.sdk.core.e.a aVar) {
        this.l = false;
        if (this.f59470e.a() == null) {
            i();
        }
    }

    public void a(j.a aVar) {
        this.m.add(aVar);
    }

    public void a(boolean z) {
        long k2 = this.f59470e.k();
        if (z) {
            this.f59470e.a(9);
        } else {
            this.f59470e.a(k2);
        }
        if (z) {
            this.f59470e.h();
        }
    }

    public void a(boolean z, boolean z2) {
        this.f59475j = z;
        if (!z) {
            this.f59470e.a(0.0f, 0.0f);
            return;
        }
        this.f59470e.a(1.0f, 1.0f);
        if (z2) {
            com.kwad.sdk.utils.b.a(this.f59474i).a(true);
        }
    }

    public boolean a() {
        return this.f59476k;
    }

    public void b() {
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f59470e.f();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f59470e.b(dVar);
    }

    @Override // com.kwad.sdk.reward.a.a
    public void b(com.kwad.sdk.core.e.a aVar) {
        if (((aVar instanceof KSRewardVideoActivityProxy) && ((KSRewardVideoActivityProxy) aVar).isRefluxVisible()) ? false : true) {
            b();
        }
        if (this.f59475j || (b.F() && this.l)) {
            com.kwad.sdk.utils.b.a(this.f59474i).a(b.F());
            if (b.F() && this.l) {
                this.l = false;
                this.f59475j = true;
                a(true, false);
            } else if (this.f59476k || !com.kwad.sdk.utils.b.a(this.f59474i).a()) {
            } else {
                this.f59475j = false;
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
        AdTemplate adTemplate = this.f59467b;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.f59470e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void c(com.kwad.sdk.core.e.a aVar) {
        c();
    }

    public void d() {
        if (com.kwad.sdk.reward.j.a()) {
            return;
        }
        this.f59470e.g();
    }

    @Override // com.kwad.sdk.reward.a.a
    public void d(com.kwad.sdk.core.e.a aVar) {
        this.l = false;
        com.kwad.sdk.contentalliance.detail.video.a aVar2 = this.f59470e;
        if (aVar2 != null) {
            aVar2.b(this.f59473h);
            this.f59470e.h();
        }
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f59470e;
        if (aVar != null) {
            aVar.n();
            this.f59470e.h();
        }
        com.kwad.sdk.utils.b.a(this.f59474i).b(this.n);
    }

    public int f() {
        return this.f59470e.i();
    }

    public int g() {
        return this.f59470e.j();
    }

    public long h() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f59470e;
        if (aVar != null) {
            return aVar.l();
        }
        return 0L;
    }
}
