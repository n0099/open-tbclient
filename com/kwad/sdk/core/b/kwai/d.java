package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.player.model.YYOption;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.a.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mv = jSONObject.optBoolean("clickActionButton");
        aVar.Mx = jSONObject.optInt(DnsModel.AREA_KEY);
        com.kwad.sdk.core.webview.a.a.c cVar = new com.kwad.sdk.core.webview.a.a.c();
        aVar.My = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.DZ = jSONObject.optBoolean("needReport", new Boolean(YYOption.IsLive.VALUE_TRUE).booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Mv;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clickActionButton", z);
        }
        int i = aVar.Mx;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, DnsModel.AREA_KEY, i);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "logParam", aVar.My);
        com.kwad.sdk.utils.r.putValue(jSONObject, "needReport", aVar.DZ);
        com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.r.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
