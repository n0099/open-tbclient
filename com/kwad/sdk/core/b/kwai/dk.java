package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.download.model.Downloads;
import com.baidubce.http.Headers;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dk implements com.kwad.sdk.core.d<com.kwad.components.a.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (jSONObject.opt("Content-Encoding") == JSONObject.NULL) {
            bVar.contentEncoding = "";
        }
        bVar.PW = jSONObject.optString(Headers.CACHE_CONTROL);
        if (jSONObject.opt(Headers.CACHE_CONTROL) == JSONObject.NULL) {
            bVar.PW = "";
        }
        bVar.PU = jSONObject.optString("Content-Type");
        if (jSONObject.opt("Content-Type") == JSONObject.NULL) {
            bVar.PU = "";
        }
        com.kwad.components.a.kwai.a aVar = new com.kwad.components.a.kwai.a();
        bVar.PX = aVar;
        aVar.parseJson(jSONObject.optJSONObject(Downloads.Impl.RequestHeaders.URI_SEGMENT));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Status", i);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.PW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, Headers.CACHE_CONTROL, bVar.PW);
        }
        String str3 = bVar.PU;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "Content-Type", bVar.PU);
        }
        com.kwad.sdk.utils.r.a(jSONObject, Downloads.Impl.RequestHeaders.URI_SEGMENT, bVar.PX);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.a.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
