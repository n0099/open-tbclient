package com.kwai.video.ksvodplayerkit.d;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    public static d a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f7289a = jSONObject.optInt("maxConcurrentCount", dVar.f7289a);
        dVar.b = jSONObject.optLong("playerLoadThreshold", dVar.b);
        dVar.c = jSONObject.optInt("speedKbpsThreshold", dVar.c);
        dVar.d = jSONObject.optLong("preloadBytesWifi", dVar.d);
        dVar.e = jSONObject.optLong("preloadBytes4G", dVar.e);
        dVar.f = jSONObject.optInt("preloadMsWifi", dVar.f);
        dVar.g = jSONObject.optInt("preloadMs4G", dVar.g);
        dVar.h = jSONObject.optDouble("vodBufferLowRatio", dVar.h);
        dVar.i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
