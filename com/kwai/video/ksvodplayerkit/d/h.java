package com.kwai.video.ksvodplayerkit.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fill_preload", gVar.f39949a);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("preload_url", gVar.f39950b);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("download_bytes", gVar.f39951c);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("preload_bytes", gVar.f39952d);
            } catch (Exception unused4) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
