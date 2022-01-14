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
/* loaded from: classes3.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f56847b;

    /* renamed from: c  reason: collision with root package name */
    public f f56848c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f56849d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f56850e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56851f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56852g;

    /* renamed from: h  reason: collision with root package name */
    public Context f56853h;

    /* renamed from: i  reason: collision with root package name */
    public e f56854i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56855j;
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
        this.f56855j = false;
        this.a = adTemplate;
        this.f56847b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f56848c = fVar;
        this.f56851f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f56852g = z;
        this.f56853h = detailVideoView.getContext();
        this.f56849d = detailVideoView;
        this.f56850e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f56855j = ksAdVideoPlayConfig.isNoCache();
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
        this.f56854i = eVar;
        this.f56850e.a(eVar);
        g();
        this.f56850e.a(new c.e() { // from class: com.kwad.sdk.f.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                if (a.this.h() && a.this.f56848c.c()) {
                    a.this.f56850e.a(b.a(a.this.a));
                    a.this.f56850e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f56850e;
            f2 = 1.0f;
        } else {
            aVar = this.f56850e;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f56850e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.f56855j).a(b.a(this.a)).a(), true, true, this.f56849d);
        a(this.f56851f);
        if (h()) {
            this.f56850e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f56852g) {
            this.f56852g = com.ksad.download.c.b.b(this.f56853h);
        }
        return this.f56852g;
    }

    public void a() {
        m.c(this.a);
        if (this.f56850e.a() == null) {
            g();
        }
        if (h() && this.f56848c.c()) {
            this.f56850e.a(b.a(this.a));
            this.f56850e.e();
        }
        this.f56848c.a(this.k);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56850e.a(dVar);
    }

    public void b() {
        m.a(this.a);
        this.f56848c.b(this.k);
        this.f56850e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56850e.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f56851f) {
                com.kwad.sdk.utils.b.a(this.f56853h).a(false);
                if (com.kwad.sdk.utils.b.a(this.f56853h).a()) {
                    this.f56851f = false;
                    a(false);
                }
            }
            this.f56850e.f();
        }
    }

    public void d() {
        this.f56850e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f56850e;
        if (aVar != null) {
            aVar.n();
            this.f56850e.h();
        }
    }

    public void f() {
        this.f56852g = true;
        if (this.f56848c.c()) {
            m.b(this.a);
            this.f56850e.a(b.a(this.a));
            this.f56850e.e();
        }
    }
}
