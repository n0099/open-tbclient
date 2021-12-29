package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cs implements com.kwad.sdk.core.d<com.kwad.sdk.c.kwai.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optString("packageId");
        if (jSONObject.opt("packageId") == JSONObject.NULL) {
            dVar.a = "";
        }
        dVar.f57653b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            dVar.f57653b = "";
        }
        dVar.f57654c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            dVar.f57654c = "";
        }
        dVar.f57655d = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            dVar.f57655d = "";
        }
        dVar.f57656e = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            dVar.f57656e = "";
        }
        dVar.f57657f = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            dVar.f57657f = "";
        }
        dVar.f57658g = jSONObject.optInt("loadType");
        dVar.f57659h = jSONObject.optInt("packageType");
        dVar.f57660i = jSONObject.optBoolean("isPublic");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "packageId", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "zipFileName", dVar.f57653b);
        com.kwad.sdk.utils.t.a(jSONObject, FileMetaUtil.ZIP_PATH, dVar.f57654c);
        com.kwad.sdk.utils.t.a(jSONObject, "packageUrl", dVar.f57655d);
        com.kwad.sdk.utils.t.a(jSONObject, "version", dVar.f57656e);
        com.kwad.sdk.utils.t.a(jSONObject, "checksum", dVar.f57657f);
        com.kwad.sdk.utils.t.a(jSONObject, "loadType", dVar.f57658g);
        com.kwad.sdk.utils.t.a(jSONObject, "packageType", dVar.f57659h);
        com.kwad.sdk.utils.t.a(jSONObject, "isPublic", dVar.f57660i);
        return jSONObject;
    }
}
