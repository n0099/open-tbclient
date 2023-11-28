package com.kwad.sdk.core.b.a;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hc implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aGS = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(bVar.aGS)) {
            bVar.aGS = "";
        }
        bVar.aGT = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(bVar.aGT)) {
            bVar.aGT = "";
        }
        bVar.aGU = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (JSONObject.NULL.toString().equals(bVar.aGU)) {
            bVar.aGU = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.ajv = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(bVar.ajv)) {
            bVar.ajv = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aGW = jSONObject.optBoolean(UnitedSchemePublicDispatcher.MODULE_NAME);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aGS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageId", bVar.aGS);
        }
        String str2 = bVar.aGT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipFileName", bVar.aGT);
        }
        String str3 = bVar.aGU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, FileMetaUtil.ZIP_PATH, bVar.aGU);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.ajv;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "checksum", bVar.ajv);
        }
        int i = bVar.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadType", i);
        }
        int i2 = bVar.packageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageType", i2);
        }
        boolean z = bVar.aGW;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, UnitedSchemePublicDispatcher.MODULE_NAME, z);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
