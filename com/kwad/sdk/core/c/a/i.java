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
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f35126a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f35127b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f35128c);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f35129d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f35130e);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f35131f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f35132g);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f35133h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.f35134i);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f35126a = jSONObject.optString("appName");
        bVar.f35127b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f35128c = jSONObject.optString("version");
        bVar.f35129d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f35130e = jSONObject.optLong("appSize");
        bVar.f35131f = jSONObject.optString(PackageTable.MD5);
        bVar.f35132g = jSONObject.optString("url");
        bVar.f35133h = jSONObject.optString("icon");
        bVar.f35134i = jSONObject.optString("desc");
    }
}
