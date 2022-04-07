package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
        dVar.b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            dVar.b = "";
        }
        dVar.c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            dVar.c = "";
        }
        dVar.d = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            dVar.d = "";
        }
        dVar.e = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            dVar.e = "";
        }
        dVar.f = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            dVar.f = "";
        }
        dVar.g = jSONObject.optInt("loadType");
        dVar.h = jSONObject.optInt("packageType");
        dVar.i = jSONObject.optBoolean("isPublic");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "packageId", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "zipFileName", dVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, FileMetaUtil.ZIP_PATH, dVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "packageUrl", dVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "version", dVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "checksum", dVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "loadType", dVar.g);
        com.kwad.sdk.utils.t.a(jSONObject, "packageType", dVar.h);
        com.kwad.sdk.utils.t.a(jSONObject, "isPublic", dVar.i);
        return jSONObject;
    }
}
