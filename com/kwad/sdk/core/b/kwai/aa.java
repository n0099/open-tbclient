package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aa implements com.kwad.sdk.core.d<q.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            bVar.a = "";
        }
        bVar.f56433b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f56433b = "";
        }
        bVar.f56434c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f56434c = "";
        }
        bVar.f56435d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f56436e = jSONObject.optLong("appSize");
        bVar.f56437f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f56437f = "";
        }
        bVar.f56438g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f56438g = "";
        }
        bVar.f56439h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f56439h = "";
        }
        bVar.f56440i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.f56440i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f56433b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f56434c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f56435d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f56436e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f56437f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f56438g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f56439h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.f56440i);
        return jSONObject;
    }
}
