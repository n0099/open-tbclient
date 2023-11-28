package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class kq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.y> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.nD = jSONObject.optInt("currentTime");
        yVar.aak = jSONObject.optBoolean("failed");
        yVar.aag = jSONObject.optBoolean(DownloadStatisticConstants.UBC_TYPE_FINISHED);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = yVar.nD;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i);
        }
        boolean z = yVar.aak;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed", z);
        }
        boolean z2 = yVar.aag;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DownloadStatisticConstants.UBC_TYPE_FINISHED, z2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }
}
