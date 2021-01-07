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
/* loaded from: classes15.dex */
public class ab extends bd {
    public TTSplashAd pJA;

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.SplashAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.a.b
        @MainThread
        public void onError(int i, String str) {
            m.a("CSJSplashAd onError code: " + i + ", message: " + str);
            ab abVar = ab.this;
            abVar.f8065b = false;
            ba baVar = abVar.pJV;
            if (baVar != null) {
                ((aj) baVar).a(abVar.f8064a.f8060a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            m.a("CSJSplashAd onSplashAdLoad");
            ab abVar = ab.this;
            abVar.f8065b = false;
            abVar.pJA = tTSplashAd;
            ba baVar = abVar.pJV;
            if (baVar != null) {
                ((aj) baVar).b(abVar.f8064a.f8060a);
            }
            AdRipper.ripCSJ(tTSplashAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            ab.this.f8065b = false;
            m.a("CSJSplashAd onTimeout");
            ab abVar = ab.this;
            ba baVar = abVar.pJV;
            if (baVar != null) {
                String str = abVar.f8064a.f8060a;
                aj ajVar = (aj) baVar;
                if (ajVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告加载超时，广告ID：" + str);
                p.a(ajVar.pJq, ajVar.pJp.getSid(), ajVar.f8050b.f8061b, str, 0, "Custom error message: Ad load onTimeout");
            }
        }
    }

    /* loaded from: classes15.dex */
    public class b implements TTSplashAd.AdInteractionListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("CSJSplashAd onAdClicked type: " + i);
            ab abVar = ab.this;
            ax axVar = abVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(abVar.f8064a.f8060a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("CSJSplashAd onAdShow type: " + i);
            ab abVar = ab.this;
            ax axVar = abVar.pJW;
            if (axVar != null) {
                ((am) axVar).b(abVar.f8064a.f8060a, view, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            m.a("CSJSplashAd onAdSkip");
            ab abVar = ab.this;
            ax axVar = abVar.pJW;
            if (axVar != null) {
                String str = abVar.f8064a.f8060a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onAdSkip，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = amVar.pJv;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(amVar.pJx.pJf.f8058a);
                }
                d.b bVar = d.pIU;
                ((d.a) bVar).a(amVar.f8051b, amVar.pJw.f8061b, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            m.a("CSJSplashAd onAdTimeOver");
            ab abVar = ab.this;
            ax axVar = abVar.pJW;
            if (axVar != null) {
                String str = abVar.f8064a.f8060a;
                am amVar = (am) axVar;
                if (amVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 穿山甲广告 onAdTimeOver，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = amVar.pJv;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(amVar.pJx.pJf.f8058a);
                }
                d.b bVar = d.pIU;
                ((d.a) bVar).a(amVar.f8051b, amVar.pJw.f8061b, str);
            }
        }
    }

    public ab(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pJA = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTSplashAd tTSplashAd = this.pJA;
        if (tTSplashAd == null) {
            return;
        }
        View splashView = tTSplashAd.getSplashView();
        if (splashView.getParent() != null) {
            ((ViewGroup) splashView.getParent()).removeView(splashView);
        }
        funAdView.removeAllViews();
        funAdView.addView(splashView);
        this.pJA.setSplashInteractionListener(new b());
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eBP() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTSplashAd tTSplashAd = this.pJA;
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

    public AdSlot eBS() {
        return new AdSlot.Builder().setCodeId(this.f8064a.f8060a).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).build();
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        super.a(context.getApplicationContext(), funAdSlot, baVar);
        if (!this.f8065b) {
            this.f8065b = true;
            this.pJX.loadSplashAd(eBS(), new a(), 5000);
            ba baVar2 = this.pJV;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f8064a.f8060a);
            }
        }
    }
}
