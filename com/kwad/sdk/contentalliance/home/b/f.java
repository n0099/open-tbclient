package com.kwad.sdk.contentalliance.home.b;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public KSPageLoadingView f32676b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f32677c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f32678d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32679e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32680f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f32681g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (f.this.f32677c != null) {
                f.this.f32677c.a(0);
                f.this.e();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f32682h = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            f.this.f32679e = false;
        }
    };
    public SlidePlayTouchViewPager.a i = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.3
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            f.this.f32679e = true;
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.home.b.f.4
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            f.this.f32676b.a();
            if (f.this.f32678d.j()) {
                if (com.kwad.sdk.core.network.f.f33874g.k == i) {
                    f.this.f32676b.c();
                } else if (!v.a(f.this.f32676b.getContext())) {
                    f.this.f32676b.a(f.this.f32680f.e());
                } else if (com.kwad.sdk.core.network.f.j.k == i) {
                    f.this.f32676b.d();
                } else {
                    f.this.f32676b.b(f.this.f32680f.e());
                }
            } else if (f.this.f32679e) {
                if (com.kwad.sdk.core.network.f.f33868a.k == i) {
                    p.a(f.this.o());
                } else if (com.kwad.sdk.core.network.f.f33874g.k != i) {
                    p.b(f.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(f.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            f.this.f32676b.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            if (r0.f32686a.f32679e != false) goto L18;
         */
        @Override // com.kwad.sdk.contentalliance.home.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z, boolean z2, int i, int i2) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        f.this.f32676b.e();
                        return;
                    } else if (i != 4) {
                        return;
                    }
                }
                f.this.f32676b.a();
                return;
            }
            f.this.f32676b.b();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (a aVar : ((com.kwad.sdk.contentalliance.home.e) this).f32768a.p) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f32768a;
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f32770b;
        this.f32677c = iVar;
        this.f32680f = fVar.f32774f.f32788a;
        iVar.a(this.j);
        this.f32678d.a(this.i);
        this.f32678d.a(this.f32682h);
        this.f32676b.setRetryClickListener(this.f32681g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32679e = false;
        this.f32677c.b(this.j);
        this.f32676b.setRetryClickListener(null);
        this.f32678d.b(this.i);
        this.f32678d.b(this.f32682h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32678d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f32676b = (KSPageLoadingView) b(R.id.ksad_page_loading);
    }
}
