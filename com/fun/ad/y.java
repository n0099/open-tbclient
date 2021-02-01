package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class y extends bd {
    public TTRewardVideoAd pPd;

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.RewardVideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJRewardVideoAd onError code: " + i + ", message: " + str);
            y yVar = y.this;
            yVar.f7767b = false;
            ba baVar = yVar.pPA;
            if (baVar != null) {
                ((aj) baVar).a(yVar.f7766a.f7762a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            m.a("CSJRewardVideoAd onRewardVideoAdLoad");
            y yVar = y.this;
            yVar.f7767b = false;
            yVar.pPd = tTRewardVideoAd;
            ba baVar = yVar.pPA;
            if (baVar != null) {
                ((aj) baVar).b(yVar.f7766a.f7762a);
            }
            AdRipper.ripCSJ(tTRewardVideoAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            m.a("CSJRewardVideoAd onRewardVideoCached");
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TTRewardVideoAd.RewardAdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            m.a("CSJRewardVideoAd onAdClose");
            y yVar = y.this;
            ax axVar = yVar.pPB;
            if (axVar != null) {
                ((am) axVar).a(yVar.f7766a.f7762a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            m.a("CSJRewardVideoAd onAdShow");
            y yVar = y.this;
            ax axVar = yVar.pPB;
            if (axVar != null) {
                ((am) axVar).b(yVar.f7766a.f7762a, null, yVar.pPd.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            m.a("CSJRewardVideoAd onAdVideoBarClick");
            y yVar = y.this;
            ax axVar = yVar.pPB;
            if (axVar != null) {
                ((am) axVar).a(yVar.f7766a.f7762a, null, yVar.pPd.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str) {
            m.a("CSJRewardVideoAd onRewardVerify rewardVerify: " + z + ", rewardAmount: " + i + ", rewardName: " + str);
            y yVar = y.this;
            ax axVar = yVar.pPB;
            if (axVar != null) {
                String str2 = yVar.f7766a.f7762a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onRewardedVideo，广告ID：" + str2);
                FunAdInteractionListener funAdInteractionListener = amVar.pPa;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(amVar.pPc.pOK.f7760a);
                }
                d.b bVar = d.pOz;
                ((d.a) bVar).e(amVar.f7753b, amVar.pPb.f7763b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
            m.a("CSJRewardVideoAd onSkippedVideo");
            ax axVar = y.this.pPB;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onSkippedVideo");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            m.a("CSJRewardVideoAd onVideoComplete");
            ax axVar = y.this.pPB;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onVideoComplete");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            m.a("CSJRewardVideoAd onVideoError");
            y yVar = y.this;
            ax axVar = yVar.pPB;
            if (axVar != null) {
                String str = yVar.f7766a.f7762a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onVideoError，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = amVar.pPa;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdError(amVar.pPc.pOK.f7760a);
                }
                d.b bVar = d.pOz;
                ((d.a) bVar).e(amVar.f7753b, amVar.pPb.f7763b, str, 0, "Custom error message: onVideoError");
            }
        }
    }

    public y(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pPd = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTRewardVideoAd tTRewardVideoAd = this.pPd;
        if (tTRewardVideoAd == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(new b());
        this.pPd.setDownloadListener(new bj(null));
        this.pPd.showRewardVideoAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eAp() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTRewardVideoAd tTRewardVideoAd = this.pPd;
        if (tTRewardVideoAd == null || (rippedCSJAd = AdRipper.getRippedCSJAd(tTRewardVideoAd, false)) == null) {
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
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.pPC.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.f7766a.f7762a).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setExpressViewAcceptedSize(d.a(context, displayMetrics.widthPixels), d.a(context, displayMetrics.heightPixels)).setUserID(null).setOrientation(this.f7766a.g != 0 ? 2 : 1).setMediaExtra("media_extra").build(), new a());
            ba baVar2 = this.pPA;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7766a.f7762a);
            }
        }
    }
}
