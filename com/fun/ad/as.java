package com.fun.ad;

import android.app.Activity;
import com.fun.ad.au;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
/* loaded from: classes6.dex */
public class as extends bu {
    public as(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bu
    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.showFullScreenAD(activity);
    }

    @Override // com.fun.ad.bu
    public void h(UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.loadFullScreenAD();
    }
}
