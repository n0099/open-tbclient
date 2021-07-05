package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adaptationId", aVar.f39861a);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("duration", aVar.f39862b);
            } catch (Exception unused2) {
            }
            try {
                if (aVar.f39863c != null && !aVar.f39863c.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (j jVar : aVar.f39863c) {
                        jSONArray.put(k.a(jVar));
                    }
                    jSONObject.put("representation", jSONArray);
                }
            } catch (Exception unused3) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
