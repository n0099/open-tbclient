package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class bl extends bd {
    public TTBannerAd pQk;

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.BannerAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener
        public void onBannerAdLoad(TTBannerAd tTBannerAd) {
            m.a("CSJBannerAd onBannerAdLoad");
            bl blVar = bl.this;
            blVar.f7767b = false;
            blVar.pQk = tTBannerAd;
            ba baVar = blVar.pQa;
            if (baVar != null) {
                ((aj) baVar).b(blVar.f7766a.f7762a);
            }
            AdRipper.ripCSJ(tTBannerAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJBannerAd onError code: " + i + ", message: " + str);
            bl blVar = bl.this;
            blVar.f7767b = false;
            ba baVar = blVar.pQa;
            if (baVar != null) {
                ((aj) baVar).a(blVar.f7766a.f7762a, i, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TTBannerAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("CSJBannerAd onAdClicked type: " + i);
            bl blVar = bl.this;
            ax axVar = blVar.pQb;
            if (axVar != null) {
                ((am) axVar).a(blVar.f7766a.f7762a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("CSJBannerAd onAdShow type: " + i);
            bl blVar = bl.this;
            ax axVar = blVar.pQb;
            if (axVar != null) {
                ((am) axVar).b(blVar.f7766a.f7762a, view, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7773a;

        public c(View view) {
            this.f7773a = view;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
            m.a("CSJBannerAd dislike icon onCancel");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onRefuse() {
            m.a("CSJBannerAd dislike icon onRefuse");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str) {
            m.a("CSJBannerAd dislike icon onSelected position: " + i + ", value: " + str);
            View view = this.f7773a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f7773a.getParent()).removeView(this.f7773a);
            }
            bl blVar = bl.this;
            ax axVar = blVar.pQb;
            if (axVar != null) {
                ((am) axVar).a(blVar.f7766a.f7762a);
            }
        }
    }

    public bl(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pQk = null;
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eAx() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTBannerAd tTBannerAd = this.pQk;
        if (tTBannerAd == null || (rippedCSJAd = AdRipper.getRippedCSJAd(tTBannerAd, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedCSJAd.title;
        funRippedAd.description = rippedCSJAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedCSJAd.landingPageUrl);
        funRippedAd.uniqueId = rippedCSJAd.title;
        funRippedAd.appName = rippedCSJAd.appName;
        funRippedAd.appPackageName = rippedCSJAd.appPackageName;
        funRippedAd.appLinkUrl = rippedCSJAd.appLinkUrl;
        funRippedAd.appMarketUrl = rippedCSJAd.marketUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        super.a(context.getApplicationContext(), funAdSlot, baVar);
        if (!this.f7767b) {
            this.f7767b = true;
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f7766a.f7762a).setSupportDeepLink(true);
            au.a aVar = this.f7766a;
            this.pQc.loadBannerAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).build(), new a());
            ba baVar2 = this.pQa;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7766a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTBannerAd tTBannerAd = this.pQk;
        if (tTBannerAd != null) {
            View bannerView = tTBannerAd.getBannerView();
            if (bannerView != null && bannerView.getParent() != null) {
                ((ViewGroup) bannerView.getParent()).removeView(bannerView);
            }
            if (bannerView != null) {
                funAdView.removeAllViews();
                funAdView.addView(bannerView);
            }
            this.pQk.setSlideIntervalTime(this.f7766a.f);
            this.pQk.setBannerInteractionListener(new b());
            this.pQk.setShowDislikeIcon(new c(bannerView));
            this.pQk.setDownloadListener(new bj(null));
        }
    }
}
