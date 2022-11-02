package com.kwad.sdk.export.proxy;

import com.kwad.sdk.core.network.c;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface AdHttpProxy {
    c doGet(String str, Map<String, String> map);

    c doGetWithoutResponse(String str, Map<String, String> map);

    c doPost(String str, Map<String, String> map, Map<String, String> map2);

    c doPost(String str, Map<String, String> map, JSONObject jSONObject);
}
