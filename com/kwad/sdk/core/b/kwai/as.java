package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.l;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class as implements com.kwad.sdk.core.d<l.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optBoolean("clickActionButton");
        aVar.f56413b = jSONObject.optString("adTemplate");
        if (jSONObject.opt("adTemplate") == JSONObject.NULL) {
            aVar.f56413b = "";
        }
        aVar.f56414c = jSONObject.optInt(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
        b.C2117b c2117b = new b.C2117b();
        aVar.f56415d = c2117b;
        c2117b.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clickActionButton", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", aVar.f56413b);
        com.kwad.sdk.utils.t.a(jSONObject, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, aVar.f56414c);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.f56415d);
        return jSONObject;
    }
}
