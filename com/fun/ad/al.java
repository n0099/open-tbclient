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
/* loaded from: classes6.dex */
public class al extends ac {
    public KsFullScreenVideoAd pPj;
    public AdRipper.RippedKSAd pPk;

    /* loaded from: classes6.dex */
    public class b implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            m.a("KSFullscreenVideoAd 全屏视频广告点击");
            al alVar = al.this;
            w wVar = alVar.pPi;
            if (wVar != null) {
                ((ag) wVar).a(alVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            m.a("KSFullscreenVideoAd 全屏视频广告关闭");
            al alVar = al.this;
            w wVar = alVar.pPi;
            if (wVar != null) {
                ((ag) wVar).d(alVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            m.a("KSFullscreenVideoAd 全屏视频广告播放跳过");
            w wVar = al.this.pPi;
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
            w wVar = al.this.pPi;
            if (wVar != null) {
                ag agVar = (ag) wVar;
                m.a("KSAdLoaderFactory onVideoPlayEnd");
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            m.a("KSFullscreenVideoAd 全屏视频广告播放出错");
            al alVar = al.this;
            w wVar = alVar.pPi;
            if (wVar != null) {
                ((ag) wVar).e(alVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
            m.a("KSFullscreenVideoAd 全屏视频广告播放开始");
            al alVar = al.this;
            w wVar = alVar.pPi;
            if (wVar != null) {
                String str = alVar.f7745a.f7762a;
                ag agVar = (ag) wVar;
                m.a("KSAdLoaderFactory onVideoPlayStart");
            }
            al alVar2 = al.this;
            w wVar2 = alVar2.pPi;
            if (wVar2 != null) {
                ((ag) wVar2).c(alVar2.f7745a.f7762a);
            }
        }
    }

    public al(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pPj = null;
        this.pPk = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eAp() {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.pPj;
        if (ksFullScreenVideoAd == null) {
            return null;
        }
        if (this.pPk == null) {
            this.pPk = AdRipper.getRippedKSAd((Object) ksFullScreenVideoAd, false);
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
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(new KsScene.Builder(Long.parseLong(this.f7745a.f7762a)).adNum(1).build(), new a());
            z zVar2 = this.pPh;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f7745a.f7762a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.FullScreenVideoAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onError(int i, String str) {
            m.a("KSFullscreenAd onError code: " + i + ", message: " + str);
            al alVar = al.this;
            alVar.f7746b = false;
            z zVar = alVar.pPh;
            if (zVar != null) {
                ((ad) zVar).a(alVar.f7745a.f7762a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            m.a("KSFullscreenAd onNativeAdLoad");
            al.this.f7746b = false;
            if (list != null && !list.isEmpty()) {
                al.this.pPj = list.get(0);
                al alVar = al.this;
                z zVar = alVar.pPh;
                if (zVar != null) {
                    ((ad) zVar).b(alVar.f7745a.f7762a);
                }
                AdRipper.ripKS(al.this.pPj);
                return;
            }
            m.a("KSFullscreenAd onNativeAdLoad error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsFullScreenVideoAd ksFullScreenVideoAd = this.pPj;
        if (ksFullScreenVideoAd != null) {
            if (ksFullScreenVideoAd.isAdEnable()) {
                this.pPj.setFullScreenVideoAdInteractionListener(new b());
                this.pPj.showFullScreenVideoAd(activity, this.f7745a.g == 1 ? new KsVideoPlayConfig.Builder().showLandscape(true).build() : null);
                return;
            }
            m.a("暂无可用全屏视频广告，请等待缓存加载或者重新刷新");
            if (wVar != null) {
                ((ag) wVar).e(this.f7745a.f7762a);
            }
        }
    }
}
