package com.kwad.sdk.core.b.kwai;

import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ev implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
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

    public static JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = shakeInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, SubtitleLog.TAG, shakeInfo.subtitle);
        }
        int i = shakeInfo.acceleration;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "acceleration", i);
        }
        boolean z = shakeInfo.clickDisabled;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clickDisabled", z);
        }
        int i2 = shakeInfo.componentIndex;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "componentIndex", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }
}
