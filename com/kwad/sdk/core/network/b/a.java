package com.kwad.sdk.core.network.b;

import com.kwad.sdk.core.network.c;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements AdHttpProxy<c> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    /* renamed from: a */
    public c parseResponse(c cVar) {
        return cVar;
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doGet(String str, Map<String, String> map) {
        return com.kwad.sdk.core.network.a.a.a(str, map);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return com.kwad.sdk.core.network.a.a.a(str, map, map2);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return com.kwad.sdk.core.network.a.a.a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }
}
