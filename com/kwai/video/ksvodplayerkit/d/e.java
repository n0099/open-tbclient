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
        dVar.f38079a = jSONObject.optInt("maxConcurrentCount", dVar.f38079a);
        dVar.f38080b = jSONObject.optLong("playerLoadThreshold", dVar.f38080b);
        dVar.f38081c = jSONObject.optInt("speedKbpsThreshold", dVar.f38081c);
        dVar.f38082d = jSONObject.optLong("preloadBytesWifi", dVar.f38082d);
        dVar.f38083e = jSONObject.optLong("preloadBytes4G", dVar.f38083e);
        dVar.f38084f = jSONObject.optInt("preloadMsWifi", dVar.f38084f);
        dVar.f38085g = jSONObject.optInt("preloadMs4G", dVar.f38085g);
        dVar.f38086h = jSONObject.optDouble("vodBufferLowRatio", dVar.f38086h);
        dVar.f38087i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.f38087i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
