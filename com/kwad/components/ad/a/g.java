package com.kwad.components.ad.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
/* loaded from: classes8.dex */
public interface g extends com.kwad.sdk.components.a {
    void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener);

    void notifyRewardVerify();
}
