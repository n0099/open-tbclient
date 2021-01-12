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
/* loaded from: classes14.dex */
public class at extends ac {
    public AdRipper.RippedKSAd pFe;
    public KsFeedAd pFl;

    /* loaded from: classes14.dex */
    public class b implements KsFeedAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f7757a;

        public b(View view) {
            this.f7757a = view;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            m.a("KSNativeExpressAd open app download onAdClicked");
            at atVar = at.this;
            w wVar = atVar.pFc;
            if (wVar != null) {
                ((ag) wVar).a(atVar.f7743a.f7760a);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            m.a("KSNativeExpressAd open app download onAdShow");
            at atVar = at.this;
            w wVar = atVar.pFc;
            if (wVar != null) {
                ((ag) wVar).c(atVar.f7743a.f7760a);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            m.a("KSNativeExpressAd open app onDislikeClicked");
            View view = this.f7757a;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f7757a.getParent()).removeView(this.f7757a);
            }
            at atVar = at.this;
            w wVar = atVar.pFc;
            if (wVar != null) {
                ((ag) wVar).b(atVar.f7743a.f7760a);
            }
        }
    }

    public at(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pFl = null;
        this.pFe = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd exX() {
        KsFeedAd ksFeedAd = this.pFl;
        if (ksFeedAd == null) {
            return null;
        }
        if (this.pFe == null) {
            this.pFe = AdRipper.getRippedKSAd((Object) ksFeedAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pFe;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pFe;
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
        if (!this.f7744b) {
            this.f7744b = true;
            KsAdSDK.getLoadManager().loadFeedAd(new KsScene.Builder(Long.parseLong(this.f7743a.f7760a)).adNum(1).build(), new a());
            z zVar2 = this.pFb;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f7743a.f7760a);
            }
        }
    }

    /* loaded from: classes14.dex */
    public class a implements KsLoadManager.FeedAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            m.a("KSNativeExpressAd onError code: " + i + ", message: " + str);
            at atVar = at.this;
            atVar.f7744b = false;
            z zVar = atVar.pFb;
            if (zVar != null) {
                ((ad) zVar).a(atVar.f7743a.f7760a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            m.a("KSNativeExpressAd onNativeAdLoad");
            at.this.f7744b = false;
            if (list != null && !list.isEmpty()) {
                at.this.pFl = list.get(0);
                at atVar = at.this;
                z zVar = atVar.pFb;
                if (zVar != null) {
                    ((ad) zVar).b(atVar.f7743a.f7760a);
                }
                AdRipper.ripKS(at.this.pFl);
                return;
            }
            m.a("KSNativeExpressAd onNativeAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsFeedAd ksFeedAd = this.pFl;
        if (ksFeedAd == null) {
            w wVar2 = this.pFc;
            if (wVar2 != null) {
                ((ag) wVar2).a(this.f7743a.f7760a, 0, "Custom error message: mKsFeedAd is null show");
                return;
            }
            return;
        }
        View feedView = ksFeedAd.getFeedView(activity);
        this.pFl.setAdInteractionListener(new b(feedView));
        this.pFl.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(d.f7776b).dataFlowAutoStart(d.c).build());
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
