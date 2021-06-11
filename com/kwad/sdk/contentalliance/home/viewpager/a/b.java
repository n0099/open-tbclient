package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public int f33438b;

    /* renamed from: c  reason: collision with root package name */
    public int f33439c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f33440d;

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        SlidePlayViewPager slidePlayViewPager = ((c) this).f33446a.f33449c;
        this.f33440d = slidePlayViewPager;
        slidePlayViewPager.a(new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                b.this.f33439c = i2;
                if (b.this.f33440d.getAdapter() != null) {
                    b.this.f33440d.getAdapter().a(i2, false);
                }
                b.this.f33440d.a(i2 > b.this.f33439c ? SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_NEXT : SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_PRE);
            }
        });
        this.f33440d.setOnPageScrollEndListener(new b.f() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.2
            @Override // com.kwad.sdk.contentalliance.b.b.f
            public void a() {
                int currentItem = ((c) b.this).f33446a.f33449c.getCurrentItem();
                if (b.this.f33438b == currentItem) {
                    return;
                }
                b.this.f33438b = currentItem;
                if (b.this.f33440d.getAdapter() != null) {
                    b.this.f33440d.getAdapter().a(currentItem, true);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f33440d.getAdapter() != null) {
            this.f33440d.getAdapter().a(true);
        }
    }
}
