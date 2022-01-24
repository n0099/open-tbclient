package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.kwad.tachikoma.config.TKConfigResultData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an implements com.kwad.sdk.core.d<TKConfigResultData.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(TKConfigResultData.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optLong("interval");
        aVar.f58153b = jSONObject.optString("jsVersion");
        if (jSONObject.opt("jsVersion") == JSONObject.NULL) {
            aVar.f58153b = "";
        }
        aVar.f58154c = jSONObject.optString("dynamicUrl");
        if (jSONObject.opt("dynamicUrl") == JSONObject.NULL) {
            aVar.f58154c = "";
        }
        aVar.f58155d = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.f58155d = "";
        }
        aVar.f58156e = jSONObject.optInt("dynamicType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(TKConfigResultData.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interval", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "jsVersion", aVar.f58153b);
        com.kwad.sdk.utils.t.a(jSONObject, "dynamicUrl", aVar.f58154c);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.f58155d);
        com.kwad.sdk.utils.t.a(jSONObject, "dynamicType", aVar.f58156e);
        return jSONObject;
    }
}
