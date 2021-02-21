package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import java.util.List;
/* loaded from: classes6.dex */
public class bo extends bd {
    public TTNativeExpressAd pPc;

    /* loaded from: classes6.dex */
    public class b implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7775a;

        public b(View view) {
            this.f7775a = view;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
            m.a("CSJBannerExpressAd dislike callback onCancel");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onRefuse() {
            m.a("CSJBannerExpressAd dislike callback onRefuse");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str) {
            m.a("CSJBannerExpressAd dislike callback onSelected position: " + i + ", message: " + str);
            if (this.f7775a.getParent() != null) {
                ((ViewGroup) this.f7775a.getParent()).removeView(this.f7775a);
            }
            bo boVar = bo.this;
            ax axVar = boVar.pQb;
            if (axVar != null) {
                ((am) axVar).a(boVar.f7766a.f7762a);
            }
        }
    }

    public bo(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        TTNativeExpressAd tTNativeExpressAd = this.pPc;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.pPc = null;
        }
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eAx() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTNativeExpressAd tTNativeExpressAd = this.pPc;
        if (tTNativeExpressAd == null || (rippedCSJAd = AdRipper.getRippedCSJAd(tTNativeExpressAd, false)) == null) {
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
    public class a implements TTAdNative.NativeExpressAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            bo.this.f7767b = false;
            m.a("CSJBannerExpressAd onError code: " + i + ", message: " + str);
            bo boVar = bo.this;
            ba baVar = boVar.pQa;
            if (baVar != null) {
                ((aj) baVar).a(boVar.f7766a.f7762a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            m.a("CSJBannerExpressAd onNativeExpressAdLoad");
            if (list != null && !list.isEmpty()) {
                bo.this.pPc = list.get(0);
                AdRipper.ripCSJ(bo.this.pPc);
                bo boVar = bo.this;
                TTNativeExpressAd tTNativeExpressAd = boVar.pPc;
                tTNativeExpressAd.setExpressInteractionListener(new br(boVar));
                tTNativeExpressAd.render();
                return;
            }
            m.a("CSJBannerExpressAd onError: adList is null or empty");
        }
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        float expressWidth;
        super.a(context.getApplicationContext(), funAdSlot, baVar);
        if (!this.f7767b) {
            this.f7767b = true;
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f7766a.f7762a).setSupportDeepLink(true).setAdCount(1);
            if (funAdSlot.getExpressWidth() == 0) {
                expressWidth = this.f7766a.e;
            } else {
                expressWidth = funAdSlot.getExpressWidth();
            }
            this.pQc.loadBannerExpressAd(adCount.setExpressViewAcceptedSize(expressWidth, 0.0f).build(), new a());
            ba baVar2 = this.pQa;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7766a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTNativeExpressAd tTNativeExpressAd = this.pPc;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setSlideIntervalTime(this.f7766a.f);
        View expressAdView = this.pPc.getExpressAdView();
        if (expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        this.pPc.setDislikeCallback(activity, new b(expressAdView));
        this.pPc.setDownloadListener(new bj(null));
        funAdView.removeAllViews();
        funAdView.addView(expressAdView);
    }
}
