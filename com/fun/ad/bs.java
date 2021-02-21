package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
/* loaded from: classes6.dex */
public class bs extends an {
    public UnifiedBannerView pQu;

    /* loaded from: classes6.dex */
    public class a implements UnifiedBannerADListener {
        public a() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            m.a("GDTBannerAd onADClicked 广告点击");
            bs bsVar = bs.this;
            ah ahVar = bsVar.pPN;
            if (ahVar != null) {
                ((aa) ahVar).c(bsVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            m.a("GDTBannerAd onADCloseOverlay");
            ah ahVar = bs.this.pPN;
            if (ahVar != null) {
                aa aaVar = (aa) ahVar;
                m.a("GDTAdLoaderFactory onADCloseOverlay");
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            m.a("GDTBannerAd onADClosed 广告关闭");
            bs bsVar = bs.this;
            ah ahVar = bsVar.pPN;
            if (ahVar != null) {
                ((aa) ahVar).a(bsVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            m.a("GDTBannerAd onADExposure 广告展示成功");
            bs bsVar = bs.this;
            ah ahVar = bsVar.pPN;
            if (ahVar != null) {
                ((aa) ahVar).d(bsVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            m.a("GDTBannerAd onADLeftApplication");
            ah ahVar = bs.this.pPN;
            if (ahVar != null) {
                if (((aa) ahVar) == null) {
                    throw null;
                }
                m.a("GDTAdLoaderFactory onADLeftApplication");
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADOpenOverlay() {
            m.a("GDTBannerAd onADOpenOverlay");
            ah ahVar = bs.this.pPN;
            if (ahVar != null) {
                aa aaVar = (aa) ahVar;
                m.a("GDTAdLoaderFactory onADOpenOverlay");
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            m.a("GDTBannerAd onADReceiv 广告加载成功");
            bs bsVar = bs.this;
            bsVar.f7755b = false;
            ak akVar = bsVar.pPM;
            if (akVar != null) {
                ((x) akVar).b(bsVar.f7754a.f7762a);
            }
            AdRipper.ripGDTUnifiedBanner(bs.this.pQu);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            bs.this.f7755b = false;
            m.a("GDTBannerAd onNoAD 广告加载错误");
            bs bsVar = bs.this;
            ak akVar = bsVar.pPM;
            if (akVar != null) {
                ((x) akVar).a(bsVar.f7754a.f7762a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    public bs(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        UnifiedBannerView unifiedBannerView = this.pQu;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
            this.pQu = null;
        }
    }

    @Override // com.fun.ad.an
    public FunRippedAd eAx() {
        AdRipper.RippedGDTAd rippedGDTUnifiedBannerAd;
        UnifiedBannerView unifiedBannerView = this.pQu;
        if (unifiedBannerView == null || (rippedGDTUnifiedBannerAd = AdRipper.getRippedGDTUnifiedBannerAd(unifiedBannerView, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedGDTUnifiedBannerAd.title;
        funRippedAd.description = rippedGDTUnifiedBannerAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTUnifiedBannerAd.customized_invoke_url);
        funRippedAd.uniqueId = rippedGDTUnifiedBannerAd.title;
        funRippedAd.appName = rippedGDTUnifiedBannerAd.appName;
        funRippedAd.appPackageName = rippedGDTUnifiedBannerAd.appPackageName;
        funRippedAd.appLinkUrl = rippedGDTUnifiedBannerAd.appLinkUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        super.a(context.getApplicationContext(), funAdSlot, akVar);
        if (!this.f7755b) {
            this.f7755b = true;
            m.a("GDTBannerAd load adId: " + this.f7754a);
            a aVar = new a();
            if (!(context instanceof Activity)) {
                this.f7755b = false;
                m.a("GDTBannerAd context is not activity");
                ak akVar2 = this.pPM;
                if (akVar2 != null) {
                    ((x) akVar2).a(this.f7754a.f7762a, 0, "Custom error message: context is not activity");
                    return;
                }
                return;
            }
            UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.f7754a.f7762a, aVar);
            unifiedBannerView.setRefresh(this.f7754a.f);
            unifiedBannerView.loadAD();
            this.pQu = unifiedBannerView;
            ak akVar3 = this.pPM;
            if (akVar3 != null) {
                ((x) akVar3).a(this.f7754a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        UnifiedBannerView unifiedBannerView = this.pQu;
        if (unifiedBannerView == null) {
            ah ahVar2 = this.pPN;
            if (ahVar2 != null) {
                ((aa) ahVar2).a(this.f7754a.f7762a, 0, "Custom error message: mUnifiedBannerView is null when show");
                return;
            }
            return;
        }
        if (unifiedBannerView.getParent() != null) {
            ((ViewGroup) this.pQu.getParent()).removeView(this.pQu);
        }
        funAdView.removeAllViews();
        int width = funAdView.getWidth();
        funAdView.addView(this.pQu, new FrameLayout.LayoutParams(width, Math.round(width / 6.4f)));
    }
}
