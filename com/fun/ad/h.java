package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import java.util.List;
/* loaded from: classes14.dex */
public class h extends bd {
    public TTNativeExpressAd pEx;

    public h(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        TTNativeExpressAd tTNativeExpressAd = this.pEx;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.pEx = null;
        }
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTNativeExpressAd tTNativeExpressAd = this.pEx;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setDownloadListener(new bj(null));
        this.pEx.showInteractionExpressAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd exX() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTNativeExpressAd tTNativeExpressAd = this.pEx;
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

    /* loaded from: classes14.dex */
    public class a implements TTAdNative.NativeExpressAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJInteractionExpressAd onError code: " + i + ", message: " + str);
            h hVar = h.this;
            hVar.f7765b = false;
            ba baVar = hVar.pFv;
            if (baVar != null) {
                ((aj) baVar).a(hVar.f7764a.f7760a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            m.a("CSJInteractionExpressAd onNativeExpressAdLoad");
            if (list != null && !list.isEmpty()) {
                h.this.pEx = list.get(0);
                AdRipper.ripCSJ(h.this.pEx);
                h hVar = h.this;
                TTNativeExpressAd tTNativeExpressAd = hVar.pEx;
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) new k(hVar));
                tTNativeExpressAd.render();
                return;
            }
            m.a("CSJInteractionExpressAd onNativeExpressAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        float expressWidth;
        super.a(context.getApplicationContext(), funAdSlot, baVar);
        if (!this.f7765b) {
            this.f7765b = true;
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f7764a.f7760a).setSupportDeepLink(true).setAdCount(1);
            if (funAdSlot.getExpressWidth() == 0) {
                expressWidth = this.f7764a.e;
            } else {
                expressWidth = funAdSlot.getExpressWidth();
            }
            this.pFx.loadInteractionExpressAd(adCount.setExpressViewAcceptedSize(expressWidth, 0.0f).build(), new a());
            ba baVar2 = this.pFv;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7764a.f7760a);
            }
        }
    }
}
