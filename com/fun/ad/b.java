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
    public TTFullScreenVideoAd pHk;

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.FullScreenVideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJFullscreenVideoAd onError code: " + i + ", message: " + str);
            b bVar = b.this;
            bVar.f8064b = false;
            ba baVar = bVar.pIn;
            if (baVar != null) {
                ((aj) baVar).a(bVar.f8063a.f8059a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            m.a("CSJFullscreenVideoAd onFullScreenVideoAdLoad");
            b bVar = b.this;
            bVar.f8064b = false;
            bVar.pHk = tTFullScreenVideoAd;
            ba baVar = bVar.pIn;
            if (baVar != null) {
                ((aj) baVar).b(bVar.f8063a.f8059a);
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
    public class C1028b implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public C1028b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            m.a("CSJFullscreenVideoAd onAdClose");
            b bVar = b.this;
            ax axVar = bVar.pIo;
            if (axVar != null) {
                ((am) axVar).a(bVar.f8063a.f8059a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            m.a("CSJFullscreenVideoAd onAdShow");
            b bVar = b.this;
            ax axVar = bVar.pIo;
            if (axVar != null) {
                ((am) axVar).b(bVar.f8063a.f8059a, null, bVar.pHk.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            m.a("CSJFullscreenVideoAd onAdVideoBarClick");
            b bVar = b.this;
            ax axVar = bVar.pIo;
            if (axVar != null) {
                ((am) axVar).a(bVar.f8063a.f8059a, null, bVar.pHk.getInteractionType());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            m.a("CSJFullscreenVideoAd onSkippedVideo");
            ax axVar = b.this.pIo;
            if (axVar != null) {
                am amVar = (am) axVar;
                m.a("CJSAdLoaderFactory onSkippedVideo");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            m.a("CSJFullscreenVideoAd onVideoComplete");
            ax axVar = b.this.pIo;
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
        this.pHk = null;
    }

    @Override // com.fun.ad.bd
    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        super.a(activity, funAdView, axVar);
        TTFullScreenVideoAd tTFullScreenVideoAd = this.pHk;
        if (tTFullScreenVideoAd == null) {
            return;
        }
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new C1028b());
        this.pHk.setDownloadListener(new bj(null));
        this.pHk.showFullScreenVideoAd(activity);
    }

    @Override // com.fun.ad.bd
    public FunRippedAd eBl() {
        AdRipper.RippedCSJAd rippedCSJAd;
        TTFullScreenVideoAd tTFullScreenVideoAd = this.pHk;
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
        if (!this.f8064b) {
            this.f8064b = true;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.pIp.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f8063a.f8059a).setExpressViewAcceptedSize(d.a(context, displayMetrics.widthPixels), d.a(context, displayMetrics.heightPixels)).setSupportDeepLink(true).setOrientation(this.f8063a.g != 0 ? 2 : 1).build(), new a());
            ba baVar2 = this.pIn;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f8063a.f8059a);
            }
        }
    }
}
