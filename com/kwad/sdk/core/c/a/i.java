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
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f34672a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f34673b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f34674c);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f34675d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f34676e);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f34677f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f34678g);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f34679h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.i);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f34672a = jSONObject.optString("appName");
        bVar.f34673b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f34674c = jSONObject.optString("version");
        bVar.f34675d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f34676e = jSONObject.optLong("appSize");
        bVar.f34677f = jSONObject.optString(PackageTable.MD5);
        bVar.f34678g = jSONObject.optString("url");
        bVar.f34679h = jSONObject.optString("icon");
        bVar.i = jSONObject.optString("desc");
    }
}
