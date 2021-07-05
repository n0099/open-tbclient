package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("avgBitrate", jVar.f39886a);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("host", jVar.f39887b);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("key", jVar.f39888c);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("maxBitrate", jVar.f39889d);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("height", jVar.f39890e);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("width", jVar.f39891f);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("url", jVar.f39892g);
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("quality", jVar.f39893h);
            } catch (Exception unused8) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
