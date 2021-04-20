package com.kwai.video.ksvodplayerkit.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        dVar.f37593a = jSONObject.optInt("maxConcurrentCount", dVar.f37593a);
        dVar.f37594b = jSONObject.optLong("playerLoadThreshold", dVar.f37594b);
        dVar.f37595c = jSONObject.optInt("speedKbpsThreshold", dVar.f37595c);
        dVar.f37596d = jSONObject.optLong("preloadBytesWifi", dVar.f37596d);
        dVar.f37597e = jSONObject.optLong("preloadBytes4G", dVar.f37597e);
        dVar.f37598f = jSONObject.optInt("preloadMsWifi", dVar.f37598f);
        dVar.f37599g = jSONObject.optInt("preloadMs4G", dVar.f37599g);
        dVar.f37600h = jSONObject.optDouble("vodBufferLowRatio", dVar.f37600h);
        dVar.i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
