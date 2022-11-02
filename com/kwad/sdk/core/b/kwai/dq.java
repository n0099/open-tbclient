package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class dq implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            jVar.url = "";
        }
        jVar.host = jSONObject.optString("host");
        if (jSONObject.opt("host") == JSONObject.NULL) {
            jVar.host = "";
        }
        jVar.httpCode = jSONObject.optInt(ETAG.KEY_HTTP_CODE);
        jVar.errorMsg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
        if (jSONObject.opt(GameCodeGetResponseMsg.PARAM_ERROR_MSG) == JSONObject.NULL) {
            jVar.errorMsg = "";
        }
        jVar.Yp = jSONObject.optString("req_type");
        if (jSONObject.opt("req_type") == JSONObject.NULL) {
            jVar.Yp = "";
        }
        jVar.Yq = jSONObject.optInt("use_ip");
        jVar.Yr = jSONObject.optInt("rate_reciprocal");
        jVar.ratioCount = jSONObject.optDouble("ratio_count");
        jVar.Ys = jSONObject.optInt("rate");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = jVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", jVar.url);
        }
        String str2 = jVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "host", jVar.host);
        }
        int i = jVar.httpCode;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, ETAG.KEY_HTTP_CODE, i);
        }
        String str3 = jVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, jVar.errorMsg);
        }
        String str4 = jVar.Yp;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "req_type", jVar.Yp);
        }
        int i2 = jVar.Yq;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "use_ip", i2);
        }
        int i3 = jVar.Yr;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "rate_reciprocal", i3);
        }
        double d = jVar.ratioCount;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", d);
        }
        int i4 = jVar.Ys;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "rate", i4);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
