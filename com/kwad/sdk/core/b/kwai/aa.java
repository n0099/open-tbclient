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
        bVar.f56478b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f56478b = "";
        }
        bVar.f56479c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f56479c = "";
        }
        bVar.f56480d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f56481e = jSONObject.optLong("appSize");
        bVar.f56482f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f56482f = "";
        }
        bVar.f56483g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f56483g = "";
        }
        bVar.f56484h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f56484h = "";
        }
        bVar.f56485i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.f56485i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f56478b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f56479c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f56480d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f56481e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f56482f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f56483g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f56484h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.f56485i);
        return jSONObject;
    }
}
