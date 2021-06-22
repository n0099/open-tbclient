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
    public AdTemplate f32375a;

    /* renamed from: b  reason: collision with root package name */
    public long f32376b;

    /* renamed from: c  reason: collision with root package name */
    public g f32377c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f32378d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32379e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32380f;

    /* renamed from: g  reason: collision with root package name */
    public Context f32381g;

    /* renamed from: h  reason: collision with root package name */
    public f f32382h;

    /* renamed from: i  reason: collision with root package name */
    public g.a f32383i = new g.a() { // from class: com.kwad.sdk.a.c.a.3
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
        this.f32375a = adTemplate;
        this.f32376b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f32377c = gVar;
        boolean z = true;
        this.f32379e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        this.f32380f = (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) ? false : false;
        this.f32381g = detailVideoView.getContext();
        this.f32378d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f fVar = new f() { // from class: com.kwad.sdk.a.c.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i2, int i3) {
                super.a(i2, i3);
                e.b(adTemplate, i2, i3);
            }
        };
        this.f32382h = fVar;
        this.f32378d.a(fVar);
        g();
        this.f32378d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.f32377c.d()) {
                    a.this.f32378d.a(new com.kwad.sdk.contentalliance.detail.video.c(a.this.f32376b, System.currentTimeMillis()));
                    a.this.f32378d.f();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f32378d;
            f2 = 1.0f;
        } else {
            aVar = this.f32378d;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f32378d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f32375a)).a(this.f32375a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f32375a)).a());
        a(this.f32379e);
        if (h()) {
            this.f32378d.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f32380f) {
            this.f32380f = b.b(this.f32381g);
        }
        return this.f32380f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f32378d.a() == null) {
            g();
        }
        if (h() && this.f32377c.d()) {
            this.f32378d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f32376b, currentTimeMillis));
            this.f32378d.f();
        }
        this.f32377c.a(this.f32383i);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f32378d.a(eVar);
    }

    public void b() {
        this.f32377c.b(this.f32383i);
        this.f32378d.k();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f32378d.b(eVar);
    }

    public void c() {
        if (h()) {
            if (this.f32379e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f32379e = false;
                    a(false);
                }
            }
            this.f32378d.h();
        }
    }

    public void d() {
        this.f32378d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f32378d;
        if (aVar != null) {
            aVar.p();
            this.f32378d.k();
        }
    }

    public void f() {
        this.f32380f = true;
        if (this.f32377c.d()) {
            this.f32378d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f32376b, System.currentTimeMillis()));
            this.f32378d.f();
        }
    }
}
