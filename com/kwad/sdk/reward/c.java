package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.g;
/* loaded from: classes6.dex */
public class c implements KsRewardVideoAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f36442a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f36443b;

    /* renamed from: c  reason: collision with root package name */
    public KsRewardVideoAd.RewardAdInteractionListener f36444c;

    public c(@NonNull AdTemplate adTemplate) {
        this.f36442a = adTemplate;
        this.f36443b = com.kwad.sdk.core.response.b.c.j(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.a.b("KsRewardVideoAdControl", "isAdEnable is false");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
        if (a2 != null) {
            ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
        }
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_SKIP_THIRTY_SECOND");
        if (a3 != null) {
            ksVideoPlayConfig.setSkipThirtySecond(((Boolean) a3.getValue()).booleanValue());
        }
        KSRewardVideoActivityProxy.launch(context, this.f36442a, ksVideoPlayConfig, this.f36444c);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f36443b);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.config.c.ae() >= 0) {
            return true;
        }
        return f.b(this.f36442a);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f36442a;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f36444c = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        a(activity, ksVideoPlayConfig);
    }
}
