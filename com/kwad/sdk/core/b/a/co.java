package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.kwad.components.core.webview.jshandler.al;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class co implements com.kwad.sdk.core.d<al.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(al.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Xl = jSONObject.optBoolean("clickActionButton");
        aVar.Xm = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.Xm)) {
            aVar.Xm = "";
        }
        aVar.Xn = jSONObject.optInt(DnsModel.AREA_KEY);
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        aVar.Xo = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(al.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Xl;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z);
        }
        String str = aVar.Xm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adTemplate", aVar.Xm);
        }
        int i = aVar.Xn;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DnsModel.AREA_KEY, i);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.Xo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(al.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(al.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
