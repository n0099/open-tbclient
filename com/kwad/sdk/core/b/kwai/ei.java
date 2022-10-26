package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ei implements com.kwad.sdk.core.d {
    public static void a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    public static JSONObject b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = playableStyleInfo.playableOrientation;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playableOrientation", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.PlayableStyleInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.PlayableStyleInfo) bVar, jSONObject);
    }
}
