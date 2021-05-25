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
        bVar.f32901a = jSONObject.optString("appName");
        bVar.f32902b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.f32903c = jSONObject.optString("version");
        bVar.f32904d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.f32905e = jSONObject.optLong("appSize");
        bVar.f32906f = jSONObject.optString(PackageTable.MD5);
        bVar.f32907g = jSONObject.optString("url");
        bVar.f32908h = jSONObject.optString("icon");
        bVar.f32909i = jSONObject.optString("desc");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f32901a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f32902b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.f32903c);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.f32904d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.f32905e);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, bVar.f32906f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.f32907g);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", bVar.f32908h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.f32909i);
        return jSONObject;
    }
}
