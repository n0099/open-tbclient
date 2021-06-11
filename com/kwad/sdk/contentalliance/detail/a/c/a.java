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
    public static boolean f32543b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32544c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f32545d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f32546e;

    /* renamed from: f  reason: collision with root package name */
    public int f32547f;

    /* renamed from: g  reason: collision with root package name */
    public aj f32548g;

    /* renamed from: h  reason: collision with root package name */
    public aj f32549h;
    public long j;
    public int k;
    public SlidePlayViewPager l;
    public c m;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32550i = false;
    public e n = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            super.a();
            a.this.f32549h.c();
            if (a.f32543b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32547f + " onVideoPlayCompleted playDuration: " + a.this.f32549h.f());
            }
            a.d(a.this);
            a.this.j = 0L;
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            super.a(i2, i3);
            a.this.f32549h.c();
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
            if (a.this.f32549h.e()) {
                a.this.f32549h.b();
            }
            if (a.f32543b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32547f + " onVideoPlayStart resumeTiming playDuration: " + a.this.f32549h.f());
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            a.this.f32549h.c();
            if (a.f32543b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32547f + " onVideoPlayPaused playDuration: " + a.this.f32549h.f());
            }
            a.this.m.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            StringBuilder sb;
            String str;
            super.d();
            if (a.this.f32549h.e()) {
                a.this.f32549h.b();
                if (a.f32543b) {
                    sb = new StringBuilder();
                    sb.append("position: ");
                    sb.append(a.this.f32547f);
                    str = " onVideoPlaying resumeTiming playDuration: ";
                    sb.append(str);
                    sb.append(a.this.f32549h.f());
                    com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
                }
            } else {
                a.this.f32549h.a();
                if (a.f32543b) {
                    sb = new StringBuilder();
                    sb.append("position: ");
                    sb.append(a.this.f32547f);
                    str = " onVideoPlaying startTiming playDuration: ";
                    sb.append(str);
                    sb.append(a.this.f32549h.f());
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
            if (a.f32543b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32547f + " becomesAttachedOnPageSelected");
            }
            if (a.this.f32544c == null) {
                com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
            } else {
                a.this.f32544c.a(a.this.p);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (a.f32543b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32547f + " becomesDetachedOnPageSelected");
            }
            if (a.this.f32544c == null) {
                com.kwad.sdk.core.d.a.c("DetailLogPagePresenter", "mVisibleHelper is null");
                return;
            }
            a.this.f32544c.b(a.this.p);
            a.this.a(a.this.f32548g.d(), a.this.f32549h.d());
            a.this.f();
        }
    };
    public com.kwad.sdk.core.i.c p = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.detail.a.c.a.3
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            a.this.f32548g.c();
            if (a.f32543b) {
                com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + a.this.f32547f + " onPageInvisible stayDuration: " + a.this.f32548g.f());
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            StringBuilder sb;
            String str;
            a.this.g();
            if (a.this.f32548g.e()) {
                a.this.f32548g.b();
                if (!a.f32543b) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("position: ");
                sb.append(a.this.f32547f);
                str = " onPageVisible resumeTiming stayDuration: ";
            } else {
                a.this.f32548g.a();
                if (!a.f32543b) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("position: ");
                sb.append(a.this.f32547f);
                str = " onPageVisible startTiming stayDuration: ";
            }
            sb.append(str);
            sb.append(a.this.f32548g.f());
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", sb.toString());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (j == 0) {
            return;
        }
        long b2 = com.kwad.sdk.core.response.b.c.c(this.f32546e) ? com.kwad.sdk.core.response.b.a.b(com.kwad.sdk.core.response.b.c.j(this.f32546e)) * 1000 : d.c(com.kwad.sdk.core.response.b.c.k(this.f32546e)).longValue();
        if (f32543b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f32547f + " reportPlayFinish videoDuration: " + b2 + " stayDuration: " + j + " playDuration " + j2);
        }
        int i2 = (this.k <= 0 || this.j != 0) ? 2 : 1;
        c.a c2 = this.m.c();
        com.kwad.sdk.core.report.e.a(this.f32545d, this.f32546e, j2, i2, j, c2.b(), c2.a());
    }

    public static /* synthetic */ int d(a aVar) {
        int i2 = aVar.k;
        aVar.k = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k = 0;
        this.j = 0L;
        this.f32550i = false;
        c cVar = this.m;
        if (cVar != null) {
            cVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f32550i) {
            return;
        }
        this.f32550i = true;
        SlidePlayViewPager slidePlayViewPager = this.l;
        if (slidePlayViewPager == null) {
            return;
        }
        int preItem = slidePlayViewPager.getPreItem();
        int currentItem = this.l.getCurrentItem();
        int i2 = currentItem <= preItem ? currentItem < preItem ? 2 : 3 : 1;
        if (f32543b) {
            com.kwad.sdk.core.d.a.a("DetailLogPagePresenter", "position: " + this.f32547f + " reportItemImpression enterType=" + i2);
        }
        com.kwad.sdk.core.report.e.a(this.f32546e, i2);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32713a;
        if (hVar != null) {
            this.f32544c = hVar.f33379a;
            this.f32545d = hVar.k;
        }
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        this.f32546e = cVar.j;
        this.f32547f = cVar.f32721i;
        this.l = cVar.l;
        this.f32548g = new aj();
        this.f32549h = new aj();
        this.m = new c();
        f();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(0, this.o);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        if (bVar != null) {
            this.f32546e.mMediaPlayerType = bVar.c();
            ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m.a(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.o);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        if (bVar != null) {
            bVar.b(this.n);
        }
    }
}
