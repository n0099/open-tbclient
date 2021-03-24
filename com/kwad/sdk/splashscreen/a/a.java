package com.kwad.sdk.splashscreen.a;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class a extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f36598a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f36599b;

    private void a(ViewGroup viewGroup) {
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        double d2 = displayMetrics.heightPixels;
        double d3 = displayMetrics.widthPixels;
        Double.isNaN(d2);
        Double.isNaN(d3);
        if (d2 / d3 > 1.7777777910232544d) {
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
        this.f36598a = cVar;
        KsLogoView ksLogoView = (KsLogoView) cVar.f36660d.findViewById(R.id.ksad_splash_logo_container);
        this.f36599b = ksLogoView;
        a((ViewGroup) ksLogoView);
        if (this.f36598a.f36659c.adInfoList.isEmpty() || (adSplashInfo = this.f36598a.f36659c.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.f36599b.setVisibility(8);
            return;
        }
        this.f36599b.setVisibility(0);
        this.f36599b.a(this.f36598a.f36659c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
