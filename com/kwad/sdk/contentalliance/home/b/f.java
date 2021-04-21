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
    public KSPageLoadingView f33061b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f33062c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33063d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33064e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33065f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f33066g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (f.this.f33062c != null) {
                f.this.f33062c.a(0);
                f.this.e();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33067h = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            f.this.f33064e = false;
        }
    };
    public SlidePlayTouchViewPager.a i = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.3
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            f.this.f33064e = true;
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.home.b.f.4
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            f.this.f33061b.a();
            if (f.this.f33063d.j()) {
                if (com.kwad.sdk.core.network.f.f34259g.k == i) {
                    f.this.f33061b.c();
                } else if (!v.a(f.this.f33061b.getContext())) {
                    f.this.f33061b.a(f.this.f33065f.e());
                } else if (com.kwad.sdk.core.network.f.j.k == i) {
                    f.this.f33061b.d();
                } else {
                    f.this.f33061b.b(f.this.f33065f.e());
                }
            } else if (f.this.f33064e) {
                if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                    p.a(f.this.o());
                } else if (com.kwad.sdk.core.network.f.f34259g.k != i) {
                    p.b(f.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(f.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            f.this.f33061b.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            if (r0.f33071a.f33064e != false) goto L18;
         */
        @Override // com.kwad.sdk.contentalliance.home.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z, boolean z2, int i, int i2) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        f.this.f33061b.e();
                        return;
                    } else if (i != 4) {
                        return;
                    }
                }
                f.this.f33061b.a();
                return;
            }
            f.this.f33061b.b();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (a aVar : ((com.kwad.sdk.contentalliance.home.e) this).f33153a.p) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33153a;
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f33155b;
        this.f33062c = iVar;
        this.f33065f = fVar.f33159f.f33173a;
        iVar.a(this.j);
        this.f33063d.a(this.i);
        this.f33063d.a(this.f33067h);
        this.f33061b.setRetryClickListener(this.f33066g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33064e = false;
        this.f33062c.b(this.j);
        this.f33061b.setRetryClickListener(null);
        this.f33063d.b(this.i);
        this.f33063d.b(this.f33067h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33063d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f33061b = (KSPageLoadingView) b(R.id.ksad_page_loading);
    }
}
