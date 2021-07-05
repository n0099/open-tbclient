package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(String str) {
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
            c cVar = new c();
            cVar.f39864a = jSONObject.optString("version", cVar.f39864a);
            cVar.f39865b = jSONObject.optString("type", cVar.f39865b);
            cVar.f39866c = e.a(jSONObject.optJSONObject("adaptationSet"));
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static String a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", cVar.f39864a);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("type", cVar.f39865b);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("adaptationSet", e.a(cVar.f39866c));
            } catch (Exception unused3) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
