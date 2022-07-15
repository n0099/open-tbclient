package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dk implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.a = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            iVar.a = "";
        }
        iVar.b = jSONObject.optString("host");
        if (jSONObject.opt("host") == JSONObject.NULL) {
            iVar.b = "";
        }
        iVar.c = jSONObject.optInt(ETAG.KEY_HTTP_CODE);
        iVar.d = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
        if (jSONObject.opt(GameCodeGetResponseMsg.PARAM_ERROR_MSG) == JSONObject.NULL) {
            iVar.d = "";
        }
        iVar.e = jSONObject.optString("req_type");
        if (jSONObject.opt("req_type") == JSONObject.NULL) {
            iVar.e = "";
        }
        iVar.f = jSONObject.optInt("use_ip");
        iVar.g = jSONObject.optInt("rate_reciprocal");
        iVar.h = jSONObject.optInt("rate");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "url", iVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "host", iVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, ETAG.KEY_HTTP_CODE, iVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, GameCodeGetResponseMsg.PARAM_ERROR_MSG, iVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "req_type", iVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "use_ip", iVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "rate_reciprocal", iVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, "rate", iVar.h);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }
}
