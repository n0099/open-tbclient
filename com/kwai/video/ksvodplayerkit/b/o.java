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
        nVar.f37263a = jSONObject.optInt("rateType", nVar.f37263a);
        nVar.f37264b = jSONObject.optInt("bwEstimateType", nVar.f37264b);
        nVar.f37265c = jSONObject.optInt("absLowResLowDevice", nVar.f37265c);
        nVar.f37266d = jSONObject.optInt("adapt4G", nVar.f37266d);
        nVar.f37267e = jSONObject.optInt("adaptWifi", nVar.f37267e);
        nVar.f37268f = jSONObject.optDouble("adaptOtherNet", nVar.f37268f);
        nVar.f37269g = jSONObject.optInt("absLowRate4G", nVar.f37269g);
        nVar.f37270h = jSONObject.optInt("absLowRateWifi", nVar.f37270h);
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
