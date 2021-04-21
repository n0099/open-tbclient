package com.kwad.sdk.a.c;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.download.d.b;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.g;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f32118a;

    /* renamed from: b  reason: collision with root package name */
    public long f32119b;

    /* renamed from: c  reason: collision with root package name */
    public g f32120c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f32121d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32122e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32123f;

    /* renamed from: g  reason: collision with root package name */
    public Context f32124g;

    /* renamed from: h  reason: collision with root package name */
    public f f32125h;
    public g.a i = new g.a() { // from class: com.kwad.sdk.a.c.a.3
        @Override // com.kwad.sdk.core.view.g.a
        public void a(boolean z) {
            if (z) {
                a.this.c();
            } else {
                a.this.d();
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull g gVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f32118a = adTemplate;
        this.f32119b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f32120c = gVar;
        boolean z = true;
        this.f32122e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        this.f32123f = (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) ? false : false;
        this.f32124g = detailVideoView.getContext();
        this.f32121d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f fVar = new f() { // from class: com.kwad.sdk.a.c.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i, int i2) {
                super.a(i, i2);
                e.b(adTemplate, i, i2);
            }
        };
        this.f32125h = fVar;
        this.f32121d.a(fVar);
        g();
        this.f32121d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.f32120c.d()) {
                    a.this.f32121d.a(new com.kwad.sdk.contentalliance.detail.video.c(a.this.f32119b, System.currentTimeMillis()));
                    a.this.f32121d.f();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f32121d;
            f2 = 1.0f;
        } else {
            aVar = this.f32121d;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f32121d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f32118a)).a(this.f32118a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f32118a)).a());
        a(this.f32122e);
        if (h()) {
            this.f32121d.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f32123f) {
            this.f32123f = b.b(this.f32124g);
        }
        return this.f32123f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f32121d.a() == null) {
            g();
        }
        if (h() && this.f32120c.d()) {
            this.f32121d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f32119b, currentTimeMillis));
            this.f32121d.f();
        }
        this.f32120c.a(this.i);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f32121d.a(eVar);
    }

    public void b() {
        this.f32120c.b(this.i);
        this.f32121d.k();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f32121d.b(eVar);
    }

    public void c() {
        if (h()) {
            if (this.f32122e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f32122e = false;
                    a(false);
                }
            }
            this.f32121d.h();
        }
    }

    public void d() {
        this.f32121d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f32121d;
        if (aVar != null) {
            aVar.p();
            this.f32121d.k();
        }
    }

    public void f() {
        this.f32123f = true;
        if (this.f32120c.d()) {
            this.f32121d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f32119b, System.currentTimeMillis()));
            this.f32121d.f();
        }
    }
}
