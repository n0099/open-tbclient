package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public class b extends bd {
    public TTFullScreenVideoAd pIS;

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.FullScreenVideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJFullscreenVideoAd onError code: " + i + ", message: " + str);
            b bVar = b.this;
            bVar.f8065b = false;
            ba baVar = bVar.pJV;
            if (baVar != null) {
                ((aj) baVar).a(bVar.f8064a.f8060a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            m.a("CSJFullscreenVideoAd onFullScreenVideoAdLoad");
            b bVar = b.this;
            bVar.f8065b = false;
            bVar.pIS = tTFullScreenVideoAd;
            ba baVar = bVar.pJV;
            if (baVar != null) {
                ((aj) baVar).b(bVar.f8064a.f8060a);
            }
            AdRipper.ripCSJ(tTFullScreenVideoAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            m.a("CSJFullscreenVideoAd onFullScreenVideoCached");
        }
    }

    /* renamed from: com.fun.ad.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C1069b implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public C1069b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            m.a("CSJFullscreenVideoAd onAdClose");
            b bVar = b.this;
            ax axVar = bVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(bVar.f8064a.f8060a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            m.a("CSJFullscreenVideoAd onAdShow");
            b bVar = b.this;
            ax axVar = bVar.pJW;
            if (axVar != null) {
                ((am) axVar).b(bVar.f8064a.f8060a, null, bVar.pIS.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            m.a("CSJFullscreenVideoAd onAdVideoBarClick");
            b bVar = b.this;
            ax axVar = bVar.pJW;
            if (axVar != null) {
                ((am) axVar).a(bVar.f8064a.f8060a, null, bVar.pIS.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            m.a("CSJFullscreenVideoAd onSkippedVideo");
            ax axVar = b.this.pJW;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onSkippedVideo");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            m.a("CSJFullscreenVideoAd onVideoComplete");
            ax axVar = b.this.pJW;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onVideoComplete");
            }
        }
    }

    public b(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bd
    public void a() {
        super.a();
        this.pIS = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTFullScreenVideoAd tTFullScreenVideoAd = this.pIS;
        if (tTFullScreenVideoAd == null) {
            return;
        }
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new C1069b());
        this.pIS.setDownloadListener(new bj(null));
        this.pIS.showFullScreenVideoAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eBP() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTFullScreenVideoAd tTFullScreenVideoAd = this.pIS;
        if (tTFullScreenVideoAd == null || (rippedCSJAd = AdRipper.getRippedCSJAd(tTFullScreenVideoAd, false)) == null) {
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
            this.pJX.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f8064a.f8060a).setExpressViewAcceptedSize(d.a(context, displayMetrics.widthPixels), d.a(context, displayMetrics.heightPixels)).setSupportDeepLink(true).setOrientation(this.f8064a.g != 0 ? 2 : 1).build(), new a());
            ba baVar2 = this.pJV;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f8064a.f8060a);
            }
        }
    }
}
