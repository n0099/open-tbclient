package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.q;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
        bVar.f56645b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.f56645b = "";
        }
        bVar.f56646c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.f56646c = "";
        }
        bVar.f56647d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f56648e = jSONObject.optLong("appSize");
        bVar.f56649f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f56649f = "";
        }
        bVar.f56650g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.f56650g = "";
        }
        bVar.f56651h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.f56651h = "";
        }
        bVar.f56652i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.f56652i = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(q.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", bVar.f56645b);
        com.kwad.sdk.utils.t.a(jSONObject, "version", bVar.f56646c);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f56647d);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", bVar.f56648e);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, bVar.f56649f);
        com.kwad.sdk.utils.t.a(jSONObject, "url", bVar.f56650g);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", bVar.f56651h);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", bVar.f56652i);
        return jSONObject;
    }
}
