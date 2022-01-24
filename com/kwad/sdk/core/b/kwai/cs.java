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
        dVar.f55512b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            dVar.f55512b = "";
        }
        dVar.f55513c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            dVar.f55513c = "";
        }
        dVar.f55514d = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            dVar.f55514d = "";
        }
        dVar.f55515e = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            dVar.f55515e = "";
        }
        dVar.f55516f = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            dVar.f55516f = "";
        }
        dVar.f55517g = jSONObject.optInt("loadType");
        dVar.f55518h = jSONObject.optInt("packageType");
        dVar.f55519i = jSONObject.optBoolean("isPublic");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.c.kwai.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "packageId", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "zipFileName", dVar.f55512b);
        com.kwad.sdk.utils.t.a(jSONObject, FileMetaUtil.ZIP_PATH, dVar.f55513c);
        com.kwad.sdk.utils.t.a(jSONObject, "packageUrl", dVar.f55514d);
        com.kwad.sdk.utils.t.a(jSONObject, "version", dVar.f55515e);
        com.kwad.sdk.utils.t.a(jSONObject, "checksum", dVar.f55516f);
        com.kwad.sdk.utils.t.a(jSONObject, "loadType", dVar.f55517g);
        com.kwad.sdk.utils.t.a(jSONObject, "packageType", dVar.f55518h);
        com.kwad.sdk.utils.t.a(jSONObject, "isPublic", dVar.f55519i);
        return jSONObject;
    }
}
