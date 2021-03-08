package com.kwad.sdk.contentalliance.home.b;

import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView;
/* loaded from: classes3.dex */
public class j extends com.kwad.sdk.contentalliance.home.e {
    private KsAdHotRefreshView b;
    private SlidePlayViewPager c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.b("HomeViewPagerPresenter", "onBind");
        this.c = this.f5821a.c;
        this.c.a(this.f5821a, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.d.a.b("HomeViewPagerPresenter", "onUnbind");
        this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (KsAdHotRefreshView) b(R.id.ksad_refresh_layout);
        this.b.setRefreshInitialOffset(0.0f);
    }
}
