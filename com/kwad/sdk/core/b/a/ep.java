package com.kwad.sdk.core.b.a;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.core.webview.d.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ep implements com.kwad.sdk.core.d<a.C0715a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0715a c0715a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0715a.Wy = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0715a.Wy)) {
            c0715a.Wy = "";
        }
        c0715a.Wz = jSONObject.optInt("SDKVersionCode");
        c0715a.awC = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0715a.awC)) {
            c0715a.awC = "";
        }
        c0715a.WA = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0715a.WA)) {
            c0715a.WA = "";
        }
        c0715a.WB = jSONObject.optInt("sdkApiVersionCode");
        c0715a.sdkType = jSONObject.optInt("sdkType");
        c0715a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0715a.appVersion)) {
            c0715a.appVersion = "";
        }
        c0715a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0715a.appName)) {
            c0715a.appName = "";
        }
        c0715a.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (JSONObject.NULL.toString().equals(c0715a.appId)) {
            c0715a.appId = "";
        }
        c0715a.aDB = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0715a.aDB)) {
            c0715a.aDB = "";
        }
        c0715a.ayr = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0715a.ayr)) {
            c0715a.ayr = "";
        }
        c0715a.ayq = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0715a.ayq)) {
            c0715a.ayq = "";
        }
        c0715a.WC = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0715a.WC)) {
            c0715a.WC = "";
        }
        c0715a.WD = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (JSONObject.NULL.toString().equals(c0715a.WD)) {
            c0715a.WD = "";
        }
        c0715a.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(c0715a.model)) {
            c0715a.model = "";
        }
        c0715a.WE = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0715a.WE)) {
            c0715a.WE = "";
        }
        c0715a.WF = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        c0715a.WG = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0715a.WG)) {
            c0715a.WG = "";
        }
        c0715a.WH = jSONObject.optInt("osApi");
        c0715a.WI = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0715a.WI)) {
            c0715a.WI = "";
        }
        c0715a.WJ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0715a.WJ)) {
            c0715a.WJ = "";
        }
        c0715a.aDC = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c0715a.aDC)) {
            c0715a.aDC = "";
        }
        c0715a.aDD = jSONObject.optBoolean("isDynamic");
        c0715a.WK = jSONObject.optInt("screenWidth");
        c0715a.WL = jSONObject.optInt("screenHeight");
        c0715a.arh = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c0715a.arh)) {
            c0715a.arh = "";
        }
        c0715a.ari = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c0715a.ari)) {
            c0715a.ari = "";
        }
        c0715a.ayl = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0715a.ayl)) {
            c0715a.ayl = "";
        }
        c0715a.ayC = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c0715a.ayC)) {
            c0715a.ayC = "";
        }
        c0715a.WM = jSONObject.optInt("statusBarHeight");
        c0715a.WN = jSONObject.optInt("titleBarHeight");
        c0715a.aDE = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0715a.aDE)) {
            c0715a.aDE = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0715a c0715a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0715a.Wy;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", c0715a.Wy);
        }
        int i = c0715a.Wz;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0715a.awC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", c0715a.awC);
        }
        String str3 = c0715a.WA;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", c0715a.WA);
        }
        int i2 = c0715a.WB;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0715a.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0715a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", c0715a.appVersion);
        }
        String str5 = c0715a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", c0715a.appName);
        }
        String str6 = c0715a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c0715a.appId);
        }
        String str7 = c0715a.aDB;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "globalId", c0715a.aDB);
        }
        String str8 = c0715a.ayr;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", c0715a.ayr);
        }
        String str9 = c0715a.ayq;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", c0715a.ayq);
        }
        String str10 = c0715a.WC;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", c0715a.WC);
        }
        String str11 = c0715a.WD;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, c0715a.WD);
        }
        String str12 = c0715a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "model", c0715a.model);
        }
        String str13 = c0715a.WE;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", c0715a.WE);
        }
        int i4 = c0715a.WF;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str14 = c0715a.WG;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", c0715a.WG);
        }
        int i5 = c0715a.WH;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0715a.WI;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", c0715a.WI);
        }
        String str16 = c0715a.WJ;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", c0715a.WJ);
        }
        String str17 = c0715a.aDC;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "uuid", c0715a.aDC);
        }
        boolean z = c0715a.aDD;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDynamic", z);
        }
        int i6 = c0715a.WK;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0715a.WL;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0715a.arh;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", c0715a.arh);
        }
        String str19 = c0715a.ari;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", c0715a.ari);
        }
        String str20 = c0715a.ayl;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", c0715a.ayl);
        }
        String str21 = c0715a.ayC;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", c0715a.ayC);
        }
        int i8 = c0715a.WM;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0715a.WN;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i9);
        }
        String str22 = c0715a.aDE;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bridgeVersion", c0715a.aDE);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0715a c0715a, JSONObject jSONObject) {
        a2(c0715a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0715a c0715a, JSONObject jSONObject) {
        return b2(c0715a, jSONObject);
    }
}
