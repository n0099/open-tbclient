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
/* loaded from: classes14.dex */
public class s extends bd {
    public TTNativeExpressAd pEx;

    /* loaded from: classes14.dex */
    public class b implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7788a;

        public b(View view) {
            this.f7788a = view;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
            m.a("CSJNativeExpressAd dislike callback onCancel");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onRefuse() {
            m.a("CSJNativeExpressAd dislike callback onRefuse");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str) {
            m.a("CSJNativeExpressAd dislike callback onSelected position: " + i + ", message: " + str);
            View view = this.f7788a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f7788a.getParent()).removeView(this.f7788a);
            }
            s sVar = s.this;
            ax axVar = sVar.pFw;
            if (axVar != null) {
                ((am) axVar).a(sVar.f7764a.f7760a);
            }
        }
    }

    public s(au.a aVar) {
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
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView != null && expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        this.pEx.setDislikeCallback(activity, new b(expressAdView));
        this.pEx.setDownloadListener(new bj(null));
        funAdView.removeAllViews();
        funAdView.addView(expressAdView);
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
            m.a("CSJNativeExpressAd onError code: " + i + ", message: " + str);
            s sVar = s.this;
            sVar.f7765b = false;
            ba baVar = sVar.pFv;
            if (baVar != null) {
                ((aj) baVar).a(sVar.f7764a.f7760a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            m.a("CSJNativeExpressAd onNativeExpressAdLoad");
            if (list != null && !list.isEmpty()) {
                s.this.pEx = list.get(0);
                AdRipper.ripCSJ(s.this.pEx);
                s sVar = s.this;
                TTNativeExpressAd tTNativeExpressAd = sVar.pEx;
                tTNativeExpressAd.setExpressInteractionListener(new v(sVar));
                tTNativeExpressAd.setCanInterruptVideoPlay(true);
                tTNativeExpressAd.render();
                return;
            }
            m.a("CSJNativeExpressAd onNativeExpressAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.bd
    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        float expressWidth;
        super.a(context, funAdSlot, baVar);
        if (!this.f7765b) {
            this.f7765b = true;
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f7764a.f7760a).setSupportDeepLink(true).setAdCount(1);
            if (funAdSlot.getExpressWidth() == 0) {
                expressWidth = this.f7764a.e;
            } else {
                expressWidth = funAdSlot.getExpressWidth();
            }
            this.pFx.loadNativeExpressAd(adCount.setExpressViewAcceptedSize(expressWidth, 0.0f).build(), new a());
            ba baVar2 = this.pFv;
            if (baVar2 != null) {
                ((aj) baVar2).a(this.f7764a.f7760a);
            }
        }
    }
}
