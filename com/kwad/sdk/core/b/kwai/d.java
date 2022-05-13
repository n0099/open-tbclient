package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements com.kwad.sdk.core.d<b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.b = jSONObject.optBoolean("clickActionButton");
        aVar.c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C0312b c0312b = new b.C0312b();
        aVar.d = c0312b;
        c0312b.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.e = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "creativeId", aVar.e);
        return jSONObject;
    }
}
