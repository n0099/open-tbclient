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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f32376b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32377c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f32378d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32379e;

    /* renamed from: f  reason: collision with root package name */
    public int f32380f;

    /* renamed from: g  reason: collision with root package name */
    public aj f32381g;

    /* renamed from: h  reason: collision with root package name */
    public aj f32382h;
    public long j;
    public int k;
    public SlidePlayViewPager l;
    public c m;
    public boolean i = false;
    public e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            a.this.f32382h.c();
            if (a.f32376b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32380f + " onVideoPlayCompleted playDuration: " + a.this.f32382h.f());
            }
            a.d(a.this);
            a.this.j = 0L;
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            super.a(i, i2);
            a.this.f32382h.c();
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
            if (a.this.f32382h.e()) {
                a.this.f32382h.b();
            }
            if (a.f32376b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32380f + " onVideoPlayStart resumeTiming playDuration: " + a.this.f32382h.f());
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            a.this.f32382h.c();
            if (a.f32376b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32380f + " onVideoPlayPaused playDuration: " + a.this.f32382h.f());
            }
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            StringBuilder sb;
            String str;
            super.d();
            if (a.this.f32382h.e()) {
                a.this.f32382h.b();
                if (a.f32376b) {
                    sb = new StringBuilder();
                    sb.append("position: ");
                    sb.append(a.this.f32380f);
                    str = " onVideoPlaying resumeTiming playDuration: ";
                    sb.append(str);
                    sb.append(a.this.f32382h.f());
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
                }
            } else {
                a.this.f32382h.a();
                if (a.f32376b) {
                    sb = new StringBuilder();
                    sb.append("position: ");
                    sb.append(a.this.f32380f);
                    str = " onVideoPlaying startTiming playDuration: ";
                    sb.append(str);
                    sb.append(a.this.f32382h.f());
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
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
    public com.kwad.sdk.contentalliance.a.a o = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (a.f32376b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32380f + " becomesAttachedOnPageSelected");
            }
            if (a.this.f32377c == null) {
                com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
            } else {
                a.this.f32377c.a(a.this.p);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (a.f32376b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32380f + " becomesDetachedOnPageSelected");
            }
            if (a.this.f32377c == null) {
                com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
                return;
            }
            a.this.f32377c.b(a.this.p);
            a.this.a(a.this.f32381g.d(), a.this.f32382h.d());
            a.this.f();
        }
    };
    public com.kwad.sdk.core.i.c p = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            a.this.f32381g.c();
            if (a.f32376b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32380f + " onPageInvisible stayDuration: " + a.this.f32381g.f());
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            StringBuilder sb;
            String str;
            a.this.g();
            if (a.this.f32381g.e()) {
                a.this.f32381g.b();
                if (!a.f32376b) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("position: ");
                sb.append(a.this.f32380f);
                str = " onPageVisible resumeTiming stayDuration: ";
            } else {
                a.this.f32381g.a();
                if (!a.f32376b) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("position: ");
                sb.append(a.this.f32380f);
                str = " onPageVisible startTiming stayDuration: ";
            }
            sb.append(str);
            sb.append(a.this.f32381g.f());
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (j == 0) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(this.f32379e) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f32379e)) * 1000 : d.c(com.kwad.sdk.core.response.b.c.k(this.f32379e)).longValue();
        if (f32376b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f32380f + " reportPlayFinish videoDuration: " + b2 + " stayDuration: " + j + " playDuration " + j2);
        }
        int i = (this.k <= 0 || this.j != 0) ? 2 : 1;
        c.a c2 = this.m.c();
        com.kwad.sdk.core.report.e.a(this.f32378d, this.f32379e, j2, i, j, c2.b(), c2.a());
    }

    public static /* synthetic */ int d(a aVar) {
        int i = aVar.k;
        aVar.k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k = 0;
        this.j = 0L;
        this.i = false;
        c cVar = this.m;
        if (cVar != null) {
            cVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.i) {
            return;
        }
        this.i = true;
        SlidePlayViewPager slidePlayViewPager = this.l;
        if (slidePlayViewPager == null) {
            return;
        }
        int preItem = slidePlayViewPager.getPreItem();
        int currentItem = this.l.getCurrentItem();
        int i = currentItem <= preItem ? currentItem < preItem ? 2 : 3 : 1;
        if (f32376b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f32380f + " reportItemImpression enterType=" + i);
        }
        com.kwad.sdk.core.report.e.a(this.f32379e, i);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32536a;
        if (hVar != null) {
            this.f32377c = hVar.f33173a;
            this.f32378d = hVar.k;
        }
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        this.f32379e = cVar.j;
        this.f32380f = cVar.i;
        this.l = cVar.l;
        this.f32381g = new aj();
        this.f32382h = new aj();
        this.m = new c();
        f();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.add(0, this.o);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m;
        if (bVar != null) {
            this.f32379e.mMediaPlayerType = bVar.c();
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m.a(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32537b.remove(this.o);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.m;
        if (bVar != null) {
            bVar.b(this.n);
        }
    }
}
