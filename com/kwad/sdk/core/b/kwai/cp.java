package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class cp implements com.kwad.sdk.core.d {
    public static void a(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        httpDnsInfo.recommendList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("recommendList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                HttpDnsInfo.IpInfo ipInfo = new HttpDnsInfo.IpInfo();
                ipInfo.parseJson(optJSONArray.optJSONObject(i));
                httpDnsInfo.recommendList.add(ipInfo);
            }
        }
        httpDnsInfo.backUpList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("backUpList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                HttpDnsInfo.IpInfo ipInfo2 = new HttpDnsInfo.IpInfo();
                ipInfo2.parseJson(optJSONArray2.optJSONObject(i2));
                httpDnsInfo.backUpList.add(ipInfo2);
            }
        }
        httpDnsInfo.otherList = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("otherList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                HttpDnsInfo.IpInfo ipInfo3 = new HttpDnsInfo.IpInfo();
                ipInfo3.parseJson(optJSONArray3.optJSONObject(i3));
                httpDnsInfo.otherList.add(ipInfo3);
            }
        }
    }

    public static JSONObject b(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "recommendList", httpDnsInfo.recommendList);
        com.kwad.sdk.utils.r.putValue(jSONObject, "backUpList", httpDnsInfo.backUpList);
        com.kwad.sdk.utils.r.putValue(jSONObject, "otherList", httpDnsInfo.otherList);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HttpDnsInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HttpDnsInfo) bVar, jSONObject);
    }
}
