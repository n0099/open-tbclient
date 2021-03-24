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
        dVar.f37303a = jSONObject.optInt("maxConcurrentCount", dVar.f37303a);
        dVar.f37304b = jSONObject.optLong("playerLoadThreshold", dVar.f37304b);
        dVar.f37305c = jSONObject.optInt("speedKbpsThreshold", dVar.f37305c);
        dVar.f37306d = jSONObject.optLong("preloadBytesWifi", dVar.f37306d);
        dVar.f37307e = jSONObject.optLong("preloadBytes4G", dVar.f37307e);
        dVar.f37308f = jSONObject.optInt("preloadMsWifi", dVar.f37308f);
        dVar.f37309g = jSONObject.optInt("preloadMs4G", dVar.f37309g);
        dVar.f37310h = jSONObject.optDouble("vodBufferLowRatio", dVar.f37310h);
        dVar.i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
