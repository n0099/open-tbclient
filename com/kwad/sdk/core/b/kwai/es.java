package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class es implements com.kwad.sdk.core.d<AdInfo.SmallAppJumpInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "originId", smallAppJumpInfo.originId);
        com.kwad.sdk.utils.r.a(jSONObject, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        a2(smallAppJumpInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        return b2(smallAppJumpInfo, jSONObject);
    }
}
