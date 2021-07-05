package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (lVar.f39895a != null && !lVar.f39895a.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (a aVar : lVar.f39895a) {
                        jSONArray.put(b.a(aVar));
                    }
                    jSONObject.put("adaptationSet", jSONArray);
                }
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
