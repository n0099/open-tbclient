package com.kwad.sdk.splashscreen.a;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class a extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.splashscreen.c f11017a;

    /* renamed from: b  reason: collision with root package name */
    private KsLogoView f11018b;

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.a();
        this.f11017a = (com.kwad.sdk.splashscreen.c) n();
        this.f11018b = (KsLogoView) this.f11017a.d.findViewById(R.id.ksad_splash_logo_container);
        a((ViewGroup) this.f11018b);
        if (this.f11017a.c.adInfoList.isEmpty() || (adSplashInfo = this.f11017a.c.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.f11018b.setVisibility(8);
            return;
        }
        this.f11018b.setVisibility(0);
        this.f11018b.a(this.f11017a.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
