package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class au implements com.kwad.sdk.core.d<LiveInfo.CoverThumbnailUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverThumbnailUrl.cdn = jSONObject.optString("cdn");
        if (jSONObject.opt("cdn") == JSONObject.NULL) {
            coverThumbnailUrl.cdn = "";
        }
        coverThumbnailUrl.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            coverThumbnailUrl.url = "";
        }
        coverThumbnailUrl.urlPattern = jSONObject.optString("urlPattern");
        if (jSONObject.opt("urlPattern") == JSONObject.NULL) {
            coverThumbnailUrl.urlPattern = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "cdn", coverThumbnailUrl.cdn);
        com.kwad.sdk.utils.t.a(jSONObject, "url", coverThumbnailUrl.url);
        com.kwad.sdk.utils.t.a(jSONObject, "urlPattern", coverThumbnailUrl.urlPattern);
        return jSONObject;
    }
}
