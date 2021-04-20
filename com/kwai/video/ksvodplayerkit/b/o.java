package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        nVar.f37552a = jSONObject.optInt("rateType", nVar.f37552a);
        nVar.f37553b = jSONObject.optInt("bwEstimateType", nVar.f37553b);
        nVar.f37554c = jSONObject.optInt("absLowResLowDevice", nVar.f37554c);
        nVar.f37555d = jSONObject.optInt("adapt4G", nVar.f37555d);
        nVar.f37556e = jSONObject.optInt("adaptWifi", nVar.f37556e);
        nVar.f37557f = jSONObject.optDouble("adaptOtherNet", nVar.f37557f);
        nVar.f37558g = jSONObject.optInt("absLowRate4G", nVar.f37558g);
        nVar.f37559h = jSONObject.optInt("absLowRateWifi", nVar.f37559h);
        nVar.i = jSONObject.optDouble("absLowRes4G", nVar.i);
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
