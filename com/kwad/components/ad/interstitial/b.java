package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    public KsScene fn;
    public KsInterstitialAd.AdInteractionListener fo;
    public d fp;
    @NonNull
    public final AdTemplate mAdTemplate;

    public b(@NonNull KsScene ksScene, @NonNull AdTemplate adTemplate) {
        this.fn = ksScene;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aD(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        return com.kwad.sdk.core.response.a.a.aB(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.fo = adInteractionListener;
        d dVar = this.fp;
        if (dVar != null) {
            dVar.setAdInteractionListener(adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.aA(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null) {
            com.kwad.sdk.core.e.b.e("StayAdHelper", "showInterstitialAd activity must not be null");
            return;
        }
        com.kwad.components.ad.interstitial.monitor.b.cr().ct();
        this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
        com.kwad.sdk.kwai.kwai.c.rd().aI(true);
        if (this.fp == null) {
            d dVar = new d(activity, this.mAdTemplate, ksVideoPlayConfig, this.fo);
            this.fp = dVar;
            dVar.cf();
        }
    }
}
