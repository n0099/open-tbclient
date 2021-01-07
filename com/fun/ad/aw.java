package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
/* loaded from: classes15.dex */
public class aw extends ac {
    public AdRipper.RippedKSAd pJF;
    public KsRewardVideoAd pJR;

    /* loaded from: classes15.dex */
    public class b implements KsRewardVideoAd.RewardAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onAdClicked() {
            m.a("KSFullscreenVideoAd 激励视频广告点击");
            aw awVar = aw.this;
            w wVar = awVar.pJD;
            if (wVar != null) {
                ((ag) wVar).a(awVar.f8043a.f8060a);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onPageDismiss() {
            m.a("KSFullscreenVideoAd 激励视频广告点击");
            aw awVar = aw.this;
            w wVar = awVar.pJD;
            if (wVar != null) {
                ((ag) wVar).d(awVar.f8043a.f8060a);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify() {
            m.a("KSFullscreenVideoAd 激励视频广告获取激励");
            aw awVar = aw.this;
            w wVar = awVar.pJD;
            if (wVar != null) {
                String str = awVar.f8043a.f8060a;
                ag agVar = (ag) wVar;
                if (agVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 快手广告 onRewardedVideo，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = agVar.pJv;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(agVar.pJx.pJf.f8058a);
                }
                d.b bVar = d.pIU;
                ((d.a) bVar).e(agVar.f8047b, agVar.pJw.f8061b, str);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayEnd() {
            m.a("KSFullscreenVideoAd 激励视频广告播放完成");
            w wVar = aw.this.pJD;
            if (wVar != null) {
                ag agVar = (ag) wVar;
                m.a("KSAdLoaderFactory onVideoPlayEnd");
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            m.a("KSFullscreenVideoAd 激励视频广告播放出错");
            aw awVar = aw.this;
            w wVar = awVar.pJD;
            if (wVar != null) {
                ((ag) wVar).e(awVar.f8043a.f8060a);
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayStart() {
            m.a("KSFullscreenVideoAd 激励视频广告播放开始");
            aw awVar = aw.this;
            w wVar = awVar.pJD;
            if (wVar != null) {
                String str = awVar.f8043a.f8060a;
                ag agVar = (ag) wVar;
                m.a("KSAdLoaderFactory onVideoPlayStart");
            }
            aw awVar2 = aw.this;
            w wVar2 = awVar2.pJD;
            if (wVar2 != null) {
                ((ag) wVar2).c(awVar2.f8043a.f8060a);
            }
        }
    }

    public aw(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pJR = null;
        this.pJF = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eBP() {
        KsRewardVideoAd ksRewardVideoAd = this.pJR;
        if (ksRewardVideoAd == null) {
            return null;
        }
        if (this.pJF == null) {
            this.pJF = AdRipper.getRippedKSAd((Object) ksRewardVideoAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pJF;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pJF;
        funRippedAd.uniqueId = rippedKSAd2.adDescription;
        funRippedAd.appName = rippedKSAd2.appName;
        funRippedAd.appPackageName = rippedKSAd2.appPackageName;
        funRippedAd.appLinkUrl = rippedKSAd2.appDownloadUrl;
        funRippedAd.appMarketUrl = rippedKSAd2.marketUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.ac
    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        super.a(context, funAdSlot, zVar);
        if (!this.f8044b) {
            this.f8044b = true;
            KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(this.f8043a.f8060a)).adNum(1).build(), new a());
            z zVar2 = this.pJC;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f8043a.f8060a);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class a implements KsLoadManager.RewardVideoAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            m.a("KSRewardVideoAd onError code: " + i + ", message: " + str);
            aw awVar = aw.this;
            awVar.f8044b = false;
            z zVar = awVar.pJC;
            if (zVar != null) {
                ((ad) zVar).a(awVar.f8043a.f8060a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            m.a("KSRewardVideoAd onNativeAdLoad");
            aw.this.f8044b = false;
            if (list != null && !list.isEmpty()) {
                aw.this.pJR = list.get(0);
                aw awVar = aw.this;
                z zVar = awVar.pJC;
                if (zVar != null) {
                    ((ad) zVar).b(awVar.f8043a.f8060a);
                }
                AdRipper.ripKS(aw.this.pJR);
                return;
            }
            m.a("KSFullscreenAd onNativeAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsRewardVideoAd ksRewardVideoAd = this.pJR;
        if (ksRewardVideoAd != null) {
            if (ksRewardVideoAd.isAdEnable()) {
                this.pJR.setRewardAdInteractionListener(new b());
                this.pJR.showRewardVideoAd(activity, this.f8043a.g == 1 ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
                return;
            }
            m.a("暂无可用激励视频广告，请等待缓存加载或者重新刷新");
            if (wVar != null) {
                ((ag) wVar).e(this.f8043a.f8060a);
            }
        }
    }
}
