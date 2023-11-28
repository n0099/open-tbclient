package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class kn implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.x> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.aaj = jSONObject.optString("status");
        if (JSONObject.NULL.toString().equals(xVar.aaj)) {
            xVar.aaj = "";
        }
        xVar.errorCode = jSONObject.optInt(CloudStabilityUBCUtils.KEY_ERROR_CODE);
        xVar.errorReason = jSONObject.optString("errorReason");
        if (JSONObject.NULL.toString().equals(xVar.errorReason)) {
            xVar.errorReason = "";
        }
        xVar.nD = jSONObject.optInt("currentTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = xVar.aaj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", xVar.aaj);
        }
        int i = xVar.errorCode;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CloudStabilityUBCUtils.KEY_ERROR_CODE, i);
        }
        String str2 = xVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorReason", xVar.errorReason);
        }
        int i2 = xVar.nD;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        a2(xVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        return b2(xVar, jSONObject);
    }
}
