package com.kwad.components.ad.reward.g;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.b.g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.d;
/* loaded from: classes10.dex */
public final class a extends d implements g {
    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.components.ad.b.g
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.fa().notifyRewardVerify();
    }

    @Override // com.kwad.components.ad.b.g
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
    }
}
