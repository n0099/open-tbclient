package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
/* loaded from: classes6.dex */
public class bp extends an {
    public SplashAD pPR;

    /* loaded from: classes6.dex */
    public class a implements SplashADListener {
        public a() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            m.a("GDTSplashAd onADClicked");
            bp bpVar = bp.this;
            ah ahVar = bpVar.pPn;
            if (ahVar != null) {
                ((aa) ahVar).c(bpVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            m.a("GDTSplashAd onADDismissed");
            bp bpVar = bp.this;
            ah ahVar = bpVar.pPn;
            if (ahVar != null) {
                ((aa) ahVar).a(bpVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            m.a("GDTSplashAd onADExposure");
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            m.a("GDTSplashAd onADLoaded");
            bp bpVar = bp.this;
            bpVar.f7755b = false;
            ak akVar = bpVar.pPm;
            if (akVar != null) {
                ((x) akVar).b(bpVar.f7754a.f7762a);
            }
            AdRipper.ripGDTSplash(bp.this.pPR);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            m.a("GDTSplashAd onADPresent");
            bp bpVar = bp.this;
            ah ahVar = bpVar.pPn;
            if (ahVar != null) {
                ((aa) ahVar).d(bpVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            m.a("GDTSplashAd onADTick l: " + j);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            m.a("GDTSplashAd onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            bp bpVar = bp.this;
            bpVar.f7755b = false;
            ak akVar = bpVar.pPm;
            if (akVar != null) {
                ((x) akVar).a(bpVar.f7754a.f7762a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    public bp(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        this.pPR = null;
    }

    @Override // com.fun.ad.an
    public FunRippedAd eAp() {
        AdRipper.RippedGDTAd rippedGDTSplashAd;
        SplashAD splashAD = this.pPR;
        if (splashAD == null || (rippedGDTSplashAd = AdRipper.getRippedGDTSplashAd(splashAD, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedGDTSplashAd.title;
        funRippedAd.description = rippedGDTSplashAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTSplashAd.customized_invoke_url);
        funRippedAd.uniqueId = rippedGDTSplashAd.title;
        funRippedAd.appName = rippedGDTSplashAd.appName;
        funRippedAd.appPackageName = rippedGDTSplashAd.appPackageName;
        funRippedAd.appLinkUrl = rippedGDTSplashAd.appLinkUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        super.a(context, funAdSlot, akVar);
        if (!this.f7755b) {
            this.f7755b = true;
            a aVar = new a();
            if (!(context instanceof Activity)) {
                m.a("GDTSplashAd context is not activity");
                this.f7755b = false;
                ak akVar2 = this.pPm;
                if (akVar2 != null) {
                    ((x) akVar2).a(this.f7754a.f7762a, 0, "Custom error message: context is not activity");
                    return;
                }
                return;
            }
            SplashAD splashAD = new SplashAD((Activity) context, this.f7754a.f7762a, aVar, 0);
            this.pPR = splashAD;
            splashAD.fetchAdOnly();
            ak akVar3 = this.pPm;
            if (akVar3 != null) {
                ((x) akVar3).a(this.f7754a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        SplashAD splashAD = this.pPR;
        if (splashAD != null) {
            splashAD.showAd(funAdView);
            return;
        }
        ah ahVar2 = this.pPn;
        if (ahVar2 != null) {
            ((aa) ahVar2).a(this.f7754a.f7762a, 0, "Custom error message: mSplashAD is null when show");
        }
    }
}
