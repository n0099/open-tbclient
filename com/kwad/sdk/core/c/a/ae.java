package com.kwad.sdk.core.c.a;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.kwad.sdk.core.webview.jshandler.g;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae implements com.kwad.sdk.core.c<g.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(g.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "type", aVar.f6343a);
        com.kwad.sdk.utils.o.a(jSONObject, "appName", aVar.b);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, aVar.c);
        com.kwad.sdk.utils.o.a(jSONObject, "version", aVar.d);
        com.kwad.sdk.utils.o.a(jSONObject, "versionCode", aVar.e);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", aVar.f);
        com.kwad.sdk.utils.o.a(jSONObject, "md5", aVar.g);
        com.kwad.sdk.utils.o.a(jSONObject, "url", aVar.h);
        com.kwad.sdk.utils.o.a(jSONObject, "appLink", aVar.i);
        com.kwad.sdk.utils.o.a(jSONObject, AlaStaticKeys.ALA_STATIC_VALUE_ICON, aVar.j);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", aVar.k);
        com.kwad.sdk.utils.o.a(jSONObject, "appId", aVar.l);
        com.kwad.sdk.utils.o.a(jSONObject, "marketUri", aVar.m);
        com.kwad.sdk.utils.o.a(jSONObject, "disableLandingPageDeepLink", aVar.n);
        com.kwad.sdk.utils.o.a(jSONObject, "isLandscapeSupported", aVar.o);
        com.kwad.sdk.utils.o.a(jSONObject, "isFromLive", aVar.p);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f6343a = jSONObject.optInt("type");
        aVar.b = jSONObject.optString("appName");
        aVar.c = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        aVar.d = jSONObject.optString("version");
        aVar.e = jSONObject.optInt("versionCode");
        aVar.f = jSONObject.optInt("appSize");
        aVar.g = jSONObject.optString("md5");
        aVar.h = jSONObject.optString("url");
        aVar.i = jSONObject.optString("appLink");
        aVar.j = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        aVar.k = jSONObject.optString("desc");
        aVar.l = jSONObject.optString("appId");
        aVar.m = jSONObject.optString("marketUri");
        aVar.n = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.o = jSONObject.optBoolean("isLandscapeSupported");
        aVar.p = jSONObject.optBoolean("isFromLive");
    }
}
