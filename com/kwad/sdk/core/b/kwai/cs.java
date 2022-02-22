package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
        dVar.f55679b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            dVar.f55679b = "";
        }
        dVar.f55680c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            dVar.f55680c = "";
        }
        dVar.f55681d = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            dVar.f55681d = "";
        }
        dVar.f55682e = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            dVar.f55682e = "";
        }
        dVar.f55683f = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            dVar.f55683f = "";
        }
        dVar.f55684g = jSONObject.optInt("loadType");
        dVar.f55685h = jSONObject.optInt("packageType");
        dVar.f55686i = jSONObject.optBoolean("isPublic");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "packageId", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "zipFileName", dVar.f55679b);
        com.kwad.sdk.utils.t.a(jSONObject, FileMetaUtil.ZIP_PATH, dVar.f55680c);
        com.kwad.sdk.utils.t.a(jSONObject, "packageUrl", dVar.f55681d);
        com.kwad.sdk.utils.t.a(jSONObject, "version", dVar.f55682e);
        com.kwad.sdk.utils.t.a(jSONObject, "checksum", dVar.f55683f);
        com.kwad.sdk.utils.t.a(jSONObject, "loadType", dVar.f55684g);
        com.kwad.sdk.utils.t.a(jSONObject, "packageType", dVar.f55685h);
        com.kwad.sdk.utils.t.a(jSONObject, "isPublic", dVar.f55686i);
        return jSONObject;
    }
}
