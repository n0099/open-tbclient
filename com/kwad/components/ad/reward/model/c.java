package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public AdInfo mAdInfo;
    public AdResultData mAdResultData;
    public AdTemplate mAdTemplate;
    public JSONObject mReportExtData;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public int rewardType = 1;
    public final boolean gt = com.kwad.components.ad.reward.a.b.gB();

    public final AdInfo bH() {
        return this.mAdInfo;
    }

    public final boolean bI() {
        return e.eb(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final boolean hg() {
        return e.i(getAdTemplate(), com.kwad.components.ad.reward.a.b.k(bH()));
    }

    public final boolean hh() {
        return e.F(getAdTemplate());
    }

    public final AdResultData hi() {
        return this.mAdResultData;
    }

    public final KsVideoPlayConfig hj() {
        return this.mVideoPlayConfig;
    }

    public final int hk() {
        return this.rewardType;
    }

    public final JSONObject hl() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo hm() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    @Nullable
    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfig;
        if (com.kwad.sdk.core.config.d.Bw()) {
            ksVideoPlayConfig = com.kwad.components.core.internal.api.e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.e.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData d = f.mB().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (d == null) {
                return null;
            }
            return a(d, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    @Nullable
    public static c a(AdResultData adResultData, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        int i2;
        c cVar = new c();
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        if (m == null) {
            com.kwad.sdk.core.e.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo dP = e.dP(m);
        if (!c(m, dP)) {
            return null;
        }
        boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        m.mInitVoiceStatus = i2;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = m;
        cVar.mAdInfo = dP;
        cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
        cVar.rewardType = i;
        return cVar;
    }

    public static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!com.kwad.sdk.core.config.d.Bw() && e.ef(adTemplate) < 0) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(com.kwad.sdk.core.response.b.a.K(adInfo));
            if (bO == null || !bO.exists()) {
                return false;
            }
        }
        return true;
    }
}
