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
        com.kwad.sdk.utils.o.a(jSONObject, "type", aVar.f34632a);
        com.kwad.sdk.utils.o.a(jSONObject, "appName", aVar.f34633b);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, aVar.f34634c);
        com.kwad.sdk.utils.o.a(jSONObject, "version", aVar.f34635d);
        com.kwad.sdk.utils.o.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f34636e);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", aVar.f34637f);
        com.kwad.sdk.utils.o.a(jSONObject, PackageTable.MD5, aVar.f34638g);
        com.kwad.sdk.utils.o.a(jSONObject, "url", aVar.f34639h);
        com.kwad.sdk.utils.o.a(jSONObject, "appLink", aVar.i);
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
        aVar.f34632a = jSONObject.optInt("type");
        aVar.f34633b = jSONObject.optString("appName");
        aVar.f34634c = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        aVar.f34635d = jSONObject.optString("version");
        aVar.f34636e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f34637f = jSONObject.optInt("appSize");
        aVar.f34638g = jSONObject.optString(PackageTable.MD5);
        aVar.f34639h = jSONObject.optString("url");
        aVar.i = jSONObject.optString("appLink");
        aVar.j = jSONObject.optString("icon");
        aVar.k = jSONObject.optString("desc");
        aVar.l = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        aVar.m = jSONObject.optString("marketUri");
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }
}
