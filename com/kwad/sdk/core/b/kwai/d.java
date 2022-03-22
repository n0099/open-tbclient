package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.core.d<b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f40011b = jSONObject.optBoolean("clickActionButton");
        aVar.f40012c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C1973b c1973b = new b.C1973b();
        aVar.f40013d = c1973b;
        c1973b.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.f40014e = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.f40011b);
        com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.f40012c);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.f40013d);
        com.kwad.sdk.utils.t.a(jSONObject, "creativeId", aVar.f40014e);
        return jSONObject;
    }
}
