package com.kwad.sdk.core.b.kwai;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushService;
import com.kwad.components.core.webview.jshandler.p;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class fx implements com.kwad.sdk.core.d<p.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.appName = "";
        }
        aVar.LY = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            aVar.LY = "";
        }
        aVar.version = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt(PushService.APP_VERSION_CODE);
        aVar.LZ = jSONObject.optInt("appSize");
        aVar.Ma = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            aVar.Ma = "";
        }
        aVar.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            aVar.url = "";
        }
        aVar.Mb = jSONObject.optString("appLink");
        if (jSONObject.opt("appLink") == JSONObject.NULL) {
            aVar.Mb = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            aVar.icon = "";
        }
        aVar.np = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            aVar.np = "";
        }
        aVar.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            aVar.appId = "";
        }
        aVar.Mc = jSONObject.optString("marketUri");
        if (jSONObject.opt("marketUri") == JSONObject.NULL) {
            aVar.Mc = "";
        }
        aVar.Md = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.Me = jSONObject.optBoolean("isLandscapeSupported");
        aVar.Mf = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.LY;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "pkgName", aVar.LY);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "version", aVar.version);
        }
        int i2 = aVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, PushService.APP_VERSION_CODE, i2);
        }
        int i3 = aVar.LZ;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appSize", i3);
        }
        String str4 = aVar.Ma;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, PackageTable.MD5, aVar.Ma);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.Mb;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appLink", aVar.Mb);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.np;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "desc", aVar.np);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.appId);
        }
        String str10 = aVar.Mc;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "marketUri", aVar.Mc);
        }
        boolean z = aVar.Md;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = aVar.Me;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = aVar.Mf;
        if (z3) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(p.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(p.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
