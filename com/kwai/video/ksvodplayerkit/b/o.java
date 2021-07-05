package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static n a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return null;
            }
            n nVar = new n();
            nVar.f39896a = jSONObject.optInt("rateType", nVar.f39896a);
            nVar.f39897b = jSONObject.optInt("bwEstimateType", nVar.f39897b);
            nVar.f39898c = jSONObject.optInt("absLowResLowDevice", nVar.f39898c);
            nVar.f39899d = jSONObject.optInt("adapt4G", nVar.f39899d);
            nVar.f39900e = jSONObject.optInt("adaptWifi", nVar.f39900e);
            nVar.f39901f = jSONObject.optDouble("adaptOtherNet", nVar.f39901f);
            nVar.f39902g = jSONObject.optInt("absLowRate4G", nVar.f39902g);
            nVar.f39903h = jSONObject.optInt("absLowRateWifi", nVar.f39903h);
            nVar.f39904i = jSONObject.optDouble("absLowRes4G", nVar.f39904i);
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
        return (n) invokeL.objValue;
    }
}
