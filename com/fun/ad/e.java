package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class e extends bd {
    public TTInteractionAd pPa;

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.InteractionAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJInteractionAd onError code: " + i + ", message: " + str);
            e eVar = e.this;
            eVar.f7767b = false;
            ba baVar = eVar.pQa;
            if (baVar != null) {
                ((aj) baVar).a(eVar.f7766a.f7762a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
        public void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
            m.a("CSJInteractionAd onInteractionAdLoad");
            e eVar = e.this;
            eVar.f7767b = false;
            eVar.pPa = tTInteractionAd;
            ba baVar = eVar.pQa;
            if (baVar != null) {
                ((aj) baVar).b(eVar.f7766a.f7762a);
            }
            AdRipper.ripCSJ(tTInteractionAd);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TTInteractionAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdClicked() {
            m.a("CSJInteractionAd onAdClicked");
            e eVar = e.this;
            ax axVar = eVar.pQb;
            if (axVar != null) {
                ((am) axVar).a(eVar.f7766a.f7762a, null, eVar.pPa.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdDismiss() {
            m.a("CSJInteractionAd onAdDismiss");
            e eVar = e.this;
            ax axVar = eVar.pQb;
            if (axVar != null) {
                ((am) axVar).b(eVar.f7766a.f7762a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdShow() {
            m.a("CSJInteractionAd onAdShow");
            e eVar = e.this;
            ax axVar = eVar.pQb;
            if (axVar != null) {
                ((am) axVar).b(eVar.f7766a.f7762a, null, eVar.pPa.getInteractionType());
            }
        }
    }

    public e(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pPa = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTInteractionAd tTInteractionAd = this.pPa;
        if (tTInteractionAd == null) {
            return;
        }
        tTInteractionAd.setAdInteractionListener(new b());
        this.pPa.setDownloadListener(new bj(null));
        this.pPa.showInteractionAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eAx() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTInteractionAd tTInteractionAd = this.pPa;
        if (tTInteractionAd == null || (rippedCSJAd = AdRipper.getRippedCSJAd(tTInteractionAd, false)) == null) {
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
            this.pQc.loadInteractionAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).build(), new a());
            ba baVar2 = this.pQa;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7766a.f7762a);
            }
        }
    }
}
