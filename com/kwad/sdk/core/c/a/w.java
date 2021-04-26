package com.kwad.sdk.core.c.a;

import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w implements com.kwad.sdk.core.c<LiveInfo.CoverThumbnailUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverThumbnailUrl.cdn = jSONObject.optString("cdn");
        coverThumbnailUrl.url = jSONObject.optString("url");
        coverThumbnailUrl.urlPattern = jSONObject.optString("urlPattern");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(LiveInfo.CoverThumbnailUrl coverThumbnailUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "cdn", coverThumbnailUrl.cdn);
        com.kwad.sdk.utils.o.a(jSONObject, "url", coverThumbnailUrl.url);
        com.kwad.sdk.utils.o.a(jSONObject, "urlPattern", coverThumbnailUrl.urlPattern);
        return jSONObject;
    }
}
