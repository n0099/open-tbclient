package com.kwad.sdk.contentalliance.detail.a.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.contentalliance.detail.a.c.c;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aj;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8612b = false;
    @Nullable
    private com.kwad.sdk.core.i.a c;
    private SceneImpl d;
    private AdTemplate e;
    private int f;
    private aj g;
    private aj h;
    private long j;
    private int k;
    private SlidePlayViewPager l;
    private c m;
    private boolean i = false;
    private e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            a.this.h.c();
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onVideoPlayCompleted playDuration: " + a.this.h.f());
            }
            a.d(a.this);
            a.this.j = 0L;
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            a.this.h.c();
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            super.a(j, j2);
            a.this.j = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            if (a.this.h.e()) {
                a.this.h.b();
            }
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onVideoPlayStart resumeTiming playDuration: " + a.this.h.f());
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            a.this.h.c();
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onVideoPlayPaused playDuration: " + a.this.h.f());
            }
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.h.e()) {
                a.this.h.b();
                if (a.f8612b) {
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onVideoPlaying resumeTiming playDuration: " + a.this.h.f());
                }
            } else {
                a.this.h.a();
                if (a.f8612b) {
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onVideoPlaying startTiming playDuration: " + a.this.h.f());
                }
            }
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void f() {
            super.f();
            a.this.m.a();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void g() {
            super.g();
            a.this.m.a();
        }
    };
    private com.kwad.sdk.contentalliance.a.a o = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " becomesAttachedOnPageSelected");
            }
            if (a.this.c == null) {
                com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
            } else {
                a.this.c.a(a.this.p);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " becomesDetachedOnPageSelected");
            }
            if (a.this.c == null) {
                com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
                return;
            }
            a.this.c.b(a.this.p);
            a.this.a(a.this.g.d(), a.this.h.d());
            a.this.f();
        }
    };
    private com.kwad.sdk.core.i.c p = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            a.this.g.c();
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onPageInvisible stayDuration: " + a.this.g.f());
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            a.this.g();
            if (a.this.g.e()) {
                a.this.g.b();
                if (a.f8612b) {
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onPageVisible resumeTiming stayDuration: " + a.this.g.f());
                    return;
                }
                return;
            }
            a.this.g.a();
            if (a.f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f + " onPageVisible startTiming stayDuration: " + a.this.g.f());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (j == 0) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(this.e) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.e)) * 1000 : d.c(com.kwad.sdk.core.response.b.c.k(this.e)).longValue();
        if (f8612b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f + " reportPlayFinish videoDuration: " + b2 + " stayDuration: " + j + " playDuration " + j2);
        }
        int i = (this.k <= 0 || this.j != 0) ? 2 : 1;
        c.a c = this.m.c();
        com.kwad.sdk.core.report.e.a(this.d, this.e, j2, i, j, c.b(), c.a());
    }

    static /* synthetic */ int d(a aVar) {
        int i = aVar.k;
        aVar.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k = 0;
        this.j = 0L;
        this.i = false;
        if (this.m != null) {
            this.m.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.i) {
            return;
        }
        this.i = true;
        if (this.l != null) {
            int preItem = this.l.getPreItem();
            int currentItem = this.l.getCurrentItem();
            int i = currentItem <= preItem ? currentItem < preItem ? 2 : 3 : 1;
            if (f8612b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f + " reportItemImpression enterType=" + i);
            }
            com.kwad.sdk.core.report.e.a(this.e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = this.f8693a.f8702a;
        if (hVar != null) {
            this.c = hVar.f9042a;
            this.d = hVar.k;
        }
        this.e = this.f8693a.j;
        this.f = this.f8693a.i;
        this.l = this.f8693a.l;
        this.g = new aj();
        this.h = new aj();
        this.m = new c();
        f();
        this.f8693a.f8703b.add(0, this.o);
        if (this.f8693a.m != null) {
            this.e.mMediaPlayerType = this.f8693a.m.c();
            this.f8693a.m.a(this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8693a.f8703b.remove(this.o);
        if (this.f8693a.m != null) {
            this.f8693a.m.b(this.n);
        }
    }
}
