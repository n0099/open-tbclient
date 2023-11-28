package com.kwad.sdk.core.b.a;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.components.core.webview.jshandler.af;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hp implements com.kwad.sdk.core.d<af.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Wy = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(aVar.Wy)) {
            aVar.Wy = "";
        }
        aVar.Wz = jSONObject.optInt("SDKVersionCode");
        aVar.WA = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(aVar.WA)) {
            aVar.WA = "";
        }
        aVar.WB = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.WC = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(aVar.WC)) {
            aVar.WC = "";
        }
        aVar.WD = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (JSONObject.NULL.toString().equals(aVar.WD)) {
            aVar.WD = "";
        }
        aVar.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.WE = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(aVar.WE)) {
            aVar.WE = "";
        }
        aVar.WF = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        aVar.WG = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(aVar.WG)) {
            aVar.WG = "";
        }
        aVar.WH = jSONObject.optInt("osApi");
        aVar.WI = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(aVar.WI)) {
            aVar.WI = "";
        }
        aVar.WJ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(aVar.WJ)) {
            aVar.WJ = "";
        }
        aVar.WK = jSONObject.optInt("screenWidth");
        aVar.WL = jSONObject.optInt("screenHeight");
        aVar.WM = jSONObject.optInt("statusBarHeight");
        aVar.WN = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Wy;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", aVar.Wy);
        }
        int i = aVar.Wz;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = aVar.WA;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", aVar.WA);
        }
        int i2 = aVar.WB;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = aVar.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i3);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.appId);
        }
        String str6 = aVar.WC;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", aVar.WC);
        }
        String str7 = aVar.WD;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, aVar.WD);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "model", aVar.model);
        }
        String str9 = aVar.WE;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", aVar.WE);
        }
        int i4 = aVar.WF;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str10 = aVar.WG;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", aVar.WG);
        }
        int i5 = aVar.WH;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i5);
        }
        String str11 = aVar.WI;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", aVar.WI);
        }
        String str12 = aVar.WJ;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", aVar.WJ);
        }
        int i6 = aVar.WK;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = aVar.WL;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i7);
        }
        int i8 = aVar.WM;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = aVar.WN;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
