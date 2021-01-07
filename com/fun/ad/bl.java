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
/* loaded from: classes15.dex */
public class bl extends bd {
    public TTBannerAd pKf;

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.BannerAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener
        public void onBannerAdLoad(TTBannerAd tTBannerAd) {
            m.a("CSJBannerAd onBannerAdLoad");
            bl blVar = bl.this;
            blVar.f8065b = false;
            blVar.pKf = tTBannerAd;
            ba baVar = blVar.pJV;
            if (baVar != null) {
                ((aj) baVar).b(blVar.f8064a.f8060a);
            }
            AdRipper.ripCSJ(tTBannerAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJBannerAd onError code: " + i + ", message: " + str);
            bl blVar = bl.this;
            blVar.f8065b = false;
            ba baVar = blVar.pJV;
            if (baVar != null) {
                ((aj) baVar).a(blVar.f8064a.f8060a, i, str);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class b implements TTBannerAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("CSJBannerAd onAdClicked type: " + i);
            bl blVar = bl.this;
            ax axVar = blVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(blVar.f8064a.f8060a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("CSJBannerAd onAdShow type: " + i);
            bl blVar = bl.this;
            ax axVar = blVar.pJW;
            if (axVar != null) {
                ((am) axVar).b(blVar.f8064a.f8060a, view, i);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class c implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f8071a;

        public c(View view) {
            this.f8071a = view;
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
            View view = this.f8071a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f8071a.getParent()).removeView(this.f8071a);
            }
            bl blVar = bl.this;
            ax axVar = blVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(blVar.f8064a.f8060a);
            }
        }
    }

    public bl(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pKf = null;
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eBP() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTBannerAd tTBannerAd = this.pKf;
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
        if (!this.f8065b) {
            this.f8065b = true;
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f8064a.f8060a).setSupportDeepLink(true);
            au.a aVar = this.f8064a;
            this.pJX.loadBannerAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).build(), new a());
            ba baVar2 = this.pJV;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f8064a.f8060a);
            }
        }
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTBannerAd tTBannerAd = this.pKf;
        if (tTBannerAd != null) {
            View bannerView = tTBannerAd.getBannerView();
            if (bannerView != null && bannerView.getParent() != null) {
                ((ViewGroup) bannerView.getParent()).removeView(bannerView);
            }
            if (bannerView != null) {
                funAdView.removeAllViews();
                funAdView.addView(bannerView);
            }
            this.pKf.setSlideIntervalTime(this.f8064a.f);
            this.pKf.setBannerInteractionListener(new b());
            this.pKf.setShowDislikeIcon(new c(bannerView));
            this.pKf.setDownloadListener(new bj(null));
        }
    }
}
