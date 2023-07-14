package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.ad.a.d;
import com.kwad.components.ad.a.e;
import com.kwad.components.ad.a.f;
import com.kwad.components.ad.a.g;
import com.kwad.components.ad.a.h;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
/* loaded from: classes10.dex */
public final class c implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadConfigFeedAd(ksScene, feedAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        com.kwad.components.ad.a.b bVar = (com.kwad.components.ad.a.b) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.b.class);
        if (bVar != null) {
            bVar.loadDrawAd(ksScene, drawAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadFeedAd(ksScene, feedAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        d dVar = (d) com.kwad.sdk.components.c.f(d.class);
        if (dVar != null) {
            dVar.loadFullScreenVideoAd(ksScene, fullScreenVideoAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        e eVar = (e) com.kwad.sdk.components.c.f(e.class);
        if (eVar != null) {
            eVar.loadInterstitialAd(ksScene, interstitialAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        f fVar = (f) com.kwad.sdk.components.c.f(f.class);
        if (fVar != null) {
            fVar.loadNativeAd(ksScene, nativeAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        f fVar = (f) com.kwad.sdk.components.c.f(f.class);
        if (fVar != null) {
            fVar.loadNativeAd(str, nativeAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        g gVar = (g) com.kwad.sdk.components.c.f(g.class);
        if (gVar != null) {
            gVar.loadRewardVideoAd(ksScene, rewardVideoAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        h hVar = (h) com.kwad.sdk.components.c.f(h.class);
        if (hVar != null) {
            hVar.loadSplashScreenAd(ksScene, splashScreenAdListener);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.a.class);
        if (aVar != null) {
            return aVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }
}
