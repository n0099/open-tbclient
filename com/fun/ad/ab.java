package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes14.dex */
public class ab extends bd {
    public TTSplashAd pEZ;

    /* loaded from: classes14.dex */
    public class a implements TTAdNative.SplashAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
        @MainThread
        public void onError(int i, String str) {
            m.a("CSJSplashAd onError code: " + i + ", message: " + str);
            ab abVar = ab.this;
            abVar.f7765b = false;
            ba baVar = abVar.pFu;
            if (baVar != null) {
                ((aj) baVar).a(abVar.f7764a.f7760a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            m.a("CSJSplashAd onSplashAdLoad");
            ab abVar = ab.this;
            abVar.f7765b = false;
            abVar.pEZ = tTSplashAd;
            ba baVar = abVar.pFu;
            if (baVar != null) {
                ((aj) baVar).b(abVar.f7764a.f7760a);
            }
            AdRipper.ripCSJ(tTSplashAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            ab.this.f7765b = false;
            m.a("CSJSplashAd onTimeout");
            ab abVar = ab.this;
            ba baVar = abVar.pFu;
            if (baVar != null) {
                String str = abVar.f7764a.f7760a;
                aj ajVar = (aj) baVar;
                if (ajVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告加载超时，广告ID：" + str);
                p.a(ajVar.pEP, ajVar.pEO.getSid(), ajVar.f7750b.f7761b, str, 0, "Custom error message: Ad load onTimeout");
            }
        }
    }

    /* loaded from: classes14.dex */
    public class b implements TTSplashAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("CSJSplashAd onAdClicked type: " + i);
            ab abVar = ab.this;
            ax axVar = abVar.pFv;
            if (axVar != null) {
                ((am) axVar).a(abVar.f7764a.f7760a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("CSJSplashAd onAdShow type: " + i);
            ab abVar = ab.this;
            ax axVar = abVar.pFv;
            if (axVar != null) {
                ((am) axVar).b(abVar.f7764a.f7760a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            m.a("CSJSplashAd onAdSkip");
            ab abVar = ab.this;
            ax axVar = abVar.pFv;
            if (axVar != null) {
                String str = abVar.f7764a.f7760a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onAdSkip，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = amVar.pEU;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(amVar.pEW.pEE.f7758a);
                }
                d.b bVar = d.pEt;
                ((d.a) bVar).a(amVar.f7751b, amVar.pEV.f7761b, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            m.a("CSJSplashAd onAdTimeOver");
            ab abVar = ab.this;
            ax axVar = abVar.pFv;
            if (axVar != null) {
                String str = abVar.f7764a.f7760a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onAdTimeOver，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = amVar.pEU;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(amVar.pEW.pEE.f7758a);
                }
                d.b bVar = d.pEt;
                ((d.a) bVar).a(amVar.f7751b, amVar.pEV.f7761b, str);
            }
        }
    }

    public ab(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pEZ = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTSplashAd tTSplashAd = this.pEZ;
        if (tTSplashAd == null) {
            return;
        }
        View splashView = tTSplashAd.getSplashView();
        if (splashView.getParent() != null) {
            ((ViewGroup) splashView.getParent()).removeView(splashView);
        }
        funAdView.removeAllViews();
        funAdView.addView(splashView);
        this.pEZ.setSplashInteractionListener(new b());
    }

    @Override // com.fun.ad.bd
    public FunRippedAd exX() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTSplashAd tTSplashAd = this.pEZ;
        if (tTSplashAd == null || (rippedCSJAd = AdRipper.getRippedCSJAd(tTSplashAd, false)) == null) {
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

    public AdSlot eya() {
        return new AdSlot.Builder().setCodeId(this.f7764a.f7760a).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).build();
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        super.a(context.getApplicationContext(), funAdSlot, baVar);
        if (!this.f7765b) {
            this.f7765b = true;
            this.pFw.loadSplashAd(eya(), new a(), 5000);
            ba baVar2 = this.pFu;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7764a.f7760a);
            }
        }
    }
}
