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
    public AdTemplate f31733a;

    /* renamed from: b  reason: collision with root package name */
    public long f31734b;

    /* renamed from: c  reason: collision with root package name */
    public g f31735c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f31736d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31737e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31738f;

    /* renamed from: g  reason: collision with root package name */
    public Context f31739g;

    /* renamed from: h  reason: collision with root package name */
    public f f31740h;
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
        this.f31733a = adTemplate;
        this.f31734b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.f31735c = gVar;
        boolean z = true;
        this.f31737e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        this.f31738f = (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) ? false : false;
        this.f31739g = detailVideoView.getContext();
        this.f31736d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        f fVar = new f() { // from class: com.kwad.sdk.a.c.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i, int i2) {
                super.a(i, i2);
                e.b(adTemplate, i, i2);
            }
        };
        this.f31740h = fVar;
        this.f31736d.a(fVar);
        g();
        this.f31736d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.f31735c.d()) {
                    a.this.f31736d.a(new com.kwad.sdk.contentalliance.detail.video.c(a.this.f31734b, System.currentTimeMillis()));
                    a.this.f31736d.f();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f31736d;
            f2 = 1.0f;
        } else {
            aVar = this.f31736d;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f31736d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f31733a)).a(this.f31733a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f31733a)).a());
        a(this.f31737e);
        if (h()) {
            this.f31736d.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f31738f) {
            this.f31738f = b.b(this.f31739g);
        }
        return this.f31738f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f31736d.a() == null) {
            g();
        }
        if (h() && this.f31735c.d()) {
            this.f31736d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f31734b, currentTimeMillis));
            this.f31736d.f();
        }
        this.f31735c.a(this.i);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f31736d.a(eVar);
    }

    public void b() {
        this.f31735c.b(this.i);
        this.f31736d.k();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f31736d.b(eVar);
    }

    public void c() {
        if (h()) {
            if (this.f31737e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f31737e = false;
                    a(false);
                }
            }
            this.f31736d.h();
        }
    }

    public void d() {
        this.f31736d.j();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f31736d;
        if (aVar != null) {
            aVar.p();
            this.f31736d.k();
        }
    }

    public void f() {
        this.f31738f = true;
        if (this.f31735c.d()) {
            this.f31736d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.f31734b, System.currentTimeMillis()));
            this.f31736d.f();
        }
    }
}
