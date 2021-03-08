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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f5444a;
    private long b;
    private g c;
    private com.kwad.sdk.contentalliance.detail.video.a d;
    private boolean e;
    private boolean f;
    private Context g;
    private f h;
    private g.a i = new g.a() { // from class: com.kwad.sdk.a.c.a.3
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
        boolean z = true;
        this.f5444a = adTemplate;
        this.b = com.kwad.sdk.core.response.b.a.k(c.j(adTemplate));
        this.c = gVar;
        this.e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        this.f = (ksAdVideoPlayConfig == null || !ksAdVideoPlayConfig.isDataFlowAutoStart()) ? false : z;
        this.g = detailVideoView.getContext();
        this.d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        this.h = new f() { // from class: com.kwad.sdk.a.c.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i, int i2) {
                super.a(i, i2);
                e.b(adTemplate, i, i2);
            }
        };
        this.d.a(this.h);
        g();
        this.d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.c.d()) {
                    a.this.d.a(new com.kwad.sdk.contentalliance.detail.video.c(a.this.b, System.currentTimeMillis()));
                    a.this.d.f();
                }
            }
        });
    }

    private void a(boolean z) {
        if (z) {
            this.d.a(1.0f, 1.0f);
        } else {
            this.d.a(0.0f, 0.0f);
        }
    }

    private void g() {
        this.d.a(new d.a().a(com.kwad.sdk.core.response.b.c.l(this.f5444a)).a(this.f5444a.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.c.a(this.f5444a)).a());
        a(this.e);
        if (h()) {
            this.d.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f) {
            this.f = b.b(this.g);
        }
        return this.f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.d.a() == null) {
            g();
        }
        if (h() && this.c.d()) {
            this.d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.b, currentTimeMillis));
            this.d.f();
        }
        this.c.a(this.i);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.d.a(eVar);
    }

    public void b() {
        this.c.b(this.i);
        this.d.k();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.e eVar) {
        if (eVar == null) {
            return;
        }
        this.d.b(eVar);
    }

    public void c() {
        if (h()) {
            if (this.e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.e = false;
                    a(this.e);
                }
            }
            this.d.h();
        }
    }

    public void d() {
        this.d.j();
    }

    @MainThread
    public void e() {
        if (this.d != null) {
            this.d.p();
            this.d.k();
        }
    }

    public void f() {
        this.f = true;
        if (this.c.d()) {
            this.d.a(new com.kwad.sdk.contentalliance.detail.video.c(this.b, System.currentTimeMillis()));
            this.d.f();
        }
    }
}
