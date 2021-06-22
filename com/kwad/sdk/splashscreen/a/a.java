package com.kwad.sdk.splashscreen.a;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class a extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f37449a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f37450b;

    private void a(ViewGroup viewGroup) {
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = ao.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = ao.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
        this.f37449a = cVar;
        KsLogoView ksLogoView = (KsLogoView) cVar.f37514d.findViewById(R.id.ksad_splash_logo_container);
        this.f37450b = ksLogoView;
        a((ViewGroup) ksLogoView);
        if (this.f37449a.f37513c.adInfoList.isEmpty() || (adSplashInfo = this.f37449a.f37513c.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.f37450b.setVisibility(8);
            return;
        }
        this.f37450b.setVisibility(0);
        this.f37450b.a(this.f37449a.f37513c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
