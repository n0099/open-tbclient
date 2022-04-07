package com.kwad.sdk.core.b.kwai;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.h;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class em implements com.kwad.sdk.core.d<h.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("type");
        aVar.b = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            aVar.c = "";
        }
        aVar.d = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            aVar.d = "";
        }
        aVar.e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f = jSONObject.optInt("appSize");
        aVar.g = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.g = "";
        }
        aVar.h = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.h = "";
        }
        aVar.i = jSONObject.optString("appLink");
        if (jSONObject.opt("appLink") == JSONObject.NULL) {
            aVar.i = "";
        }
        aVar.j = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            aVar.j = "";
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
        com.kwad.sdk.utils.t.a(jSONObject, "appName", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "version", aVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", aVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.g);
        com.kwad.sdk.utils.t.a(jSONObject, "url", aVar.h);
        com.kwad.sdk.utils.t.a(jSONObject, "appLink", aVar.i);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", aVar.j);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", aVar.k);
        com.kwad.sdk.utils.t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
        com.kwad.sdk.utils.t.a(jSONObject, "marketUri", aVar.m);
        com.kwad.sdk.utils.t.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
        com.kwad.sdk.utils.t.a(jSONObject, "isLandscapeSupported", aVar.o);
        com.kwad.sdk.utils.t.a(jSONObject, "isFromLive", aVar.p);
        return jSONObject;
    }
}
