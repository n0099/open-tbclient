package com.kwad.components.ad.reward;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.g {
    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return com.kwad.components.ad.a.g.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.ad.a.g
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        f.loadRewardVideoAd(ksScene, rewardVideoAdListener);
    }

    @Override // com.kwad.components.ad.a.g
    public final void notifyRewardVerify() {
        c.eZ().notifyRewardVerify();
    }
}
