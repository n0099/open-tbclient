package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f32001b = false;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32002c;

    /* renamed from: d  reason: collision with root package name */
    public int f32003d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32004e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f32005f;
    public volatile long j;

    /* renamed from: g  reason: collision with root package name */
    public long f32006g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32007h = false;
    public boolean i = true;
    public boolean k = false;
    public e l = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.this.i = false;
            if (!b.this.k) {
                b.this.f32006g = SystemClock.elapsedRealtime();
            }
            b.this.j = SystemClock.elapsedRealtime();
            if (b.f32001b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32003d + " onVideoPlayStart");
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            b.this.i = true;
            if (b.this.f32007h) {
                com.kwad.sdk.core.report.e.a(b.this.f32005f, b.this.f32002c, b.this.j > 0 ? SystemClock.elapsedRealtime() - b.this.j : -1L);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.f32001b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32003d + " onVideoPlaying");
            }
            b.this.g();
            b.this.j = SystemClock.elapsedRealtime();
            if (b.this.f32007h && b.this.i) {
                com.kwad.sdk.core.report.e.b(b.this.f32002c);
            }
            b.this.i = false;
        }
    };
    public com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.f32001b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32003d + " becomesAttachedOnPageSelected");
            }
            b.this.f32006g = SystemClock.elapsedRealtime();
            if (b.this.f32004e == null) {
                com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
            } else {
                b.this.f32004e.a(b.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.f32001b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32003d + " becomesDetachedOnPageSelected");
            }
            if (b.this.f32004e == null) {
                com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
                return;
            }
            b.this.f32004e.b(b.this.n);
            b.this.f();
        }
    };
    public com.kwad.sdk.core.i.c n = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            b.this.k = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (b.f32001b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32003d + " onPageVisible");
            }
            b.this.k = true;
            b.this.f32006g = SystemClock.elapsedRealtime();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k = false;
        this.f32007h = false;
        this.i = false;
        this.j = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f32007h) {
            return;
        }
        this.f32007h = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f32006g;
        if (f32001b) {
            com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f32003d + " startPlayDuration startPlayDuration: " + elapsedRealtime);
        }
        com.kwad.sdk.core.report.e.a(this.f32002c, elapsedRealtime);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32151a;
        if (hVar != null) {
            this.f32004e = hVar.f32788a;
            this.f32005f = hVar.k;
        }
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        this.f32002c = cVar.j;
        this.f32003d = cVar.i;
        f();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(this.m);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        if (bVar != null) {
            bVar.a(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.remove(this.m);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        if (bVar != null) {
            bVar.b(this.l);
        }
    }
}
