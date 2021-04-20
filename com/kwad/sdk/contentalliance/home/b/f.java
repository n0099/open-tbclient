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
    public KSPageLoadingView f32966b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f32967c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f32968d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32969e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32970f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f32971g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (f.this.f32967c != null) {
                f.this.f32967c.a(0);
                f.this.e();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f32972h = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            f.this.f32969e = false;
        }
    };
    public SlidePlayTouchViewPager.a i = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.3
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            f.this.f32969e = true;
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.home.b.f.4
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            f.this.f32966b.a();
            if (f.this.f32968d.j()) {
                if (com.kwad.sdk.core.network.f.f34164g.k == i) {
                    f.this.f32966b.c();
                } else if (!v.a(f.this.f32966b.getContext())) {
                    f.this.f32966b.a(f.this.f32970f.e());
                } else if (com.kwad.sdk.core.network.f.j.k == i) {
                    f.this.f32966b.d();
                } else {
                    f.this.f32966b.b(f.this.f32970f.e());
                }
            } else if (f.this.f32969e) {
                if (com.kwad.sdk.core.network.f.f34158a.k == i) {
                    p.a(f.this.o());
                } else if (com.kwad.sdk.core.network.f.f34164g.k != i) {
                    p.b(f.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(f.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            f.this.f32966b.a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
            if (r0.f32976a.f32969e != false) goto L18;
         */
        @Override // com.kwad.sdk.contentalliance.home.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z, boolean z2, int i, int i2) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        f.this.f32966b.e();
                        return;
                    } else if (i != 4) {
                        return;
                    }
                }
                f.this.f32966b.a();
                return;
            }
            f.this.f32966b.b();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (a aVar : ((com.kwad.sdk.contentalliance.home.e) this).f33058a.p) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33058a;
        com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f33060b;
        this.f32967c = iVar;
        this.f32970f = fVar.f33064f.f33078a;
        iVar.a(this.j);
        this.f32968d.a(this.i);
        this.f32968d.a(this.f32972h);
        this.f32966b.setRetryClickListener(this.f32971g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32969e = false;
        this.f32967c.b(this.j);
        this.f32966b.setRetryClickListener(null);
        this.f32968d.b(this.i);
        this.f32968d.b(this.f32972h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32968d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f32966b = (KSPageLoadingView) b(R.id.ksad_page_loading);
    }
}
