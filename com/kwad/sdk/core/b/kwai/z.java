package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class z implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardReflowSwitch = jSONObject.optBoolean("rewardReflowSwitch", new Boolean("true").booleanValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.r.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j = adStyleConfInfo.closeDelaySeconds;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "closeDelaySeconds", j);
        }
        long j2 = adStyleConfInfo.playableCloseSeconds;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playableCloseSeconds", j2);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "rewardReflowSwitch", adStyleConfInfo.rewardReflowSwitch);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        a2(adStyleConfInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return b2(adStyleConfInfo, jSONObject);
    }
}
