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
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f34767a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f34768b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f34769c);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f34770d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f34771e);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f34772f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f34773g);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f34774h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.i);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f34767a = jSONObject.optString("appName");
        bVar.f34768b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f34769c = jSONObject.optString("version");
        bVar.f34770d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f34771e = jSONObject.optLong("appSize");
        bVar.f34772f = jSONObject.optString(PackageTable.MD5);
        bVar.f34773g = jSONObject.optString("url");
        bVar.f34774h = jSONObject.optString("icon");
        bVar.i = jSONObject.optString("desc");
    }
}
