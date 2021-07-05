package com.kwai.video.ksvodplayerkit.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d a(String str) {
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
            d dVar = new d();
            dVar.f39940a = jSONObject.optInt("maxConcurrentCount", dVar.f39940a);
            dVar.f39941b = jSONObject.optLong("playerLoadThreshold", dVar.f39941b);
            dVar.f39942c = jSONObject.optInt("speedKbpsThreshold", dVar.f39942c);
            dVar.f39943d = jSONObject.optLong("preloadBytesWifi", dVar.f39943d);
            dVar.f39944e = jSONObject.optLong("preloadBytes4G", dVar.f39944e);
            dVar.f39945f = jSONObject.optInt("preloadMsWifi", dVar.f39945f);
            dVar.f39946g = jSONObject.optInt("preloadMs4G", dVar.f39946g);
            dVar.f39947h = jSONObject.optDouble("vodBufferLowRatio", dVar.f39947h);
            dVar.f39948i = jSONObject.optInt("vodPausePreloadMaxCount", dVar.f39948i);
            dVar.j = jSONObject.optInt("maxSpeedKbps", dVar.j);
            dVar.k = jSONObject.optInt("vodCacheKbThresholdKb", dVar.k);
            return dVar;
        }
        return (d) invokeL.objValue;
    }
}
