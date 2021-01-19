package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
/* loaded from: classes14.dex */
public class bu extends an {
    public UnifiedInterstitialAD pFU;

    /* loaded from: classes14.dex */
    public class a implements UnifiedInterstitialADListener {
        public a() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            m.a("GDTUnifiedInterstitialAd onADClicked");
            bu buVar = bu.this;
            ah ahVar = buVar.pFi;
            if (ahVar != null) {
                ((aa) ahVar).c(buVar.f7752a.f7760a);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            m.a("GDTUnifiedInterstitialAd onADClosed");
            bu buVar = bu.this;
            ah ahVar = buVar.pFi;
            if (ahVar != null) {
                ((aa) ahVar).a(buVar.f7752a.f7760a);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            m.a("GDTUnifiedInterstitialAd onADExposure");
            bu buVar = bu.this;
            ah ahVar = buVar.pFi;
            if (ahVar != null) {
                ((aa) ahVar).d(buVar.f7752a.f7760a);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            m.a("GDTUnifiedInterstitialAd onADLeftApplication");
            ah ahVar = bu.this.pFi;
            if (ahVar != null) {
                if (((aa) ahVar) == null) {
                    throw null;
                }
                m.a("GDTAdLoaderFactory onADLeftApplication");
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            m.a("GDTUnifiedInterstitialAd onADOpened");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            m.a("GDTUnifiedInterstitialAd onADReceive");
            bu buVar = bu.this;
            buVar.f7753b = false;
            ak akVar = buVar.pFh;
            if (akVar != null) {
                ((x) akVar).b(buVar.f7752a.f7760a);
            }
            AdRipper.ripGDTUnifiedInterstitial(bu.this.pFU);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            m.a("GDTUnifiedInterstitialAd onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            bu buVar = bu.this;
            buVar.f7753b = false;
            ak akVar = buVar.pFh;
            if (akVar != null) {
                ((x) akVar).a(buVar.f7752a.f7760a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            m.a("GDTUnifiedInterstitialAd onVideoCached");
        }
    }

    public bu(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        UnifiedInterstitialAD unifiedInterstitialAD = this.pFU;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.pFU = null;
        }
    }

    public void a(Activity activity, UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.show(activity);
    }

    @Override // com.fun.ad.an
    public FunRippedAd exX() {
        AdRipper.RippedGDTAd rippedGDTUnifiedInterstitialAd;
        UnifiedInterstitialAD unifiedInterstitialAD = this.pFU;
        if (unifiedInterstitialAD == null || (rippedGDTUnifiedInterstitialAd = AdRipper.getRippedGDTUnifiedInterstitialAd(unifiedInterstitialAD, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedGDTUnifiedInterstitialAd.title;
        funRippedAd.description = rippedGDTUnifiedInterstitialAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTUnifiedInterstitialAd.customized_invoke_url);
        funRippedAd.uniqueId = rippedGDTUnifiedInterstitialAd.title;
        funRippedAd.appName = rippedGDTUnifiedInterstitialAd.appName;
        funRippedAd.appPackageName = rippedGDTUnifiedInterstitialAd.appPackageName;
        funRippedAd.appLinkUrl = rippedGDTUnifiedInterstitialAd.appLinkUrl;
        return funRippedAd;
    }

    public void h(UnifiedInterstitialAD unifiedInterstitialAD) {
        unifiedInterstitialAD.loadAD();
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        super.a(context, funAdSlot, akVar);
        if (!this.f7753b) {
            this.f7753b = true;
            a aVar = new a();
            if (!(context instanceof Activity)) {
                m.a("GDTUnifiedInterstitialAd context is not activity");
                this.f7753b = false;
                ak akVar2 = this.pFh;
                if (akVar2 != null) {
                    ((x) akVar2).a(this.f7752a.f7760a, 0, "Custom error message: context is not activity");
                    return;
                }
                return;
            }
            UnifiedInterstitialAD unifiedInterstitialAD = new UnifiedInterstitialAD((Activity) context, this.f7752a.f7760a, aVar);
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(d.c ? 1 : 0).setAutoPlayMuted(true).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
            unifiedInterstitialAD.setMinVideoDuration(0);
            unifiedInterstitialAD.setMaxVideoDuration(0);
            unifiedInterstitialAD.setVideoPlayPolicy(1);
            this.pFU = unifiedInterstitialAD;
            h(unifiedInterstitialAD);
            ak akVar3 = this.pFh;
            if (akVar3 != null) {
                ((x) akVar3).a(this.f7752a.f7760a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        UnifiedInterstitialAD unifiedInterstitialAD = this.pFU;
        if (unifiedInterstitialAD != null) {
            a(activity, unifiedInterstitialAD);
            return;
        }
        ah ahVar2 = this.pFi;
        if (ahVar2 != null) {
            ((aa) ahVar2).a(this.f7752a.f7760a, 0, "Custom error message: mUnifiedInterstitialAD is null when show");
        }
    }
}
