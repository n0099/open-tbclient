package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dp implements com.kwad.sdk.core.d<com.kwad.sdk.e.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optString("packageId");
        if (jSONObject.opt("packageId") == JSONObject.NULL) {
            bVar.a = "";
        }
        bVar.b = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            bVar.b = "";
        }
        bVar.c = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            bVar.c = "";
        }
        bVar.e = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            bVar.e = "";
        }
        bVar.f = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f = "";
        }
        bVar.g = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            bVar.g = "";
        }
        bVar.h = jSONObject.optInt("loadType");
        bVar.i = jSONObject.optInt("packageType");
        bVar.j = jSONObject.optBoolean("public");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "packageId", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "zipFileName", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, FileMetaUtil.ZIP_PATH, bVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "packageUrl", bVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "version", bVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "checksum", bVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, "loadType", bVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, "packageType", bVar.i);
        com.kwad.sdk.utils.r.a(jSONObject, "public", bVar.j);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
