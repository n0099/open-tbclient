package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
/* loaded from: classes7.dex */
public class f implements KsRewardVideoAd {
    public int a = 1;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40807b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f40808c;

    /* renamed from: d  reason: collision with root package name */
    public KsRewardVideoAd.RewardAdInteractionListener f40809d;

    public f(@NonNull AdTemplate adTemplate) {
        this.f40807b = adTemplate;
        this.f40808c = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.a.c("KsRewardVideoAdControl", "isAdEnable is false");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        DevelopMangerPlugin.DevelopValue a = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
        if (a != null) {
            ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a.getValue()).booleanValue());
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_SKIP_THIRTY_SECOND");
        if (a2 != null) {
            ksVideoPlayConfig.setSkipThirtySecond(((Boolean) a2.getValue()).booleanValue());
        }
        if (com.kwad.sdk.core.response.a.a.as(this.f40808c)) {
            AdRewardPreviewActivityProxy.launch(context, this.f40807b, com.kwad.sdk.core.response.a.a.G(this.f40808c), this.f40809d);
        } else {
            KSRewardVideoActivityProxy.launch(context, this.f40807b, ksVideoPlayConfig, this.f40809d, this.a);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(this.f40808c);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(this.f40808c);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(this.f40808c);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.config.b.C() >= 0) {
            return true;
        }
        return n.b(this.f40807b);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.f40807b, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f40807b;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f40809d = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        a(activity, ksVideoPlayConfig);
    }
}
