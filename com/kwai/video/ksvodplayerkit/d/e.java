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
        dVar.f37688a = jSONObject.optInt("maxConcurrentCount", dVar.f37688a);
        dVar.f37689b = jSONObject.optLong("playerLoadThreshold", dVar.f37689b);
        dVar.f37690c = jSONObject.optInt("speedKbpsThreshold", dVar.f37690c);
        dVar.f37691d = jSONObject.optLong("preloadBytesWifi", dVar.f37691d);
        dVar.f37692e = jSONObject.optLong("preloadBytes4G", dVar.f37692e);
        dVar.f37693f = jSONObject.optInt("preloadMsWifi", dVar.f37693f);
        dVar.f37694g = jSONObject.optInt("preloadMs4G", dVar.f37694g);
        dVar.f37695h = jSONObject.optDouble("vodBufferLowRatio", dVar.f37695h);
        dVar.i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
