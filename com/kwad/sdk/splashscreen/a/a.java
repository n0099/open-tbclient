package com.kwad.sdk.splashscreen.a;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class a extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f33991a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f33992b;

    private void a(ViewGroup viewGroup) {
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = an.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = an.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.a();
        com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) k();
        this.f33991a = cVar;
        KsLogoView ksLogoView = (KsLogoView) cVar.f34059d.findViewById(R.id.ksad_splash_logo_container);
        this.f33992b = ksLogoView;
        a((ViewGroup) ksLogoView);
        if (this.f33991a.f34058c.adInfoList.isEmpty() || (adSplashInfo = this.f33991a.f34058c.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.f33992b.setVisibility(8);
            return;
        }
        this.f33992b.setVisibility(0);
        this.f33992b.a(this.f33991a.f34058c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
    }
}
