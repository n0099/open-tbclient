package com.kwad.sdk.core.b.kwai;

import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class en implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString(SubtitleLog.TAG);
        if (jSONObject.opt(SubtitleLog.TAG) == JSONObject.NULL) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "title", shakeInfo.title);
        com.kwad.sdk.utils.r.a(jSONObject, SubtitleLog.TAG, shakeInfo.subtitle);
        com.kwad.sdk.utils.r.a(jSONObject, "acceleration", shakeInfo.acceleration);
        com.kwad.sdk.utils.r.a(jSONObject, "clickDisabled", shakeInfo.clickDisabled);
        com.kwad.sdk.utils.r.a(jSONObject, "componentIndex", shakeInfo.componentIndex);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        a2(shakeInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        return b2(shakeInfo, jSONObject);
    }
}
