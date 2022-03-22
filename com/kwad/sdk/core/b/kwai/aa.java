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
        bVar.f40081b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f40081b = "";
        }
        bVar.f40082c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f40082c = "";
        }
        bVar.f40083d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f40084e = jSONObject.optLong("appSize");
        bVar.f40085f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f40085f = "";
        }
        bVar.f40086g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f40086g = "";
        }
        bVar.f40087h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f40087h = "";
        }
        bVar.i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f40081b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f40082c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f40083d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f40084e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f40085f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f40086g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f40087h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.i);
        return jSONObject;
    }
}
