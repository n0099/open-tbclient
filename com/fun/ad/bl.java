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
/* loaded from: classes14.dex */
public class bl extends bd {
    public TTBannerAd pFF;

    /* loaded from: classes14.dex */
    public class a implements TTAdNative.BannerAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener
        public void onBannerAdLoad(TTBannerAd tTBannerAd) {
            m.a("CSJBannerAd onBannerAdLoad");
            bl blVar = bl.this;
            blVar.f7765b = false;
            blVar.pFF = tTBannerAd;
            ba baVar = blVar.pFv;
            if (baVar != null) {
                ((aj) baVar).b(blVar.f7764a.f7760a);
            }
            AdRipper.ripCSJ(tTBannerAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJBannerAd onError code: " + i + ", message: " + str);
            bl blVar = bl.this;
            blVar.f7765b = false;
            ba baVar = blVar.pFv;
            if (baVar != null) {
                ((aj) baVar).a(blVar.f7764a.f7760a, i, str);
            }
        }
    }

    /* loaded from: classes14.dex */
    public class b implements TTBannerAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("CSJBannerAd onAdClicked type: " + i);
            bl blVar = bl.this;
            ax axVar = blVar.pFw;
            if (axVar != null) {
                ((am) axVar).a(blVar.f7764a.f7760a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("CSJBannerAd onAdShow type: " + i);
            bl blVar = bl.this;
            ax axVar = blVar.pFw;
            if (axVar != null) {
                ((am) axVar).b(blVar.f7764a.f7760a, view, i);
            }
        }
    }

    /* loaded from: classes14.dex */
    public class c implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7771a;

        public c(View view) {
            this.f7771a = view;
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
            View view = this.f7771a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f7771a.getParent()).removeView(this.f7771a);
            }
            bl blVar = bl.this;
            ax axVar = blVar.pFw;
            if (axVar != null) {
                ((am) axVar).a(blVar.f7764a.f7760a);
            }
        }
    }

    public bl(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pFF = null;
    }

    @Override // com.fun.ad.bd
    public FunRippedAd exX() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTBannerAd tTBannerAd = this.pFF;
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
        if (!this.f7765b) {
            this.f7765b = true;
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f7764a.f7760a).setSupportDeepLink(true);
            au.a aVar = this.f7764a;
            this.pFx.loadBannerAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).build(), new a());
            ba baVar2 = this.pFv;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7764a.f7760a);
            }
        }
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTBannerAd tTBannerAd = this.pFF;
        if (tTBannerAd != null) {
            View bannerView = tTBannerAd.getBannerView();
            if (bannerView != null && bannerView.getParent() != null) {
                ((ViewGroup) bannerView.getParent()).removeView(bannerView);
            }
            if (bannerView != null) {
                funAdView.removeAllViews();
                funAdView.addView(bannerView);
            }
            this.pFF.setSlideIntervalTime(this.f7764a.f);
            this.pFF.setBannerInteractionListener(new b());
            this.pFF.setShowDislikeIcon(new c(bannerView));
            this.pFF.setDownloadListener(new bj(null));
        }
    }
}
