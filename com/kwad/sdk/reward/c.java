package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
/* loaded from: classes6.dex */
public class c implements KsRewardVideoAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33752a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33753b;

    /* renamed from: c  reason: collision with root package name */
    public KsRewardVideoAd.RewardAdInteractionListener f33754c;

    public c(@NonNull AdTemplate adTemplate) {
        this.f33752a = adTemplate;
        this.f33753b = com.kwad.sdk.core.response.b.c.g(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.a.c("KsRewardVideoAdControl", "isAdEnable is false");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
        if (a2 != null) {
            ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
        }
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_SKIP_THIRTY_SECOND");
        if (a3 != null) {
            ksVideoPlayConfig.setSkipThirtySecond(((Boolean) a3.getValue()).booleanValue());
        }
        KSRewardVideoActivityProxy.launch(context, this.f33752a, ksVideoPlayConfig, this.f33754c);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(this.f33753b);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.config.c.y() >= 0) {
            return true;
        }
        return g.b(this.f33752a);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f33752a;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f33754c = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        a(activity, ksVideoPlayConfig);
    }
}
