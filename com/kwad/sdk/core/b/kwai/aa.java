package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        bVar.f54995b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f54995b = "";
        }
        bVar.f54996c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f54996c = "";
        }
        bVar.f54997d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f54998e = jSONObject.optLong("appSize");
        bVar.f54999f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f54999f = "";
        }
        bVar.f55000g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f55000g = "";
        }
        bVar.f55001h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f55001h = "";
        }
        bVar.f55002i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.f55002i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f54995b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f54996c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f54997d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f54998e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f54999f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f55000g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f55001h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.f55002i);
        return jSONObject;
    }
}
