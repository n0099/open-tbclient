package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class y implements com.kwad.sdk.core.c<AdInfo.MaterialSize> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.MaterialSize materialSize) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "width", materialSize.width);
        com.kwad.sdk.utils.o.a(jSONObject, "height", materialSize.height);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.MaterialSize materialSize, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialSize.width = jSONObject.optInt("width");
        materialSize.height = jSONObject.optInt("height");
    }
}
