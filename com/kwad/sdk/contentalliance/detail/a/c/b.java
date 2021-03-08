package com.kwad.sdk.contentalliance.detail.a.c;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    private static boolean b = false;
    private AdTemplate c;
    private int d;
    @Nullable
    private com.kwad.sdk.core.i.a e;
    private SceneImpl f;
    private volatile long j;
    private long g = 0;
    private boolean h = false;
    private boolean i = true;
    private boolean k = false;
    private e l = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            b.this.i = false;
            if (!b.this.k) {
                b.this.g = SystemClock.elapsedRealtime();
            }
            b.this.j = SystemClock.elapsedRealtime();
            if (b.b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.d + " onVideoPlayStart");
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            b.this.i = true;
            if (b.this.h) {
                com.kwad.sdk.core.report.e.a(b.this.f, b.this.c, b.this.j > 0 ? SystemClock.elapsedRealtime() - b.this.j : -1L);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (b.b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.d + " onVideoPlaying");
            }
            b.this.g();
            b.this.j = SystemClock.elapsedRealtime();
            if (b.this.h && b.this.i) {
                com.kwad.sdk.core.report.e.b(b.this.c);
            }
            b.this.i = false;
        }
    };
    private com.kwad.sdk.contentalliance.a.a m = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.d + " becomesAttachedOnPageSelected");
            }
            b.this.g = SystemClock.elapsedRealtime();
            if (b.this.e == null) {
                com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
            } else {
                b.this.e.a(b.this.n);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.d + " becomesDetachedOnPageSelected");
            }
            if (b.this.e == null) {
                com.kwad.sdk.core.d.a.c("DetailLogVideoPresenter", "mVisibleHelper is null");
                return;
            }
            b.this.e.b(b.this.n);
            b.this.f();
        }
    };
    private com.kwad.sdk.core.i.c n = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.b.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            b.this.k = false;
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (b.b) {
                com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + b.this.d + " onPageVisible");
            }
            b.this.k = true;
            b.this.g = SystemClock.elapsedRealtime();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k = false;
        this.h = false;
        this.i = false;
        this.j = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.h) {
            return;
        }
        this.h = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.g;
        if (b) {
            com.kwad.sdk.core.d.a.a("DetailLogVideoPresenter", "position: " + this.d + " startPlayDuration startPlayDuration: " + elapsedRealtime);
        }
        com.kwad.sdk.core.report.e.a(this.c, elapsedRealtime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = this.f5594a.f5600a;
        if (hVar != null) {
            this.e = hVar.f5826a;
            this.f = hVar.k;
        }
        this.c = this.f5594a.j;
        this.d = this.f5594a.i;
        f();
        this.f5594a.b.add(this.m);
        if (this.f5594a.m != null) {
            this.f5594a.m.a(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5594a.b.remove(this.m);
        if (this.f5594a.m != null) {
            this.f5594a.m.b(this.l);
        }
    }
}
