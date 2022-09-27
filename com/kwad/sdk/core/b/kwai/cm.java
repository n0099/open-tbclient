package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cm implements com.kwad.sdk.core.d<a.C0613a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0613a c0613a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0613a.LF = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            c0613a.LF = "";
        }
        c0613a.LG = jSONObject.optInt("SDKVersionCode");
        c0613a.abe = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            c0613a.abe = "";
        }
        c0613a.LH = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            c0613a.LH = "";
        }
        c0613a.LI = jSONObject.optInt("sdkApiVersionCode");
        c0613a.LJ = jSONObject.optInt("sdkType");
        c0613a.appVersion = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            c0613a.appVersion = "";
        }
        c0613a.appName = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            c0613a.appName = "";
        }
        c0613a.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            c0613a.appId = "";
        }
        c0613a.agm = jSONObject.optString("globalId");
        if (jSONObject.opt("globalId") == JSONObject.NULL) {
            c0613a.agm = "";
        }
        c0613a.acB = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            c0613a.acB = "";
        }
        c0613a.acA = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            c0613a.acA = "";
        }
        c0613a.LK = jSONObject.optString("networkType");
        if (jSONObject.opt("networkType") == JSONObject.NULL) {
            c0613a.LK = "";
        }
        c0613a.LL = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (jSONObject.opt(HttpConstants.HTTP_MANUFACTURER) == JSONObject.NULL) {
            c0613a.LL = "";
        }
        c0613a.model = jSONObject.optString("model");
        if (jSONObject.opt("model") == JSONObject.NULL) {
            c0613a.model = "";
        }
        c0613a.LM = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            c0613a.LM = "";
        }
        c0613a.LN = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        c0613a.LO = jSONObject.optString("systemVersion");
        if (jSONObject.opt("systemVersion") == JSONObject.NULL) {
            c0613a.LO = "";
        }
        c0613a.LP = jSONObject.optInt("osApi");
        c0613a.LQ = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            c0613a.LQ = "";
        }
        c0613a.LR = jSONObject.optString("locale");
        if (jSONObject.opt("locale") == JSONObject.NULL) {
            c0613a.LR = "";
        }
        c0613a.agn = jSONObject.optString("uuid");
        if (jSONObject.opt("uuid") == JSONObject.NULL) {
            c0613a.agn = "";
        }
        c0613a.LS = jSONObject.optInt("screenWidth");
        c0613a.LT = jSONObject.optInt("screenHeight");
        c0613a.VB = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            c0613a.VB = "";
        }
        c0613a.VC = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            c0613a.VC = "";
        }
        c0613a.acv = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            c0613a.acv = "";
        }
        c0613a.acO = jSONObject.optString("mac");
        if (jSONObject.opt("mac") == JSONObject.NULL) {
            c0613a.acO = "";
        }
        c0613a.LU = jSONObject.optInt("statusBarHeight");
        c0613a.LV = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0613a c0613a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0613a.LF;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "SDKVersion", c0613a.LF);
        }
        int i = c0613a.LG;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0613a.abe;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "tkVersion", c0613a.abe);
        }
        String str3 = c0613a.LH;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkApiVersion", c0613a.LH);
        }
        int i2 = c0613a.LI;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0613a.LJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0613a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appVersion", c0613a.appVersion);
        }
        String str5 = c0613a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appName", c0613a.appName);
        }
        String str6 = c0613a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c0613a.appId);
        }
        String str7 = c0613a.agm;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "globalId", c0613a.agm);
        }
        String str8 = c0613a.acB;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "eGid", c0613a.acB);
        }
        String str9 = c0613a.acA;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceSig", c0613a.acA);
        }
        String str10 = c0613a.LK;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "networkType", c0613a.LK);
        }
        String str11 = c0613a.LL;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, c0613a.LL);
        }
        String str12 = c0613a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "model", c0613a.model);
        }
        String str13 = c0613a.LM;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceBrand", c0613a.LM);
        }
        int i4 = c0613a.LN;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str14 = c0613a.LO;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "systemVersion", c0613a.LO);
        }
        int i5 = c0613a.LP;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0613a.LQ;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "language", c0613a.LQ);
        }
        String str16 = c0613a.LR;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "locale", c0613a.LR);
        }
        String str17 = c0613a.agn;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "uuid", c0613a.agn);
        }
        int i6 = c0613a.LS;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0613a.LT;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0613a.VB;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "imei", c0613a.VB);
        }
        String str19 = c0613a.VC;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "oaid", c0613a.VC);
        }
        String str20 = c0613a.acv;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "androidId", c0613a.acv);
        }
        String str21 = c0613a.acO;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mac", c0613a.acO);
        }
        int i8 = c0613a.LU;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0613a.LV;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0613a c0613a, JSONObject jSONObject) {
        a2(c0613a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0613a c0613a, JSONObject jSONObject) {
        return b2(c0613a, jSONObject);
    }
}
