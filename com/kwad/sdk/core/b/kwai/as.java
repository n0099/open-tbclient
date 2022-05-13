package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.l;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class as implements com.kwad.sdk.core.d<l.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optBoolean("clickActionButton");
        aVar.b = jSONObject.optString("adTemplate");
        if (jSONObject.opt("adTemplate") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C0312b c0312b = new b.C0312b();
        aVar.d = c0312b;
        c0312b.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.d);
        return jSONObject;
    }
}
