package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ai implements com.kwad.sdk.core.c<AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo horizontalPatchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        horizontalPatchAdInfo.patchCardUrl = jSONObject.optString("patchCardUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo horizontalPatchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "patchCardUrl", horizontalPatchAdInfo.patchCardUrl);
        return jSONObject;
    }
}
