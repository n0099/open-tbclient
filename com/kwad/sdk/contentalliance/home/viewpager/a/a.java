package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.home.a.d;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.contentalliance.refreshview.e;
/* loaded from: classes3.dex */
public class a extends c {
    private SlidePlayViewPager b;
    private i c;
    @Nullable
    private e d;
    private RefreshLayout.b e = new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            a.this.g();
        }
    };
    private SlidePlayTouchViewPager.a f = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.2
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            a.this.f();
        }
    };
    private ViewPager.OnPageChangeListener g = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int a2 = a.this.b.getAdapter().a(i);
            int a3 = a.this.b.getAdapter().a();
            if (a3 <= 0 || a2 < a3 - 3) {
                return;
            }
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "preloadMoreData position=" + a2);
            a.this.f();
        }
    };
    private d h = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.4
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            if (a.this.d != null) {
                a.this.d.setRefreshing(false);
            }
            a.this.b.i();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (!z) {
                a.this.b.a(a.this.c.d());
                a.this.b.i();
                return;
            }
            if (a.this.d != null) {
                a.this.d.setRefreshing(false);
            }
            a.this.b.postDelayed(a.this.i, 300L);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            super.a(z, z2, i, i2);
            a.this.b.h();
        }
    };
    private Runnable i = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.b.b(a.this.c.d());
            a.this.b.i();
        }
    };

    private void e() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.c.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadMore");
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.c.a(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f5842a.f5843a;
        this.b = this.f5842a.c;
        this.b.a(this.g);
        this.c.a(this.h);
        this.d = this.f5842a.d;
        if (this.d != null) {
            this.d.setOnRefreshListener(this.e);
        }
        this.b.a(this.f);
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.b.b(this.g);
        this.c.b(this.h);
        this.b.removeCallbacks(this.i);
        this.c.b();
    }
}
