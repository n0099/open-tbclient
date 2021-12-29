package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class av implements com.kwad.sdk.core.d<LiveInfo.CoverUrlCdn> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo.CoverUrlCdn coverUrlCdn, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverUrlCdn.coverUrlCdn = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            coverUrlCdn.coverUrlCdn = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.CoverUrlCdn coverUrlCdn, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "url", coverUrlCdn.coverUrlCdn);
        return jSONObject;
    }
}
