package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fa implements com.kwad.sdk.core.d {
    public static void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        smallAppJumpInfo.smallAppJumpUrl = jSONObject.optString("smallAppJumpUrl");
        if (jSONObject.opt("smallAppJumpUrl") == JSONObject.NULL) {
            smallAppJumpInfo.smallAppJumpUrl = "";
        }
        smallAppJumpInfo.originId = jSONObject.optString("originId");
        if (jSONObject.opt("originId") == JSONObject.NULL) {
            smallAppJumpInfo.originId = "";
        }
        smallAppJumpInfo.mediaSmallAppId = jSONObject.optString("mediaSmallAppId");
        if (jSONObject.opt("mediaSmallAppId") == JSONObject.NULL) {
            smallAppJumpInfo.mediaSmallAppId = "";
        }
    }

    public static JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = smallAppJumpInfo.smallAppJumpUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        }
        String str2 = smallAppJumpInfo.originId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "originId", smallAppJumpInfo.originId);
        }
        String str3 = smallAppJumpInfo.mediaSmallAppId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.SmallAppJumpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.SmallAppJumpInfo) bVar, jSONObject);
    }
}
