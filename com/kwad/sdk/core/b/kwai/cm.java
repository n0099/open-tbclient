package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.core.webview.a.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class cm implements com.kwad.sdk.core.d<a.C0620a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0620a c0620a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0620a.LF = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            c0620a.LF = "";
        }
        c0620a.LG = jSONObject.optInt("SDKVersionCode");
        c0620a.abe = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            c0620a.abe = "";
        }
        c0620a.LH = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            c0620a.LH = "";
        }
        c0620a.LI = jSONObject.optInt("sdkApiVersionCode");
        c0620a.LJ = jSONObject.optInt("sdkType");
        c0620a.appVersion = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            c0620a.appVersion = "";
        }
        c0620a.appName = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            c0620a.appName = "";
        }
        c0620a.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            c0620a.appId = "";
        }
        c0620a.agm = jSONObject.optString("globalId");
        if (jSONObject.opt("globalId") == JSONObject.NULL) {
            c0620a.agm = "";
        }
        c0620a.acB = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            c0620a.acB = "";
        }
        c0620a.acA = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            c0620a.acA = "";
        }
        c0620a.LK = jSONObject.optString("networkType");
        if (jSONObject.opt("networkType") == JSONObject.NULL) {
            c0620a.LK = "";
        }
        c0620a.LL = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (jSONObject.opt(HttpConstants.HTTP_MANUFACTURER) == JSONObject.NULL) {
            c0620a.LL = "";
        }
        c0620a.model = jSONObject.optString("model");
        if (jSONObject.opt("model") == JSONObject.NULL) {
            c0620a.model = "";
        }
        c0620a.LM = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            c0620a.LM = "";
        }
        c0620a.LN = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        c0620a.LO = jSONObject.optString("systemVersion");
        if (jSONObject.opt("systemVersion") == JSONObject.NULL) {
            c0620a.LO = "";
        }
        c0620a.LP = jSONObject.optInt("osApi");
        c0620a.LQ = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            c0620a.LQ = "";
        }
        c0620a.LR = jSONObject.optString("locale");
        if (jSONObject.opt("locale") == JSONObject.NULL) {
            c0620a.LR = "";
        }
        c0620a.agn = jSONObject.optString("uuid");
        if (jSONObject.opt("uuid") == JSONObject.NULL) {
            c0620a.agn = "";
        }
        c0620a.LS = jSONObject.optInt("screenWidth");
        c0620a.LT = jSONObject.optInt("screenHeight");
        c0620a.VB = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            c0620a.VB = "";
        }
        c0620a.VC = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            c0620a.VC = "";
        }
        c0620a.acv = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            c0620a.acv = "";
        }
        c0620a.acO = jSONObject.optString("mac");
        if (jSONObject.opt("mac") == JSONObject.NULL) {
            c0620a.acO = "";
        }
        c0620a.LU = jSONObject.optInt("statusBarHeight");
        c0620a.LV = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0620a c0620a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0620a.LF;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "SDKVersion", c0620a.LF);
        }
        int i = c0620a.LG;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0620a.abe;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "tkVersion", c0620a.abe);
        }
        String str3 = c0620a.LH;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkApiVersion", c0620a.LH);
        }
        int i2 = c0620a.LI;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0620a.LJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0620a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appVersion", c0620a.appVersion);
        }
        String str5 = c0620a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appName", c0620a.appName);
        }
        String str6 = c0620a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c0620a.appId);
        }
        String str7 = c0620a.agm;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "globalId", c0620a.agm);
        }
        String str8 = c0620a.acB;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "eGid", c0620a.acB);
        }
        String str9 = c0620a.acA;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceSig", c0620a.acA);
        }
        String str10 = c0620a.LK;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "networkType", c0620a.LK);
        }
        String str11 = c0620a.LL;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, c0620a.LL);
        }
        String str12 = c0620a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "model", c0620a.model);
        }
        String str13 = c0620a.LM;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceBrand", c0620a.LM);
        }
        int i4 = c0620a.LN;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str14 = c0620a.LO;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "systemVersion", c0620a.LO);
        }
        int i5 = c0620a.LP;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0620a.LQ;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "language", c0620a.LQ);
        }
        String str16 = c0620a.LR;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "locale", c0620a.LR);
        }
        String str17 = c0620a.agn;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "uuid", c0620a.agn);
        }
        int i6 = c0620a.LS;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0620a.LT;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0620a.VB;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "imei", c0620a.VB);
        }
        String str19 = c0620a.VC;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "oaid", c0620a.VC);
        }
        String str20 = c0620a.acv;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "androidId", c0620a.acv);
        }
        String str21 = c0620a.acO;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mac", c0620a.acO);
        }
        int i8 = c0620a.LU;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0620a.LV;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0620a c0620a, JSONObject jSONObject) {
        a2(c0620a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0620a c0620a, JSONObject jSONObject) {
        return b2(c0620a, jSONObject);
    }
}
