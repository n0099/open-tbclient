package com.kwai.video.ksvodplayerkit.d;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {
    public static d a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f38177a = jSONObject.optInt("maxConcurrentCount", dVar.f38177a);
        dVar.f38178b = jSONObject.optLong("playerLoadThreshold", dVar.f38178b);
        dVar.f38179c = jSONObject.optInt("speedKbpsThreshold", dVar.f38179c);
        dVar.f38180d = jSONObject.optLong("preloadBytesWifi", dVar.f38180d);
        dVar.f38181e = jSONObject.optLong("preloadBytes4G", dVar.f38181e);
        dVar.f38182f = jSONObject.optInt("preloadMsWifi", dVar.f38182f);
        dVar.f38183g = jSONObject.optInt("preloadMs4G", dVar.f38183g);
        dVar.f38184h = jSONObject.optDouble("vodBufferLowRatio", dVar.f38184h);
        dVar.f38185i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.f38185i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
