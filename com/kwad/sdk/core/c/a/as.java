package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class as implements com.kwad.sdk.core.c<PhotoInfo.PhotoAd> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo.PhotoAd photoAd, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoAd.requestPatchAd = jSONObject.optBoolean("requestPatchAd", new Boolean("false").booleanValue());
        photoAd.requestAdWidgetWithPosition = jSONObject.optInt("requestAdWidgetWithPosition");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo.PhotoAd photoAd, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "requestPatchAd", photoAd.requestPatchAd);
        com.kwad.sdk.utils.o.a(jSONObject, "requestAdWidgetWithPosition", photoAd.requestAdWidgetWithPosition);
        return jSONObject;
    }
}
