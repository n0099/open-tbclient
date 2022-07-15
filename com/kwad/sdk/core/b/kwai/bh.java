package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.kwad.components.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bh implements com.kwad.sdk.core.d<q.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optBoolean("clickActionButton");
        aVar.b = jSONObject.optString("adTemplate");
        if (jSONObject.opt("adTemplate") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        com.kwad.sdk.core.webview.a.a.c cVar = new com.kwad.sdk.core.webview.a.a.c();
        aVar.d = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "clickActionButton", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "adTemplate", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "logParam", aVar.d);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(q.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(q.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
