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
    public AdTemplate f32527a;

    /* renamed from: b  reason: collision with root package name */
    public long f32528b;

    /* renamed from: c  reason: collision with root package name */
    public b f32529c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f32530d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32531e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32532f;

    /* renamed from: g  reason: collision with root package name */
    public Context f32533g;

    /* renamed from: h  reason: collision with root package name */
    public e f32534h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32535i;
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
        this.f32535i = false;
        this.f32527a = adTemplate;
        this.f32528b = com.kwad.sdk.core.response.b.a.i(c.g(adTemplate));
        this.f32529c = bVar;
        this.f32531e = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f32532f = z;
        this.f32533g = detailVideoView.getContext();
        this.f32530d = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f32535i = ksAdVideoPlayConfig.isNoCache();
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
        this.f32534h = eVar;
        this.f32530d.a(eVar);
        g();
        this.f32530d.a(new c.e() { // from class: com.kwad.sdk.a.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.h() && a.this.f32529c.d()) {
                    a.this.f32530d.a(new com.kwad.sdk.contentalliance.detail.video.b(a.this.f32528b, System.currentTimeMillis()));
                    a.this.f32530d.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f32530d;
            f2 = 1.0f;
        } else {
            aVar = this.f32530d;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f32530d.a(new c.a().a(com.kwad.sdk.core.response.b.c.i(this.f32527a)).b(d.b(com.kwad.sdk.core.response.b.c.h(this.f32527a))).a(this.f32527a.mVideoPlayerStatus).a(this.f32535i).a(com.kwad.sdk.contentalliance.detail.video.b.a(this.f32527a)).a());
        a(this.f32531e);
        if (h()) {
            this.f32530d.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f32532f) {
            this.f32532f = com.ksad.download.d.b.b(this.f32533g);
        }
        return this.f32532f;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f32530d.a() == null) {
            g();
        }
        if (h() && this.f32529c.d()) {
            this.f32530d.a(new com.kwad.sdk.contentalliance.detail.video.b(this.f32528b, currentTimeMillis));
            this.f32530d.e();
        }
        this.f32529c.a(this.j);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f32530d.a(dVar);
    }

    public void b() {
        this.f32529c.b(this.j);
        this.f32530d.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f32530d.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f32531e) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.f32531e = false;
                    a(false);
                }
            }
            this.f32530d.f();
        }
    }

    public void d() {
        this.f32530d.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f32530d;
        if (aVar != null) {
            aVar.m();
            this.f32530d.h();
        }
    }

    public void f() {
        this.f32532f = true;
        if (this.f32529c.d()) {
            this.f32530d.a(new com.kwad.sdk.contentalliance.detail.video.b(this.f32528b, System.currentTimeMillis()));
            this.f32530d.e();
        }
    }
}
