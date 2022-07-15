package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.a.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.b = jSONObject.optBoolean("clickActionButton");
        aVar.c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        com.kwad.sdk.core.webview.a.a.c cVar = new com.kwad.sdk.core.webview.a.a.c();
        aVar.d = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.e = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.f = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.g = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "clickActionButton", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "logParam", aVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "needReport", aVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "creativeId", aVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyle", aVar.g);
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
