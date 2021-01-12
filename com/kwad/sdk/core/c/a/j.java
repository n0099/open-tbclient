package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.db.TableDefine;
import com.kwad.sdk.emotion.model.CDNUrl;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j implements com.kwad.sdk.core.c<CDNUrl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(CDNUrl cDNUrl) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "cdn", cDNUrl.cdn);
        com.kwad.sdk.utils.o.a(jSONObject, "url", cDNUrl.url);
        com.kwad.sdk.utils.o.a(jSONObject, TableDefine.UserInfoColumns.COLUMN_IP, cDNUrl.ip);
        com.kwad.sdk.utils.o.a(jSONObject, "urlPattern", cDNUrl.urlPattern);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(CDNUrl cDNUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cDNUrl.cdn = jSONObject.optString("cdn");
        cDNUrl.url = jSONObject.optString("url");
        cDNUrl.ip = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_IP);
        cDNUrl.urlPattern = jSONObject.optString("urlPattern");
    }
}
