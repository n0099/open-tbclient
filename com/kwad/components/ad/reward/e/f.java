package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class f {
    public static final HashMap<String, f> rt = new HashMap<>();
    public KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    public com.kwad.components.core.i.d ox;
    public KsRewardVideoAd.RewardAdInteractionListener ru;

    private void destroy() {
        this.mInteractionListener = null;
        this.ru = null;
        com.kwad.components.core.i.d dVar = this.ox;
        if (dVar != null) {
            dVar.destroy();
            this.ox = null;
        }
    }

    @Nullable
    public static f F(String str) {
        return rt.get(str);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener G(String str) {
        f F = F(str);
        if (F != null) {
            return F.ru;
        }
        return null;
    }

    public static void H(String str) {
        f F = F(str);
        if (F != null) {
            F.ru = F.mInteractionListener;
        }
    }

    public static com.kwad.components.core.i.d I(String str) {
        f F = F(str);
        if (F != null) {
            return F.ox;
        }
        return null;
    }

    public static void J(String str) {
        f F = F(str);
        if (F != null) {
            F.destroy();
            rt.put(str, null);
        }
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.ox = dVar;
        fVar.ru = rewardAdInteractionListener;
        rt.put(str, fVar);
    }
}
