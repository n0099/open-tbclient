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
    public KSPageLoadingView f33359b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f33360c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33361d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33362e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33363f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f33364g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (f.this.f33360c != null) {
                f.this.f33360c.a(0);
                f.this.e();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33365h = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            f.this.f33362e = false;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f33366i = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.3
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            f.this.f33362e = true;
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.home.b.f.4
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            f.this.f33359b.a();
            if (f.this.f33361d.j()) {
                if (com.kwad.sdk.core.network.f.f34601g.k == i2) {
                    f.this.f33359b.c();
                } else if (!v.a(f.this.f33359b.getContext())) {
                    f.this.f33359b.a(f.this.f33363f.e());
                } else if (com.kwad.sdk.core.network.f.j.k == i2) {
                    f.this.f33359b.d();
                } else {
                    f.this.f33359b.b(f.this.f33363f.e());
                }
            } else if (f.this.f33362e) {
                if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                    p.a(f.this.o());
                } else if (com.kwad.sdk.core.network.f.f34601g.k != i2) {
                    p.b(f.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(f.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            f.this.f33359b.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            if (r0.f33370a.f33362e != false) goto L18;
         */
        @Override // com.kwad.sdk.contentalliance.home.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z, boolean z2, int i2, int i3) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        f.this.f33359b.e();
                        return;
                    } else if (i2 != 4) {
                        return;
                    }
                }
                f.this.f33359b.a();
                return;
            }
            f.this.f33359b.b();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (a aVar : ((com.kwad.sdk.contentalliance.home.e) this).f33455a.p) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33455a;
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f33457b;
        this.f33360c = iVar;
        this.f33363f = fVar.f33461f.f33477a;
        iVar.a(this.j);
        this.f33361d.a(this.f33366i);
        this.f33361d.a(this.f33365h);
        this.f33359b.setRetryClickListener(this.f33364g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33362e = false;
        this.f33360c.b(this.j);
        this.f33359b.setRetryClickListener(null);
        this.f33361d.b(this.f33366i);
        this.f33361d.b(this.f33365h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33361d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f33359b = (KSPageLoadingView) b(R.id.ksad_page_loading);
    }
}
