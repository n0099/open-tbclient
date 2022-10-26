package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dv implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ait = jSONObject.optString("packageId");
        if (jSONObject.opt("packageId") == JSONObject.NULL) {
            bVar.ait = "";
        }
        bVar.aiu = jSONObject.optString("zipFileName");
        if (jSONObject.opt("zipFileName") == JSONObject.NULL) {
            bVar.aiu = "";
        }
        bVar.aiv = jSONObject.optString(FileMetaUtil.ZIP_PATH);
        if (jSONObject.opt(FileMetaUtil.ZIP_PATH) == JSONObject.NULL) {
            bVar.aiv = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (jSONObject.opt("packageUrl") == JSONObject.NULL) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.version = "";
        }
        bVar.aix = jSONObject.optString("checksum");
        if (jSONObject.opt("checksum") == JSONObject.NULL) {
            bVar.aix = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aiy = jSONObject.optBoolean("public");
    }

    public static JSONObject b(com.kwad.sdk.e.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.ait;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "packageId", bVar.ait);
        }
        String str2 = bVar.aiu;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "zipFileName", bVar.aiu);
        }
        String str3 = bVar.aiv;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, FileMetaUtil.ZIP_PATH, bVar.aiv);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.aix;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "checksum", bVar.aix);
        }
        int i = bVar.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "loadType", i);
        }
        int i2 = bVar.packageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "packageType", i2);
        }
        boolean z = bVar.aiy;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "public", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.e.kwai.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.e.kwai.b) bVar, jSONObject);
    }
}
