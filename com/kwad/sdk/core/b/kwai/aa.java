package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes5.dex */
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
        bVar.b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.b = "";
        }
        bVar.c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.c = "";
        }
        bVar.d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.e = jSONObject.optLong("appSize");
        bVar.f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f = "";
        }
        bVar.g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.g = "";
        }
        bVar.h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.h = "";
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
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.i);
        return jSONObject;
    }
}
