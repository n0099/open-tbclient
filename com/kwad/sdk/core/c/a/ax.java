package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ax implements com.kwad.sdk.core.c<AdInfo.PlayableStyleInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "playableOrientation", playableStyleInfo.playableOrientation);
        return jSONObject;
    }
}
