package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class o {
    public static n a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.f7281a = jSONObject.optInt("rateType", nVar.f7281a);
        nVar.b = jSONObject.optInt("bwEstimateType", nVar.b);
        nVar.c = jSONObject.optInt("absLowResLowDevice", nVar.c);
        nVar.d = jSONObject.optInt("adapt4G", nVar.d);
        nVar.e = jSONObject.optInt("adaptWifi", nVar.e);
        nVar.f = jSONObject.optDouble("adaptOtherNet", nVar.f);
        nVar.g = jSONObject.optInt("absLowRate4G", nVar.g);
        nVar.h = jSONObject.optInt("absLowRateWifi", nVar.h);
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
