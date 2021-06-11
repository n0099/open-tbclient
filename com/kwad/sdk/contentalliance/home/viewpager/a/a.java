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
    public SlidePlayViewPager f33425b;

    /* renamed from: c  reason: collision with root package name */
    public i f33426c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f33427d;

    /* renamed from: e  reason: collision with root package name */
    public RefreshLayout.b f33428e = new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            a.this.g();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f33429f = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.2
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            a.this.f();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33430g = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int a2 = a.this.f33425b.getAdapter().a(i2);
            int a3 = a.this.f33425b.getAdapter().a();
            if (a3 <= 0 || a2 < a3 - 3) {
                return;
            }
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "preloadMoreData position=" + a2);
            a.this.f();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public d f33431h = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.4
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            if (a.this.f33427d != null) {
                a.this.f33427d.setRefreshing(false);
            }
            a.this.f33425b.i();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            if (!z) {
                a.this.f33425b.a(a.this.f33426c.d());
                a.this.f33425b.i();
                return;
            }
            if (a.this.f33427d != null) {
                a.this.f33427d.setRefreshing(false);
            }
            a.this.f33425b.postDelayed(a.this.f33432i, 300L);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i2, int i3) {
            super.a(z, z2, i2, i3);
            a.this.f33425b.h();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public Runnable f33432i = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.f33425b.b(a.this.f33426c.d());
            a.this.f33425b.i();
        }
    };

    private void e() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f33426c.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadMore");
        this.f33426c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f33426c.a(1);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.viewpager.d dVar = ((c) this).f33446a;
        this.f33426c = dVar.f33447a;
        SlidePlayViewPager slidePlayViewPager = dVar.f33449c;
        this.f33425b = slidePlayViewPager;
        slidePlayViewPager.a(this.f33430g);
        this.f33426c.a(this.f33431h);
        e eVar = ((c) this).f33446a.f33450d;
        this.f33427d = eVar;
        if (eVar != null) {
            eVar.setOnRefreshListener(this.f33428e);
        }
        this.f33425b.a(this.f33429f);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33425b.b(this.f33430g);
        this.f33426c.b(this.f33431h);
        this.f33425b.removeCallbacks(this.f33432i);
        this.f33426c.b();
    }
}
