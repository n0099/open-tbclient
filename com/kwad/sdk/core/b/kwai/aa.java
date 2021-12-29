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
        bVar.f58644b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f58644b = "";
        }
        bVar.f58645c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f58645c = "";
        }
        bVar.f58646d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f58647e = jSONObject.optLong("appSize");
        bVar.f58648f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f58648f = "";
        }
        bVar.f58649g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f58649g = "";
        }
        bVar.f58650h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f58650h = "";
        }
        bVar.f58651i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.f58651i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f58644b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f58645c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f58646d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f58647e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f58648f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f58649g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f58650h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.f58651i);
        return jSONObject;
    }
}
