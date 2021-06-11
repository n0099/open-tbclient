package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class o {
    public static n a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.f38035a = jSONObject.optInt("rateType", nVar.f38035a);
        nVar.f38036b = jSONObject.optInt("bwEstimateType", nVar.f38036b);
        nVar.f38037c = jSONObject.optInt("absLowResLowDevice", nVar.f38037c);
        nVar.f38038d = jSONObject.optInt("adapt4G", nVar.f38038d);
        nVar.f38039e = jSONObject.optInt("adaptWifi", nVar.f38039e);
        nVar.f38040f = jSONObject.optDouble("adaptOtherNet", nVar.f38040f);
        nVar.f38041g = jSONObject.optInt("absLowRate4G", nVar.f38041g);
        nVar.f38042h = jSONObject.optInt("absLowRateWifi", nVar.f38042h);
        nVar.f38043i = jSONObject.optDouble("absLowRes4G", nVar.f38043i);
        nVar.j = jSONObject.optDouble("absLowResWifi", nVar.j);
        nVar.k = jSONObject.optDouble("shortKeepInterval", nVar.k);
        nVar.l = jSONObject.optInt("longKeepInterval", nVar.l);
        nVar.m = jSONObject.optInt("bitrateInitLevel", nVar.m);
        nVar.n = jSONObject.optDouble("weight", nVar.n);
        nVar.o = jSONObject.optDouble("blockAffectedIntervalMs", nVar.o);
        nVar.p = jSONObject.optDouble("wifiAmend", nVar.p);
        nVar.q = jSONObject.optDouble("fourGAmend", nVar.q);
        nVar.r = jSONObject.optDouble("resAmend", nVar.r);
        nVar.s = jSONObject.optDouble("devWidthTh", nVar.s);
        nVar.t = jSONObject.optInt("devHeightTh", nVar.t);
        nVar.u = jSONObject.optInt("priorityPolicy", nVar.u);
        return nVar;
    }
}
