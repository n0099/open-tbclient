package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            f fVar = new f();
            fVar.f39869a = jSONObject.optString("url", fVar.f39869a);
            JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add((String) optJSONArray.opt(i2));
                }
                fVar.f39870b = arrayList;
            }
            fVar.f39871c = jSONObject.optString("m3u8", fVar.f39871c);
            fVar.f39872d = jSONObject.optString("baseUrl", fVar.f39872d);
            fVar.f39873e = jSONObject.optDouble("duration", fVar.f39873e);
            fVar.f39874f = jSONObject.optString("m3u8Slice", fVar.f39874f);
            fVar.f39875g = jSONObject.optInt("bandwidth", fVar.f39875g);
            fVar.f39876h = jSONObject.optString("codecs", fVar.f39876h);
            fVar.f39877i = jSONObject.optInt("width", fVar.f39877i);
            fVar.j = jSONObject.optInt("height", fVar.j);
            fVar.k = jSONObject.optDouble("frameRate", fVar.k);
            fVar.l = jSONObject.optString("cacheKey", fVar.l);
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static String a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", fVar.f39869a);
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f39870b));
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("m3u8", fVar.f39871c);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("baseUrl", fVar.f39872d);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("duration", fVar.f39873e);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("m3u8Slice", fVar.f39874f);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("bandwidth", fVar.f39875g);
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("codecs", fVar.f39876h);
            } catch (Exception unused8) {
            }
            try {
                jSONObject.put("width", fVar.f39877i);
            } catch (Exception unused9) {
            }
            try {
                jSONObject.put("height", fVar.j);
            } catch (Exception unused10) {
            }
            try {
                jSONObject.put("frameRate", fVar.k);
            } catch (Exception unused11) {
            }
            try {
                jSONObject.put("cacheKey", fVar.l);
            } catch (Exception unused12) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
