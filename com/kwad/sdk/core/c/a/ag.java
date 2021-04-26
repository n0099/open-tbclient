package com.kwad.sdk.core.c.a;

import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ag implements com.kwad.sdk.core.c<LiveInfo.User.HeadUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        headUrl.cdn = jSONObject.optString("cdn");
        headUrl.url = jSONObject.optString("url");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "cdn", headUrl.cdn);
        com.kwad.sdk.utils.o.a(jSONObject, "url", headUrl.url);
        return jSONObject;
    }
}
