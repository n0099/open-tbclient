package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public int f33226b;

    /* renamed from: c  reason: collision with root package name */
    public int f33227c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33228d;

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        SlidePlayViewPager slidePlayViewPager = ((c) this).f33233a.f33236c;
        this.f33228d = slidePlayViewPager;
        slidePlayViewPager.a(new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f2, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                b.this.f33227c = i;
                if (b.this.f33228d.getAdapter() != null) {
                    b.this.f33228d.getAdapter().a(i, false);
                }
                b.this.f33228d.a(i > b.this.f33227c ? SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_NEXT : SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_PRE);
            }
        });
        this.f33228d.setOnPageScrollEndListener(new b.f() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.2
            @Override // com.kwad.sdk.contentalliance.b.b.f
            public void a() {
                int currentItem = ((c) b.this).f33233a.f33236c.getCurrentItem();
                if (b.this.f33226b == currentItem) {
                    return;
                }
                b.this.f33226b = currentItem;
                if (b.this.f33228d.getAdapter() != null) {
                    b.this.f33228d.getAdapter().a(currentItem, true);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f33228d.getAdapter() != null) {
            this.f33228d.getAdapter().a(true);
        }
    }
}
