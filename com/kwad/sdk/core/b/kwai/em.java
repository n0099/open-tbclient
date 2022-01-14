package com.kwad.sdk.core.b.kwai;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.sdk.core.webview.jshandler.h;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class em implements com.kwad.sdk.core.d<h.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("type");
        aVar.f56384b = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.f56384b = "";
        }
        aVar.f56385c = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            aVar.f56385c = "";
        }
        aVar.f56386d = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            aVar.f56386d = "";
        }
        aVar.f56387e = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        aVar.f56388f = jSONObject.optInt("appSize");
        aVar.f56389g = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.f56389g = "";
        }
        aVar.f56390h = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.f56390h = "";
        }
        aVar.f56391i = jSONObject.optString("appLink");
        if (jSONObject.opt("appLink") == JSONObject.NULL) {
            aVar.f56391i = "";
        }
        aVar.f56392j = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            aVar.f56392j = "";
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
        com.kwad.sdk.utils.t.a(jSONObject, "appName", aVar.f56384b);
        com.kwad.sdk.utils.t.a(jSONObject, "pkgName", aVar.f56385c);
        com.kwad.sdk.utils.t.a(jSONObject, "version", aVar.f56386d);
        com.kwad.sdk.utils.t.a(jSONObject, PushManager.APP_VERSION_CODE, aVar.f56387e);
        com.kwad.sdk.utils.t.a(jSONObject, "appSize", aVar.f56388f);
        com.kwad.sdk.utils.t.a(jSONObject, PackageTable.MD5, aVar.f56389g);
        com.kwad.sdk.utils.t.a(jSONObject, "url", aVar.f56390h);
        com.kwad.sdk.utils.t.a(jSONObject, "appLink", aVar.f56391i);
        com.kwad.sdk.utils.t.a(jSONObject, "icon", aVar.f56392j);
        com.kwad.sdk.utils.t.a(jSONObject, "desc", aVar.k);
        com.kwad.sdk.utils.t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.l);
        com.kwad.sdk.utils.t.a(jSONObject, "marketUri", aVar.m);
        com.kwad.sdk.utils.t.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
        com.kwad.sdk.utils.t.a(jSONObject, "isLandscapeSupported", aVar.o);
        com.kwad.sdk.utils.t.a(jSONObject, "isFromLive", aVar.p);
        return jSONObject;
    }
}
