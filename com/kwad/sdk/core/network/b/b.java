package com.kwad.sdk.core.network.b;

import com.kwad.sdk.core.network.c;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b implements AdHttpProxy {
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doGet(String str, Map<String, String> map) {
        return com.kwad.sdk.core.network.kwai.b.doGet(str, map);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doGetWithoutResponse(String str, Map<String, String> map) {
        return com.kwad.sdk.core.network.kwai.b.a(str, map, false);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return com.kwad.sdk.core.network.kwai.b.doPost(str, map, map2);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return com.kwad.sdk.core.network.kwai.b.doPost(str, map, jSONObject);
    }
}
