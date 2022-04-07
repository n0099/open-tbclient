package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class at implements com.kwad.sdk.core.d<PhotoInfo.CoverInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverInfo.coverUrl = jSONObject.optString("coverUrl");
        if (jSONObject.opt("coverUrl") == JSONObject.NULL) {
            coverInfo.coverUrl = "";
        }
        coverInfo.width = jSONObject.optInt("width");
        coverInfo.height = jSONObject.optInt("height");
        coverInfo.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (jSONObject.opt("webpCoverUrl") == JSONObject.NULL) {
            coverInfo.webpCoverUrl = "";
        }
        coverInfo.blurCoverUrl = jSONObject.optString("blurCoverUrl");
        if (jSONObject.opt("blurCoverUrl") == JSONObject.NULL) {
            coverInfo.blurCoverUrl = "";
        }
        coverInfo.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (jSONObject.opt("blurBackgroundUrl") == JSONObject.NULL) {
            coverInfo.blurBackgroundUrl = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "coverUrl", coverInfo.coverUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "width", coverInfo.width);
        com.kwad.sdk.utils.t.a(jSONObject, "height", coverInfo.height);
        com.kwad.sdk.utils.t.a(jSONObject, "webpCoverUrl", coverInfo.webpCoverUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "blurCoverUrl", coverInfo.blurCoverUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "blurBackgroundUrl", coverInfo.blurBackgroundUrl);
        return jSONObject;
    }
}
