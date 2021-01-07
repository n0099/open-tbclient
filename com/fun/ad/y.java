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
/* loaded from: classes15.dex */
public class y extends bd {
    public TTRewardVideoAd pJy;

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.RewardVideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJRewardVideoAd onError code: " + i + ", message: " + str);
            y yVar = y.this;
            yVar.f8065b = false;
            ba baVar = yVar.pJV;
            if (baVar != null) {
                ((aj) baVar).a(yVar.f8064a.f8060a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            m.a("CSJRewardVideoAd onRewardVideoAdLoad");
            y yVar = y.this;
            yVar.f8065b = false;
            yVar.pJy = tTRewardVideoAd;
            ba baVar = yVar.pJV;
            if (baVar != null) {
                ((aj) baVar).b(yVar.f8064a.f8060a);
            }
            AdRipper.ripCSJ(tTRewardVideoAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            m.a("CSJRewardVideoAd onRewardVideoCached");
        }
    }

    /* loaded from: classes15.dex */
    public class b implements TTRewardVideoAd.RewardAdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            m.a("CSJRewardVideoAd onAdClose");
            y yVar = y.this;
            ax axVar = yVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(yVar.f8064a.f8060a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            m.a("CSJRewardVideoAd onAdShow");
            y yVar = y.this;
            ax axVar = yVar.pJW;
            if (axVar != null) {
                ((am) axVar).b(yVar.f8064a.f8060a, null, yVar.pJy.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            m.a("CSJRewardVideoAd onAdVideoBarClick");
            y yVar = y.this;
            ax axVar = yVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(yVar.f8064a.f8060a, null, yVar.pJy.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str) {
            m.a("CSJRewardVideoAd onRewardVerify rewardVerify: " + z + ", rewardAmount: " + i + ", rewardName: " + str);
            y yVar = y.this;
            ax axVar = yVar.pJW;
            if (axVar != null) {
                String str2 = yVar.f8064a.f8060a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onRewardedVideo，广告ID：" + str2);
                FunAdInteractionListener funAdInteractionListener = amVar.pJv;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(amVar.pJx.pJf.f8058a);
                }
                d.b bVar = d.pIU;
                ((d.a) bVar).e(amVar.f8051b, amVar.pJw.f8061b, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
            m.a("CSJRewardVideoAd onSkippedVideo");
            ax axVar = y.this.pJW;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onSkippedVideo");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            m.a("CSJRewardVideoAd onVideoComplete");
            ax axVar = y.this.pJW;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onVideoComplete");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            m.a("CSJRewardVideoAd onVideoError");
            y yVar = y.this;
            ax axVar = yVar.pJW;
            if (axVar != null) {
                String str = yVar.f8064a.f8060a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onVideoError，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = amVar.pJv;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdError(amVar.pJx.pJf.f8058a);
                }
                d.b bVar = d.pIU;
                ((d.a) bVar).e(amVar.f8051b, amVar.pJw.f8061b, str, 0, "Custom error message: onVideoError");
            }
        }
    }

    public y(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pJy = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTRewardVideoAd tTRewardVideoAd = this.pJy;
        if (tTRewardVideoAd == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(new b());
        this.pJy.setDownloadListener(new bj(null));
        this.pJy.showRewardVideoAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eBP() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTRewardVideoAd tTRewardVideoAd = this.pJy;
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
        if (!this.f8065b) {
            this.f8065b = true;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.pJX.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.f8064a.f8060a).setSupportDeepLink(true).setRewardName("Coin").setRewardAmount(1).setExpressViewAcceptedSize(d.a(context, displayMetrics.widthPixels), d.a(context, displayMetrics.heightPixels)).setUserID(null).setOrientation(this.f8064a.g != 0 ? 2 : 1).setMediaExtra("media_extra").build(), new a());
            ba baVar2 = this.pJV;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f8064a.f8060a);
            }
        }
    }
}
