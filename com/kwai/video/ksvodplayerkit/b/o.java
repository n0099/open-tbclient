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
        nVar.f37647a = jSONObject.optInt("rateType", nVar.f37647a);
        nVar.f37648b = jSONObject.optInt("bwEstimateType", nVar.f37648b);
        nVar.f37649c = jSONObject.optInt("absLowResLowDevice", nVar.f37649c);
        nVar.f37650d = jSONObject.optInt("adapt4G", nVar.f37650d);
        nVar.f37651e = jSONObject.optInt("adaptWifi", nVar.f37651e);
        nVar.f37652f = jSONObject.optDouble("adaptOtherNet", nVar.f37652f);
        nVar.f37653g = jSONObject.optInt("absLowRate4G", nVar.f37653g);
        nVar.f37654h = jSONObject.optInt("absLowRateWifi", nVar.f37654h);
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
