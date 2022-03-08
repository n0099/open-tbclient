package com.kwad.sdk.core.b.kwai;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class em implements com.kwad.sdk.core.d<h.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("type");
        aVar.f54946b = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.f54946b = "";
        }
        aVar.f54947c = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            aVar.f54947c = "";
        }
        aVar.f54948d = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            aVar.f54948d = "";
        }
        aVar.f54949e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f54950f = jSONObject.optInt("appSize");
        aVar.f54951g = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.f54951g = "";
        }
        aVar.f54952h = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.f54952h = "";
        }
        aVar.f54953i = jSONObject.optString("appLink");
        if (jSONObject.opt("appLink") == JSONObject.NULL) {
            aVar.f54953i = "";
        }
        aVar.f54954j = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            aVar.f54954j = "";
        }
        aVar.k = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            aVar.k = "";
        }
        aVar.l = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            aVar.l = "";
        }
        aVar.m = jSONObject.optString("marketUri");
        if (jSONObject.opt("marketUri") == JSONObject.NULL) {
            aVar.m = "";
        }
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "type", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "appName", aVar.f54946b);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", aVar.f54947c);
        com.kwad.sdk.utils.t.a(jSONObject, "version", aVar.f54948d);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f54949e);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", aVar.f54950f);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.f54951g);
        com.kwad.sdk.utils.t.a(jSONObject, "url", aVar.f54952h);
        com.kwad.sdk.utils.t.a(jSONObject, "appLink", aVar.f54953i);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", aVar.f54954j);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", aVar.k);
        com.kwad.sdk.utils.t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
        com.kwad.sdk.utils.t.a(jSONObject, "marketUri", aVar.m);
        com.kwad.sdk.utils.t.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
        com.kwad.sdk.utils.t.a(jSONObject, "isLandscapeSupported", aVar.o);
        com.kwad.sdk.utils.t.a(jSONObject, "isFromLive", aVar.p);
        return jSONObject;
    }
}
