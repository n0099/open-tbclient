package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cz implements com.kwad.sdk.core.d {
    public static void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString("ip");
        if (jSONObject.opt("ip") == JSONObject.NULL) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    public static JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = ipInfo.ip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ip", ipInfo.ip);
        }
        int i = ipInfo.weight;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "weight", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HttpDnsInfo.IpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HttpDnsInfo.IpInfo) bVar, jSONObject);
    }
}
