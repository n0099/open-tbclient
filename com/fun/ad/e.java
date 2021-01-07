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
/* loaded from: classes15.dex */
public class e extends bd {
    public TTInteractionAd pIV;

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.InteractionAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJInteractionAd onError code: " + i + ", message: " + str);
            e eVar = e.this;
            eVar.f8065b = false;
            ba baVar = eVar.pJV;
            if (baVar != null) {
                ((aj) baVar).a(eVar.f8064a.f8060a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
        public void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
            m.a("CSJInteractionAd onInteractionAdLoad");
            e eVar = e.this;
            eVar.f8065b = false;
            eVar.pIV = tTInteractionAd;
            ba baVar = eVar.pJV;
            if (baVar != null) {
                ((aj) baVar).b(eVar.f8064a.f8060a);
            }
            AdRipper.ripCSJ(tTInteractionAd);
        }
    }

    /* loaded from: classes15.dex */
    public class b implements TTInteractionAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdClicked() {
            m.a("CSJInteractionAd onAdClicked");
            e eVar = e.this;
            ax axVar = eVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(eVar.f8064a.f8060a, null, eVar.pIV.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdDismiss() {
            m.a("CSJInteractionAd onAdDismiss");
            e eVar = e.this;
            ax axVar = eVar.pJW;
            if (axVar != null) {
                ((am) axVar).b(eVar.f8064a.f8060a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdShow() {
            m.a("CSJInteractionAd onAdShow");
            e eVar = e.this;
            ax axVar = eVar.pJW;
            if (axVar != null) {
                ((am) axVar).b(eVar.f8064a.f8060a, null, eVar.pIV.getInteractionType());
            }
        }
    }

    public e(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pIV = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTInteractionAd tTInteractionAd = this.pIV;
        if (tTInteractionAd == null) {
            return;
        }
        tTInteractionAd.setAdInteractionListener(new b());
        this.pIV.setDownloadListener(new bj(null));
        this.pIV.showInteractionAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eBP() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTInteractionAd tTInteractionAd = this.pIV;
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
        if (!this.f8065b) {
            this.f8065b = true;
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f8064a.f8060a).setSupportDeepLink(true);
            au.a aVar = this.f8064a;
            this.pJX.loadInteractionAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).build(), new a());
            ba baVar2 = this.pJV;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f8064a.f8060a);
            }
        }
    }
}
