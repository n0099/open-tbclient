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
/* loaded from: classes8.dex */
public class a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public long f55409b;

    /* renamed from: c  reason: collision with root package name */
    public f f55410c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f55411d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f55412e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55413f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55414g;

    /* renamed from: h  reason: collision with root package name */
    public Context f55415h;

    /* renamed from: i  reason: collision with root package name */
    public e f55416i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55417j;
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
        this.f55417j = false;
        this.a = adTemplate;
        this.f55409b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f55410c = fVar;
        this.f55413f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f55414g = z;
        this.f55415h = detailVideoView.getContext();
        this.f55411d = detailVideoView;
        this.f55412e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f55417j = ksAdVideoPlayConfig.isNoCache();
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
        this.f55416i = eVar;
        this.f55412e.a(eVar);
        g();
        this.f55412e.a(new c.e() { // from class: com.kwad.sdk.f.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                if (a.this.h() && a.this.f55410c.c()) {
                    a.this.f55412e.a(b.a(a.this.a));
                    a.this.f55412e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f55412e;
            f2 = 1.0f;
        } else {
            aVar = this.f55412e;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f55412e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.f55417j).a(b.a(this.a)).a(), true, true, this.f55411d);
        a(this.f55413f);
        if (h()) {
            this.f55412e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f55414g) {
            this.f55414g = com.ksad.download.c.b.b(this.f55415h);
        }
        return this.f55414g;
    }

    public void a() {
        m.c(this.a);
        if (this.f55412e.a() == null) {
            g();
        }
        if (h() && this.f55410c.c()) {
            this.f55412e.a(b.a(this.a));
            this.f55412e.e();
        }
        this.f55410c.a(this.k);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f55412e.a(dVar);
    }

    public void b() {
        m.a(this.a);
        this.f55410c.b(this.k);
        this.f55412e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f55412e.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f55413f) {
                com.kwad.sdk.utils.b.a(this.f55415h).a(false);
                if (com.kwad.sdk.utils.b.a(this.f55415h).a()) {
                    this.f55413f = false;
                    a(false);
                }
            }
            this.f55412e.f();
        }
    }

    public void d() {
        this.f55412e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f55412e;
        if (aVar != null) {
            aVar.n();
            this.f55412e.h();
        }
    }

    public void f() {
        this.f55414g = true;
        if (this.f55410c.c()) {
            m.b(this.a);
            this.f55412e.a(b.a(this.a));
            this.f55412e.e();
        }
    }
}
