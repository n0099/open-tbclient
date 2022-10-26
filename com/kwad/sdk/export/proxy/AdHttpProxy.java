package com.kwad.sdk.export.proxy;

import com.kwad.sdk.core.network.c;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface AdHttpProxy {
    c doGet(String str, Map map);

    c doGetWithoutResponse(String str, Map map);

    c doPost(String str, Map map, Map map2);

    c doPost(String str, Map map, JSONObject jSONObject);
}
