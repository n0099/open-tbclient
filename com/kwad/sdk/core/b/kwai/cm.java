package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class cm implements com.kwad.sdk.core.d<a.C0686a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0686a c0686a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0686a.LF = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            c0686a.LF = "";
        }
        c0686a.LG = jSONObject.optInt("SDKVersionCode");
        c0686a.abe = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            c0686a.abe = "";
        }
        c0686a.LH = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            c0686a.LH = "";
        }
        c0686a.LI = jSONObject.optInt("sdkApiVersionCode");
        c0686a.LJ = jSONObject.optInt("sdkType");
        c0686a.appVersion = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            c0686a.appVersion = "";
        }
        c0686a.appName = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            c0686a.appName = "";
        }
        c0686a.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            c0686a.appId = "";
        }
        c0686a.agm = jSONObject.optString("globalId");
        if (jSONObject.opt("globalId") == JSONObject.NULL) {
            c0686a.agm = "";
        }
        c0686a.acB = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            c0686a.acB = "";
        }
        c0686a.acA = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            c0686a.acA = "";
        }
        c0686a.LK = jSONObject.optString("networkType");
        if (jSONObject.opt("networkType") == JSONObject.NULL) {
            c0686a.LK = "";
        }
        c0686a.LL = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (jSONObject.opt(HttpConstants.HTTP_MANUFACTURER) == JSONObject.NULL) {
            c0686a.LL = "";
        }
        c0686a.model = jSONObject.optString("model");
        if (jSONObject.opt("model") == JSONObject.NULL) {
            c0686a.model = "";
        }
        c0686a.LM = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            c0686a.LM = "";
        }
        c0686a.LN = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        c0686a.LO = jSONObject.optString("systemVersion");
        if (jSONObject.opt("systemVersion") == JSONObject.NULL) {
            c0686a.LO = "";
        }
        c0686a.LP = jSONObject.optInt("osApi");
        c0686a.LQ = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            c0686a.LQ = "";
        }
        c0686a.LR = jSONObject.optString("locale");
        if (jSONObject.opt("locale") == JSONObject.NULL) {
            c0686a.LR = "";
        }
        c0686a.agn = jSONObject.optString("uuid");
        if (jSONObject.opt("uuid") == JSONObject.NULL) {
            c0686a.agn = "";
        }
        c0686a.LS = jSONObject.optInt("screenWidth");
        c0686a.LT = jSONObject.optInt("screenHeight");
        c0686a.VB = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            c0686a.VB = "";
        }
        c0686a.VC = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            c0686a.VC = "";
        }
        c0686a.acv = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            c0686a.acv = "";
        }
        c0686a.acO = jSONObject.optString("mac");
        if (jSONObject.opt("mac") == JSONObject.NULL) {
            c0686a.acO = "";
        }
        c0686a.LU = jSONObject.optInt("statusBarHeight");
        c0686a.LV = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0686a c0686a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0686a.LF;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "SDKVersion", c0686a.LF);
        }
        int i = c0686a.LG;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0686a.abe;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "tkVersion", c0686a.abe);
        }
        String str3 = c0686a.LH;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkApiVersion", c0686a.LH);
        }
        int i2 = c0686a.LI;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0686a.LJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0686a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appVersion", c0686a.appVersion);
        }
        String str5 = c0686a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appName", c0686a.appName);
        }
        String str6 = c0686a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c0686a.appId);
        }
        String str7 = c0686a.agm;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "globalId", c0686a.agm);
        }
        String str8 = c0686a.acB;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "eGid", c0686a.acB);
        }
        String str9 = c0686a.acA;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceSig", c0686a.acA);
        }
        String str10 = c0686a.LK;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "networkType", c0686a.LK);
        }
        String str11 = c0686a.LL;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, c0686a.LL);
        }
        String str12 = c0686a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "model", c0686a.model);
        }
        String str13 = c0686a.LM;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceBrand", c0686a.LM);
        }
        int i4 = c0686a.LN;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str14 = c0686a.LO;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "systemVersion", c0686a.LO);
        }
        int i5 = c0686a.LP;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0686a.LQ;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "language", c0686a.LQ);
        }
        String str16 = c0686a.LR;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "locale", c0686a.LR);
        }
        String str17 = c0686a.agn;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "uuid", c0686a.agn);
        }
        int i6 = c0686a.LS;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0686a.LT;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0686a.VB;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "imei", c0686a.VB);
        }
        String str19 = c0686a.VC;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "oaid", c0686a.VC);
        }
        String str20 = c0686a.acv;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "androidId", c0686a.acv);
        }
        String str21 = c0686a.acO;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mac", c0686a.acO);
        }
        int i8 = c0686a.LU;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0686a.LV;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0686a c0686a, JSONObject jSONObject) {
        a2(c0686a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0686a c0686a, JSONObject jSONObject) {
        return b2(c0686a, jSONObject);
    }
}
