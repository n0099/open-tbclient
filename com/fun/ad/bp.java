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
/* loaded from: classes15.dex */
public class bp extends an {
    public SplashAD pKm;

    /* loaded from: classes15.dex */
    public class a implements SplashADListener {
        public a() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            m.a("GDTSplashAd onADClicked");
            bp bpVar = bp.this;
            ah ahVar = bpVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).c(bpVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            m.a("GDTSplashAd onADDismissed");
            bp bpVar = bp.this;
            ah ahVar = bpVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).a(bpVar.f8052a.f8060a);
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
            bpVar.f8053b = false;
            ak akVar = bpVar.pJH;
            if (akVar != null) {
                ((x) akVar).b(bpVar.f8052a.f8060a);
            }
            AdRipper.ripGDTSplash(bp.this.pKm);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            m.a("GDTSplashAd onADPresent");
            bp bpVar = bp.this;
            ah ahVar = bpVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).d(bpVar.f8052a.f8060a);
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
            bpVar.f8053b = false;
            ak akVar = bpVar.pJH;
            if (akVar != null) {
                ((x) akVar).a(bpVar.f8052a.f8060a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    public bp(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        this.pKm = null;
    }

    @Override // com.fun.ad.an
    public FunRippedAd eBP() {
        AdRipper.RippedGDTAd rippedGDTSplashAd;
        SplashAD splashAD = this.pKm;
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
        if (!this.f8053b) {
            this.f8053b = true;
            a aVar = new a();
            if (!(context instanceof Activity)) {
                m.a("GDTSplashAd context is not activity");
                this.f8053b = false;
                ak akVar2 = this.pJH;
                if (akVar2 != null) {
                    ((x) akVar2).a(this.f8052a.f8060a, 0, "Custom error message: context is not activity");
                    return;
                }
                return;
            }
            SplashAD splashAD = new SplashAD((Activity) context, this.f8052a.f8060a, aVar, 0);
            this.pKm = splashAD;
            splashAD.fetchAdOnly();
            ak akVar3 = this.pJH;
            if (akVar3 != null) {
                ((x) akVar3).a(this.f8052a.f8060a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        SplashAD splashAD = this.pKm;
        if (splashAD != null) {
            splashAD.showAd(funAdView);
            return;
        }
        ah ahVar2 = this.pJI;
        if (ahVar2 != null) {
            ((aa) ahVar2).a(this.f8052a.f8060a, 0, "Custom error message: mSplashAD is null when show");
        }
    }
}
