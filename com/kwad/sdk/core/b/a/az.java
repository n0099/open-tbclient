package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class az implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.anF = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.anF)) {
            bVar.anF = "";
        }
        bVar.downloadId = jSONObject.optString("download_id");
        if (JSONObject.NULL.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.anG = jSONObject.optString("apk_package");
        if (JSONObject.NULL.toString().equals(bVar.anG)) {
            bVar.anG = "";
        }
        bVar.anH = jSONObject.optString("apk_name");
        if (JSONObject.NULL.toString().equals(bVar.anH)) {
            bVar.anH = "";
        }
        bVar.anI = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.anJ = jSONObject.optLong("apk_cur_size");
        bVar.anK = jSONObject.optInt("apk_install_type");
        bVar.anL = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.anF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_host", bVar.anF);
        }
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_id", bVar.downloadId);
        }
        String str4 = bVar.anG;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_package", bVar.anG);
        }
        String str5 = bVar.anH;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_name", bVar.anH);
        }
        long j = bVar.anI;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_size", j);
        }
        long j2 = bVar.downloadTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_time", j2);
        }
        long j3 = bVar.anJ;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_cur_size", j3);
        }
        int i2 = bVar.anK;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_type", i2);
        }
        int i3 = bVar.anL;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_source", i3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
