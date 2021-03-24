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
    public SlidePlayViewPager f32829b;

    /* renamed from: c  reason: collision with root package name */
    public i f32830c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f32831d;

    /* renamed from: e  reason: collision with root package name */
    public RefreshLayout.b f32832e = new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            a.this.g();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f32833f = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.2
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            a.this.f();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f32834g = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int a2 = a.this.f32829b.getAdapter().a(i);
            int a3 = a.this.f32829b.getAdapter().a();
            if (a3 <= 0 || a2 < a3 - 3) {
                return;
            }
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "preloadMoreData position=" + a2);
            a.this.f();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public d f32835h = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.4
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            if (a.this.f32831d != null) {
                a.this.f32831d.setRefreshing(false);
            }
            a.this.f32829b.i();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (!z) {
                a.this.f32829b.a(a.this.f32830c.d());
                a.this.f32829b.i();
                return;
            }
            if (a.this.f32831d != null) {
                a.this.f32831d.setRefreshing(false);
            }
            a.this.f32829b.postDelayed(a.this.i, 300L);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            super.a(z, z2, i, i2);
            a.this.f32829b.h();
        }
    };
    public Runnable i = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.f32829b.b(a.this.f32830c.d());
            a.this.f32829b.i();
        }
    };

    private void e() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f32830c.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadMore");
        this.f32830c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f32830c.a(1);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.viewpager.d dVar = ((c) this).f32848a;
        this.f32830c = dVar.f32849a;
        SlidePlayViewPager slidePlayViewPager = dVar.f32851c;
        this.f32829b = slidePlayViewPager;
        slidePlayViewPager.a(this.f32834g);
        this.f32830c.a(this.f32835h);
        e eVar = ((c) this).f32848a.f32852d;
        this.f32831d = eVar;
        if (eVar != null) {
            eVar.setOnRefreshListener(this.f32832e);
        }
        this.f32829b.a(this.f32833f);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32829b.b(this.f32834g);
        this.f32830c.b(this.f32835h);
        this.f32829b.removeCallbacks(this.i);
        this.f32830c.b();
    }
}
