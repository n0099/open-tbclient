package com.kwad.sdk.core.c.a;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.g;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ae implements com.kwad.sdk.core.c<g.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(g.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "type", aVar.f35085a);
        com.kwad.sdk.utils.o.a(jSONObject, "appName", aVar.f35086b);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, aVar.f35087c);
        com.kwad.sdk.utils.o.a(jSONObject, "version", aVar.f35088d);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f35089e);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", aVar.f35090f);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, aVar.f35091g);
        com.kwad.sdk.utils.o.a(jSONObject, "url", aVar.f35092h);
        com.kwad.sdk.utils.o.a(jSONObject, "appLink", aVar.f35093i);
        com.kwad.sdk.utils.o.a(jSONObject, "icon", aVar.j);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", aVar.k);
        com.kwad.sdk.utils.o.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
        com.kwad.sdk.utils.o.a(jSONObject, "marketUri", aVar.m);
        com.kwad.sdk.utils.o.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
        com.kwad.sdk.utils.o.a(jSONObject, "isLandscapeSupported", aVar.o);
        com.kwad.sdk.utils.o.a(jSONObject, "isFromLive", aVar.p);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f35085a = jSONObject.optInt("type");
        aVar.f35086b = jSONObject.optString("appName");
        aVar.f35087c = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        aVar.f35088d = jSONObject.optString("version");
        aVar.f35089e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f35090f = jSONObject.optInt("appSize");
        aVar.f35091g = jSONObject.optString(PackageTable.MD5);
        aVar.f35092h = jSONObject.optString("url");
        aVar.f35093i = jSONObject.optString("appLink");
        aVar.j = jSONObject.optString("icon");
        aVar.k = jSONObject.optString("desc");
        aVar.l = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        aVar.m = jSONObject.optString("marketUri");
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }
}
