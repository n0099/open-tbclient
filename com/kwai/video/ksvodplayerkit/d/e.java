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
        dVar.f37304a = jSONObject.optInt("maxConcurrentCount", dVar.f37304a);
        dVar.f37305b = jSONObject.optLong("playerLoadThreshold", dVar.f37305b);
        dVar.f37306c = jSONObject.optInt("speedKbpsThreshold", dVar.f37306c);
        dVar.f37307d = jSONObject.optLong("preloadBytesWifi", dVar.f37307d);
        dVar.f37308e = jSONObject.optLong("preloadBytes4G", dVar.f37308e);
        dVar.f37309f = jSONObject.optInt("preloadMsWifi", dVar.f37309f);
        dVar.f37310g = jSONObject.optInt("preloadMs4G", dVar.f37310g);
        dVar.f37311h = jSONObject.optDouble("vodBufferLowRatio", dVar.f37311h);
        dVar.i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.i);
        dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
        dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
        return dVar;
    }
}
