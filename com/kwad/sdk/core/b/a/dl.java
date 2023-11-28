package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dl implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aFb = jSONObject.optInt("funcSwitch");
        bVar.aFc = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.aFc)) {
            bVar.aFc = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.aFd = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.aFd)) {
            bVar.aFd = "";
        }
        bVar.aFe = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.aFe)) {
            bVar.aFe = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aFf = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.aFf)) {
            bVar.aFf = "";
        }
        bVar.aFg = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.aFg)) {
            bVar.aFg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.aFb;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", i);
        }
        String str = bVar.aFc;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "minSdkVersion", bVar.aFc);
        }
        int i2 = bVar.sdkType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i2);
        }
        String str2 = bVar.aFd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5V7", bVar.aFd);
        }
        String str3 = bVar.aFe;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5V8", bVar.aFe);
        }
        String str4 = bVar.version;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str5 = bVar.aFf;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "v7Url", bVar.aFf);
        }
        String str6 = bVar.aFg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "v8Url", bVar.aFg);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
