package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ci implements com.kwad.sdk.core.d<LiveInfo.LiveStreamPlayCDNNode> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveStreamPlayCDNNode.cdn = jSONObject.optString("cdn");
        if (jSONObject.opt("cdn") == JSONObject.NULL) {
            liveStreamPlayCDNNode.cdn = "";
        }
        liveStreamPlayCDNNode.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            liveStreamPlayCDNNode.url = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "cdn", liveStreamPlayCDNNode.cdn);
        com.kwad.sdk.utils.t.a(jSONObject, "url", liveStreamPlayCDNNode.url);
        return jSONObject;
    }
}
