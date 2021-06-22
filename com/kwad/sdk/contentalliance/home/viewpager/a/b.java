package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public int f33536b;

    /* renamed from: c  reason: collision with root package name */
    public int f33537c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33538d;

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        SlidePlayViewPager slidePlayViewPager = ((c) this).f33544a.f33547c;
        this.f33538d = slidePlayViewPager;
        slidePlayViewPager.a(new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                b.this.f33537c = i2;
                if (b.this.f33538d.getAdapter() != null) {
                    b.this.f33538d.getAdapter().a(i2, false);
                }
                b.this.f33538d.a(i2 > b.this.f33537c ? SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_NEXT : SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_PRE);
            }
        });
        this.f33538d.setOnPageScrollEndListener(new b.f() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.2
            @Override // com.kwad.sdk.contentalliance.b.b.f
            public void a() {
                int currentItem = ((c) b.this).f33544a.f33547c.getCurrentItem();
                if (b.this.f33536b == currentItem) {
                    return;
                }
                b.this.f33536b = currentItem;
                if (b.this.f33538d.getAdapter() != null) {
                    b.this.f33538d.getAdapter().a(currentItem, true);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f33538d.getAdapter() != null) {
            this.f33538d.getAdapter().a(true);
        }
    }
}
