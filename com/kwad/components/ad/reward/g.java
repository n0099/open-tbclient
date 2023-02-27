package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class g implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    public com.kwad.components.ad.reward.c.c kJ;
    public final AdInfo mAdInfo;
    @NonNull
    public final AdTemplate mAdTemplate;
    public KsRewardVideoAd.RewardAdInteractionListener ma;
    public KsRewardVideoAd.RewardAdInteractionListener mb;
    public int rewardType = 1;

    public g(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        if (!isAdEnable()) {
            com.kwad.sdk.core.e.b.i("KsRewardVideoAdControl", "isAdEnable is false");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        KsVideoPlayConfig ksVideoPlayConfig2 = ksVideoPlayConfig;
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        fg();
        if (com.kwad.sdk.core.response.a.a.bk(this.mAdInfo)) {
            AdRewardPreviewActivityProxy.launch(context, this.mAdTemplate, com.kwad.sdk.core.response.a.a.ar(this.mAdInfo), this.ma);
        } else {
            KSRewardVideoActivityProxy.launch(context, this.mAdTemplate, ksVideoPlayConfig2, this.ma, this.mb, this.kJ, this.rewardType);
        }
    }

    private void fg() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.b.c.a(this.ma) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.ap(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.config.d.sc() >= 0) {
            return true;
        }
        return com.kwad.components.core.video.f.h(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setBidEcpm(int i) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.aA(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.kJ = new com.kwad.components.ad.reward.c.c(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.ma = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.mb = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.components.ad.reward.monitor.a.a(true, this.mAdTemplate);
        a(activity, ksVideoPlayConfig);
    }
}
