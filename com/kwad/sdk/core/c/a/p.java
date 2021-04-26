package com.kwad.sdk.core.c.a;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.l;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p implements com.kwad.sdk.core.c<l.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f33727a = jSONObject.optString("appName");
        bVar.f33728b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f33729c = jSONObject.optString("version");
        bVar.f33730d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f33731e = jSONObject.optLong("appSize");
        bVar.f33732f = jSONObject.optString(PackageTable.MD5);
        bVar.f33733g = jSONObject.optString("url");
        bVar.f33734h = jSONObject.optString("icon");
        bVar.f33735i = jSONObject.optString("desc");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f33727a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f33728b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f33729c);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f33730d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f33731e);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f33732f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f33733g);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f33734h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.f33735i);
        return jSONObject;
    }
}
