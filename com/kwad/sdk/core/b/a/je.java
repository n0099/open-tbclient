package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.kwad.components.core.webview.tachikoma.a.u;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class je implements com.kwad.sdk.core.d<u.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.errorCode = jSONObject.optInt(CloudStabilityUBCUtils.KEY_ERROR_CODE);
        bVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(bVar.errorMsg)) {
            bVar.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.errorCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CloudStabilityUBCUtils.KEY_ERROR_CODE, i2);
        }
        String str = bVar.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", bVar.errorMsg);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(u.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(u.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
