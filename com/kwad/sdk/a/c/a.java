package com.kwad.sdk.a.c;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f31701a;

    /* renamed from: b  reason: collision with root package name */
    public long f31702b;

    /* renamed from: c  reason: collision with root package name */
    public b f31703c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f31704d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31705e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31706f;

    /* renamed from: g  reason: collision with root package name */
    public Context f31707g;

    /* renamed from: h  reason: collision with root package name */
    public e f31708h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31709i;
    public b.a j = new b.a() { // from class: com.kwad.sdk.a.c.a.3
        @Override // com.kwad.sdk.core.view.b.a
        public void a(boolean z) {
            if (z) {
                a.this.c();
            } else {
                a.this.d();
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        boolean z = false;
        this.f31709i = false;
        this.f31701a = adTemplate;
        this.f31702b = com.kwad.sdk.core.response.b.a.i(c.g(adTemplate));
        this.f31703c = bVar;
        this.f31705e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f31706f = z;
        this.f31707g = detailVideoView.getContext();
        this.f31704d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f31709i = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
            }
        }
        e eVar = new e() { // from class: com.kwad.sdk.a.c.a.1
            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i2, int i3) {
                super.a(i2, i3);
                com.kwad.sdk.core.report.e.a(adTemplate, i2, i3);
            }
        };
        this.f31708h = eVar;
        this.f31704d.a(eVar);
        g();
        this.f31704d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.f31703c.d()) {
                    a.this.f31704d.a(new com.kwad.sdk.contentalliance.detail.video.b(a.this.f31702b, System.currentTimeMillis()));
                    a.this.f31704d.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f31704d;
            f2 = 1.0f;
        } else {
            aVar = this.f31704d;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f31704d.a(new c.a().a(com.kwad.sdk.core.response.b.c.i(this.f31701a)).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f31701a))).a(this.f31701a.mVideoPlayerStatus).a(this.f31709i).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f31701a)).a());
        a(this.f31705e);
        if (h()) {
            this.f31704d.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f31706f) {
            this.f31706f = com.ksad.download.d.b.b(this.f31707g);
        }
        return this.f31706f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f31704d.a() == null) {
            g();
        }
        if (h() && this.f31703c.d()) {
            this.f31704d.a(new com.kwad.sdk.contentalliance.detail.video.b(this.f31702b, currentTimeMillis));
            this.f31704d.e();
        }
        this.f31703c.a(this.j);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f31704d.a(dVar);
    }

    public void b() {
        this.f31703c.b(this.j);
        this.f31704d.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f31704d.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f31705e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f31705e = false;
                    a(false);
                }
            }
            this.f31704d.f();
        }
    }

    public void d() {
        this.f31704d.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f31704d;
        if (aVar != null) {
            aVar.m();
            this.f31704d.h();
        }
    }

    public void f() {
        this.f31706f = true;
        if (this.f31703c.d()) {
            this.f31704d.a(new com.kwad.sdk.contentalliance.detail.video.b(this.f31702b, System.currentTimeMillis()));
            this.f31704d.e();
        }
    }
}
