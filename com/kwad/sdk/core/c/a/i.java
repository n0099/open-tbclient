package com.kwad.sdk.core.c.a;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.l;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements com.kwad.sdk.core.c<l.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(l.b bVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f35028a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f35029b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f35030c);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f35031d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f35032e);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f35033f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f35034g);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f35035h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.f35036i);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f35028a = jSONObject.optString("appName");
        bVar.f35029b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f35030c = jSONObject.optString("version");
        bVar.f35031d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f35032e = jSONObject.optLong("appSize");
        bVar.f35033f = jSONObject.optString(PackageTable.MD5);
        bVar.f35034g = jSONObject.optString("url");
        bVar.f35035h = jSONObject.optString("icon");
        bVar.f35036i = jSONObject.optString("desc");
    }
}
