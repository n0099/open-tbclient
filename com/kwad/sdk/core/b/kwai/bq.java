package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bq implements com.kwad.sdk.core.d<LiveInfo.User.HeadUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        headUrl.cdn = jSONObject.optString("cdn");
        if (jSONObject.opt("cdn") == JSONObject.NULL) {
            headUrl.cdn = "";
        }
        headUrl.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            headUrl.url = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "cdn", headUrl.cdn);
        com.kwad.sdk.utils.t.a(jSONObject, "url", headUrl.url);
        return jSONObject;
    }
}
