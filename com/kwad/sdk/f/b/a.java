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
    public long f56892b;

    /* renamed from: c  reason: collision with root package name */
    public f f56893c;

    /* renamed from: d  reason: collision with root package name */
    public DetailVideoView f56894d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f56895e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56896f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56897g;

    /* renamed from: h  reason: collision with root package name */
    public Context f56898h;

    /* renamed from: i  reason: collision with root package name */
    public e f56899i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56900j;
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
        this.f56900j = false;
        this.a = adTemplate;
        this.f56892b = com.kwad.sdk.core.response.a.a.l(com.kwad.sdk.core.response.a.d.j(adTemplate));
        this.f56893c = fVar;
        this.f56896f = ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isVideoSoundEnable();
        if (ksAdVideoPlayConfig != null && ksAdVideoPlayConfig.isDataFlowAutoStart()) {
            z = true;
        }
        this.f56897g = z;
        this.f56898h = detailVideoView.getContext();
        this.f56894d = detailVideoView;
        this.f56895e = new com.kwad.sdk.contentalliance.detail.video.a(detailVideoView);
        if (ksAdVideoPlayConfig != null) {
            try {
                this.f56900j = ksAdVideoPlayConfig.isNoCache();
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
        this.f56899i = eVar;
        this.f56895e.a(eVar);
        g();
        this.f56895e.a(new c.e() { // from class: com.kwad.sdk.f.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(c cVar) {
                if (a.this.h() && a.this.f56893c.c()) {
                    a.this.f56895e.a(b.a(a.this.a));
                    a.this.f56895e.e();
                }
            }
        });
    }

    private void a(boolean z) {
        com.kwad.sdk.contentalliance.detail.video.a aVar;
        float f2;
        if (z) {
            aVar = this.f56895e;
            f2 = 1.0f;
        } else {
            aVar = this.f56895e;
            f2 = 0.0f;
        }
        aVar.a(f2, f2);
    }

    private void g() {
        this.f56895e.a(new c.a(this.a).a(com.kwad.sdk.core.response.a.d.m(this.a)).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.a))).a(this.a.mVideoPlayerStatus).a(this.f56900j).a(b.a(this.a)).a(), true, true, this.f56894d);
        a(this.f56896f);
        if (h()) {
            this.f56895e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.f56897g) {
            this.f56897g = com.ksad.download.c.b.b(this.f56898h);
        }
        return this.f56897g;
    }

    public void a() {
        m.c(this.a);
        if (this.f56895e.a() == null) {
            g();
        }
        if (h() && this.f56893c.c()) {
            this.f56895e.a(b.a(this.a));
            this.f56895e.e();
        }
        this.f56893c.a(this.k);
    }

    @MainThread
    public void a(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56895e.a(dVar);
    }

    public void b() {
        m.a(this.a);
        this.f56893c.b(this.k);
        this.f56895e.h();
    }

    @MainThread
    public void b(com.kwad.sdk.contentalliance.detail.video.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f56895e.b(dVar);
    }

    public void c() {
        if (h()) {
            if (this.f56896f) {
                com.kwad.sdk.utils.b.a(this.f56898h).a(false);
                if (com.kwad.sdk.utils.b.a(this.f56898h).a()) {
                    this.f56896f = false;
                    a(false);
                }
            }
            this.f56895e.f();
        }
    }

    public void d() {
        this.f56895e.g();
    }

    @MainThread
    public void e() {
        com.kwad.sdk.contentalliance.detail.video.a aVar = this.f56895e;
        if (aVar != null) {
            aVar.n();
            this.f56895e.h();
        }
    }

    public void f() {
        this.f56897g = true;
        if (this.f56893c.c()) {
            m.b(this.a);
            this.f56895e.a(b.a(this.a));
            this.f56895e.e();
        }
    }
}
