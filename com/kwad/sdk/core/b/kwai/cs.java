package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        dVar.f39179b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            dVar.f39179b = "";
        }
        dVar.f39180c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            dVar.f39180c = "";
        }
        dVar.f39181d = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            dVar.f39181d = "";
        }
        dVar.f39182e = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            dVar.f39182e = "";
        }
        dVar.f39183f = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            dVar.f39183f = "";
        }
        dVar.f39184g = jSONObject.optInt("loadType");
        dVar.f39185h = jSONObject.optInt("packageType");
        dVar.i = jSONObject.optBoolean("isPublic");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "packageId", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "zipFileName", dVar.f39179b);
        com.kwad.sdk.utils.t.a(jSONObject, FileMetaUtil.ZIP_PATH, dVar.f39180c);
        com.kwad.sdk.utils.t.a(jSONObject, "packageUrl", dVar.f39181d);
        com.kwad.sdk.utils.t.a(jSONObject, "version", dVar.f39182e);
        com.kwad.sdk.utils.t.a(jSONObject, "checksum", dVar.f39183f);
        com.kwad.sdk.utils.t.a(jSONObject, "loadType", dVar.f39184g);
        com.kwad.sdk.utils.t.a(jSONObject, "packageType", dVar.f39185h);
        com.kwad.sdk.utils.t.a(jSONObject, "isPublic", dVar.i);
        return jSONObject;
    }
}
