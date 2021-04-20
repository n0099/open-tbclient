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
/* loaded from: classes6.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f33119b;

    /* renamed from: c  reason: collision with root package name */
    public i f33120c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f33121d;

    /* renamed from: e  reason: collision with root package name */
    public RefreshLayout.b f33122e = new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            a.this.g();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f33123f = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.2
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            a.this.f();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33124g = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int a2 = a.this.f33119b.getAdapter().a(i);
            int a3 = a.this.f33119b.getAdapter().a();
            if (a3 <= 0 || a2 < a3 - 3) {
                return;
            }
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "preloadMoreData position=" + a2);
            a.this.f();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public d f33125h = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.4
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            if (a.this.f33121d != null) {
                a.this.f33121d.setRefreshing(false);
            }
            a.this.f33119b.i();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (!z) {
                a.this.f33119b.a(a.this.f33120c.d());
                a.this.f33119b.i();
                return;
            }
            if (a.this.f33121d != null) {
                a.this.f33121d.setRefreshing(false);
            }
            a.this.f33119b.postDelayed(a.this.i, 300L);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            super.a(z, z2, i, i2);
            a.this.f33119b.h();
        }
    };
    public Runnable i = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.f33119b.b(a.this.f33120c.d());
            a.this.f33119b.i();
        }
    };

    private void e() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f33120c.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadMore");
        this.f33120c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f33120c.a(1);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.viewpager.d dVar = ((c) this).f33138a;
        this.f33120c = dVar.f33139a;
        SlidePlayViewPager slidePlayViewPager = dVar.f33141c;
        this.f33119b = slidePlayViewPager;
        slidePlayViewPager.a(this.f33124g);
        this.f33120c.a(this.f33125h);
        e eVar = ((c) this).f33138a.f33142d;
        this.f33121d = eVar;
        if (eVar != null) {
            eVar.setOnRefreshListener(this.f33122e);
        }
        this.f33119b.a(this.f33123f);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33119b.b(this.f33124g);
        this.f33120c.b(this.f33125h);
        this.f33119b.removeCallbacks(this.i);
        this.f33120c.b();
    }
}
