package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.player.model.YYOption;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Xl = jSONObject.optBoolean("clickActionButton");
        aVar.Xn = jSONObject.optInt(DnsModel.AREA_KEY);
        aVar.kk = jSONObject.optInt("itemClickType");
        aVar.aDH = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        aVar.Xo = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.KC = jSONObject.optBoolean("needReport", new Boolean(YYOption.IsLive.VALUE_TRUE).booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.KM = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.KM)) {
            aVar.KM = "";
        }
        aVar.aDI = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.aDJ = jSONObject.optBoolean("isCallbackOnly");
        aVar.aDK = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Xl;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z);
        }
        int i = aVar.Xn;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DnsModel.AREA_KEY, i);
        }
        int i2 = aVar.kk;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "convertPageType", aVar.aDH);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.Xo);
        com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", aVar.KC);
        com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.KM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveItemId", aVar.KM);
        }
        int i3 = aVar.aDI;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sceneType", i3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z2 = aVar.aDJ;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isCallbackOnly", z2);
        }
        boolean z3 = aVar.aDK;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableCallback", z3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
