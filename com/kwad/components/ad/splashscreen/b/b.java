package com.kwad.components.ad.splashscreen.b;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class b extends e {
    public KsLogoView bq;

    private void h(ViewGroup viewGroup) {
        if (this.yF.xV != 0) {
            return;
        }
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels / displayMetrics.widthPixels > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.aq();
        KsLogoView ksLogoView = (KsLogoView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091401);
        this.bq = ksLogoView;
        h(ksLogoView);
        if (this.yF.mAdTemplate.adInfoList.isEmpty() || (adSplashInfo = this.yF.mAdTemplate.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.bq.setVisibility(8);
            return;
        }
        this.bq.setVisibility(0);
        this.bq.T(this.yF.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
