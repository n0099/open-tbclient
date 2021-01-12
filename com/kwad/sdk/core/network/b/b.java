package com.kwad.sdk.core.network.b;

import com.kwad.sdk.core.network.c;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements AdHttpProxy<Response> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    /* renamed from: a */
    public c parseResponse(Response response) {
        c cVar = new c();
        if (response != null) {
            try {
                cVar.f9318a = response.code();
                cVar.f9319b = com.kwad.sdk.core.network.a.b.a(response);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
        return cVar;
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doGet(String str, Map<String, String> map) {
        return parseResponse(com.kwad.sdk.core.network.a.b.a(str, map));
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return parseResponse(com.kwad.sdk.core.network.a.b.a(str, map, map2));
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return parseResponse(com.kwad.sdk.core.network.a.b.a(str, map, jSONObject));
    }
}
