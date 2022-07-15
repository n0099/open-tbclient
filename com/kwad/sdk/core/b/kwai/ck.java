package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ck implements com.kwad.sdk.core.d<a.C0549a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0549a c0549a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0549a.a = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            c0549a.a = "";
        }
        c0549a.b = jSONObject.optInt("SDKVersionCode");
        c0549a.c = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            c0549a.c = "";
        }
        c0549a.d = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            c0549a.d = "";
        }
        c0549a.e = jSONObject.optInt("sdkApiVersionCode");
        c0549a.f = jSONObject.optInt("sdkType");
        c0549a.g = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            c0549a.g = "";
        }
        c0549a.h = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            c0549a.h = "";
        }
        c0549a.i = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            c0549a.i = "";
        }
        c0549a.j = jSONObject.optString("globalId");
        if (jSONObject.opt("globalId") == JSONObject.NULL) {
            c0549a.j = "";
        }
        c0549a.k = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            c0549a.k = "";
        }
        c0549a.l = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            c0549a.l = "";
        }
        c0549a.m = jSONObject.optString("networkType");
        if (jSONObject.opt("networkType") == JSONObject.NULL) {
            c0549a.m = "";
        }
        c0549a.n = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (jSONObject.opt(HttpConstants.HTTP_MANUFACTURER) == JSONObject.NULL) {
            c0549a.n = "";
        }
        c0549a.o = jSONObject.optString("model");
        if (jSONObject.opt("model") == JSONObject.NULL) {
            c0549a.o = "";
        }
        c0549a.p = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            c0549a.p = "";
        }
        c0549a.q = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        c0549a.r = jSONObject.optString("systemVersion");
        if (jSONObject.opt("systemVersion") == JSONObject.NULL) {
            c0549a.r = "";
        }
        c0549a.s = jSONObject.optInt("osApi");
        c0549a.t = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            c0549a.t = "";
        }
        c0549a.u = jSONObject.optString("locale");
        if (jSONObject.opt("locale") == JSONObject.NULL) {
            c0549a.u = "";
        }
        c0549a.v = jSONObject.optString("uuid");
        if (jSONObject.opt("uuid") == JSONObject.NULL) {
            c0549a.v = "";
        }
        c0549a.w = jSONObject.optInt("screenWidth");
        c0549a.x = jSONObject.optInt("screenHeight");
        c0549a.y = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            c0549a.y = "";
        }
        c0549a.z = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            c0549a.z = "";
        }
        c0549a.A = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            c0549a.A = "";
        }
        c0549a.B = jSONObject.optString("mac");
        if (jSONObject.opt("mac") == JSONObject.NULL) {
            c0549a.B = "";
        }
        c0549a.C = jSONObject.optInt("statusBarHeight");
        c0549a.D = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0549a c0549a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "SDKVersion", c0549a.a);
        com.kwad.sdk.utils.r.a(jSONObject, "SDKVersionCode", c0549a.b);
        com.kwad.sdk.utils.r.a(jSONObject, "tkVersion", c0549a.c);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkApiVersion", c0549a.d);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkApiVersionCode", c0549a.e);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkType", c0549a.f);
        com.kwad.sdk.utils.r.a(jSONObject, "appVersion", c0549a.g);
        com.kwad.sdk.utils.r.a(jSONObject, "appName", c0549a.h);
        com.kwad.sdk.utils.r.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c0549a.i);
        com.kwad.sdk.utils.r.a(jSONObject, "globalId", c0549a.j);
        com.kwad.sdk.utils.r.a(jSONObject, "eGid", c0549a.k);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceSig", c0549a.l);
        com.kwad.sdk.utils.r.a(jSONObject, "networkType", c0549a.m);
        com.kwad.sdk.utils.r.a(jSONObject, HttpConstants.HTTP_MANUFACTURER, c0549a.n);
        com.kwad.sdk.utils.r.a(jSONObject, "model", c0549a.o);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceBrand", c0549a.p);
        com.kwad.sdk.utils.r.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, c0549a.q);
        com.kwad.sdk.utils.r.a(jSONObject, "systemVersion", c0549a.r);
        com.kwad.sdk.utils.r.a(jSONObject, "osApi", c0549a.s);
        com.kwad.sdk.utils.r.a(jSONObject, "language", c0549a.t);
        com.kwad.sdk.utils.r.a(jSONObject, "locale", c0549a.u);
        com.kwad.sdk.utils.r.a(jSONObject, "uuid", c0549a.v);
        com.kwad.sdk.utils.r.a(jSONObject, "screenWidth", c0549a.w);
        com.kwad.sdk.utils.r.a(jSONObject, "screenHeight", c0549a.x);
        com.kwad.sdk.utils.r.a(jSONObject, "imei", c0549a.y);
        com.kwad.sdk.utils.r.a(jSONObject, "oaid", c0549a.z);
        com.kwad.sdk.utils.r.a(jSONObject, "androidId", c0549a.A);
        com.kwad.sdk.utils.r.a(jSONObject, "mac", c0549a.B);
        com.kwad.sdk.utils.r.a(jSONObject, "statusBarHeight", c0549a.C);
        com.kwad.sdk.utils.r.a(jSONObject, "titleBarHeight", c0549a.D);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0549a c0549a, JSONObject jSONObject) {
        a2(c0549a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0549a c0549a, JSONObject jSONObject) {
        return b2(c0549a, jSONObject);
    }
}
