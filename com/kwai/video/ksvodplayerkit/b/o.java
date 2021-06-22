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
        nVar.f38133a = jSONObject.optInt("rateType", nVar.f38133a);
        nVar.f38134b = jSONObject.optInt("bwEstimateType", nVar.f38134b);
        nVar.f38135c = jSONObject.optInt("absLowResLowDevice", nVar.f38135c);
        nVar.f38136d = jSONObject.optInt("adapt4G", nVar.f38136d);
        nVar.f38137e = jSONObject.optInt("adaptWifi", nVar.f38137e);
        nVar.f38138f = jSONObject.optDouble("adaptOtherNet", nVar.f38138f);
        nVar.f38139g = jSONObject.optInt("absLowRate4G", nVar.f38139g);
        nVar.f38140h = jSONObject.optInt("absLowRateWifi", nVar.f38140h);
        nVar.f38141i = jSONObject.optDouble("absLowRes4G", nVar.f38141i);
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
