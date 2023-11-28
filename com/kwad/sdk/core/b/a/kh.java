package com.kwad.sdk.core.b.a;

import com.baidu.sapi2.activity.BaseActivity;
import com.heytap.mcssdk.PushService;
import com.kwad.components.core.webview.jshandler.ah;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class kh implements com.kwad.sdk.core.d<ah.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt(PushService.APP_VERSION_CODE);
        aVar.WQ = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString("md5");
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.WR = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.WR)) {
            aVar.WR = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.qa = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(aVar.qa)) {
            aVar.qa = "";
        }
        aVar.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.WS = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.WS)) {
            aVar.WS = "";
        }
        aVar.WT = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.WU = jSONObject.optBoolean("isLandscapeSupported");
        aVar.WV = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", aVar.version);
        }
        int i2 = aVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, PushService.APP_VERSION_CODE, i2);
        }
        int i3 = aVar.WQ;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSize", i3);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5", aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.WR;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appLink", aVar.WR);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.qa;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "desc", aVar.qa);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.appId);
        }
        String str10 = aVar.WS;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "marketUri", aVar.WS);
        }
        boolean z = aVar.WT;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = aVar.WU;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = aVar.WV;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ah.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ah.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
