package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.r;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public JSONObject mReportExtData;
    public int mScreenOrientation;
    public KsVideoPlayConfig mVideoPlayConfig;
    public int rewardType = 1;

    @Nullable
    public static c a(AdTemplate adTemplate, @Nullable AdTemplate adTemplate2, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        File ad;
        c cVar = new c();
        AdInfo bQ = d.bQ(adTemplate);
        String A = com.kwad.sdk.core.response.a.a.A(bQ);
        if (com.kwad.sdk.core.config.d.sc() >= 0 || ((ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A)) != null && ad.exists())) {
            boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
            adTemplate.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
            if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
                JSONObject jSONObject = new JSONObject();
                r.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
                cVar.mReportExtData = jSONObject;
            }
            cVar.mVideoPlayConfig = ksVideoPlayConfig;
            cVar.mAdTemplate = adTemplate;
            cVar.mAdInfo = bQ;
            cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
            cVar.rewardType = i;
            adTemplate.mPlayAgain = adTemplate2;
            return cVar;
        }
        return null;
    }

    @Nullable
    public static c c(Intent intent) {
        AdTemplate adTemplate;
        Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
        if (!(serializableExtra instanceof KsVideoPlayConfig)) {
            com.kwad.sdk.core.e.b.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
            return null;
        }
        KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        String stringExtra = intent.getStringExtra("key_template_json");
        try {
            AdTemplate adTemplate2 = new AdTemplate();
            adTemplate2.parseJson(new JSONObject(stringExtra));
            String stringExtra2 = intent.getStringExtra(KSRewardVideoActivityProxy.KEY_TEMPLATE_PLAY_AGAIN);
            if (stringExtra2 != null) {
                adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra2));
            } else {
                adTemplate = null;
            }
            return a(adTemplate2, adTemplate, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return null;
        }
    }

    public final AdInfo by() {
        return this.mAdInfo;
    }

    public final boolean bz() {
        return d.cd(this.mAdTemplate);
    }

    public final boolean gL() {
        return d.e(getAdTemplate(), com.kwad.components.ad.reward.kwai.b.j(by()));
    }

    public final boolean gM() {
        return d.p(getAdTemplate());
    }

    public final KsVideoPlayConfig gN() {
        return this.mVideoPlayConfig;
    }

    public final int gO() {
        return this.rewardType;
    }

    public final JSONObject gP() {
        return this.mReportExtData;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final void y(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.bQ(adTemplate);
    }
}
