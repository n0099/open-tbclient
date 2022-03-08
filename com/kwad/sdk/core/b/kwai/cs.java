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
        dVar.f54029b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            dVar.f54029b = "";
        }
        dVar.f54030c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            dVar.f54030c = "";
        }
        dVar.f54031d = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            dVar.f54031d = "";
        }
        dVar.f54032e = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            dVar.f54032e = "";
        }
        dVar.f54033f = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            dVar.f54033f = "";
        }
        dVar.f54034g = jSONObject.optInt("loadType");
        dVar.f54035h = jSONObject.optInt("packageType");
        dVar.f54036i = jSONObject.optBoolean("isPublic");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "packageId", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "zipFileName", dVar.f54029b);
        com.kwad.sdk.utils.t.a(jSONObject, FileMetaUtil.ZIP_PATH, dVar.f54030c);
        com.kwad.sdk.utils.t.a(jSONObject, "packageUrl", dVar.f54031d);
        com.kwad.sdk.utils.t.a(jSONObject, "version", dVar.f54032e);
        com.kwad.sdk.utils.t.a(jSONObject, "checksum", dVar.f54033f);
        com.kwad.sdk.utils.t.a(jSONObject, "loadType", dVar.f54034g);
        com.kwad.sdk.utils.t.a(jSONObject, "packageType", dVar.f54035h);
        com.kwad.sdk.utils.t.a(jSONObject, "isPublic", dVar.f54036i);
        return jSONObject;
    }
}
