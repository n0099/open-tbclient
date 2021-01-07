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
/* loaded from: classes15.dex */
public class bs extends an {
    public UnifiedBannerView pKp;

    /* loaded from: classes15.dex */
    public class a implements UnifiedBannerADListener {
        public a() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            m.a("GDTBannerAd onADClicked 广告点击");
            bs bsVar = bs.this;
            ah ahVar = bsVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).c(bsVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADCloseOverlay() {
            m.a("GDTBannerAd onADCloseOverlay");
            ah ahVar = bs.this.pJI;
            if (ahVar != null) {
                aa aaVar = (aa) ahVar;
                m.a("GDTAdLoaderFactory onADCloseOverlay");
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            m.a("GDTBannerAd onADClosed 广告关闭");
            bs bsVar = bs.this;
            ah ahVar = bsVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).a(bsVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            m.a("GDTBannerAd onADExposure 广告展示成功");
            bs bsVar = bs.this;
            ah ahVar = bsVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).d(bsVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            m.a("GDTBannerAd onADLeftApplication");
            ah ahVar = bs.this.pJI;
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
            ah ahVar = bs.this.pJI;
            if (ahVar != null) {
                aa aaVar = (aa) ahVar;
                m.a("GDTAdLoaderFactory onADOpenOverlay");
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            m.a("GDTBannerAd onADReceiv 广告加载成功");
            bs bsVar = bs.this;
            bsVar.f8053b = false;
            ak akVar = bsVar.pJH;
            if (akVar != null) {
                ((x) akVar).b(bsVar.f8052a.f8060a);
            }
            AdRipper.ripGDTUnifiedBanner(bs.this.pKp);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            bs.this.f8053b = false;
            m.a("GDTBannerAd onNoAD 广告加载错误");
            bs bsVar = bs.this;
            ak akVar = bsVar.pJH;
            if (akVar != null) {
                ((x) akVar).a(bsVar.f8052a.f8060a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }
    }

    public bs(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        UnifiedBannerView unifiedBannerView = this.pKp;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
            this.pKp = null;
        }
    }

    @Override // com.fun.ad.an
    public FunRippedAd eBP() {
        AdRipper.RippedGDTAd rippedGDTUnifiedBannerAd;
        UnifiedBannerView unifiedBannerView = this.pKp;
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
        if (!this.f8053b) {
            this.f8053b = true;
            m.a("GDTBannerAd load adId: " + this.f8052a);
            a aVar = new a();
            if (!(context instanceof Activity)) {
                this.f8053b = false;
                m.a("GDTBannerAd context is not activity");
                ak akVar2 = this.pJH;
                if (akVar2 != null) {
                    ((x) akVar2).a(this.f8052a.f8060a, 0, "Custom error message: context is not activity");
                    return;
                }
                return;
            }
            UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, this.f8052a.f8060a, aVar);
            unifiedBannerView.setRefresh(this.f8052a.f);
            unifiedBannerView.loadAD();
            this.pKp = unifiedBannerView;
            ak akVar3 = this.pJH;
            if (akVar3 != null) {
                ((x) akVar3).a(this.f8052a.f8060a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        UnifiedBannerView unifiedBannerView = this.pKp;
        if (unifiedBannerView == null) {
            ah ahVar2 = this.pJI;
            if (ahVar2 != null) {
                ((aa) ahVar2).a(this.f8052a.f8060a, 0, "Custom error message: mUnifiedBannerView is null when show");
                return;
            }
            return;
        }
        if (unifiedBannerView.getParent() != null) {
            ((ViewGroup) this.pKp.getParent()).removeView(this.pKp);
        }
        funAdView.removeAllViews();
        int width = funAdView.getWidth();
        funAdView.addView(this.pKp, new FrameLayout.LayoutParams(width, Math.round(width / 6.4f)));
    }
}
