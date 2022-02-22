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
/* loaded from: classes4.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f57059b;

    /* renamed from: c  reason: collision with root package name */
    public f f57060c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f57061d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f57062e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57063f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57064g;

    /* renamed from: h  reason: collision with root package name */
    public Context f57065h;

    /* renamed from: i  reason: collision with root package name */
    public e f57066i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57067j;
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
        this.f57067j = false;
        this.a = adTemplate;
        this.f57059b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f57060c = fVar;
        this.f57063f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f57064g = z;
        this.f57065h = detailVideoView.getContext();
        this.f57061d = detailVideoView;
        this.f57062e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f57067j = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        e eVar = new e() { // from class: com.kwad.sdk.f.b.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i2, int i3) {
                super.a(i2, i3);
                com.kwad.sdk.core.report.d.b(adTemplate, i2, i3);
            }
        };
        this.f57066i = eVar;
        this.f57062e.a(eVar);
        g();
        this.f57062e.a(new c.e() { // from class: com.kwad.sdk.f.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                if (a.this.h() && a.this.f57060c.c()) {
                    a.this.f57062e.a(b.a(a.this.a));
                    a.this.f57062e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f57062e;
            f2 = 1.0f;
        } else {
            aVar = this.f57062e;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f57062e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.f57067j).a(b.a(this.a)).a(), true, true, this.f57061d);
        a(this.f57063f);
        if (h()) {
            this.f57062e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f57064g) {
            this.f57064g = com.ksad.download.c.b.b(this.f57065h);
        }
        return this.f57064g;
    }

    public void a() {
        m.c(this.a);
        if (this.f57062e.a() == null) {
            g();
        }
        if (h() && this.f57060c.c()) {
            this.f57062e.a(b.a(this.a));
            this.f57062e.e();
        }
        this.f57060c.a(this.k);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f57062e.a(dVar);
    }

    public void b() {
        m.a(this.a);
        this.f57060c.b(this.k);
        this.f57062e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f57062e.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f57063f) {
                com.kwad.sdk.utils.b.a(this.f57065h).a(false);
                if (com.kwad.sdk.utils.b.a(this.f57065h).a()) {
                    this.f57063f = false;
                    a(false);
                }
            }
            this.f57062e.f();
        }
    }

    public void d() {
        this.f57062e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f57062e;
        if (aVar != null) {
            aVar.n();
            this.f57062e.h();
        }
    }

    public void f() {
        this.f57064g = true;
        if (this.f57060c.c()) {
            m.b(this.a);
            this.f57062e.a(b.a(this.a));
            this.f57062e.e();
        }
    }
}
