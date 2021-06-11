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
    public KSPageLoadingView f33261b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f33262c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33263d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33264e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33265f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f33266g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (f.this.f33262c != null) {
                f.this.f33262c.a(0);
                f.this.e();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33267h = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            f.this.f33264e = false;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f33268i = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.3
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            f.this.f33264e = true;
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.home.b.f.4
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            f.this.f33261b.a();
            if (f.this.f33263d.j()) {
                if (com.kwad.sdk.core.network.f.f34503g.k == i2) {
                    f.this.f33261b.c();
                } else if (!v.a(f.this.f33261b.getContext())) {
                    f.this.f33261b.a(f.this.f33265f.e());
                } else if (com.kwad.sdk.core.network.f.j.k == i2) {
                    f.this.f33261b.d();
                } else {
                    f.this.f33261b.b(f.this.f33265f.e());
                }
            } else if (f.this.f33264e) {
                if (com.kwad.sdk.core.network.f.f34497a.k == i2) {
                    p.a(f.this.o());
                } else if (com.kwad.sdk.core.network.f.f34503g.k != i2) {
                    p.b(f.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(f.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            f.this.f33261b.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            if (r0.f33272a.f33264e != false) goto L18;
         */
        @Override // com.kwad.sdk.contentalliance.home.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z, boolean z2, int i2, int i3) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        f.this.f33261b.e();
                        return;
                    } else if (i2 != 4) {
                        return;
                    }
                }
                f.this.f33261b.a();
                return;
            }
            f.this.f33261b.b();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (a aVar : ((com.kwad.sdk.contentalliance.home.e) this).f33357a.p) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33357a;
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f33359b;
        this.f33262c = iVar;
        this.f33265f = fVar.f33363f.f33379a;
        iVar.a(this.j);
        this.f33263d.a(this.f33268i);
        this.f33263d.a(this.f33267h);
        this.f33261b.setRetryClickListener(this.f33266g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33264e = false;
        this.f33262c.b(this.j);
        this.f33261b.setRetryClickListener(null);
        this.f33263d.b(this.f33268i);
        this.f33263d.b(this.f33267h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33263d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f33261b = (KSPageLoadingView) b(R.id.ksad_page_loading);
    }
}
