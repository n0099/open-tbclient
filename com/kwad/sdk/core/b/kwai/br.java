package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class br implements com.kwad.sdk.core.d<AdMatrixInfo.DownloadTexts> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadTexts.adActionDescription = jSONObject.optString("adActionDescription");
        if (jSONObject.opt("adActionDescription") == JSONObject.NULL) {
            downloadTexts.adActionDescription = "";
        }
        downloadTexts.installAppLabel = jSONObject.optString("installAppLabel");
        if (jSONObject.opt("installAppLabel") == JSONObject.NULL) {
            downloadTexts.installAppLabel = "";
        }
        downloadTexts.openAppLabel = jSONObject.optString("openAppLabel");
        if (jSONObject.opt("openAppLabel") == JSONObject.NULL) {
            downloadTexts.openAppLabel = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "adActionDescription", downloadTexts.adActionDescription);
        com.kwad.sdk.utils.r.a(jSONObject, "installAppLabel", downloadTexts.installAppLabel);
        com.kwad.sdk.utils.r.a(jSONObject, "openAppLabel", downloadTexts.openAppLabel);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        a2(downloadTexts, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        return b2(downloadTexts, jSONObject);
    }
}
