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
/* loaded from: classes14.dex */
public class e extends bd {
    public TTInteractionAd pEv;

    /* loaded from: classes14.dex */
    public class a implements TTAdNative.InteractionAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJInteractionAd onError code: " + i + ", message: " + str);
            e eVar = e.this;
            eVar.f7765b = false;
            ba baVar = eVar.pFv;
            if (baVar != null) {
                ((aj) baVar).a(eVar.f7764a.f7760a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
        public void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
            m.a("CSJInteractionAd onInteractionAdLoad");
            e eVar = e.this;
            eVar.f7765b = false;
            eVar.pEv = tTInteractionAd;
            ba baVar = eVar.pFv;
            if (baVar != null) {
                ((aj) baVar).b(eVar.f7764a.f7760a);
            }
            AdRipper.ripCSJ(tTInteractionAd);
        }
    }

    /* loaded from: classes14.dex */
    public class b implements TTInteractionAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdClicked() {
            m.a("CSJInteractionAd onAdClicked");
            e eVar = e.this;
            ax axVar = eVar.pFw;
            if (axVar != null) {
                ((am) axVar).a(eVar.f7764a.f7760a, null, eVar.pEv.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdDismiss() {
            m.a("CSJInteractionAd onAdDismiss");
            e eVar = e.this;
            ax axVar = eVar.pFw;
            if (axVar != null) {
                ((am) axVar).b(eVar.f7764a.f7760a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdShow() {
            m.a("CSJInteractionAd onAdShow");
            e eVar = e.this;
            ax axVar = eVar.pFw;
            if (axVar != null) {
                ((am) axVar).b(eVar.f7764a.f7760a, null, eVar.pEv.getInteractionType());
            }
        }
    }

    public e(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pEv = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTInteractionAd tTInteractionAd = this.pEv;
        if (tTInteractionAd == null) {
            return;
        }
        tTInteractionAd.setAdInteractionListener(new b());
        this.pEv.setDownloadListener(new bj(null));
        this.pEv.showInteractionAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd exX() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTInteractionAd tTInteractionAd = this.pEv;
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
        if (!this.f7765b) {
            this.f7765b = true;
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f7764a.f7760a).setSupportDeepLink(true);
            au.a aVar = this.f7764a;
            this.pFx.loadInteractionAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).build(), new a());
            ba baVar2 = this.pFv;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7764a.f7760a);
            }
        }
    }
}
