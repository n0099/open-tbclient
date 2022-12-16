package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.kwad.components.core.webview.jshandler.t;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class bi implements com.kwad.sdk.core.d<t.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mv = jSONObject.optBoolean("clickActionButton");
        aVar.Mw = jSONObject.optString("adTemplate");
        if (jSONObject.opt("adTemplate") == JSONObject.NULL) {
            aVar.Mw = "";
        }
        aVar.Mx = jSONObject.optInt(DnsModel.AREA_KEY);
        com.kwad.sdk.core.webview.a.a.c cVar = new com.kwad.sdk.core.webview.a.a.c();
        aVar.My = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Mv;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clickActionButton", z);
        }
        String str = aVar.Mw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adTemplate", aVar.Mw);
        }
        int i = aVar.Mx;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, DnsModel.AREA_KEY, i);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "logParam", aVar.My);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(t.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(t.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
