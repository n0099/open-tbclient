package com.kwad.sdk.splashscreen.a;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class b extends Presenter {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f41235b;

    private void a(ViewGroup viewGroup) {
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.a();
        com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
        this.a = gVar;
        KsLogoView ksLogoView = (KsLogoView) gVar.f41331e.findViewById(R.id.obfuscated_res_0x7f091145);
        this.f41235b = ksLogoView;
        a((ViewGroup) ksLogoView);
        if (this.a.f41330d.adInfoList.isEmpty() || (adSplashInfo = this.a.f41330d.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.f41235b.setVisibility(8);
            return;
        }
        this.f41235b.setVisibility(0);
        this.f41235b.a(this.a.f41330d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
    }
}
