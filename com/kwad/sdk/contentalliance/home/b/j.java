package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView;
/* loaded from: classes6.dex */
public class j extends com.kwad.sdk.contentalliance.home.e {

    /* renamed from: b  reason: collision with root package name */
    public KsAdHotRefreshView f32992b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f32993c;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.b("HomeViewPagerPresenter", "onBind");
        com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f33058a;
        SlidePlayViewPager slidePlayViewPager = fVar.f33061c;
        this.f32993c = slidePlayViewPager;
        slidePlayViewPager.a(fVar, this.f32992b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.d.a.b("HomeViewPagerPresenter", "onUnbind");
        this.f32993c.g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        KsAdHotRefreshView ksAdHotRefreshView = (KsAdHotRefreshView) b(R.id.ksad_refresh_layout);
        this.f32992b = ksAdHotRefreshView;
        ksAdHotRefreshView.setRefreshInitialOffset(0.0f);
    }
}
