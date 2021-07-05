package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.video.ksvodplayerkit.b.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c.a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            c.a aVar = new c.a();
            JSONArray optJSONArray = jSONObject.optJSONArray("representation");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(g.a(optJSONObject));
                    }
                }
                aVar.f39868a = arrayList;
            }
            return aVar;
        }
        return (c.a) invokeL.objValue;
    }

    public static String a(c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (aVar.f39868a != null && !aVar.f39868a.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (f fVar : aVar.f39868a) {
                        jSONArray.put(g.a(fVar));
                    }
                    jSONObject.put("representation", jSONArray);
                }
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
