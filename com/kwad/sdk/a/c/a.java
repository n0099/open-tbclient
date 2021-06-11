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
    public AdTemplate f32277a;

    /* renamed from: b  reason: collision with root package name */
    public long f32278b;

    /* renamed from: c  reason: collision with root package name */
    public g f32279c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f32280d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32281e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32282f;

    /* renamed from: g  reason: collision with root package name */
    public Context f32283g;

    /* renamed from: h  reason: collision with root package name */
    public f f32284h;

    /* renamed from: i  reason: collision with root package name */
    public g.a f32285i = new g.a() { // from class: com.kwad.sdk.a.c.a.3
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
        this.f32277a = adTemplate;
        this.f32278b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f32279c = gVar;
        boolean z = true;
        this.f32281e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        this.f32282f = (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) ? false : false;
        this.f32283g = detailVideoView.getContext();
        this.f32280d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f fVar = new f() { // from class: com.kwad.sdk.a.c.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i2, int i3) {
                super.a(i2, i3);
                e.b(adTemplate, i2, i3);
            }
        };
        this.f32284h = fVar;
        this.f32280d.a(fVar);
        g();
        this.f32280d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.f32279c.d()) {
                    a.this.f32280d.a(new com.kwad.sdk.contentalliance.detail.video.c(a.this.f32278b, System.currentTimeMillis()));
                    a.this.f32280d.f();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f32280d;
            f2 = 1.0f;
        } else {
            aVar = this.f32280d;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f32280d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f32277a)).a(this.f32277a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f32277a)).a());
        a(this.f32281e);
        if (h()) {
            this.f32280d.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f32282f) {
            this.f32282f = b.b(this.f32283g);
        }
        return this.f32282f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f32280d.a() == null) {
            g();
        }
        if (h() && this.f32279c.d()) {
            this.f32280d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f32278b, currentTimeMillis));
            this.f32280d.f();
        }
        this.f32279c.a(this.f32285i);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f32280d.a(eVar);
    }

    public void b() {
        this.f32279c.b(this.f32285i);
        this.f32280d.k();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f32280d.b(eVar);
    }

    public void c() {
        if (h()) {
            if (this.f32281e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f32281e = false;
                    a(false);
                }
            }
            this.f32280d.h();
        }
    }

    public void d() {
        this.f32280d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f32280d;
        if (aVar != null) {
            aVar.p();
            this.f32280d.k();
        }
    }

    public void f() {
        this.f32282f = true;
        if (this.f32279c.d()) {
            this.f32280d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f32278b, System.currentTimeMillis()));
            this.f32280d.f();
        }
    }
}
