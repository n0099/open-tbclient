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
    public SlidePlayViewPager f32830b;

    /* renamed from: c  reason: collision with root package name */
    public i f32831c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f32832d;

    /* renamed from: e  reason: collision with root package name */
    public RefreshLayout.b f32833e = new RefreshLayout.b() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.1
        @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
        public void a() {
            a.this.g();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f32834f = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.2
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            a.this.f();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f32835g = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.3
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int a2 = a.this.f32830b.getAdapter().a(i);
            int a3 = a.this.f32830b.getAdapter().a();
            if (a3 <= 0 || a2 < a3 - 3) {
                return;
            }
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "preloadMoreData position=" + a2);
            a.this.f();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public d f32836h = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.4
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            if (a.this.f32832d != null) {
                a.this.f32832d.setRefreshing(false);
            }
            a.this.f32830b.i();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            if (!z) {
                a.this.f32830b.a(a.this.f32831c.d());
                a.this.f32830b.i();
                return;
            }
            if (a.this.f32832d != null) {
                a.this.f32832d.setRefreshing(false);
            }
            a.this.f32830b.postDelayed(a.this.i, 300L);
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            super.a(z, z2, i, i2);
            a.this.f32830b.h();
        }
    };
    public Runnable i = new Runnable() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.5
        @Override // java.lang.Runnable
        public void run() {
            a.this.f32830b.b(a.this.f32831c.d());
            a.this.f32830b.i();
        }
    };

    private void e() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f32831c.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadMore");
        this.f32831c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
        this.f32831c.a(1);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.viewpager.d dVar = ((c) this).f32849a;
        this.f32831c = dVar.f32850a;
        SlidePlayViewPager slidePlayViewPager = dVar.f32852c;
        this.f32830b = slidePlayViewPager;
        slidePlayViewPager.a(this.f32835g);
        this.f32831c.a(this.f32836h);
        e eVar = ((c) this).f32849a.f32853d;
        this.f32832d = eVar;
        if (eVar != null) {
            eVar.setOnRefreshListener(this.f32833e);
        }
        this.f32830b.a(this.f32834f);
        e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32830b.b(this.f32835g);
        this.f32831c.b(this.f32836h);
        this.f32830b.removeCallbacks(this.i);
        this.f32831c.b();
    }
}
