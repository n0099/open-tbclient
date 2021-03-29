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
    public static boolean f32002b = false;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32003c;

    /* renamed from: d  reason: collision with root package name */
    public int f32004d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32005e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f32006f;
    public volatile long j;

    /* renamed from: g  reason: collision with root package name */
    public long f32007g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32008h = false;
    public boolean i = true;
    public boolean k = false;
    public e l = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.this.i = false;
            if (!b.this.k) {
                b.this.f32007g = SystemClock.elapsedRealtime();
            }
            b.this.j = SystemClock.elapsedRealtime();
            if (b.f32002b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32004d + " onVideoPlayStart");
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            b.this.i = true;
            if (b.this.f32008h) {
                com.kwad.sdk.core.report.e.a(b.this.f32006f, b.this.f32003c, b.this.j > 0 ? SystemClock.elapsedRealtime() - b.this.j : -1L);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.f32002b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32004d + " onVideoPlaying");
            }
            b.this.g();
            b.this.j = SystemClock.elapsedRealtime();
            if (b.this.f32008h && b.this.i) {
                com.kwad.sdk.core.report.e.b(b.this.f32003c);
            }
            b.this.i = false;
        }
    };
    public com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.f32002b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32004d + " becomesAttachedOnPageSelected");
            }
            b.this.f32007g = SystemClock.elapsedRealtime();
            if (b.this.f32005e == null) {
                com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
            } else {
                b.this.f32005e.a(b.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.f32002b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32004d + " becomesDetachedOnPageSelected");
            }
            if (b.this.f32005e == null) {
                com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
                return;
            }
            b.this.f32005e.b(b.this.n);
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
            if (b.f32002b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.f32004d + " onPageVisible");
            }
            b.this.k = true;
            b.this.f32007g = SystemClock.elapsedRealtime();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k = false;
        this.f32008h = false;
        this.i = false;
        this.j = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f32008h) {
            return;
        }
        this.f32008h = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f32007g;
        if (f32002b) {
            com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.f32004d + " startPlayDuration startPlayDuration: " + elapsedRealtime);
        }
        com.kwad.sdk.core.report.e.a(this.f32003c, elapsedRealtime);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32152a;
        if (hVar != null) {
            this.f32005e = hVar.f32789a;
            this.f32006f = hVar.k;
        }
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        this.f32003c = cVar.j;
        this.f32004d = cVar.i;
        f();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.add(this.m);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.a(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.m);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.b(this.l);
        }
    }
}
