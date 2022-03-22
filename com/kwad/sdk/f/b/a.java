package com.kwad.sdk.f.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.m;
/* loaded from: classes7.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f40459b;

    /* renamed from: c  reason: collision with root package name */
    public f f40460c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f40461d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f40462e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40463f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40464g;

    /* renamed from: h  reason: collision with root package name */
    public Context f40465h;
    public e i;
    public boolean j;
    public final d k = new d() { // from class: com.kwad.sdk.f.b.a.3
        @Override // com.kwad.sdk.core.j.d
        public void e() {
            a.this.c();
        }

        @Override // com.kwad.sdk.core.j.d
        public void f() {
            a.this.d();
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull f fVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        boolean z = false;
        this.j = false;
        this.a = adTemplate;
        this.f40459b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f40460c = fVar;
        this.f40463f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f40464g = z;
        this.f40465h = detailVideoView.getContext();
        this.f40461d = detailVideoView;
        this.f40462e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.j = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        e eVar = new e() { // from class: com.kwad.sdk.f.b.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i, int i2) {
                super.a(i, i2);
                com.kwad.sdk.core.report.d.b(adTemplate, i, i2);
            }
        };
        this.i = eVar;
        this.f40462e.a(eVar);
        g();
        this.f40462e.a(new c.e() { // from class: com.kwad.sdk.f.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                if (a.this.h() && a.this.f40460c.c()) {
                    a.this.f40462e.a(b.a(a.this.a));
                    a.this.f40462e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f40462e;
            f2 = 1.0f;
        } else {
            aVar = this.f40462e;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f40462e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.j).a(b.a(this.a)).a(), true, true, this.f40461d);
        a(this.f40463f);
        if (h()) {
            this.f40462e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f40464g) {
            this.f40464g = com.ksad.download.c.b.b(this.f40465h);
        }
        return this.f40464g;
    }

    public void a() {
        m.c(this.a);
        if (this.f40462e.a() == null) {
            g();
        }
        if (h() && this.f40460c.c()) {
            this.f40462e.a(b.a(this.a));
            this.f40462e.e();
        }
        this.f40460c.a(this.k);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f40462e.a(dVar);
    }

    public void b() {
        m.a(this.a);
        this.f40460c.b(this.k);
        this.f40462e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f40462e.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f40463f) {
                com.kwad.sdk.utils.b.a(this.f40465h).a(false);
                if (com.kwad.sdk.utils.b.a(this.f40465h).a()) {
                    this.f40463f = false;
                    a(false);
                }
            }
            this.f40462e.f();
        }
    }

    public void d() {
        this.f40462e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f40462e;
        if (aVar != null) {
            aVar.n();
            this.f40462e.h();
        }
    }

    public void f() {
        this.f40464g = true;
        if (this.f40460c.c()) {
            m.b(this.a);
            this.f40462e.a(b.a(this.a));
            this.f40462e.e();
        }
    }
}
