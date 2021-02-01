package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.fun.ad.sdk.R;
import java.util.List;
/* loaded from: classes6.dex */
public class bt extends bd {
    public TTFeedAd pPW;
    public TTNativeAd pPX;

    /* loaded from: classes6.dex */
    public class b implements TTNativeAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            m.a("CSJBannerNativeAd onAdClicked");
            bt btVar = bt.this;
            ax axVar = btVar.pPB;
            if (axVar != null) {
                ((am) axVar).a(btVar.f7766a.f7762a, view, tTNativeAd.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            m.a("CSJBannerNativeAd onAdCreativeClick");
            bt btVar = bt.this;
            ax axVar = btVar.pPB;
            if (axVar != null) {
                ((am) axVar).a(btVar.f7766a.f7762a, view, tTNativeAd.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            m.a("CSJBannerNativeAd onAdShow");
            bt btVar = bt.this;
            ax axVar = btVar.pPB;
            if (axVar != null) {
                ((am) axVar).b(btVar.f7766a.f7762a, null, tTNativeAd.getInteractionType());
            }
        }
    }

    public bt(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pPW = null;
        this.pPX = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        int i;
        super.a(activity, funAdView, axVar);
        b bVar = new b();
        TTFeedAd tTFeedAd = this.pPW;
        int imageMode = tTFeedAd != null ? tTFeedAd.getImageMode() : this.pPX.getImageMode();
        if (imageMode == 15) {
            i = R.layout.csj_ad_native_vertical_video_view;
        } else if (imageMode != 16) {
            switch (imageMode) {
                case 2:
                    i = R.layout.csj_ad_native_small_img_view;
                    break;
                case 3:
                    i = R.layout.csj_ad_native_large_img_view;
                    break;
                case 4:
                    i = R.layout.csj_ad_native_group_img_view;
                    break;
                case 5:
                    i = R.layout.csj_ad_native_large_video_view;
                    break;
                default:
                    return;
            }
        } else {
            i = R.layout.csj_ad_native_vertical_img_view;
        }
        f0 f0Var = (f0) LayoutInflater.from(activity).inflate(i, (ViewGroup) funAdView, false);
        f0Var.setAdViewWidth(funAdView.getWidth());
        funAdView.removeAllViews();
        funAdView.addView(f0Var);
        TTFeedAd tTFeedAd2 = this.pPW;
        if (tTFeedAd2 != null) {
            tTFeedAd2.setActivityForDownloadApp(activity);
            f0Var.a(activity, this.pPW, (TTNativeAd.AdInteractionListener) bVar);
            return;
        }
        this.pPX.setActivityForDownloadApp(activity);
        f0Var.a(activity, this.pPX, bVar);
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        super.a(context, funAdSlot, baVar);
        if (this.f7767b) {
            return;
        }
        this.f7767b = true;
        c();
    }

    public void c() {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f7766a.f7762a).setSupportDeepLink(true);
        au.a aVar = this.f7766a;
        this.pPC.loadNativeAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).setNativeAdType(1).setAdCount(1).build(), new a());
        ba baVar = this.pPA;
        if (baVar != null) {
            ((aj) baVar).a(this.f7766a.f7762a);
        }
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eAp() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTNativeAd tTNativeAd = this.pPX;
        if (tTNativeAd != null) {
            rippedCSJAd = AdRipper.getRippedCSJAd(tTNativeAd, false);
        } else {
            TTFeedAd tTFeedAd = this.pPW;
            rippedCSJAd = tTFeedAd != null ? AdRipper.getRippedCSJAd(tTFeedAd, false) : null;
        }
        if (rippedCSJAd == null) {
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

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.NativeAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJBannerNativeAd onError code: " + i + ", message: " + str);
            bt btVar = bt.this;
            btVar.f7767b = false;
            ba baVar = btVar.pPA;
            if (baVar != null) {
                ((aj) baVar).a(btVar.f7766a.f7762a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
        public void onNativeAdLoad(List<TTNativeAd> list) {
            m.a("CSJBannerNativeAd onNativeAdLoad");
            bt.this.f7767b = false;
            if (list != null && !list.isEmpty()) {
                bt.this.pPX = list.get(0);
                m.a("CSJBannerNativeAd onNativeAdLoad imageMode: " + bt.this.pPX.getImageMode());
                bt btVar = bt.this;
                ba baVar = btVar.pPA;
                if (baVar != null) {
                    ((aj) baVar).b(btVar.f7766a.f7762a);
                }
                AdRipper.ripCSJ(bt.this.pPX);
                return;
            }
            m.a("CSJBannerNativeAd onNativeAdLoad error: list is null or empty");
        }
    }
}
