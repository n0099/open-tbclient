package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class v implements com.kwad.sdk.core.c<PhotoInfo.CoverInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverInfo.coverUrl = jSONObject.optString("coverUrl");
        coverInfo.width = jSONObject.optInt("width");
        coverInfo.height = jSONObject.optInt("height");
        coverInfo.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        coverInfo.blurCoverUrl = jSONObject.optString("blurCoverUrl");
        coverInfo.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "coverUrl", coverInfo.coverUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "width", coverInfo.width);
        com.kwad.sdk.utils.o.a(jSONObject, "height", coverInfo.height);
        com.kwad.sdk.utils.o.a(jSONObject, "webpCoverUrl", coverInfo.webpCoverUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "blurCoverUrl", coverInfo.blurCoverUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "blurBackgroundUrl", coverInfo.blurBackgroundUrl);
        return jSONObject;
    }
}
