package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.components.core.webview.jshandler.k;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class eb implements com.kwad.sdk.core.d<k.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.b = jSONObject.optInt("SDKVersionCode");
        aVar.c = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            aVar.c = "";
        }
        aVar.d = jSONObject.optInt("sdkApiVersionCode");
        aVar.e = jSONObject.optInt("sdkType");
        aVar.f = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            aVar.f = "";
        }
        aVar.g = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.g = "";
        }
        aVar.h = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            aVar.h = "";
        }
        aVar.i = jSONObject.optString("networkType");
        if (jSONObject.opt("networkType") == JSONObject.NULL) {
            aVar.i = "";
        }
        aVar.j = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (jSONObject.opt(HttpConstants.HTTP_MANUFACTURER) == JSONObject.NULL) {
            aVar.j = "";
        }
        aVar.k = jSONObject.optString("model");
        if (jSONObject.opt("model") == JSONObject.NULL) {
            aVar.k = "";
        }
        aVar.l = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            aVar.l = "";
        }
        aVar.m = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        aVar.n = jSONObject.optString("systemVersion");
        if (jSONObject.opt("systemVersion") == JSONObject.NULL) {
            aVar.n = "";
        }
        aVar.o = jSONObject.optInt("osApi");
        aVar.p = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            aVar.p = "";
        }
        aVar.q = jSONObject.optString("locale");
        if (jSONObject.opt("locale") == JSONObject.NULL) {
            aVar.q = "";
        }
        aVar.r = jSONObject.optInt("screenWidth");
        aVar.s = jSONObject.optInt("screenHeight");
        aVar.t = jSONObject.optInt("statusBarHeight");
        aVar.u = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(k.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "SDKVersion", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "SDKVersionCode", aVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkApiVersion", aVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkApiVersionCode", aVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkType", aVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "appVersion", aVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "appName", aVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, "networkType", aVar.i);
        com.kwad.sdk.utils.r.a(jSONObject, HttpConstants.HTTP_MANUFACTURER, aVar.j);
        com.kwad.sdk.utils.r.a(jSONObject, "model", aVar.k);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceBrand", aVar.l);
        com.kwad.sdk.utils.r.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, aVar.m);
        com.kwad.sdk.utils.r.a(jSONObject, "systemVersion", aVar.n);
        com.kwad.sdk.utils.r.a(jSONObject, "osApi", aVar.o);
        com.kwad.sdk.utils.r.a(jSONObject, "language", aVar.p);
        com.kwad.sdk.utils.r.a(jSONObject, "locale", aVar.q);
        com.kwad.sdk.utils.r.a(jSONObject, "screenWidth", aVar.r);
        com.kwad.sdk.utils.r.a(jSONObject, "screenHeight", aVar.s);
        com.kwad.sdk.utils.r.a(jSONObject, "statusBarHeight", aVar.t);
        com.kwad.sdk.utils.r.a(jSONObject, "titleBarHeight", aVar.u);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
