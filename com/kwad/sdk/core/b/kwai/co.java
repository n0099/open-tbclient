package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class co implements com.kwad.sdk.core.d<HybridLoadMsg> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString(MemberPayActivityConfig.SCENE_ID);
        if (jSONObject.opt(MemberPayActivityConfig.SCENE_ID) == JSONObject.NULL) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (jSONObject.opt("h5_version") == JSONObject.NULL) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        hybridLoadMsg.interval = jSONObject.optString("interval");
        if (jSONObject.opt("interval") == JSONObject.NULL) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (jSONObject.opt("fail_reason") == JSONObject.NULL) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (jSONObject.opt("package_url") == JSONObject.NULL) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, MemberPayActivityConfig.SCENE_ID, hybridLoadMsg.sceneId);
        com.kwad.sdk.utils.r.a(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        com.kwad.sdk.utils.r.a(jSONObject, "load_type", hybridLoadMsg.loadType);
        com.kwad.sdk.utils.r.a(jSONObject, "state", hybridLoadMsg.state);
        com.kwad.sdk.utils.r.a(jSONObject, "interval", hybridLoadMsg.interval);
        com.kwad.sdk.utils.r.a(jSONObject, "fail_state", hybridLoadMsg.failState);
        com.kwad.sdk.utils.r.a(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        com.kwad.sdk.utils.r.a(jSONObject, "url", hybridLoadMsg.url);
        com.kwad.sdk.utils.r.a(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        a2(hybridLoadMsg, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        return b2(hybridLoadMsg, jSONObject);
    }
}
