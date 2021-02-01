package com.kwad.sdk.contentalliance.home.b;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes3.dex */
public class f extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    private KSPageLoadingView f8692b;
    private com.kwad.sdk.contentalliance.home.a.i c;
    private SlidePlayViewPager d;
    private boolean e;
    private com.kwad.sdk.core.i.a f;
    private KSPageLoadingView.a g = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.1
        @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
        public void a() {
            if (f.this.c != null) {
                f.this.c.a(0);
                f.this.e();
            }
        }
    };
    private ViewPager.OnPageChangeListener h = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.b.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            f.this.e = false;
        }
    };
    private SlidePlayTouchViewPager.a i = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.b.f.3
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            f.this.e = true;
        }
    };
    private com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.home.b.f.4
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            f.this.f8692b.a();
            if (f.this.d.j()) {
                if (com.kwad.sdk.core.network.f.g.k == i) {
                    f.this.f8692b.c();
                } else if (!v.a(f.this.f8692b.getContext())) {
                    f.this.f8692b.a(f.this.f.e());
                } else if (com.kwad.sdk.core.network.f.j.k == i) {
                    f.this.f8692b.d();
                } else {
                    f.this.f8692b.b(f.this.f.e());
                }
            } else if (f.this.e) {
                if (com.kwad.sdk.core.network.f.f9323a.k == i) {
                    p.a(f.this.o());
                } else if (com.kwad.sdk.core.network.f.g.k != i) {
                    p.b(f.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(f.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            f.this.f8692b.a();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            switch (i) {
                case 0:
                    f.this.f8692b.b();
                    return;
                case 1:
                    f.this.f8692b.a();
                    return;
                case 2:
                case 3:
                    f.this.f8692b.e();
                    return;
                case 4:
                    if (f.this.e) {
                        f.this.f8692b.b();
                        return;
                    } else {
                        f.this.f8692b.a();
                        return;
                    }
                default:
                    return;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        for (a aVar : this.f8736a.p) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    protected void a() {
        super.a();
        this.c = this.f8736a.f8738b;
        this.f = this.f8736a.f.f8744a;
        this.c.a(this.j);
        this.d.a(this.i);
        this.d.a(this.h);
        this.f8692b.setRetryClickListener(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.e = false;
        this.c.b(this.j);
        this.f8692b.setRetryClickListener(null);
        this.d.b(this.i);
        this.d.b(this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
        this.f8692b = (KSPageLoadingView) b(R.id.ksad_page_loading);
    }
}
