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
        aVar.f56404b = jSONObject.optBoolean("clickActionButton");
        aVar.f56405c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C2123b c2123b = new b.C2123b();
        aVar.f56406d = c2123b;
        c2123b.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.f56407e = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.f56404b);
        com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.f56405c);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.f56406d);
        com.kwad.sdk.utils.t.a(jSONObject, "creativeId", aVar.f56407e);
        return jSONObject;
    }
}
