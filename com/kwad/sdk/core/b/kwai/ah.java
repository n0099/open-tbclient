package com.kwad.sdk.core.b.kwai;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.PushManager;
import com.kwad.components.core.webview.jshandler.v;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ah implements com.kwad.sdk.core.d<v.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            bVar.a = "";
        }
        bVar.b = jSONObject.optString("pkgName");
        if (jSONObject.opt("pkgName") == JSONObject.NULL) {
            bVar.b = "";
        }
        bVar.c = jSONObject.optString("version");
        if (jSONObject.opt("version") == JSONObject.NULL) {
            bVar.c = "";
        }
        bVar.d = jSONObject.optInt(PushManager.APP_VERSION_CODE);
        bVar.e = jSONObject.optLong("appSize");
        bVar.f = jSONObject.optString(PackageTable.MD5);
        if (jSONObject.opt(PackageTable.MD5) == JSONObject.NULL) {
            bVar.f = "";
        }
        bVar.g = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            bVar.g = "";
        }
        bVar.h = jSONObject.optString("icon");
        if (jSONObject.opt("icon") == JSONObject.NULL) {
            bVar.h = "";
        }
        bVar.i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            bVar.i = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "appName", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "pkgName", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "version", bVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, PushManager.APP_VERSION_CODE, bVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "appSize", bVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, PackageTable.MD5, bVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "url", bVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, "icon", bVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, "desc", bVar.i);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(v.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(v.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
