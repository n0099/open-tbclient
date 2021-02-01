package com.kwad.sdk.core.c.a;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.kwad.sdk.core.webview.jshandler.l;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i implements com.kwad.sdk.core.c<l.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(l.b bVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "appName", bVar.f9602a);
        com.kwad.sdk.utils.o.a(jSONObject, PushClientConstants.TAG_PKG_NAME, bVar.f9603b);
        com.kwad.sdk.utils.o.a(jSONObject, "version", bVar.c);
        com.kwad.sdk.utils.o.a(jSONObject, "versionCode", bVar.d);
        com.kwad.sdk.utils.o.a(jSONObject, "appSize", bVar.e);
        com.kwad.sdk.utils.o.a(jSONObject, "md5", bVar.f);
        com.kwad.sdk.utils.o.a(jSONObject, "url", bVar.g);
        com.kwad.sdk.utils.o.a(jSONObject, AlaStaticKeys.ALA_STATIC_VALUE_ICON, bVar.h);
        com.kwad.sdk.utils.o.a(jSONObject, "desc", bVar.i);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.f9602a = jSONObject.optString("appName");
        bVar.f9603b = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        bVar.c = jSONObject.optString("version");
        bVar.d = jSONObject.optInt("versionCode");
        bVar.e = jSONObject.optLong("appSize");
        bVar.f = jSONObject.optString("md5");
        bVar.g = jSONObject.optString("url");
        bVar.h = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        bVar.i = jSONObject.optString("desc");
    }
}
