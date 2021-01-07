package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
/* loaded from: classes15.dex */
public class al extends ac {
    public KsFullScreenVideoAd pJE;
    public AdRipper.RippedKSAd pJF;

    /* loaded from: classes15.dex */
    public class b implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            m.a("KSFullscreenVideoAd 全屏视频广告点击");
            al alVar = al.this;
            w wVar = alVar.pJD;
            if (wVar != null) {
                ((ag) wVar).a(alVar.f8043a.f8060a);
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            m.a("KSFullscreenVideoAd 全屏视频广告关闭");
            al alVar = al.this;
            w wVar = alVar.pJD;
            if (wVar != null) {
                ((ag) wVar).d(alVar.f8043a.f8060a);
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            m.a("KSFullscreenVideoAd 全屏视频广告播放跳过");
            w wVar = al.this.pJD;
            if (wVar != null) {
                if (((ag) wVar) == null) {
                    throw null;
                }
                m.a("KSAdLoaderFactory onSkippedVideo");
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayEnd() {
            m.a("KSFullscreenVideoAd 全屏视频广告播放完成");
            w wVar = al.this.pJD;
            if (wVar != null) {
                ag agVar = (ag) wVar;
                m.a("KSAdLoaderFactory onVideoPlayEnd");
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            m.a("KSFullscreenVideoAd 全屏视频广告播放出错");
            al alVar = al.this;
            w wVar = alVar.pJD;
            if (wVar != null) {
                ((ag) wVar).e(alVar.f8043a.f8060a);
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
            m.a("KSFullscreenVideoAd 全屏视频广告播放开始");
            al alVar = al.this;
            w wVar = alVar.pJD;
            if (wVar != null) {
                String str = alVar.f8043a.f8060a;
                ag agVar = (ag) wVar;
                m.a("KSAdLoaderFactory onVideoPlayStart");
            }
            al alVar2 = al.this;
            w wVar2 = alVar2.pJD;
            if (wVar2 != null) {
                ((ag) wVar2).c(alVar2.f8043a.f8060a);
            }
        }
    }

    public al(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pJE = null;
        this.pJF = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eBP() {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.pJE;
        if (ksFullScreenVideoAd == null) {
            return null;
        }
        if (this.pJF == null) {
            this.pJF = AdRipper.getRippedKSAd((Object) ksFullScreenVideoAd, false);
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
        super.a(context.getApplicationContext(), funAdSlot, zVar);
        if (!this.f8044b) {
            this.f8044b = true;
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(new KsScene.Builder(Long.parseLong(this.f8043a.f8060a)).adNum(1).build(), new a());
            z zVar2 = this.pJC;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f8043a.f8060a);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class a implements KsLoadManager.FullScreenVideoAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i, String str) {
            m.a("KSFullscreenAd onError code: " + i + ", message: " + str);
            al alVar = al.this;
            alVar.f8044b = false;
            z zVar = alVar.pJC;
            if (zVar != null) {
                ((ad) zVar).a(alVar.f8043a.f8060a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            m.a("KSFullscreenAd onNativeAdLoad");
            al.this.f8044b = false;
            if (list != null && !list.isEmpty()) {
                al.this.pJE = list.get(0);
                al alVar = al.this;
                z zVar = alVar.pJC;
                if (zVar != null) {
                    ((ad) zVar).b(alVar.f8043a.f8060a);
                }
                AdRipper.ripKS(al.this.pJE);
                return;
            }
            m.a("KSFullscreenAd onNativeAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsFullScreenVideoAd ksFullScreenVideoAd = this.pJE;
        if (ksFullScreenVideoAd != null) {
            if (ksFullScreenVideoAd.isAdEnable()) {
                this.pJE.setFullScreenVideoAdInteractionListener(new b());
                this.pJE.showFullScreenVideoAd(activity, this.f8043a.g == 1 ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
                return;
            }
            m.a("暂无可用全屏视频广告，请等待缓存加载或者重新刷新");
            if (wVar != null) {
                ((ag) wVar).e(this.f8043a.f8060a);
            }
        }
    }
}
