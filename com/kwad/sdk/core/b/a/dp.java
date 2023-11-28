package com.kwad.sdk.core.b.a;

import com.baidu.sapi2.activity.BaseActivity;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dp implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.aFT = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.aFT)) {
            bVar.aFT = "";
        }
        bVar.aFU = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.aFU)) {
            bVar.aFU = "";
        }
        bVar.aFV = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.aFV)) {
            bVar.aFV = "";
        }
        bVar.aFW = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aFW)) {
            bVar.aFW = "";
        }
        bVar.aFX = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.aFX)) {
            bVar.aFX = "";
        }
        bVar.aFY = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.aFY)) {
            bVar.aFY = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bVar.appId);
        }
        String str2 = bVar.aFT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pluginListenerName", bVar.aFT);
        }
        String str3 = bVar.aFU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportMethodName", bVar.aFU);
        }
        String str4 = bVar.aFV;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherProxyClassName", bVar.aFV);
        }
        String str5 = bVar.aFW;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherFieldName", bVar.aFW);
        }
        String str6 = bVar.aFX;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "otherLevelFieldName", bVar.aFX);
        }
        String str7 = bVar.aFY;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTag", bVar.aFY);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
