package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class cq implements com.kwad.sdk.core.d<HybridLoadMsg> {
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
        hybridLoadMsg.ratioCount = jSONObject.optDouble("ratio_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = hybridLoadMsg.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, MemberPayActivityConfig.SCENE_ID, hybridLoadMsg.sceneId);
        }
        String str2 = hybridLoadMsg.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        int i = hybridLoadMsg.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "load_type", i);
        }
        int i2 = hybridLoadMsg.state;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "state", i2);
        }
        String str3 = hybridLoadMsg.interval;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "interval", hybridLoadMsg.interval);
        }
        int i3 = hybridLoadMsg.failState;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fail_state", i3);
        }
        String str4 = hybridLoadMsg.failReason;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        String str5 = hybridLoadMsg.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        String str6 = hybridLoadMsg.packageUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        double d = hybridLoadMsg.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
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
