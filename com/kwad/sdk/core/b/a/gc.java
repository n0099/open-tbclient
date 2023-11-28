package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.download.model.Downloads;
import com.baidubce.http.Headers;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class gc implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (JSONObject.NULL.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.aDq = jSONObject.optString(Headers.CACHE_CONTROL);
        if (JSONObject.NULL.toString().equals(bVar.aDq)) {
            bVar.aDq = "";
        }
        bVar.aDo = jSONObject.optString("Content-Type");
        if (JSONObject.NULL.toString().equals(bVar.aDo)) {
            bVar.aDo = "";
        }
        com.kwad.sdk.core.webview.b.a.a aVar = new com.kwad.sdk.core.webview.b.a.a();
        bVar.aDr = aVar;
        aVar.parseJson(jSONObject.optJSONObject(Downloads.Impl.RequestHeaders.URI_SEGMENT));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Status", i);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.aDq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Headers.CACHE_CONTROL, bVar.aDq);
        }
        String str3 = bVar.aDo;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Type", bVar.aDo);
        }
        com.kwad.sdk.utils.t.a(jSONObject, Downloads.Impl.RequestHeaders.URI_SEGMENT, bVar.aDr);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
