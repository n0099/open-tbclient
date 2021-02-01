package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes6.dex */
public class at extends ac {
    public AdRipper.RippedKSAd pPk;
    public KsFeedAd pPr;

    /* loaded from: classes6.dex */
    public class b implements KsFeedAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7759a;

        public b(View view) {
            this.f7759a = view;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            m.a("KSNativeExpressAd open app download onAdClicked");
            at atVar = at.this;
            w wVar = atVar.pPi;
            if (wVar != null) {
                ((ag) wVar).a(atVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            m.a("KSNativeExpressAd open app download onAdShow");
            at atVar = at.this;
            w wVar = atVar.pPi;
            if (wVar != null) {
                ((ag) wVar).c(atVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            m.a("KSNativeExpressAd open app onDislikeClicked");
            View view = this.f7759a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f7759a.getParent()).removeView(this.f7759a);
            }
            at atVar = at.this;
            w wVar = atVar.pPi;
            if (wVar != null) {
                ((ag) wVar).b(atVar.f7745a.f7762a);
            }
        }
    }

    public at(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pPr = null;
        this.pPk = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eAp() {
        KsFeedAd ksFeedAd = this.pPr;
        if (ksFeedAd == null) {
            return null;
        }
        if (this.pPk == null) {
            this.pPk = AdRipper.getRippedKSAd((Object) ksFeedAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pPk;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pPk;
        funRippedAd.uniqueId = rippedKSAd2.adDescription;
        funRippedAd.appName = rippedKSAd2.appName;
        funRippedAd.appPackageName = rippedKSAd2.appPackageName;
        funRippedAd.appLinkUrl = rippedKSAd2.appDownloadUrl;
        funRippedAd.appMarketUrl = rippedKSAd2.marketUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.ac
    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        super.a(context.getApplicationContext(), funAdSlot, zVar);
        if (!this.f7746b) {
            this.f7746b = true;
            KsAdSDK.getLoadManager().loadFeedAd(new KsScene.Builder(Long.parseLong(this.f7745a.f7762a)).adNum(1).build(), new a());
            z zVar2 = this.pPh;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f7745a.f7762a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.FeedAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            m.a("KSNativeExpressAd onError code: " + i + ", message: " + str);
            at atVar = at.this;
            atVar.f7746b = false;
            z zVar = atVar.pPh;
            if (zVar != null) {
                ((ad) zVar).a(atVar.f7745a.f7762a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            m.a("KSNativeExpressAd onNativeAdLoad");
            at.this.f7746b = false;
            if (list != null && !list.isEmpty()) {
                at.this.pPr = list.get(0);
                at atVar = at.this;
                z zVar = atVar.pPh;
                if (zVar != null) {
                    ((ad) zVar).b(atVar.f7745a.f7762a);
                }
                AdRipper.ripKS(at.this.pPr);
                return;
            }
            m.a("KSNativeExpressAd onNativeAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsFeedAd ksFeedAd = this.pPr;
        if (ksFeedAd == null) {
            w wVar2 = this.pPi;
            if (wVar2 != null) {
                ((ag) wVar2).a(this.f7745a.f7762a, 0, "Custom error message: mKsFeedAd is null show");
                return;
            }
            return;
        }
        View feedView = ksFeedAd.getFeedView(activity);
        this.pPr.setAdInteractionListener(new b(feedView));
        this.pPr.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(d.f7778b).dataFlowAutoStart(d.c).build());
        if (feedView != null && feedView.getParent() != null) {
            ((ViewGroup) feedView.getParent()).removeView(feedView);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int i = (int) ((10.0f * activity.getResources().getDisplayMetrics().density) + 0.5f);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        funAdView.removeAllViews();
        funAdView.addView(feedView, layoutParams);
    }
}
