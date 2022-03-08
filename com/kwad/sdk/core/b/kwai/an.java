package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.kwad.tachikoma.config.TKConfigResultData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class an implements com.kwad.sdk.core.d<TKConfigResultData.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(TKConfigResultData.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optLong("interval");
        aVar.f56670b = jSONObject.optString("jsVersion");
        if (jSONObject.opt("jsVersion") == JSONObject.NULL) {
            aVar.f56670b = "";
        }
        aVar.f56671c = jSONObject.optString("dynamicUrl");
        if (jSONObject.opt("dynamicUrl") == JSONObject.NULL) {
            aVar.f56671c = "";
        }
        aVar.f56672d = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.f56672d = "";
        }
        aVar.f56673e = jSONObject.optInt("dynamicType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(TKConfigResultData.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "interval", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "jsVersion", aVar.f56670b);
        com.kwad.sdk.utils.t.a(jSONObject, "dynamicUrl", aVar.f56671c);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.f56672d);
        com.kwad.sdk.utils.t.a(jSONObject, "dynamicType", aVar.f56673e);
        return jSONObject;
    }
}
