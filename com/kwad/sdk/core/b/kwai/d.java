package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements com.kwad.sdk.core.d<b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f56359b = jSONObject.optBoolean("clickActionButton");
        aVar.f56360c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C2117b c2117b = new b.C2117b();
        aVar.f56361d = c2117b;
        c2117b.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.f56362e = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.f56359b);
        com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.f56360c);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.f56361d);
        com.kwad.sdk.utils.t.a(jSONObject, "creativeId", aVar.f56362e);
        return jSONObject;
    }
}
