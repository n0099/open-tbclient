package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public int f32842b;

    /* renamed from: c  reason: collision with root package name */
    public int f32843c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f32844d;

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        SlidePlayViewPager slidePlayViewPager = ((c) this).f32849a.f32852c;
        this.f32844d = slidePlayViewPager;
        slidePlayViewPager.a(new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f2, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                b.this.f32843c = i;
                if (b.this.f32844d.getAdapter() != null) {
                    b.this.f32844d.getAdapter().a(i, false);
                }
                b.this.f32844d.a(i > b.this.f32843c ? SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_NEXT : SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_PRE);
            }
        });
        this.f32844d.setOnPageScrollEndListener(new b.f() { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.2
            @Override // com.kwad.sdk.contentalliance.b.b.f
            public void a() {
                int currentItem = ((c) b.this).f32849a.f32852c.getCurrentItem();
                if (b.this.f32842b == currentItem) {
                    return;
                }
                b.this.f32842b = currentItem;
                if (b.this.f32844d.getAdapter() != null) {
                    b.this.f32844d.getAdapter().a(currentItem, true);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        if (this.f32844d.getAdapter() != null) {
            this.f32844d.getAdapter().a(true);
        }
    }
}
